package lab02.task2.PUSH;

class TestBabyMonitor {
    public static void main(String[] args) {
        Baby marla = new Baby("marla");
        // one monitor with one baby
        BabyMonitorSimple livingRoom = new BabyMonitorSimple("kitchen ", marla);
        marla.setData(true, 1);
        Baby charlie = new Baby("Charlie");
        marla.setData(true, 2);
        charlie.setData(true, 1);
    }
}
