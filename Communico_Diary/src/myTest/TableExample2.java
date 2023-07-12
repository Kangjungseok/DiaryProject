package myTest;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class TableExample2 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("JTable Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 테이블 데이터와 컬럼 이름 배열
		Object[][] data = {
		    {"John", "Doe", 30},
		    {"Jane", "Smith", 25},
		    {"Bob", "Johnson", 40}
		};
		String[] columnNames = {"First Name", "Last Name", "Age"};

		// DefaultTableModel을 사용하여 데이터 및 컬럼 이름 설정
		DefaultTableModel model = new DefaultTableModel(data, columnNames);

		// JTable 생성
		JTable table = new JTable(model);
		
		// TableCellRenderer 설정
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
		    @Override
		    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
		                                                   boolean hasFocus, int row, int column) {
		        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

		        if (hasFocus) {
		            component.setBackground(Color.BLUE);
		        } else {
		            component.setBackground(Color.WHITE);
		        }

		        return component;
		    }
		});


		// MouseListener 설정
		table.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		        int column = table.columnAtPoint(e.getPoint());

		        if (column == 0) {
		            table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		            table.repaint();
		        }
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		        int column = table.columnAtPoint(e.getPoint());

		        if (column == 0) {
		            table.setCursor(Cursor.getDefaultCursor());
		            table.repaint();
		        }
		    }

		    @Override
		    public void mouseClicked(MouseEvent e) {
		        int column = table.columnAtPoint(e.getPoint());

		        if (column == 0) {
		            int row = table.rowAtPoint(e.getPoint());
		            table.changeSelection(row, column, false, false);
		            table.repaint();
		        }
		    }
		});

		 // JFrame에 JTable 추가
        frame.getContentPane().add(new JScrollPane(table));
        frame.pack();
        frame.setVisible(true);
		
	}

}
