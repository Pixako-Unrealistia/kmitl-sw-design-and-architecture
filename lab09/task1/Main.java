import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<Shape>();
        shapes.add(new Circle(20, 20, 30));
        shapes.add(new Pixel (22, 22));
        shapes.add(new Pixel (24, 24));
        shapes.add(new Pixel (26, 26));
        shapes.add(new Rectangle(100, 100, 200, 200));
        shapes.add(new Triangle(50, 50, 100, 50, 75, 100));
        for (Shape s : shapes) {
            s.draw();
          }

        for (Shape s : shapes) {
            s.setDrawType(new WrapScreen());
            s.draw();
        }

        for (Shape s : shapes) {
            s.setDrawType(new WrapXML_Writer());
            s.draw();
        }

    }
}