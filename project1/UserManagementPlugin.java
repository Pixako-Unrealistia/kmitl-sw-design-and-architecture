import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JDialog;
import javax.swing.JLabel;

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

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("NOTI");
        // get string from arg
        String str = (String) arg;
        // popup a message box with the string
        JDialog loginDialog = new JDialog();
        loginDialog.setTitle("Notification");
        loginDialog.add(new JLabel(str));
        loginDialog.setSize(200, 100);
        loginDialog.setVisible(true);
        System.out.println("NOTI : " + str);
    }

    public void addBalance(int amount) {
        this.balance += amount;
    }
}

public class UserManagementPlugin implements Plugin {
    private Map<String, User> users = new HashMap<>();
    private User currentUser;

    @Override
    public void initialize() {
        // Initialize with some mock users
        users.put("admin", new User("admin", "admin"));
    }

    @Override
    public String execute() {
        return currentUser != null ? "Logged in as: " + currentUser.getUsername() : "No user logged in";
    }

    public boolean authenticate(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            currentUser = user;
            return true;
        }
        return false;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void addUser(String username, String password) {
        users.put(username, new User(username, password));
    }

    public boolean registerUser(String username, String password) {
        if (users.containsKey(username)) {
            return false;
        }
        addUser(username, password);
        return true;
    }
}
