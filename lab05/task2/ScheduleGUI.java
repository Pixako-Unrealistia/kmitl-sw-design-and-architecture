import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class ScheduleGUI extends JFrame {  // Caretaker

	private TableMemento memento;
	private ScheduleTableModel tableModel;

	private Object[][] data = {
			{"08.00-09.00", "----", "Math", "", "", ""},
			{"09.00-10.00", "", "Math", "", "", ""},
			{"10.00-11.00", "", "", "SE 2", "", "Math"},
			{"11.00-12.00", "", "", "SE 2", "", "Math"},
			{"12.00-13.00", "----", "----", "----", "----", "----"},
			{"13.00-14.00", "SE 2", "OpSys", "", "", ""},
			{"14.00-15.00", "SE 2", "OpSys", "", "Project", ""},
			{"15.00-16.00", "", "OpSys", "", "Project", ""},
			{"16.00-17.00", "", "OpSys", "", "Project", ""},
			{"17.00-18.00", "", "", "", "Project", ""}
		};

	private String[] columnNames = {
		"Time", 
		"Monday",
		"Tuesday",
		"Wednesday",
		"Thursday",
		"Friday"
	};

	public ScheduleGUI() {
		super("Schedule GUI with Memento");
		initComponents();
		pack();
	}

	protected void initComponents() {
		addWindowListener (new WindowAdapter () {
			public void windowClosing (WindowEvent evt) {
				exitForm (evt);
			}
		});

		JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("File");

		JMenuItem saveAsMenuItem = new JMenuItem("Save As..");
		saveAsMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Save As functionality
				memento = new TableMemento(tableModel.getData());
			}
		});
		fileMenu.add(saveAsMenuItem);

		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				exitMenuItemActionPerformed (e);
			}
		});

		fileMenu.add(exitMenuItem);
		mb.add(fileMenu);
		setJMenuBar(mb);

		tableModel = new ScheduleTableModel(data, columnNames);
		final JTable table = new JTable(tableModel);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		JButton newButton = new JButton("Snapshot");
		newButton.setPreferredSize(new Dimension(125, 27));
		newButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// Get new memento.
				memento = new TableMemento(tableModel.getData());
			}
		});

		JButton revertButton = new JButton("Revert");
		revertButton.setPreferredSize(new Dimension(125, 27));
		revertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// Set memento.
				if (memento != null) {
					tableModel.setData(memento.getData());
				}
			}
		});

		JPanel panel = new JPanel();
		panel.add(newButton);
		panel.add(revertButton);
		getContentPane().add(panel, BorderLayout.SOUTH);

		// Take a memento for the initial state of the table.
		memento = new TableMemento(tableModel.getData());
	}

	protected void exitMenuItemActionPerformed(ActionEvent evt) {
		System.exit(0);
	}

	protected void exitForm(WindowEvent e) {
		System.exit(0);
	}

	public static void main(String[] args) {
		new ScheduleGUI().setVisible(true);
	} // end of main ()

	// Memento class to store the table state
	private class TableMemento {
		private Object[][] data;

		public TableMemento(Object[][] data) {
			this.data = new Object[data.length][];
			for (int i = 0; i < data.length; i++) {
				this.data[i] = data[i].clone();
			}
		}

		public Object[][] getData() {
			return data;
		}
	}

	// Custom table model class
	private class ScheduleTableModel extends AbstractTableModel {
		private Object[][] data;
		private String[] columnNames;

		public ScheduleTableModel(Object[][] data, String[] columnNames) {
			this.data = data;
			this.columnNames = columnNames;
		}

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return data.length;
		}

		public Object getValueAt(int row, int col) {
			return data[row][col];
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

		public void setValueAt(Object value, int row, int col) {
			data[row][col] = value;
			fireTableCellUpdated(row, col);
		}

		public boolean isCellEditable(int row, int col) {
			return col != 0; // Time column is not editable
		}

		public void setData(Object[][] data) {
			this.data = data;
			fireTableDataChanged();
		}

		public Object[][] getData() {
			return data;
		}
	}
}