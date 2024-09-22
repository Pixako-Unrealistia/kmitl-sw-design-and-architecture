public class NewLocationHandler extends Handler {
    public void handleRequest(String request) {
        if (request == "new location") {
            System.out.println("NewLocationHandler handling new location mail.");
        } else {
            getSuccessor().handleRequest(request);
        }
    }
}
