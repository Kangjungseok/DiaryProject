package myTest;

import javax.swing.*;
import java.awt.*;

public class MyMDIApplication extends JFrame {
    private JDesktopPane desktopPane;

    public MyMDIApplication() {
        setTitle("내 MDI 애플리케이션");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        desktopPane = new JDesktopPane();
        getContentPane().add(desktopPane, BorderLayout.CENTER);

        // 내부 프레임 생성 및 추가
        createInternalFrame("프레임 1");
        createInternalFrame("프레임 2");
    }

    private void createInternalFrame(String title) {
        JInternalFrame internalFrame = new JInternalFrame(title, true, true, true, true);
        internalFrame.setSize(200, 200);
        internalFrame.setVisible(true);

        // 내부 프레임에 콘텐츠 추가
        JLabel label = new JLabel(title);
        internalFrame.add(label);

        desktopPane.add(internalFrame);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MyMDIApplication mdiApp = new MyMDIApplication();
            mdiApp.setVisible(true);
        });
    }
}
