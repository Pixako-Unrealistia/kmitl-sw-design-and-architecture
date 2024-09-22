public class ComplaintHandler extends Handler {
    public void handleRequest(Email email) {
        if (email.getType() == "complaint") {
            System.out.println("ComplaintHandler handling complaint mail.");
        } else {
            getSuccessor().handleRequest(email);
        }
    }
}
