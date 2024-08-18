public class RewardManagementPlugin implements Plugin {
//    private static final int REWARD_AMOUNT = 50;
    private UserManagementPlugin userPlugin;

    public RewardManagementPlugin(UserManagementPlugin userPlugin) {
        this.userPlugin = userPlugin;
    }

    @Override
    public void initialize() {
    }

    @Override
    public String execute() {
        return "Reward system is active.";
    }

    public void rewardUser(int rewardAmount) {
        User currentUser = userPlugin.getCurrentUser();
        if (currentUser != null) {
            currentUser.addBalance(rewardAmount);
            System.out.println("User " + currentUser.getUsername() + " has been rewarded $" + rewardAmount);
        } else {
            System.out.println("No user logged in. Cannot reward.");
        }
    }
}
