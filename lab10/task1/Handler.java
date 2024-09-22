public class Handler {
    private Handler successor;
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
    public Handler getSuccessor() {
        return successor;
    }
    public void handleRequest(Email request) {
        successor.handleRequest(request);
    };
}
