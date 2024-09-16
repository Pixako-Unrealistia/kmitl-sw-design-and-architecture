public class WrapPrinter extends DrawingService {

    private Printer printer;

    public WrapPrinter() {
        printer = Printer.getPrinter();
    }

    public void drawLine(int x1, int y1, int x2, int y2) {
        printer.print_line(x1, y1, x2, y2);
    }

    public void drawPixel(int x, int y) {
        printer.print_pixel(x, y);
    }

    public void drawCircle(int x, int y, int r) {
        printer.print_circle(x, y, r);
    }
}
