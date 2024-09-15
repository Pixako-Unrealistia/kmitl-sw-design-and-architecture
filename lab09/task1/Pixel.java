public class Pixel extends Shape {

    public Pixel(int x, int y) {
        super(x, y);
    }

    public void draw() {
        draw.drawPixel(x, y);
    }   
}
