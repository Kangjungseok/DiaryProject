package myTest;

import javax.swing.*;
import javax.swing.table.*;

public class HiddenColumnNameExample {
    public static void main(String[] args) {
        // 테이블 데이터 생성
        Object[][] data = {
            {"John", "Doe", 30},
            {"Jane", "Smith", 25},
            {"Bob", "Johnson", 35}
        };

        // 열 이름 생성
        String[] columnNames = {"First Name", "Last Name", "Age"};

        // TableModel 생성
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // JTable 생성
        JTable table = new JTable(model);

        // TableColumnModel 가져오기
        TableColumnModel columnModel = table.getColumnModel();

        // 각 열의 헤더를 숨기기
        /*
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            TableColumn column = columnModel.getColumn(i);
            column.setHeaderValue(null);
        }
		*/
        
        // JTable 갱신
        table.getTableHeader().setVisible(false);
        //table.repaint();
        
        // JTable을 JFrame에 추가하여 보여주기
        JFrame frame = new JFrame("Hidden Column Name Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new JScrollPane(table));
        frame.pack();
        frame.setVisible(true);
    }
}
