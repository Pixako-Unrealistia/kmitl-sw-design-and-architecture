public class CurrencyExchangePlugin implements Plugin {
//    private static final int REWARD_AMOUNT = 50;
    private UserManagementPlugin userPlugin;

    public CurrencyExchangePlugin(UserManagementPlugin userPlugin) {
        this.userPlugin = userPlugin;
    }

    @Override
    public void initialize() {
    }

    @Override
    public String execute() {
        return "Currency Exchange system is active.";
    }

    public boolean withdraw(int amount) {
        User currentUser = userPlugin.getCurrentUser();
        if (currentUser != null) {
            return currentUser.subBalance(amount);
        } else {
            System.out.println("No user logged in. Cannot withdraw.");
            return false;
        }
    }
    public void deposit(int amount) {
        User currentUser = userPlugin.getCurrentUser();
        if (currentUser != null) {
            currentUser.addBalance(amount);
            System.out.println("User " + currentUser.getUsername() + " has deposited $" + amount);
        } else {
            System.out.println("No user logged in. Cannot deposit.");
        }
    }
}
