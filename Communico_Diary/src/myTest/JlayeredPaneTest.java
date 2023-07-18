package myTest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

public class JlayeredPaneTest extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JlayeredPaneTest frame = new JlayeredPaneTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JlayeredPaneTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(new Color(255, 0, 0));
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBackground(new Color(0, 255, 128));
		layeredPane_1.setBounds(0, 0, 376, 241);
		layeredPane_1.moveToFront(layeredPane_1);
		layeredPane.add(layeredPane_1);
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		layeredPane_2.setBackground(new Color(255, 0, 0));
		layeredPane_2.setBounds(0, 0, 264, 400);
		layeredPane.add(layeredPane_2);
		
		JLayeredPane layeredPane_3 = new JLayeredPane();
		layeredPane_3.setBackground(new Color(0, 128, 192));
		layeredPane_3.setBounds(0, 0, 300, 300);
		layeredPane.add(layeredPane_3);
	}
}
