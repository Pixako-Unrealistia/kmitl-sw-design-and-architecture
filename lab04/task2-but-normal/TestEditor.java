public class TestEditor {
	public static void main(String[] args) {
		DocumentInvoker myDocument = new DocumentInvoker("callmemaybe");
		myDocument.Write("Hey I just met you");
		myDocument.Write("And this is crazy");
		myDocument.Write("But here’s my number");

		myDocument.Undo(3);
		myDocument.Redo();

		myDocument.printCommandBuffer();
		System.out.println(myDocument.Read());
//		DocumentInvoker myDocument2 = new DocumentInvoker("callmemaybe");
//		myDocument2.Write("Hey I just met you");
//		myDocument2.Write("And this is crazy");
//		myDocument2.Write("But here’s my number");
//		myDocument2.Undo(2);
//		System.out.println(myDocument2.Read());
//
//		DocumentInvoker myDocument3 = new DocumentInvoker("callmemaybe");
//		myDocument3.Write("Hey I just met you");
//		myDocument3.Write("And this is crazy");
//		myDocument3.Write("But here’s my number");
//		myDocument3.Redo(1);
//		System.out.println(myDocument3.Read());

	}
	// myDocument.Erase("So call me maybe");
	// System.out.println(myDocument.Read());
	// myDocument.Write("So call me maybe?");
	// // myDocument.Undo();
	// System.out.println(myDocument.Read());
	// }
}
