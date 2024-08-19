import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainApp extends JFrame {
    private DefaultListModel<Post> postListModel;
    private JList<Post> postList;
    private JLabel adLabel;
    private JButton loginButton;
    private JButton registerButton;
    private JLabel balanceLabel;
    private JButton logoutButton;
    private JButton topupButton;
    private JButton withdrawButton;
    private Microkernel kernel;
    private UserManagementPlugin userPlugin;
    private RewardManagementPlugin rewardPlugin;
    private CurrencyExchangePlugin currencyPlugin;
    private PictureManagementPlugin picturePlugin;
    private PostManagementPlugin postPlugin;
    private NotificationObservable notificationObservable;

    private boolean loggedIn = false;

    public MainApp() {
        postListModel = new DefaultListModel<>();
        postList = new JList<>(postListModel);
        adLabel = new JLabel();

        kernel = new Microkernel();
        userPlugin = new UserManagementPlugin();
        rewardPlugin = new RewardManagementPlugin(userPlugin);
        currencyPlugin = new CurrencyExchangePlugin(userPlugin);
        picturePlugin = new PictureManagementPlugin();
        postPlugin = new PostManagementPlugin(postListModel);
        notificationObservable = new NotificationObservable();

        kernel.registerPlugin("userManagement", userPlugin);
        kernel.registerPlugin("rewardManagement", rewardPlugin);
        kernel.registerPlugin("currencyExchange", currencyPlugin);
        kernel.registerPlugin("pictureManagement", picturePlugin);
        kernel.registerPlugin("postManagement", postPlugin);

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

        registerButton = new JButton("Register");
        registerButton.addActionListener(e -> openRegisterDialog());

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
        userPanel.setLayout(new GridLayout(5, 1));

        sidePanel.add(createPostButton, BorderLayout.NORTH);
        sidePanel.add(adLabel, BorderLayout.CENTER);

        userPanel.add(topupButton);
        userPanel.add(withdrawButton);
        userPanel.add(logoutButton);
        userPanel.add(loginButton);
        userPanel.add(registerButton);
        sidePanel.add(userPanel, BorderLayout.SOUTH);

        add(listingPanel, BorderLayout.CENTER);
        add(sidePanel, BorderLayout.EAST);

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

        updatePostList();
        updateLoginStatus();
    }

    private void updatePostList() {
        postListModel.clear();
        for (Post post : postPlugin.getPosts()) {
            postListModel.addElement(post);
        }
    }

    public class PostRenderer extends JLabel implements ListCellRenderer<Post> {
        @Override
        public Component getListCellRendererComponent(JList<? extends Post> list, Post post, int index, boolean isSelected, boolean cellHasFocus) {
            setText(post.toString());
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

        JLabel rewardAmountLabel = new JLabel("Reward Amount:");
        JTextField rewardAmountField = new JTextField();

        JButton submitButton = new JButton("Submit");

        submitButton.addActionListener(e -> {
            String petName = nameField.getText();
            String description = descriptionField.getText();
            String location = locationField.getText();
            String type = (String) typeComboBox.getSelectedItem();

            if (!petName.isEmpty() && !description.isEmpty() && !location.isEmpty() && rewardAmountField.getText().matches("[0-9]+")) {
                int rewardAmount = Integer.parseInt(rewardAmountField.getText());
                if (rewardAmount > userPlugin.getCurrentUser().getBalance()) {
                    JOptionPane.showMessageDialog(dialog, "You do not have enough balance to post this reward!");
                    return;
                }

                PictureManagementPlugin picturePlugin = (PictureManagementPlugin) kernel.getPlugin("pictureManagement");
                String author = userPlugin.getCurrentUser() != null ? userPlugin.getCurrentUser().getUsername() : "Unknown";
                userPlugin.getCurrentUser().subBalance(rewardAmount);
                balanceLabel.setText("Balance: $" + userPlugin.getCurrentUser().getBalance());
                postPlugin.addPost(petName, description, location, type, picturePlugin.getPicture(), author, rewardAmount);
                notificationObservable.notifyObservers("New post created: " + petName);
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
                postPlugin.removePost(post);
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
            registerButton.setVisible(false);
            logoutButton.setVisible(true);
            withdrawButton.setVisible(true);
            topupButton.setVisible(true);
            balanceLabel.setText("Balance: $" + userPlugin.getCurrentUser().getBalance());
            add(balanceLabel, BorderLayout.SOUTH);
        } else {
            loggedIn = false;
            loginButton.setVisible(true);
            registerButton.setVisible(true);
            logoutButton.setVisible(false);
            withdrawButton.setVisible(false);
            topupButton.setVisible(false);
            remove(balanceLabel);
        }
        revalidate();
        repaint();
    }

    private void openLoginDialog() {
        JDialog dialog = new JDialog(this, "Login", true);
        dialog.setSize(300, 200);
        dialog.setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            boolean success = userPlugin.authenticate(username, password);
            if (success) {
                notificationObservable.addObserver(userPlugin.getCurrentUser());
                updateLoginStatus();
                dialog.dispose();
            } else {
                JOptionPane.showMessageDialog(dialog, "Invalid username or password.");
            }
        });

        dialog.add(usernameLabel);
        dialog.add(usernameField);
        dialog.add(passwordLabel);
        dialog.add(passwordField);
        dialog.add(new JLabel());
        dialog.add(loginButton);

        dialog.setVisible(true);
    }

    private void openRegisterDialog() {
        JDialog dialog = new JDialog(this, "Register", true);
        dialog.setSize(300, 200);
        dialog.setLayout(new GridLayout(4, 2));

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            boolean success = userPlugin.registerUser(username, password);
            if (success) {
                JOptionPane.showMessageDialog(dialog, "Registration successful!");
                dialog.dispose();
            } else {
                JOptionPane.showMessageDialog(dialog, "Username already exists.");
            }
        });

        dialog.add(usernameLabel);
        dialog.add(usernameField);
        dialog.add(passwordLabel);
        dialog.add(passwordField);
        dialog.add(new JLabel());
        dialog.add(registerButton);

        dialog.setVisible(true);
    }

    private void topupBalance() {
        String amountStr = JOptionPane.showInputDialog(this, "Enter amount to top up:");
        try {
            int amount = Integer.parseInt(amountStr);
            currencyPlugin.deposit(amount);
            updateBalanceLabel();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid amount. Please enter a valid number.");
        }
    }

    private void withdrawBalance() {
        String amountStr = JOptionPane.showInputDialog(this, "Enter amount to withdraw:");
        try {
            int amount = Integer.parseInt(amountStr);
            if (amount <= userPlugin.getCurrentUser().getBalance()) {
                currencyPlugin.withdraw(amount);
                updateBalanceLabel();
            } else {
                JOptionPane.showMessageDialog(this, "Insufficient balance.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid amount. Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainApp app = new MainApp();
            app.setVisible(true);
        });
    }
}
