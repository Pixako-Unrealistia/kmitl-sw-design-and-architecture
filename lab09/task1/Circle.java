public class Circle extends Shape {
    protected int r;

    public Circle(int x, int y, int r) {
       
        super(x, y);
        this.r = r;
    }

    public void draw() {
        draw.drawCircle(x, y, r);
    }

}
