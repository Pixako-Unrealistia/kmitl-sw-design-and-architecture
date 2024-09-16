public class Rectangle extends Shape{
    private int x;
    private int y;
    private int x2;
    private int y2;

    public Rectangle(int x, int y, int x2, int y2) {
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void draw() {
        System.out.println("Display Rectangle which includes:");
        draw_service.drawLine(x, y, x2, y);
        draw_service.drawLine(x2, y, x2, y2);
        draw_service.drawLine(x2, y2, x, y2);
        draw_service.drawLine(x, y2, x, y);
    }

}
