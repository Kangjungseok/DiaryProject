package list;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;

public class ListPanel2 extends JFrame {

	private JPanel contentPane;
	private JPanel titlePane;
	private JPanel panel_1;
	private JPanel description;
	private JPanel timeline;
	private JTextField titleLabel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPanel detailIconPane;
	private JLabel closeDetailPane;
	private JTable table;
	private JPanel managerPane;
	private JLabel name1;
	private JLabel name2;
	private JLabel name3;
	private JLabel calendar;
	private JLabel calendarLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListPanel2 frame = new ListPanel2();
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
	public ListPanel2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{247, 57, 0};
		gbl_panel.rowHeights = new int[]{15, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel addNewRowLabel = new JLabel("\uC791\uC5C5 \uCD94\uAC00");
		GridBagConstraints gbc_addNewRowLabel = new GridBagConstraints();
		gbc_addNewRowLabel.insets = new Insets(0, 0, 0, 5);
		gbc_addNewRowLabel.gridx = 0;
		gbc_addNewRowLabel.gridy = 0;
		panel.add(addNewRowLabel, gbc_addNewRowLabel);
		
		
		
		JPanel addNewRowPanel = new JPanel();
		contentPane.add(addNewRowPanel, BorderLayout.SOUTH);
		addNewRowPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel addNewRowLabel2 = new JLabel("\uC791\uC5C5 \uCD94\uAC00");
		addNewRowPanel.add(addNewRowLabel2);
		
		JPanel detailPane = new JPanel();
		detailPane.setBackground(new Color(254, 252, 243));
		detailPane.setVisible(false);
		contentPane.add(detailPane, BorderLayout.EAST);
		detailPane.setLayout(new MigLayout("", "[116px,grow][grow]", "[grow][21px,grow][grow][grow][grow]"));
		
		detailIconPane = new JPanel();
		detailIconPane.setBackground(new Color(254, 252, 243));
		detailPane.add(detailIconPane, "cell 0 0,grow");
		GridBagLayout gbl_detailIconPane = new GridBagLayout();
		gbl_detailIconPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_detailIconPane.rowHeights = new int[]{0, 0};
		gbl_detailIconPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_detailIconPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		detailIconPane.setLayout(gbl_detailIconPane);
		
		closeDetailPane = new JLabel("\u2192|");
		GridBagConstraints gbc_closeDetailPane = new GridBagConstraints();
		gbc_closeDetailPane.gridx = 3;
		gbc_closeDetailPane.gridy = 0;
		detailIconPane.add(closeDetailPane, gbc_closeDetailPane);
		
		titlePane = new JPanel();
		titlePane.setBackground(new Color(254, 252, 243));
		detailPane.add(titlePane, "cell 0 1,grow");
		
		titleLabel = new JTextField();
		titleLabel.setText("\uD0C0\uC774\uD2C0\uC785\uB2C8\uB2F9");
		titlePane.add(titleLabel);
		titleLabel.setColumns(10);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(254, 252, 243));
		detailPane.add(panel_1, "cell 0 2,grow");
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		textField = new JTextField();
		textField.setText("\uB2F4\uB2F9\uC790");
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 0;
		panel_1.add(textField, gbc_textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("\uB9C8\uAC10\uC77C");
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 1;
		panel_1.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_1 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setText("\uD504\uB85C\uC81D\uD2B8");
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 0;
		gbc_textField_2.gridy = 2;
		panel_1.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		lblNewLabel = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		lblNewLabel_2 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		description = new JPanel();
		description.setBackground(new Color(254, 252, 243));
		detailPane.add(description, "cell 0 3,grow");
		
		textField_3 = new JTextField();
		textField_3.setText("\uB098\uB294 \uC124\uBA85\uCC3D\uC774\uB2E4");
		description.add(textField_3);
		textField_3.setColumns(10);
		
		timeline = new JPanel();
		timeline.setBackground(new Color(254, 252, 243));
		detailPane.add(timeline, "cell 0 4,grow");
		
		textField_4 = new JTextField();
		textField_4.setText("\uB098\uB294 \uD0C0\uC784\uB77C\uC778 \uCC3D\uC774 \uB420\uD14C\uC57C");
		timeline.add(textField_4);
		textField_4.setColumns(10);
		
		JLayeredPane backgroundpane = new JLayeredPane();
		backgroundpane.setBackground(new Color(254, 252, 243));
		contentPane.add(backgroundpane, BorderLayout.CENTER);
		backgroundpane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(254, 252, 243));
		backgroundpane.addComponentListener(new ComponentAdapter() {
		    @Override
		    public void componentResized(ComponentEvent e) {
		        scrollPane.setBounds(0, 0, backgroundpane.getWidth(), backgroundpane.getHeight());
		    }
		});
		backgroundpane.add(scrollPane,JLayeredPane.PALETTE_LAYER);
		
		
		

		
		
		
		Vector<String> columnNames = new Vector<>();
		columnNames.add("작업 이름");
		columnNames.add("담당자");
		columnNames.add("마감일");
		DefaultTableModel dtm = new DefaultTableModel(columnNames, 1);
		
		
		table = new JTable(dtm);
		table.setBackground(new Color(254, 252, 243));
		scrollPane.setViewportView(table);
		
		managerPane = new JPanel();
		managerPane.setBackground(new Color(245, 235, 224));
		managerPane.setBounds(66, 45, 50, 90);
		backgroundpane.add(managerPane, JLayeredPane.DEFAULT_LAYER);
		
		GridBagLayout gbl_managerPane = new GridBagLayout();
		gbl_managerPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_managerPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_managerPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_managerPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		managerPane.setLayout(gbl_managerPane);
		
		name1 = new JLabel("\uAC15\uC815\uC11D1");
		name1.setOpaque(true);
		name1.setBackground(new Color(245, 235, 224));
		GridBagConstraints gbc_name1 = new GridBagConstraints();
		gbc_name1.insets = new Insets(0, 0, 5, 5);
		gbc_name1.gridx = 0;
		gbc_name1.gridy = 0;
		managerPane.add(name1, gbc_name1);
		
		name2 = new JLabel("\uAC15\uC815\uC11D2");
		name2.setBackground(new Color(245, 235, 224));
		name2.setOpaque(true);
		GridBagConstraints gbc_name2 = new GridBagConstraints();
		gbc_name2.insets = new Insets(0, 0, 5, 5);
		gbc_name2.gridx = 0;
		gbc_name2.gridy = 1;
		managerPane.add(name2, gbc_name2);
		
		name3 = new JLabel("\uAC15\uC815\uC11D3");
		name3.setBackground(new Color(245, 235, 224));
		name3.setOpaque(true);
		GridBagConstraints gbc_name3 = new GridBagConstraints();
		gbc_name3.insets = new Insets(0, 0, 5, 5);
		gbc_name3.gridx = 0;
		gbc_name3.gridy = 2;
		managerPane.add(name3, gbc_name3);
		
		calendarLabel = new JLabel("\uB098\uB294 \uCE98\uB9B0\uB354\uAC00 \uB420 \uC544\uC774\uC785\uB2C8\uB2E4");
		calendarLabel.setBackground(new Color(245, 235, 224));
		calendarLabel.setBounds(267, 45, 95, 140);
		backgroundpane.add(calendarLabel, JLayeredPane.DEFAULT_LAYER);
		
		
		
		addNewRowLabel2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dtm.addRow(getComponentListeners());
			}
		});
		
		addNewRowLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dtm.addRow(getComponentListeners());
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int sensitive = 20;
				int selectedColumn = table.getSelectedColumn();
	            if (selectedColumn == 0) {
	                detailPane.setVisible(true); // detailPane을 보이게 설정
	            }
	            if (selectedColumn == 1) {
	            	//managerPane.setLocation(getMousePosition());
	            	managerPane.setLocation(e.getX(), e.getY()+sensitive);
	            	backgroundpane.setLayer(managerPane, JLayeredPane.POPUP_LAYER);
	            }else {
	            	backgroundpane.setLayer(managerPane, JLayeredPane.DEFAULT_LAYER);
	            }
	            if (selectedColumn == 2) {
	            	calendarLabel.setLocation(e.getX(), e.getY()+sensitive);
	            	backgroundpane.setLayer(calendarLabel, JLayeredPane.POPUP_LAYER);
	            }else {
	            	backgroundpane.setLayer(calendarLabel, JLayeredPane.DEFAULT_LAYER);
	            }
	            
	            
	            int row = table.rowAtPoint(e.getPoint()); // 클릭한 위치의 행 인덱스 가져오기
	            int column = table.columnAtPoint(e.getPoint()); // 클릭한 위치의 열 인덱스 가져오기
	            System.out.println(row + "행 " + column + "열 선택됨");
			}
		});
		
		closeDetailPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				detailPane.setVisible(false);
			}		
		});
		
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				backgroundpane.setLayer(managerPane, JLayeredPane.DEFAULT_LAYER);
				backgroundpane.setLayer(calendarLabel, JLayeredPane.DEFAULT_LAYER);				
			}
		});
		
		// managerPane의 자식 컴포넌트들에 대한 MouseListener 추가
		for (Component component : managerPane.getComponents()) {
		    component.addMouseListener(new MouseAdapter() {
		        @Override
		        public void mouseClicked(MouseEvent e) {
		        	System.out.println(((JLabel)component).getText()+"클릭됨");
		        }
		        @Override
		        public void mouseEntered(MouseEvent e) {
		            component.setBackground(Color.lightGray);
		        }
		        @Override
		        public void mouseExited(MouseEvent e) {
		            component.setBackground(null);
		        }
		    });

		}
		
		
		
		
	}
}
