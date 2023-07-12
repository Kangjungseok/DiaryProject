package myTest;

import java.awt.BorderLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class ScrollEventExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ScrollEventExample::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Scroll Event Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea textArea = new JTextArea(50, 50);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        JScrollBar scrollBar = scrollPane.getVerticalScrollBar();
        
        scrollBar.addAdjustmentListener(new AdjustmentListener() {
            private boolean adjustmentNeeded = true;

            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
            	
            	System.out.println("스크롤바 변경 전 최소값 : "+ scrollBar.getMinimum());
    	        System.out.println("스크롤바 변경 전 최댓값 : "+ scrollBar.getMaximum());
            	System.out.println("스크롤바의 변경 전 크기" +scrollBar.getVisibleAmount());
            	System.out.println("스크롤바의 초기 위치 : "+scrollBar.getValue());
            	scrollBar.setValues(50, 10, 0, 100);
            	
            	System.out.println("스크롤바 변경 후 최소값 : "+ scrollBar.getMinimum());
    	        System.out.println("스크롤바 변경 후 최댓값 : "+ scrollBar.getMaximum());
            	System.out.println("스크롤바의 변경 후 크기" +scrollBar.getVisibleAmount());
            	System.out.println("스크롤바의 현재 위치 : "+scrollBar.getValue());
            	
            	
            	
                    // 스크롤 조정 이벤트를 처리하는 로직을 작성합니다.
            		if(scrollBar.getValue() == scrollBar.getMinimum()) {
              		  System.out.println("스크롤 조정 이벤트 발생!");
              		  scrollBar.setValue(100);
              	  }

            		 
            	        
            	        System.out.println("스크롤바 상단? 현재 위치 : " + scrollBar.getValue());
            	        
            	        System.out.println("스크롤바 상단? 현재 위치 : " + scrollBar.getValue());
                    
                   
                
            	
            	/*
            	  if(scrollBar.getValue() == scrollBar.getMinimum()) {
            		  System.out.println("스크롤 조정 이벤트 발생!");
            		  scrollBar.setValue(100);
            	  }
            	  */
            	/*
            	if (adjustmentNeeded) {
                    // 스크롤 조정 이벤트를 처리하는 로직을 작성합니다.
                    System.out.println("스크롤 조정 이벤트 발생!");

                    // 이벤트 처리 후 adjustmentNeeded 값을 false로 설정하여 이후 이벤트를 무시합니다.
                    adjustmentNeeded = false;
                }
            	*/
            }
        });

        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
