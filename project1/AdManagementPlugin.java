import javax.swing.*;

public class AdManagementPlugin implements Plugin {
    private JLabel adLabel;

    public AdManagementPlugin(JLabel adLabel) {
        this.adLabel = adLabel;
    }

    @Override
    public void initialize() {
        adLabel.setText("<html><center><strong>Ad:</strong> Get 20% off at PetStore! Use code FLUFFY20</center></html>");
    }

    @Override
    public String execute() {
        return "Ad displayed.";
    }
}