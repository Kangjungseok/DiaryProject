package myTest;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GridBagLayoutExample extends JFrame {
    public GridBagLayoutExample() {
        setTitle("GridBagLayout Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(gridbag);

        // JLabel 생성 및 이벤트 등록
        for (int column = 0; column < 3; column++) {
            JLabel label = new JLabel("Label " + (column + 1));
            c.gridx = column; // 열 번호 설정
            c.gridy = 0; // 고정된 행 번호 (예제에서는 0으로 고정)
            c.fill = GridBagConstraints.BOTH;
            c.insets = new Insets(5, 5, 5, 5); // 셀 간격 조정

            // JLabel에 이벤트 리스너 등록
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    JLabel clickedLabel = (JLabel) e.getSource();
                    System.out.println("Clicked: " + clickedLabel.getText());
                }
            });

            gridbag.setConstraints(label, c);
            add(label);
        }

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GridBagLayoutExample().setVisible(true);
        });
    }
}
