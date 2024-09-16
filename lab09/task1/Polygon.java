public class Polygon extends Shape {
    private int[] x;
    private int[] y;
    private int n;
    public Polygon(int[] x, int[] y, int n) {
        this.x = x;
        this.y = y;
        this.n = n;
    }
    public void draw() {
        System.out.println("Display Polygon which includes:");
        for (int i = 0; i < n - 1; i++) {
            draw_service.drawLine(x[i], y[i], x[i + 1], y[i + 1]);
        }
        draw_service.drawLine(x[n - 1], y[n - 1], x[0], y[0]);
    }
}