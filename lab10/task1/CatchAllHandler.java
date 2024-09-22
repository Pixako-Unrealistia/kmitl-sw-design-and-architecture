public class CatchAllHandler extends Handler {
    public void handleRequest(Email email) {
        System.out.println("CatchAllHandler: No handler found for email type: " + email.getType());
    }
}
