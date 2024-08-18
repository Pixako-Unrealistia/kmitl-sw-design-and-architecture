import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

class Post {
    private String petName;
    private String description;
    private String location;
    private String type; // "Missing" / "Found"
    private ImageIcon picture;
    private String creator;

    private int reward;

    public Post(String petName, String description, String location, String type, ImageIcon picture, String creator, int reward) {
        this.petName = petName;
        this.description = description;
        this.location = location;
        this.type = type;
        this.picture = picture;
        this.creator = creator;
        this.reward = reward;
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

    @Override
    public String toString() {
        return "<html><strong>" + type + " Pet:</strong> " + petName + "<br><strong>Location:</strong> " + location + "<br><strong>Description:</strong> " +   "<br><strong>Reward:</strong> " + reward + "<br><strong>Posted by:</strong> " + creator + "</html>";
    }
}


public class PostManagementPlugin implements Plugin {
    private List<Post> posts = new ArrayList<>();
    private DefaultListModel<Post> postListModel;

    public PostManagementPlugin(DefaultListModel<Post> postListModel) {
        this.postListModel = postListModel;
    }

    @Override
    public void initialize() {
    }

    @Override
    public String execute() {
        postListModel.clear();
        for (Post post : posts) {
            postListModel.addElement(post);
        }
        return "Posts updated.";
    }

    public void addPost(Post post) {
        posts.add(post);
    }
}
