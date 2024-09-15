public class Screen {
    private static Screen Screen = new Screen();
    private Screen() {
        
    }
    public static Screen getScreen() {
        return Screen;
    }
    public void draw_a_line(int x1, int y1, int x2, int y2) {
        System.out.println("Screen Drawing a line from (" + x1 + "," + y1 + ") to (" + x2 + "," + y2 + ")");
    }

    public void draw_a_pixel(int x, int y, int r) {
        System.out.println("Screen Drawing a pixel at (" + x + "," + y + ") with radius " + r);
    }

    public void draw_a_circle(int x, int y, int r) {
        System.out.println("Screen Drawing a circle at (" + x + "," + y + ") with radius " + r);
    }
}
