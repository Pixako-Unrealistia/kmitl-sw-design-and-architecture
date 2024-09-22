public class ComplaintHandler extends Handler {
    public void handleRequest(String request) {
        if (request == "complaint") {
            System.out.println("handling complaint mail.");
        } else {
            getSuccessor().handleRequest(request);
        }
    }
}
