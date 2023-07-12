package myTest;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TableExample {
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

        // DefaultTableModel을 사용하여 데이터 및 컬럼 이름을 설정
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
                    component.setBackground(Color.GRAY);
                } else {
                    component.setBackground(Color.WHITE);
                }

                return component;
            }
        });
         
        
        // MouseMotionListener 설정
        table.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                int column = table.columnAtPoint(e.getPoint());

                if (row >= 0 && column >= 0) {
                    table.setRowSelectionInterval(row, row);
                    table.setColumnSelectionInterval(column, column);
                }
            }
        });
		
        
        // MouseListener 설정
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                table.clearSelection();
            }
        });

        // JFrame에 JTable 추가
        frame.getContentPane().add(new JScrollPane(table));

        frame.pack();
        frame.setVisible(true);
    }
}
