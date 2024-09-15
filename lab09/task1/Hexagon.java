public class Hexagon extends Shape {
    protected int x2, y2;
    protected int x3, y3;
    protected int x4, y4;
    protected int x5, y5;
    protected int x6, y6;

    public Hexagon(int x, int y, int x2, int y2, int x3, int y3, int x4, int y4, int x5, int y5, int x6, int y6) {
        super(x, y);
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.x4 = x4;
        this.y4 = y4;
        this.x5 = x5;
        this.y5 = y5;
        this.x6 = x6;
        this.y6 = y6;
    }

    @Override
    public void draw() {
        draw.drawLine(x, y, x2, y2);
        draw.drawLine(x2, y2, x3, y3);
        draw.drawLine(x3, y3, x4, y4);
        draw.drawLine(x4, y4, x5, y5);
        draw.drawLine(x5, y5, x6, y6);
        draw.drawLine(x6, y6, x, y);
    }
}
