import java.util.Scanner;

public class Main {
    private final LoggingSidecar sidecar;
    private final ServiceA serviceA;
    private final ServiceB serviceB;

    public Main(LoggingSidecar sidecar) {
        this.sidecar = sidecar;
        this.serviceA = new ServiceA(sidecar); 
        this.serviceB = new ServiceB(sidecar); 
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

       
        while (true) {
            System.out.println("Select a service (A/B) or type 'exit' to quit:");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("exit")) {
                break;
            }

            if (choice.equalsIgnoreCase("A")) {
                System.out.println("Enter a request for Service A:");
                String request = scanner.nextLine();
                serviceA.processRequest(request); 

            } else if (choice.equalsIgnoreCase("B")) {
                System.out.println("Enter a task for Service B:");
                String task = scanner.nextLine();
                serviceB.executeTask(task); 
                System.out.println("Invalid choice! Please select 'A' or 'B'.");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        LoggingSidecar sidecar = new LoggingSidecar(); 
        Main app = new Main(sidecar); 
        app.run();
    }
}