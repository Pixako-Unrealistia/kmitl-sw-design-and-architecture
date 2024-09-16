
public class Printer {
    private static Printer printer = new Printer();

    public static Printer getPrinter() {
        return printer;
    }

    public synchronized void print_line(int x1, int y1, int x2, int y2) {
        System.err.println("Print in printer Line: x1=" + x1 + " y1=" + y1 +" to"+" x2=" + x2 + " y2=" + y2);
    }

    public synchronized void print_pixel(int x, int y) {
        System.err.println("Print in printer Pixel: x=" + x + " y=" + y);
    }

    public synchronized void print_circle(int x, int y, int r) {
        System.out.println("Print in printer Circle: x=" + x + " y=" + y + " r=" + r);
    }


}
