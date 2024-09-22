public class SpamHandler extends Handler {
    public void handleRequest(Email email) {
        if (email.getType() == "spam") {
            System.out.println("SpamHandler handling spam mail.");
        } else {
            getSuccessor().handleRequest(email);
        }
    }
}
