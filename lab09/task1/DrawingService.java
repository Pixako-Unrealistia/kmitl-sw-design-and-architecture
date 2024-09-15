public abstract class DrawingService {
    public abstract void drawLine(int x1, int y1, int x2, int y2);
    public abstract void drawPixel(int x, int y);
    public abstract void drawCircle(int x, int y, int r);
    public abstract void drawPolygon(int[] xPoints, int[] yPoints);
}
