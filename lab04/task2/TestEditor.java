public class TestEditor {
	public static void main(String[] args) {
	DocumentInvoker myDocument = new DocumentInvoker ("callmemaybe");
	 myDocument.Write("Hey I just met you");
	 myDocument.Write("And this is crazy");
	 myDocument.Write("But here’s my number");
	 myDocument.Write("So call me maybe");
    //myDocument.Erase("And this is crazy");
     //myDocument.Undo();
     myDocument.Bold(1); 
	 System.out.println(myDocument.Read());
	 myDocument.printCommandBuffer();
	}
//	 myDocument.Erase("So call me maybe");
//	 System.out.println(myDocument.Read());
//	 myDocument.Write("So call me maybe?");
//	// myDocument.Undo();
//	 System.out.println(myDocument.Read());
//	}
}
