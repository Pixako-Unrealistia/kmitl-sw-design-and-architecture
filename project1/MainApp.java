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

    private JButton logoutButton;

    private JButton topupButton;
    private JButton withdrawButton;
    private Microkernel kernel;
    private UserManagementPlugin userPlugin;
    private RewardManagementPlugin rewardPlugin;
    private CurrencyExchangePlugin currencyPlugin;
    private PictureManagementPlugin picturePlugin;
    private boolean loggedIn = false;

    public MainApp() {
        posts = new ArrayList<>();
        postListModel = new DefaultListModel<>();
        postList = new JList<>(postListModel);
        adLabel = new JLabel();

        // Initialize the microkernel and plugins
        kernel = new Microkernel();
        userPlugin = new UserManagementPlugin();
        rewardPlugin = new RewardManagementPlugin(userPlugin);
        currencyPlugin = new CurrencyExchangePlugin(userPlugin);
        picturePlugin = new PictureManagementPlugin();
        kernel.registerPlugin("userManagement", userPlugin);
        kernel.registerPlugin("rewardManagement", rewardPlugin);
        kernel.registerPlugin("currencyExchange", currencyPlugin);
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

        logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> {
            userPlugin.logout();
            updateLoginStatus();
        });

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

        topupButton = new JButton("Top Up Balance");
        topupButton.addActionListener(e -> topupBalance());


        withdrawButton = new JButton("Withdraw Balance");
        withdrawButton.addActionListener(e -> withdrawBalance());


        JPanel userPanel = new JPanel();
        userPanel.setLayout(new GridLayout(4, 1));

        sidePanel.add(createPostButton, BorderLayout.NORTH);
        sidePanel.add(adLabel, BorderLayout.CENTER);

        userPanel.add(topupButton);
        userPanel.add(withdrawButton);
        userPanel.add(logoutButton);
        userPanel.add(loginButton);
        sidePanel.add(userPanel, BorderLayout.SOUTH);

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

//        Reward Amount
        JLabel rewardAmountLabel = new JLabel("Reward Amount:");
        JTextField rewardAmountField = new JTextField();

        JButton submitButton = new JButton("Submit");

        submitButton.addActionListener(e -> {
            String petName = nameField.getText();
            String description = descriptionField.getText();
            String location = locationField.getText();
            String type = (String) typeComboBox.getSelectedItem();

            if (!petName.isEmpty() && !description.isEmpty() && !location.isEmpty() && rewardAmountField.getText().matches("[0-9]+")) {
//                check for reward amount
                int rewardAmount = Integer.parseInt(rewardAmountField.getText());
                if (rewardAmount > userPlugin.getCurrentUser().getBalance()) {
                    JOptionPane.showMessageDialog(dialog, "You do not have enough balance to post this reward!");
                    return;
                }

                PictureManagementPlugin picturePlugin = (PictureManagementPlugin) kernel.getPlugin("pictureManagement");
                String author = userPlugin.getCurrentUser() != null ? userPlugin.getCurrentUser().getUsername()
                        : "Unknown";
                Post newPost = new Post(petName, description, location, type, picturePlugin.getPicture(), author, rewardAmount);
                userPlugin.getCurrentUser().subBalance(rewardAmount);
                balanceLabel.setText("Balance: $" + userPlugin.getCurrentUser().getBalance());
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
        dialog.add(rewardAmountLabel);
        dialog.add(rewardAmountField);
        dialog.add(new JLabel());
        dialog.add(submitButton);


        dialog.setVisible(true);
    }

    private void handlePostRightClick(Post post) {
        if ("Missing".equals(post.getType())) {
            int response = JOptionPane.showConfirmDialog(this, "Mark this pet as found and reward user?", "Reward Pet",
                    JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                rewardPlugin.rewardUser(post.getReward());
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
            logoutButton.setVisible(true);
            withdrawButton.setVisible(true);
            topupButton.setVisible(true);
            balanceLabel.setText("Balance: $" + userPlugin.getCurrentUser().getBalance());
            add(balanceLabel, BorderLayout.SOUTH);
        } else {
            loggedIn = false;
            loginButton.setVisible(true);
            logoutButton.setVisible(false);
            withdrawButton.setVisible(false);
            topupButton.setVisible(false);
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
    private void topupBalance() {
        JDialog topupDialog = new JDialog(this, "Top Up Balance", true);
        topupDialog.setSize(300, 150);
        topupDialog.setLayout(new GridLayout(3, 2));

        JLabel amountLabel = new JLabel("Amount:");
        JTextField amountField = new JTextField();

        JButton topupButton = new JButton("Top Up");
        topupButton.addActionListener(e -> {
            try {
                int amount = Integer.parseInt(amountField.getText());
                if (amount > 0) {
                    currencyPlugin.deposit(amount);
                    updateBalanceLabel();
                    JOptionPane.showMessageDialog(topupDialog, "Balance topped up successfully!");
                    topupDialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(topupDialog, "Amount must be greater than 0.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(topupDialog, "Invalid amount. Please enter a number.");
            }
        });

        topupDialog.add(amountLabel);
        topupDialog.add(amountField);
        topupDialog.add(new JLabel());
        topupDialog.add(topupButton);

        topupDialog.setVisible(true);
    }

    private void withdrawBalance() {
        JDialog withdrawDialog = new JDialog(this, "Withdraw Balance", true);
        withdrawDialog.setSize(300, 150);
        withdrawDialog.setLayout(new GridLayout(3, 2));

        JLabel amountLabel = new JLabel("Amount:");
        JTextField amountField = new JTextField();

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(e -> {
            try {
                int amount = Integer.parseInt(amountField.getText());
                if (amount > 0) {
                    if (currencyPlugin.withdraw(amount)) {
                        updateBalanceLabel();
                        JOptionPane.showMessageDialog(withdrawDialog, "Balance withdrawn successfully!");
                        withdrawDialog.dispose();
                    } else {
                        JOptionPane.showMessageDialog(withdrawDialog, "Insufficient balance.");
                    }
                } else {
                    JOptionPane.showMessageDialog(withdrawDialog, "Amount must be greater than 0.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(withdrawDialog, "Invalid amount. Please enter a number.");
            }
        });

        withdrawDialog.add(amountLabel);
        withdrawDialog.add(amountField);
        withdrawDialog.add(new JLabel());
        withdrawDialog.add(withdrawButton);

        withdrawDialog.setVisible(true);
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