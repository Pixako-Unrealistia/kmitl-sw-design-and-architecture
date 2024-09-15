public class WrapScreen extends DrawingService{
    private Screen screen;

    public WrapScreen(){
        screen= Screen.getScreen();
    }

    public void drawLine(int x1, int y1, int x2, int y2){
        screen.draw_a_line(x1, y1, x2, y2);
    }

    public void drawpixel(int x, int y, int r){
        screen.draw_a_pixel(x, y, r);
    }
    
    public void drawCircle(int x, int y, int r){
        screen.draw_a_circle(x, y, r);
    }
    
}
