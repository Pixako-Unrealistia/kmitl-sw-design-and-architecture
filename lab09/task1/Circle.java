public class Circle extends Shape {
    private	int x;
	private int y;
    protected int r;
  
    public Circle(int x, int y, int r) {
        this.x = x;
	    this.y = y;
        this.r = r;
    }
  
    public void draw() {
        draw_service.drawCircle(x, y, r);
    }
  
  }
  