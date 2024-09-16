
public class Screen {
    private static Screen screen = new Screen();

    public static Screen getScreen() {
        return screen;
    }

    public synchronized void draw_line(int x1, int y1, int x2, int y2) {
        System.err.println("Display in Screen Line: x1=" + x1 + " y1=" + y1 +" to"+ " x2=" + x2 + " y2=" + y2);
    }

    public synchronized void draw_pixel(int x, int y) {
        System.err.println("Display in Screen Pixel: x=" + x + " y=" + y);
    }

    public synchronized void draw_circle(int x, int y, int r) {
        System.out.println("Display in Screen Circle: x=" + x + " y=" + y + " r=" + r);
    }


}
