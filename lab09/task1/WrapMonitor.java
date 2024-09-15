public class WrapMonitor extends DrawingService {

    private Monitor monitor;

    public WrapMonitor() {
        monitor = Monitor.getMonitor();
    }

    public void drawLine(int x1, int y1, int x2, int y2) {
        monitor.draw_a_line(x1, y1, x2, y2);
    }

    public void drawPixel(int x, int y) {
        monitor.draw_a_pixel(x, y);
    }

    public void drawCircle(int x, int y, int r) {
        monitor.draw_a_circle(x, y, r);
    }
}
