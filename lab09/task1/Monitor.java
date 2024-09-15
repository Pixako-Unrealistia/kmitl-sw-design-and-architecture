import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Monitor extends JComponent {
    private static Monitor monitorInstance;

    public static Monitor getMonitor() {
        if (monitorInstance == null) {
            monitorInstance = new Monitor();
        }
        return monitorInstance;
    }

    private List<Line> lines;
    private List<Pixel> pixels;
    private List<Arc> arcs;
    private List<Polygon> polygons;
    private JFrame frame;

    private Monitor() {
        super();
        frame = new JFrame("Monitor");
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
        g.setColor(Color.red);
        for (Line line : lines) {
            g.drawLine(line.x1, line.y1, line.x2, line.y2);
        }
        g.setColor(Color.red);
        for (Polygon polygon : polygons) {
            g.drawPolygon(polygon.xPoints, polygon.yPoints, polygon.xPoints.length);
        }
        g.setColor(Color.red);
        for (Pixel pixel : pixels) {
            g.fillRect(pixel.x, pixel.y, 1, 1);
        }
        g.setColor(Color.red);
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


}
