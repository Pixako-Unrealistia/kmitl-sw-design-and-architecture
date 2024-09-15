public class Triangle extends Shape {
    protected int x2, y2;
    protected int x3, y3;

    public Triangle(int x, int y, int x2, int y2, int x3, int y3) {
        super(x, y); 
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    public void draw() {
        draw.drawLine(x, y, x2, y2);
        draw.drawLine(x2, y2, x3, y3);
        draw.drawLine(x3, y3, x, y);
    }
}
