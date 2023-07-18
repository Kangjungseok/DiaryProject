package timeline;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.time.LocalDate;
import java.util.Vector;

import javax.swing.JTable;

public class TimelinePanel extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimelinePanel frame = new TimelinePanel();
					
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
	public TimelinePanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		JPanel datePanel = new JPanel();
		scrollPane.setViewportView(datePanel);
		datePanel.setLayout(new BorderLayout(0, 0));
		
		Vector<LocalDate> datesColumn = new Vector<>();
		int size = 30;
		int before = 0;
		for(int i = 0 ;i<size;i++) {
			datesColumn.add(LocalDate.now().plusDays(i-before));
			System.out.println(datesColumn.get(i));
		}
		
		DefaultTableModel dtm = new DefaultTableModel(datesColumn, 1);
		table = new JTable(dtm);
		for(int i = 0 ; i<datesColumn.size();i++) {
			dtm.setValueAt(dtm.getColumnName(i), 0, i);			
		}
		datePanel.add(table, BorderLayout.CENTER);
		
		
		
		
		
		
		JScrollBar scrollBar = scrollPane.getHorizontalScrollBar();
		scrollBar.setValue( (scrollBar.getMinimum()+scrollBar.getMaximum()) /2);
		
		
		
		SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	            JScrollBar scrollBar = scrollPane.getHorizontalScrollBar();
	            int minValue = scrollBar.getMinimum();
	            int maxValue = scrollBar.getMaximum();
	            int centerValue = (minValue + maxValue) / 2;
	            scrollBar.setValue(centerValue);
	        }
	    });
		scrollBar.addAdjustmentListener(new AdjustmentListener() {
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				int lastindex = dtm.getColumnCount()-1;
				if( (scrollBar.getValue()+scrollBar.getVisibleAmount()) == scrollBar.getMaximum() ) {
					for(int i = 0; i<size;i++) {
						dtm.addColumn(datesColumn.get(lastindex).plusDays(i));
						//dtm.setValueAt(e, 0, before)
					}
					
					
				}
				
			}
		});
		
		
		
		
	}

}
