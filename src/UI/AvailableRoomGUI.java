package UI;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import myLibs.JDBCroom;
import myLibs.RoomLibs2;

public class AvailableRoomGUI {

	JFrame frame;
	Object[] columns;
	DefaultTableModel model;
	JTable table;
	ArrayList<RoomLibs2> tmpPerson;

	// default constructor to set the contents of frame
	public AvailableRoomGUI() {

		frame = new JFrame("Available Room");
		frame.setSize(450, 250);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());

		// adding JTable in frame
		columns = new Object[4];
		columns[0] = "Room No";
		columns[1] = "Room Type";
		columns[2] = "Room Price";
		columns[3] = "Room Status";

		table = new JTable();
		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(columns);
		updateTable();
		JScrollPane scroll1 = new JScrollPane(table);
		scroll1.setBounds(400, 20, 500, 400);
		frame.add(scroll1, BorderLayout.CENTER);

		frame.setVisible(true);

	}

	public void updateTable() {

		JDBCroom jdbc = new JDBCroom();
		ArrayList select = jdbc.searchAvailableRoom();
		model.setRowCount(0);
		if (select.size() > 0) {
			for (int i = 0; i < select.size(); i++) {

				RoomLibs2 room = (RoomLibs2) select.get(i);
				Vector tmpperson = new Vector();

				tmpperson.add(room.getRoom_No());
				tmpperson.add(room.getRoom_Type());
				tmpperson.add(room.getRoom_Price());
				tmpperson.add(room.getRoom_Status());

				model.addRow(tmpperson);
			}
		}

	}

	//main method to run the program
	public static void main(String[] args) {
		new AvailableRoomGUI();

	}

}
