import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainApp extends JFrame {
    private List<Post> posts;
    private DefaultListModel<Post> postListModel;
    private JList<Post> postList;
    private JLabel adLabel;
    private JButton loginButton;
    private JLabel balanceLabel;
    private Microkernel kernel;
    private UserManagementPlugin userPlugin;
    private RewardManagementPlugin rewardPlugin;
    private PictureManagementPlugin picturePlugin;
    private boolean loggedIn = false;
    private NotificationObservable notificationObservable;

    public MainApp() {
        posts = new ArrayList<>();
        postListModel = new DefaultListModel<>();
        postList = new JList<>(postListModel);
        adLabel = new JLabel();
        notificationObservable = new NotificationObservable();

        // Initialize the microkernel and plugins
        kernel = new Microkernel();
        userPlugin = new UserManagementPlugin();
        rewardPlugin = new RewardManagementPlugin(userPlugin);
        picturePlugin = new PictureManagementPlugin();
        kernel.registerPlugin("userManagement", userPlugin);
        kernel.registerPlugin("rewardManagement", rewardPlugin);
        kernel.registerPlugin("pictureManagement", picturePlugin);

        setTitle("Where's My Fluffy - Pet Finder App");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel listingPanel = new JPanel();
        listingPanel.setLayout(new BorderLayout());
        postList.setCellRenderer(new PostRenderer());
        JScrollPane scrollPane = new JScrollPane(postList);
        listingPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new BorderLayout());

        loginButton = new JButton("Login");
        loginButton.addActionListener(e -> openLoginDialog());

        JButton createPostButton = new JButton("Create Post");
        createPostButton.addActionListener(e -> {
            if (loggedIn) {
                openPostCreationDialog();
            } else {
                JOptionPane.showMessageDialog(this, "You must be logged in to create a post.");
            }
        });

        balanceLabel = new JLabel();

        adLabel.setText(
                "<html><center><strong>Ad:</strong> Get 20% off at PetStore! Use code FLUFFY20</center></html>");
        adLabel.setHorizontalAlignment(SwingConstants.CENTER);
        adLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        adLabel.setPreferredSize(new Dimension(200, 100));

        sidePanel.add(createPostButton, BorderLayout.NORTH);
        sidePanel.add(adLabel, BorderLayout.CENTER);
        sidePanel.add(loginButton, BorderLayout.SOUTH);

        add(listingPanel, BorderLayout.CENTER);
        add(sidePanel, BorderLayout.EAST);

        addMockData();

        postList.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    int index = postList.locationToIndex(e.getPoint());
                    if (index >= 0) {
                        Post post = postListModel.getElementAt(index);
                        handlePostRightClick(post);
                    }
                }
            }
        });

        updateLoginStatus();
    }

    private void addMockData() {
        updatePostList();
    }

    private void updatePostList() {
        postListModel.clear();
        for (Post post : posts) {
            postListModel.addElement(post);
        }
    }

    private void openPostCreationDialog() {
        JDialog dialog = new JDialog(this, "Create a New Post", true);
        dialog.setSize(400, 400);
        dialog.setLayout(new GridLayout(8, 2));

        JLabel typeLabel = new JLabel("Post Type:");
        JComboBox<String> typeComboBox = new JComboBox<>(new String[] { "Missing", "Found" });

        JLabel nameLabel = new JLabel("Pet Name:");
        JTextField nameField = new JTextField();

        JLabel descriptionLabel = new JLabel("Description:");
        JTextField descriptionField = new JTextField();

        JLabel locationLabel = new JLabel("Location:");
        JTextField locationField = new JTextField();

        JLabel pictureLabel = new JLabel("Picture:");
        JButton uploadPictureButton = new JButton("Upload Picture");

        JLabel picturePreviewLabel = new JLabel();
        picturePreviewLabel.setPreferredSize(new Dimension(150, 150));

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            String petName = nameField.getText();
            String description = descriptionField.getText();
            String location = locationField.getText();
            String type = (String) typeComboBox.getSelectedItem();

            if (!petName.isEmpty() && !description.isEmpty() && !location.isEmpty()) {
                PictureManagementPlugin picturePlugin = (PictureManagementPlugin) kernel.getPlugin("pictureManagement");
                String author = userPlugin.getCurrentUser() != null ? userPlugin.getCurrentUser().getUsername()
                        : "Unknown";
                Post newPost = new Post(petName, description, location, type, picturePlugin.getPicture(), author);
                notificationObservable.notifyObservers("New post created by " + author + ": " + petName);
                posts.add(newPost);
                updatePostList();
                dialog.dispose();
            } else {
                JOptionPane.showMessageDialog(dialog, "All fields are required!");
            }
        });

        uploadPictureButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(dialog);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                PictureManagementPlugin picturePlugin = (PictureManagementPlugin) kernel.getPlugin("pictureManagement");
                picturePlugin.setPicture(selectedFile);
                picturePreviewLabel.setIcon(picturePlugin.getPicture());
            }
        });

        dialog.add(typeLabel);
        dialog.add(typeComboBox);
        dialog.add(nameLabel);
        dialog.add(nameField);
        dialog.add(descriptionLabel);
        dialog.add(descriptionField);
        dialog.add(locationLabel);
        dialog.add(locationField);
        dialog.add(pictureLabel);
        dialog.add(uploadPictureButton);
        dialog.add(new JLabel());
        dialog.add(picturePreviewLabel);
        dialog.add(new JLabel());
        dialog.add(submitButton);

        dialog.setVisible(true);
    }

    private void handlePostRightClick(Post post) {
        if ("Missing".equals(post.getType())) {
            int response = JOptionPane.showConfirmDialog(this, "Mark this pet as found and reward user?", "Reward Pet",
                    JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                rewardPlugin.rewardUser();
                posts.remove(post);
                updatePostList();
                updateBalanceLabel();
            }
        }
    }

    private void updateBalanceLabel() {
        if (userPlugin.getCurrentUser() != null) {
            balanceLabel.setText("Balance: $" + userPlugin.getCurrentUser().getBalance());
        } else {
            balanceLabel.setText("Balance: $0");
        }
    }

    private void updateLoginStatus() {
        if (userPlugin.getCurrentUser() != null) {
            loggedIn = true;
            loginButton.setVisible(false);
            balanceLabel.setText("Balance: $" + userPlugin.getCurrentUser().getBalance());
            add(balanceLabel, BorderLayout.SOUTH);
        } else {
            loggedIn = false;
            loginButton.setVisible(true);
            remove(balanceLabel);
        }
        validate();
        repaint();
    }

    private void openLoginDialog() {
        JDialog loginDialog = new JDialog(this, "Login", true);
        loginDialog.setSize(300, 250);
        loginDialog.setLayout(new GridLayout(4, 2));

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (userPlugin.authenticate(username, password)) {
                System.out.println("Logged in as: " + userPlugin.getCurrentUser().getUsername());
                notificationObservable.addObserver(userPlugin.getCurrentUser());
                JOptionPane.showMessageDialog(loginDialog, "Login successful!");
                updateLoginStatus();
                loginDialog.dispose();
            } else {
                JOptionPane.showMessageDialog(loginDialog, "Invalid credentials, please try again.");
            }
        });

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(e -> openRegistrationDialog());

        loginDialog.add(usernameLabel);
        loginDialog.add(usernameField);
        loginDialog.add(passwordLabel);
        loginDialog.add(passwordField);
        loginDialog.add(new JLabel()); // Spacer
        loginDialog.add(loginButton);
        loginDialog.add(new JLabel()); // Spacer
        loginDialog.add(registerButton);

        loginDialog.setVisible(true);
    }

    private void openRegistrationDialog() {
        JDialog registrationDialog = new JDialog(this, "Register", true);
        registrationDialog.setSize(300, 250);
        registrationDialog.setLayout(new GridLayout(4, 2));

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (userPlugin.registerUser(username, password)) {
                JOptionPane.showMessageDialog(registrationDialog, "Registration successful! You can now log in.");
                registrationDialog.dispose();
            } else {
                JOptionPane.showMessageDialog(registrationDialog, "Username already exists. Please choose another.");
            }
        });

        registrationDialog.add(usernameLabel);
        registrationDialog.add(usernameField);
        registrationDialog.add(passwordLabel);
        registrationDialog.add(passwordField);
        registrationDialog.add(new JLabel());
        registrationDialog.add(registerButton);

        registrationDialog.setVisible(true);
    }

    private static class PostRenderer extends JLabel implements ListCellRenderer<Post> {
        private static final int MAX_WIDTH = 150;
        private static final int MAX_HEIGHT = 150;

        @Override
        public Component getListCellRendererComponent(JList<? extends Post> list, Post value, int index,
                boolean isSelected, boolean cellHasFocus) {
            setText(value.toString());
            setIcon(resizeImage(value.getPicture()));
            setOpaque(true);
            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }
            return this;
        }

        private ImageIcon resizeImage(ImageIcon originalIcon) {
            if (originalIcon == null) {
                return null;
            }

            Image img = originalIcon.getImage();
            int width = img.getWidth(null);
            int height = img.getHeight(null);

            if (width > MAX_WIDTH || height > MAX_HEIGHT) {
                double aspectRatio = (double) width / height;
                if (width > height) {
                    width = MAX_WIDTH;
                    height = (int) (width / aspectRatio);
                } else {
                    height = MAX_HEIGHT;
                    width = (int) (height * aspectRatio);
                }
                Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                return new ImageIcon(scaledImg);
            } else {
                return originalIcon;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainApp app = new MainApp();
            app.setVisible(true);
        });
    }
}