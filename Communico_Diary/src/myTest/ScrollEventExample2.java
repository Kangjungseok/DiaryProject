package myTest;

import java.awt.BorderLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class ScrollEventExample2 {
	static boolean eventHandled = false; // 이벤트 처리 여부를 추적하는 변수
	
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ScrollEventExample2::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Scroll Event Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea textArea = new JTextArea(50, 50);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        JScrollBar scrollBar = scrollPane.getVerticalScrollBar();
        
        
        scrollBar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (scrollBar.getValue() == scrollBar.getMinimum()) {
                	scrollBar.setValue(300);
                    System.out.println("스크롤 조정 이벤트 발생!");
                }
            }
        });
        scrollBar.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                if (scrollBar.getValue() == scrollBar.getMinimum()) {
                    if (!eventHandled) { // 이벤트가 처리되지 않은 경우에만 실행
                        System.out.println("스크롤 조정 이벤트 발생!");
                        scrollBar.setValue(300);
                        eventHandled = true; // 이벤트가 처리되었음을 표시
                    }
                } else {
                    eventHandled = false; // 스크롤 위치가 변경되면 이벤트 처리 여부를 재설정
                }
            }
        });

        
        
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
