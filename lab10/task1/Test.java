public class Test {
    public static void main(String arg[]) {
        Handler spamHandler = new SpamHandler();
        Handler fanHandler = new FanHandler();
        Handler complaintHandler = new ComplaintHandler();
        Handler newLocationHandler = new NewLocationHandler();
        Handler catchAllHandler = new CatchAllHandler();

        spamHandler.setSuccessor(fanHandler);
        fanHandler.setSuccessor(complaintHandler);
        complaintHandler.setSuccessor(newLocationHandler);
        newLocationHandler.setSuccessor(catchAllHandler);


        Email spamEmail = new Email("spam");
        Email fanEmail = new Email("fan");
        Email complaintEmail = new Email("complaint");
        Email newLocationEmail = new Email("new location");
        Email notificationEmail = new Email("notification");
        
        spamHandler.handleRequest(spamEmail);
        spamHandler.handleRequest(fanEmail);
        spamHandler.handleRequest(complaintEmail);
        spamHandler.handleRequest(newLocationEmail);
        spamHandler.handleRequest(notificationEmail);
    }
}