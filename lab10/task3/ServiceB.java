class ServiceB {
    private final LoggingSidecar sidecar;

    public ServiceB(LoggingSidecar sidecar) {
        this.sidecar = sidecar;
    }

    public void executeTask(String task) {

        sidecar.log("Service B - Task: " + task);
        System.out.println("Service B is executing the task: " + task);
    }
}