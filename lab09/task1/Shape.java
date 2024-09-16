public abstract class Shape{

    protected DrawingService draw_service;

    public Shape() {
        this.draw_service = new WrapScreen();
    }

    public abstract void draw();

    public void setDrawType(DrawingService draw) {
        this.draw_service = draw;
    }
}