import java.util.HashMap;
import java.util.Map;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Observer;
import java.util.Observable;

class User implements Observer {
    private String username;
    private String password;
    private int balance;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.balance = 0;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getBalance() {
        return balance;
    }

    public void addBalance(int amount) {
        this.balance += amount;
    }

    public boolean subBalance(int amount) {
        if (this.balance < amount) {
            return false;
        }
        this.balance -= amount;
        return true;
    }
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("NOTI");
        // get string from arg
        String str = (String) arg;
        System.out.println("NOTI : " + str);
    }
}

public class UserManagementPlugin implements Plugin {
    private Map<String, User> users = new HashMap<>();
    private User currentUser;
    private Connection connection;

    @Override
    public void initialize() {
        connectToDatabase();
        createTableIfNotExists();
        loadUsersFromDatabase();
    }

    @Override
    public String execute() {
        return currentUser != null ? "Logged in as: " + currentUser.getUsername() : "No user logged in";
    }

    private void connectToDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:users.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTableIfNotExists() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
                "username TEXT PRIMARY KEY," +
                "password TEXT NOT NULL," +
                "balance INTEGER NOT NULL DEFAULT 0" +
                ")";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadUsersFromDatabase() {
        String selectSQL = "SELECT username, password, balance FROM users";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(selectSQL)) {

            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                int balance = rs.getInt("balance");

                User user = new User(username, password);
                user.addBalance(balance);
                users.put(username, user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean authenticate(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            currentUser = user;
            return true;
        }
        return false;
    }

    public void logout() {
        currentUser = null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void addUser(String username, String password) {
        User user = new User(username, password);
        users.put(username, user);
        saveUserToDatabase(user);
    }

    public boolean registerUser(String username, String password) {
        if (users.containsKey(username)) {
            return false;
        }
        addUser(username, password);
        return true;
    }

    void saveUserToDatabase(User user) {
        String insertSQL = "INSERT INTO users (username, password, balance) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(insertSQL)) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setInt(3, user.getBalance());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUserBalance(User user) {
        String updateSQL = "UPDATE users SET balance = ? WHERE username = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(updateSQL)) {
            pstmt.setInt(1, user.getBalance());
            pstmt.setString(2, user.getUsername());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addBalanceToCurrentUser(int amount) {
        if (currentUser != null) {
            currentUser.addBalance(amount);
            updateUserBalance(currentUser);
        }
    }

    public boolean subBalanceFromCurrentUser(int amount) {
        if (currentUser != null && currentUser.subBalance(amount)) {
            updateUserBalance(currentUser);
            return true;
        }
        return false;
    }
}
