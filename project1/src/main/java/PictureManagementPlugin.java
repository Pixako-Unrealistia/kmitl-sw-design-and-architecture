import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class PictureManagementPlugin implements Plugin {
    private ImageIcon picture;

    @Override
    public void initialize() {
    }

    @Override
    public String execute() {
        return "Picture handling functionality executed.";
    }

    public void setPicture(File pictureFile) {
        try {
            BufferedImage img = ImageIO.read(pictureFile);
            picture = new ImageIcon(img);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ImageIcon getPicture() {
        return picture;
    }
}
