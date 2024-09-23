import java.util.Scanner;

public class Main {
    private final ServiceA serviceA;
    private final ServiceB serviceB;

    public Main() {
        this.serviceA = new ServiceA(); 
        this.serviceB = new ServiceB(); 
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
            } else {
                System.out.println("Invalid choice! Please select 'A' or 'B'.");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        Main app = new Main(); 
        app.run();
    }
}