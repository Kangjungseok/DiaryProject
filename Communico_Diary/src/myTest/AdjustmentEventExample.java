package myTest;

import java.awt.*;
import java.awt.event.*;

public class AdjustmentEventExample {
    public static void main(String[] args) {
        Frame frame = new Frame("AdjustmentEvent 예제");

        Scrollbar scrollbar = new Scrollbar(Scrollbar.HORIZONTAL, 0, 10, 0, 100);
        scrollbar.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                int value = scrollbar.getValue();
                System.out.println("스크롤바 값 변경: " + value);
            }
        });

        frame.add(scrollbar);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
