package myTest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JEditorPane;

public class JDesktopPaneTest extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JDesktopPaneTest frame = new JDesktopPaneTest();
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
	public JDesktopPaneTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(90, 0, 103, 17);
		desktopPane.add(toolBar);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("New toggle button");
		tglbtnNewToggleButton.setBounds(86, 89, 135, 23);
		desktopPane.add(tglbtnNewToggleButton);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(90, 122, 97, 23);
		desktopPane.add(btnNewButton);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(233, 91, 128, 83);
		desktopPane.add(editorPane);
	}
}
