package timeline;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class TimelinePanel2 extends JFrame {

	private TimelineContentPane timelineContentPane = new TimelineContentPane();
	private JScrollPane scrollPane = new JScrollPane();
	private Timeline_datePanel datePanel = new Timeline_datePanel();
	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimelinePanel2 frame = new TimelinePanel2();
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
	public TimelinePanel2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		

		setContentPane(timelineContentPane);
		
		
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		timelineContentPane.add(scrollPane, gbc_scrollPane);
		
		scrollPane.setViewportView(datePanel);
		
		SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	            JScrollBar scrollBar = scrollPane.getHorizontalScrollBar();
	            int minValue = scrollBar.getMinimum();
	            int maxValue = scrollBar.getMaximum();
	            int centerValue = (minValue + maxValue) / 2;
	            scrollBar.setValue(centerValue);
	        }
	    });
		
	}

}
