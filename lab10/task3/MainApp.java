import java.util.Scanner;

public class MainApp {
    private final LoggingSidecar sidecar;

    public MainApp(LoggingSidecar sidecar) {
        this.sidecar = sidecar;
    }

    public void processRequest(String request) {
        // Process the request (dummy processing in this example)
        String response = "Processed: " + request;
        
        // Log the request and response using the sidecar
        sidecar.log("Request: " + request);
        sidecar.log("Response: " + response);

        // Print the response
        System.out.println(response);
    }

    public static void main(String[] args) {
        LoggingSidecar sidecar = new LoggingSidecar();
        MainApp app = new MainApp(sidecar);

        // Simulate processing some requests
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a request (or type 'exit' to quit):");
            String request = scanner.nextLine();
            if (request.equalsIgnoreCase("exit")) {
                break;
            }
            app.processRequest(request);
        }
        scanner.close();
    }
}
