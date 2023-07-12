package myTest;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.time.LocalDate;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class PanelTest_debounceTimerEx extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private boolean adjusting;
	private Timer debounceTimer;
    private final int DEBOUNCE_DELAY = 200; // 디바운스 지연 시간 설정 (200ms)
	
	private Thread thread1 = new Thread();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelTest_debounceTimerEx frame = new PanelTest_debounceTimerEx();
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
	public PanelTest_debounceTimerEx() {
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
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setShowGrid(false);
		

		int size = 30; // 처음에 만들 열의 갯수
		int before = size/2; // [0][0]이 며칠 전부터의 날짜로 시작할건지

		Vector<LocalDate> columNames = new Vector<>(size);
		//LocalDate[] columNames = new LocalDate[size];
		for(int i = 0; i<size ; i++) {
			columNames.add(LocalDate.now().plusDays(i-before));
			
		}
		
		DefaultTableModel dtm = new DefaultTableModel(columNames, 1);
		for(int i = 0 ; i<size;i++) {
			dtm.setValueAt(columNames.get(i).getDayOfMonth(), 0, i);			
		}
		

		table.setModel(dtm);
		table.getTableHeader().setVisible(true);
		

		JLabel month = new JLabel();
		month.setBounds(49, 21, 57, 15);
		calendarPanel.add(month);

		// String[] 에 날짜가 들어가도록?
		// 스크롤바를 기준으로, 스크롤바가 min val, max val 에 닿았을 때 컬럼을 추가시키고...

		table.setBorder(new EmptyBorder(0, 0, 0, 0));
		table.setBackground(UIManager.getColor("Button.background"));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 166, 1000, 756);
		scrollPane.setViewportView(table);
		JScrollBar scrollBar = scrollPane.getHorizontalScrollBar();

		// 으아아아아아아아아!!!!!!!!!!!!!!!!!!!!!
		// 스크롤의 크기를 줄여서 왼쪽, 오른쪽으로 이동할 수 있게 만들자.
		// scrollBar.setValues(50, 10, 0, 100);
		
		//스크롤바 초기 설정...그러나 전혀 먹지 않는다!!!!
		scrollBar.setValue(500);

		
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		panel.add(scrollPane);
		
		//아래에다가 또 쓰니까 적용이 된다...근데 위에 걸 지우고 이 것만 적으면 또 안 된다...미치겠다  
		scrollBar.setValue((scrollBar.getMinimum() + scrollBar.getMaximum()) / 2);
		
		scrollBar.addAdjustmentListener(new AdjustmentListener() {

			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				int addSize = 5;
				int lastIndexToAdd = dtm.getColumnCount()-1;
				int initScroll = 300;
				
				

				 // 타이머가 실행 중이면 이전 작업을 취소하고 재설정합니다.
                if (debounceTimer != null && debounceTimer.isRunning()) {
                    debounceTimer.restart();
                } else {
                    // 타이머가 실행 중이 아니면 새로운 타이머를 생성합니다.
                    debounceTimer = new Timer(DEBOUNCE_DELAY, actionEvent -> {
                        // 스크롤 이벤트가 일정 시간 동안 발생하지 않았으므로 작업을 수행합니다.
                        // 여기서 필요한 작업을 수행합니다.
                        // ...
                    	if (scrollBar.getValue() >= (scrollBar.getMaximum() - scrollBar.getVisibleAmount())) {
        					
                    		
                    		
        					
        					if(!adjusting) {
        						adjusting =true;
        						new Thread(()->{
        							try {
        								Thread.sleep(100);
        							} catch (InterruptedException e1) {
        								e1.printStackTrace();
        							}
        							
        							
        							for(int i = 1 ; i<=addSize; i++) {
        								System.out.println("내가 lastIndex다 : " +lastIndexToAdd);
        								//columName은 LocalDate 타입. 마지막 인덱스의 columName을 읽어서 +i
        								LocalDate dateAdded = columNames.get(lastIndexToAdd).plusDays(i);
        								dtm.addColumn(dateAdded);
        								System.out.println("columName 추가됨" + columNames.get(lastIndexToAdd+i));
        								
        							}
        							
        						
        								for(int i = 1 ; i<=addSize; i++) {
        									System.out.println("내가 lastIndex다" +lastIndexToAdd);
        									
        									LocalDate dateAdded = columNames.get(lastIndexToAdd).plusDays(i);
        									dtm.setValueAt(dateAdded.getDayOfMonth(), 0, lastIndexToAdd+i);
        									System.out.println("dtm.setValue 실행됨, 추가된 값" + dtm.getValueAt(0, lastIndexToAdd+i));
        								}
        								adjusting =false;
        						}).start();
        					}
        					
        					System.out.println("scrollBar 이전 위치 : "+scrollBar.getValue());
        					scrollBar.setValue((scrollBar.getMaximum()+scrollBar.getMinimum())/2);
        					System.out.println("scrollBar 현재 위치 : "+scrollBar.getValue());
        				
        				
        				}
                    });
                    debounceTimer.setRepeats(false); // 타이머는 한 번만 실행되도록 설정합니다.
                    debounceTimer.start(); // 타이머를 시작합니다.
				
				
				
	
				
				
				
				
				
				
				
				
				
                }
		};

	});
}}
