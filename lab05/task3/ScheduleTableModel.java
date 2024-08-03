import java.io.*;
import java.util.ArrayList;
import javax.swing.table.*;

public class ScheduleTableModel extends DefaultTableModel {

	public ScheduleTableModel(Object[][] data, Object[] columnNames) {
		super(data, columnNames);
	}

	public TableMemento createMemento() {
		ArrayList<Object> columnIdentifiers = new ArrayList<>(getColumnCount());
		for (int i = 0; i < getColumnCount(); i++) {
			columnIdentifiers.add(getColumnName(i));
		}

		ArrayList<ArrayList<Object>> dataVector = new ArrayList<>(getRowCount());
		for (int i = 0; i < getRowCount(); i++) {
			ArrayList<Object> row = new ArrayList<>(getColumnCount());
			for (int j = 0; j < getColumnCount(); j++) {
				row.add(getValueAt(i, j));
			}
			dataVector.add(row);
		}

		return new TableMemento(columnIdentifiers, dataVector);
	}

	public void setMemento(TableMemento memento) {
		ArrayList<ArrayList<Object>> dataVector = memento.getDataVector();
		Object[][] dataArray = new Object[dataVector.size()][];
		for (int i = 0; i < dataVector.size(); i++) {
			dataArray[i] = dataVector.get(i).toArray();
		}
		setDataVector(dataArray, memento.getColumnIdentifiers().toArray());
	}

	public void save(String filename) throws IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
			out.writeObject(createMemento());
		}
	}

	public void load(String filename) throws IOException, ClassNotFoundException {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
			TableMemento memento = (TableMemento) in.readObject();
			setMemento(memento);
		}
	}

	public class TableMemento implements Serializable {
		private ArrayList<Object> columnIdentifiers;
		private ArrayList<ArrayList<Object>> dataVector;

		public TableMemento(ArrayList<Object> columnIdentifiers, ArrayList<ArrayList<Object>> dataVector) {
			this.columnIdentifiers = columnIdentifiers;
			this.dataVector = dataVector;
		}

		public ArrayList<Object> getColumnIdentifiers() {
			return columnIdentifiers;
		}

		public ArrayList<ArrayList<Object>> getDataVector() {
			return dataVector;
		}

		public String toString() {
			return "[ci=" + columnIdentifiers.toString() + "\n" +
				   "dl=" + dataVector.toString() + "]";
		}
	}
}
