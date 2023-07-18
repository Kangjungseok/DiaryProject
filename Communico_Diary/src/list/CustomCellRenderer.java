package list;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class CustomCellRenderer extends DefaultTableCellRenderer {
	

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        // 이벤트 리스너 등록
        component.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // 셀 클릭 시 동작할 내용을 여기에 작성합니다.
                // 예: 특정 셀 클릭 시 다른 동작 수행
            	System.out.println("이벤트 발생!!!!");
            	
            	
            	
            }
        });
        
        return component;
    }
}
