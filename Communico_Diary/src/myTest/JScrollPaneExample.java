package myTest;

import javax.swing.*;
import javax.swing.table.TableModel;

import java.awt.*;

public class JScrollPaneExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JScrollPane 예제");

        // heavyweight 컴포넌트 생성
        TextArea textArea = new TextArea(100, 300);

        // JScrollPane에 heavyweight 컴포넌트 추가
        JScrollPane scrollPane = new JScrollPane(textArea);

        new JScrollPane(new JTable(new TableModel));
        // JScrollPane을 프레임에 추가
        frame.getContentPane().add(scrollPane);

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
