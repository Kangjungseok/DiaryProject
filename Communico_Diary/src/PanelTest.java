import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import javax.swing.UIManager;
import java.awt.Scrollbar;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.time.LocalDate;

import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;

public class PanelTest extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelTest frame = new PanelTest();
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
	public PanelTest() {
		setBounds(new Rectangle(0, 0, 1920, 1080));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(0, 0, 1920, 1080));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(new Rectangle(0, 0, 1000, 1000));
		panel.setBackground(new Color(236, 205, 180));
		panel.setBounds(920, 80, 1000, 1000);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel calendarPanel = new JPanel();
		calendarPanel.setBounds(0, 120, 1000, 46);
		calendarPanel.setBackground(new Color(128, 128, 0));
		panel.add(calendarPanel);
		calendarPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\uC6D4 \uD45C\uC2DC");
		lblNewLabel_1.setBounds(49, 21, 57, 15);
		calendarPanel.add(lblNewLabel_1);
		
		JPanel workPanel = new JPanel();
		workPanel.setBounds(0, 0, 1000, 120);
		workPanel.setBackground(Color.ORANGE);
		panel.add(workPanel);
		workPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uFF0B\uC791\uC5C5 \uCD94\uAC00");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(112, 47, 65, 30);
		workPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("\uBAA8\uB4E0 \uC791\uC5C5");
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBounds(233, 47, 57, 30);
		workPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("\uC624\uB298");
		lblNewLabel_2_1.setOpaque(true);
		lblNewLabel_2_1.setBounds(744, 47, 32, 30);
		workPanel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("\uC77C");
		lblNewLabel_2_1_1.setOpaque(true);
		lblNewLabel_2_1_1.setBounds(818, 47, 32, 30);
		workPanel.add(lblNewLabel_2_1_1);
		
		JPanel timeUnitPanel = new JPanel();
		timeUnitPanel.setBounds(684, 75, 168, 210);
		timeUnitPanel.setOpaque(false);
		timeUnitPanel.setLayout(null);
		panel.add(timeUnitPanel);
		
		JLabel lblNewLabel_4 = new JLabel("\uC2DC\uAC04");
		lblNewLabel_4.setBounds(0, 0, 168, 30);
		timeUnitPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("\uC77C");
		lblNewLabel_4_1.setBounds(0, 30, 168, 30);
		timeUnitPanel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("\uC8FC");
		lblNewLabel_4_2.setBounds(0, 60, 168, 30);
		timeUnitPanel.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("\uB2EC");
		lblNewLabel_4_3.setBounds(0, 90, 168, 30);
		timeUnitPanel.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_4_4 = new JLabel("\uBD84\uAE30");
		lblNewLabel_4_4.setBounds(0, 120, 168, 30);
		timeUnitPanel.add(lblNewLabel_4_4);
		
		JLabel lblNewLabel_4_5 = new JLabel("\uBC18\uAE30");
		lblNewLabel_4_5.setBounds(0, 150, 168, 30);
		timeUnitPanel.add(lblNewLabel_4_5);
		
		JLabel lblNewLabel_4_6 = new JLabel("\uB144");
		lblNewLabel_4_6.setBounds(0, 180, 168, 30);
		timeUnitPanel.add(lblNewLabel_4_6);
		
		
		
		table = new JTable();
		table.setShowGrid(false);
		DefaultTableModel dtm =new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,},
					},
				new String[] {
						String.valueOf(LocalDate.now().plusDays(-14).getDayOfMonth()), String.valueOf(LocalDate.now().plusDays(-13).getDayOfMonth()), String.valueOf(LocalDate.now().plusDays(-12).getDayOfMonth()), String.valueOf(LocalDate.now().plusDays(-11).getDayOfMonth()), String.valueOf(LocalDate.now().plusDays(-10).getDayOfMonth()), String.valueOf(LocalDate.now().plusDays(-9).getDayOfMonth()), String.valueOf(LocalDate.now().plusDays(-8).getDayOfMonth()), String.valueOf(LocalDate.now().plusDays(-7).getDayOfMonth()), String.valueOf(LocalDate.now().plusDays(-6).getDayOfMonth()), String.valueOf(LocalDate.now().plusDays(-5).getDayOfMonth()), String.valueOf(LocalDate.now().plusDays(-4).getDayOfMonth()), String.valueOf(LocalDate.now().plusDays(-3).getDayOfMonth()), String.valueOf(LocalDate.now().plusDays(-2).getDayOfMonth()), String.valueOf(LocalDate.now().plusDays(-1).getDayOfMonth()), String.valueOf(LocalDate.now().getDayOfMonth()), String.valueOf(LocalDate.now().plusDays(1).getDayOfMonth()), String.valueOf(LocalDate.now().plusDays(2).getDayOfMonth()), String.valueOf(LocalDate.now().plusDays(3).getDayOfMonth()), String.valueOf(LocalDate.now().plusDays(4).getDayOfMonth()), String.valueOf(LocalDate.now().plusDays(5).getDayOfMonth())
				});
		table.setModel(dtm);
		//String[] 에 날짜가 들어가도록?
		//스크롤바를 기준으로, 스크롤바가 min val, max val 에 닿았을 때 컬럼을 추가시키고...
		
		
		
		
		table.setBorder(new EmptyBorder(0, 0, 0, 0));
		table.setBackground(UIManager.getColor("Button.background"));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 166, 1000, 756);
		
		
		//으아아아아아아아아!!!!!!!!!!!!!!!!!!!!!
		//스크롤의 크기를 줄여서 왼쪽, 오른쪽으로 이동할 수 있게 만들자.
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		//scrollPane.getHorizontalScrollBar().setValues(50, 10, 0, 100);
		
		panel.add(scrollPane);
		scrollPane.setViewportView(table);
		
		 
		scrollPane.getHorizontalScrollBar().addAdjustmentListener(new AdjustmentListener() {
			
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				if(scrollPane.getHorizontalScrollBar().getValue() == scrollPane.getHorizontalScrollBar().getMaximum()) {
					//스크롤이 오른쪽 끝에 닿으면 30개 열을 추가시킨다.
					for(int i = 1 ; i<=30 ; i++) {
						dtm.addColumn(String.valueOf(LocalDate.now().plusDays(5+i).getDayOfMonth()));					
					}
					
				}
	
				
			}
		});
		
	}
}
