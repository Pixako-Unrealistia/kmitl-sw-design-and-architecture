public class XML_Writer {

    
        private static XML_Writer xml_writer = new XML_Writer();

        private XML_Writer() {
        }

        public static XML_Writer getXML_Writer() {
            return xml_writer;
        }
        
        public void draw_a_line(int x1, int y1, int x2, int y2) {
            System.out.println("XML_Writer Drawing a line from (" + x1 + "," + y1 + ") to (" + x2 + "," + y2 + ")");
        }
    
        public void draw_a_pixel(int x, int y, int r) {
            System.out.println("XML_Writer Drawing a pixel at (" + x + "," + y + ") with radius " + r);
        }
    
        public void draw_a_circle(int x, int y, int r) {
            System.out.println("XML_Writer Drawing a circle at (" + x + "," + y + ") with radius " + r);
        }
    
    
}
