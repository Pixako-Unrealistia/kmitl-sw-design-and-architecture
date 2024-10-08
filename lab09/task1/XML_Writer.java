public class XML_Writer{
    private static XML_Writer xml_writer;

    public static XML_Writer getXML_Writer() {
        if (xml_writer == null) {
            xml_writer = new XML_Writer();
        }
        return xml_writer;
    }

    public void write_Line(int x1, int y1, int x2, int y2) {
        String xmlOutput = String.format("<Line x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\" />", x1, y1, x2, y2);
        System.out.println(xmlOutput);
    }

    public void write_Pixel(int x, int y) {
        String xmlOutput = String.format("<Pixel x=\"%d\" y=\"%d\" />", x, y);
        System.out.println(xmlOutput);
    }

    public void write_Circle(int x, int y, int r) {
        String xmlOutput = String.format("<Circle x=\"%d\" y=\"%d\" radius=\"%d\" />", x, y, r);
        System.out.println(xmlOutput);
    }

}