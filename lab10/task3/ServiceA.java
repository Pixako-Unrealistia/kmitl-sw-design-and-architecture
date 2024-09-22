class ServiceA {
    private final LoggingSidecar sidecar;

    public ServiceA(LoggingSidecar sidecar) {
        this.sidecar = sidecar;
    }

    public void processRequest(String request) {

        sidecar.log("Service A - Request: " + request);
        System.out.println("Service A is processing the request: " + request);
    }
}