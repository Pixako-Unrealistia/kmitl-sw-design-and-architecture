public class Pixel extends Shape {

    private int x;
    private int y;

    public Pixel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw() {
        draw_service.drawPixel(x, y);
    }   
}
