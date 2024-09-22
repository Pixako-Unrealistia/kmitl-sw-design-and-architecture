public class SpamHandler extends Handler {
    public void handleRequest(String request) {
        if (request == "spam") {
            System.out.println("SpamHandler handling spam mail.");
        } else {
            getSuccessor().handleRequest(request);
        }
    }
}
