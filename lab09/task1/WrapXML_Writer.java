public class WrapXML_Writer extends DrawingService {
    private XML_Writer xml_writer;
    
    public WrapXML_Writer() {
        xml_writer = XML_Writer.getXML_Writer();
    }
    
    public void drawLine(int x1, int y1, int x2, int y2) {
        xml_writer.draw_a_line(x1, y1, x2, y2);
    }
    
    public void drawpixel(int x, int y) {
        xml_writer.draw_a_pixel(x, y);
    }
    
    public void drawCircle(int x, int y, int r) {
        xml_writer.draw_a_circle(x, y, r);
    }   
}
