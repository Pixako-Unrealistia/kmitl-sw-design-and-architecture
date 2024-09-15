public abstract class Shape{
    protected int x ;
    protected int y ;

    protected DrawingService draw;

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
        this.draw = new WrapMonitor();
    }

    public abstract void draw();

    public void setDrawType(DrawingService draw) {
        this.draw = draw;
    }   
}
