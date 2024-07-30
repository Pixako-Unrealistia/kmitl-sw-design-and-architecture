import java.util.Stack;

public class DocumentInvoker {
	private Stack<Command> undoStack = new Stack<>();
	private Stack<Command> redoStack = new Stack<>();
	private Document currentDoc;

	public DocumentInvoker(String name) {
		currentDoc = new Document(name);
	}

	public void Undo() {
		if (!undoStack.isEmpty()) {
			Command cmd = undoStack.pop();
			cmd.undo();
			redoStack.push(cmd);
		}
	}

	public void Redo() {
		if (!redoStack.isEmpty()) {
			Command cmd = redoStack.pop();
			cmd.redo();
			undoStack.push(cmd);
		}
	}

	public void Undo(int step) {
		for (int i = 0; i < step; i++) {
			Undo();
		}
	}

	public void Redo(int step) {
		for (int i = 0; i < step; i++) {
			Redo();
		}
	}

	public void Write(String text) {
		DocumentWriteCommand cmd = new DocumentWriteCommand(currentDoc, text);
		cmd.redo();
		undoStack.push(cmd);
		redoStack.clear();
	}

	public void Erase(String text) {
		DocumentEraseCommand cmd = new DocumentEraseCommand(currentDoc, text);
		cmd.redo();
		undoStack.push(cmd);
		redoStack.clear();
	}

	public void Bold(int line) {
		DocumentBoldCommand cmd = new DocumentBoldCommand(currentDoc, line);
		cmd.redo();
		undoStack.push(cmd);
		redoStack.clear();
	}

	public void RemoveBold(int line) {
		DocumentRemoveBoldCommand cmd = new DocumentRemoveBoldCommand(currentDoc, line);
		cmd.redo();
		undoStack.push(cmd);
		redoStack.clear();
	}

	public String Read() {
		return currentDoc.Read();
	}

	public void printCommandBuffer() {
		StringBuffer txt = new StringBuffer();
		txt.append("---- Commands issued----\n");
		for (int i = 0; i < undoStack.size(); i++) {
			txt.append(i + ":" + undoStack.get(i) + "\n");
		}
		System.out.println(txt.toString());
	}
}