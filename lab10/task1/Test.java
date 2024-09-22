public class Test {
    public static void main(String arg[]) {
        Handler spamHandler = new SpamHandler();
        Handler fanHandler = new FanHandler();
        Handler complaintHandler = new ComplaintHandler();
        Handler newLocationHandler = new NewLocationHandler();

        spamHandler.setSuccessor(fanHandler);
        fanHandler.setSuccessor(complaintHandler);
        complaintHandler.setSuccessor(newLocationHandler);
        spamHandler.handleRequest("fan");


    }
}
