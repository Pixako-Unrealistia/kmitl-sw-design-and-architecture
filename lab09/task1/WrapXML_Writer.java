public class WrapXML_Writer extends DrawingService {
    private XML_Writer xml_writer;
    
    public WrapXML_Writer() {
        xml_writer = XML_Writer.getXML_Writer();
    }

    public void drawLine(int x1, int y1, int x2, int y2) {
        xml_writer.write_Line(x1, y1, x2, y2);
    }

    public void drawPixel(int x, int y) {
        xml_writer.write_Pixel(x, y);
    }   

    public void drawCircle(int x, int y, int r) {
        xml_writer.write_Circle(x, y, r);
    }

}
