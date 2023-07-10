package myTest;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ScrollPaneExample {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Scroll Pane Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // JTextArea 생성
        JTextArea textArea = new JTextArea(100, 200);
        
        // JScrollPane 생성 및 JTextArea를 스크롤 가능한 컴포넌트로 설정
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        // 스크롤바 표시 정책 설정 (수평 및 수직 스크롤바 모두 표시)
       
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        
        // JFrame의 ContentPane에 JScrollPane 추가
        frame.getContentPane().add(scrollPane);
        
        frame.setSize(300, 200);
        frame.setVisible(true);

	}

}
