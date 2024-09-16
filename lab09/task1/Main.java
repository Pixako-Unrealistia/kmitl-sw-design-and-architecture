import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<Shape>();
        shapes.add(new Circle(20, 20, 30));
        shapes.add(new Pixel (22, 22));
        shapes.add(new Rectangle(100, 100, 200, 200));
        shapes.add(new Polygon(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}, 5));
        
        for (Shape s : shapes) {
            s.draw();
          }

        System.out.println("=====================================");
        for (Shape s : shapes) {
            s.setDrawType(new WrapPrinter());
            s.draw();
        }

        System.out.println("=====================================");
        for (Shape s : shapes) {
            s.setDrawType(new WrapXML_Writer());
            s.draw();
        }

    }
}