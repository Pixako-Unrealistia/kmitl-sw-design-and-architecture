import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.io.ByteArrayOutputStream;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

class Post {
    private int id;
    private String petName;
    private String description;
    private String location;
    private String type; // "Missing" / "Found"
    private ImageIcon picture;
    private String creator;
    private int reward;

    public Post(int id, String petName, String description, String location, String type, ImageIcon picture, String creator, int reward) {
        this.id = id;
        this.petName = petName;
        this.description = description;
        this.location = location;
        this.type = type;
        this.picture = picture;
        this.creator = creator;
        this.reward = reward;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPictureBase64() {
        if (picture == null) return null;
        try {
            BufferedImage img = (BufferedImage) picture.getImage();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(img, "png", baos);
            byte[] imageBytes = baos.toByteArray();
            return Base64.getEncoder().encodeToString(imageBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ImageIcon base64ToImageIcon(String base64String) {
        if (base64String == null || base64String.isEmpty()) return null;
        try {
            byte[] imageBytes = Base64.getDecoder().decode(base64String);
            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            BufferedImage img = ImageIO.read(bais);
            return new ImageIcon(img);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "<html><strong>" + "(" + id + ") " + type + " Pet:</strong> " + petName + "<br><strong>Location:</strong> " + location +
                "<br><strong>Description:</strong> " + description + "<br><strong>Reward:</strong> " + reward +
                "<br><strong>Posted by:</strong> " + creator + "</html>";
    }

    public String getPetName() {
        return petName;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getType() {
        return type;
    }

    public ImageIcon getPicture() {
        return picture;
    }

    public String getCreator() {
        return creator;
    }

    public int getReward() {
        return reward;
    }

}

public class PostManagementPlugin implements Plugin {
    private List<Post> posts = new ArrayList<>();
    private DefaultListModel<Post> postListModel;
    private Connection connection;

    public PostManagementPlugin(DefaultListModel<Post> postListModel) {
        this.postListModel = postListModel;
    }

    private void connectToDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:posts.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTableIfNotExists() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS posts (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "petName TEXT NOT NULL," +
                "description TEXT," +
                "location TEXT," +
                "type TEXT," +
                "picture TEXT," +
                "creator TEXT," +
                "reward INTEGER" +
                ")";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize() {
        connectToDatabase();
        createTableIfNotExists();
        loadPostsFromDatabase();
    }

    @Override
    public String execute() {
        postListModel.clear();
        for (Post post : posts) {
            postListModel.addElement(post);
        }
        return "Posts updated.";
    }

    public void addPost(String petName, String description, String location, String type, ImageIcon picture, String creator, int reward) {
        Post post = new Post(0, petName, description, location, type, picture, creator, reward);
        posts.add(post);
        savePostToDatabase(post);
    }

    private void savePostToDatabase(Post post) {
        String insertSQL = "INSERT INTO posts (petName, description, location, type, picture, creator, reward) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, post.getPetName());
            pstmt.setString(2, post.getDescription());
            pstmt.setString(3, post.getLocation());
            pstmt.setString(4, post.getType());
            pstmt.setString(5, post.getPictureBase64());
            pstmt.setString(6, post.getCreator());
            pstmt.setInt(7, post.getReward());
            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    post.setId(id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removePost(Post post) {
        posts.remove(post);
        deletePostFromDatabase(post.getId());
    }

    private void deletePostFromDatabase(int id) {
        String deleteSQL = "DELETE FROM posts WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(deleteSQL)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Post> getPosts() {
        return posts;
    }

    private void loadPostsFromDatabase() {
        String selectSQL = "SELECT id, petName, description, location, type, picture, creator, reward FROM posts";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(selectSQL)) {

            Set<Integer> loadedIds = new HashSet<>();

            while (rs.next()) {
                int id = rs.getInt("id");
                String petName = rs.getString("petName");
                String description = rs.getString("description");
                String location = rs.getString("location");
                String type = rs.getString("type");
                String pictureBase64 = rs.getString("picture");
                String creator = rs.getString("creator");
                int reward = rs.getInt("reward");

                if (!loadedIds.contains(id)) {
                    System.out.println("Loading post with id: " + id);
                    ImageIcon picture = Post.base64ToImageIcon(pictureBase64);
                    Post post = new Post(id, petName, description, location, type, picture, creator, reward);
                    posts.add(post);
                    loadedIds.add(id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}