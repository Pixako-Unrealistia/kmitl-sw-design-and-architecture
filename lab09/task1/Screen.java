import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Screen extends JComponent {
    private static Screen screenInstance;

    public static Screen getScreen() {
        if (screenInstance == null) {
            screenInstance = new Screen();
        }
        return screenInstance;
    }

    private List<Line> lines;
    private List<Pixel> pixels;
    private List<Arc> arcs;
    private List<Polygon> polygons;
    private JFrame frame;

    private Screen() {
        super();
        frame = new JFrame("Screen");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        lines = new LinkedList<>();
        pixels = new LinkedList<>();
        arcs = new LinkedList<>();
        polygons = new LinkedList<>();
        frame.setVisible(true);
    }

    public synchronized void draw_a_line(int x1, int y1, int x2, int y2) {
        lines.add(new Line(x1, y1, x2, y2));
        repaint();
    }

    public synchronized void draw_a_pixel(int x, int y) {
        pixels.add(new Pixel(x, y));
        repaint();
    }

    public synchronized void draw_a_circle(int x, int y, int r) {
        arcs.add(new Arc(x, y, r));
        repaint();
    }

    public synchronized void draw_a_polygon(int[] xPoints, int[] yPoints) {
        polygons.add(new Polygon(xPoints, yPoints));
        repaint();
    }

    @Override
    public synchronized void paint(Graphics g) {
        g.setColor(Color.blue);
        for (Line line : lines) {
            g.drawLine(line.x1, line.y1, line.x2, line.y2);
        }
        g.setColor(Color.blue);
        for (Polygon polygon : polygons) {
            g.drawPolygon(polygon.xPoints, polygon.yPoints, polygon.xPoints.length);
        }
        g.setColor(Color.blue);
        for (Pixel pixel : pixels) {
            g.fillRect(pixel.x, pixel.y, 1, 1);
        }
        g.setColor(Color.blue);
        for (Arc arc : arcs) {
            g.drawArc(arc.x, arc.y, arc.r * 2, arc.r * 2, 0, 360);
        }
    }

    private static class Polygon {
        int[] xPoints;
        int[] yPoints;

        Polygon(int[] xPoints, int[] yPoints) {
            this.xPoints = xPoints;
            this.yPoints = yPoints;
        }
    }

    private static class Line {
        int x1, y1, x2, y2;

        Line(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    private static class Pixel {
        int x, y;

        Pixel(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Arc {
        int x, y, r;

        Arc(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }
}
