public class FanHandler extends Handler {
    public void handleRequest(Email email) {
        if (email.getType() == "fan") {
            System.out.println("FanHandler handling fan mail.");
        } else {
            getSuccessor().handleRequest(email);
        }
    }
}
