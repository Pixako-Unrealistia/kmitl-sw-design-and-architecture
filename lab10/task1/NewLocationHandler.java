public class NewLocationHandler extends Handler {
    public void handleRequest(Email email) {
        if (email.getType() == "new location") {
            System.out.println("NewLocationHandler handling new location mail.");
        } else {
            getSuccessor().handleRequest(email);
        }
    }
}
