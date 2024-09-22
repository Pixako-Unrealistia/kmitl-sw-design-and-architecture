public class FanHandler extends Handler {
    public void handleRequest(String request) {
        if (request == "fan") {
            System.out.println("FanHandler handling fan mail.");
        } else {
            getSuccessor().handleRequest(request);
        }
    }
}
