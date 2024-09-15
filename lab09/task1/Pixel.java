public class Pixel extends Shape {
    protected int r;

    public Pixel(int x, int y, int r) {
        super(x, y);
        this.r = r;
    }

    public void draw() {
        draw.drawpixel(x, y, r);
    }   
}
