package calendar;

import java.awt.EventQueue;
import java.time.LocalDate;
import java.time.YearMonth;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;

public class CalendarExample extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalendarExample frame = new CalendarExample();
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
	public CalendarExample() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		CalendarEx calendar = new CalendarEx();
		panel.add(calendar);
	}
	
	
	

	class CalendarEx extends JPanel{
	    public CalendarEx() {
			// TODO Auto-generated constructor stub
		
	    	int year = LocalDate.now().getYear();
	    	int month = LocalDate.now().getMonthValue();
	        YearMonth yearMonth = YearMonth.of(year, month); // 특정 연도와 월 설정
	        LocalDate firstDayOfMonth = yearMonth.atDay(1); // 해당 월의 첫 번째 날짜

	        // 월의 첫 번째 날짜의 요일을 구함 (1: 월요일, 2: 화요일, ..., 7: 일요일)
	        int dayOfWeek = firstDayOfMonth.getDayOfWeek().getValue();

	        // 월의 마지막 날짜를 구함
	        int lastDayOfMonth = yearMonth.lengthOfMonth();

	        // 달력 출력
	        System.out.println(yearMonth.getMonth() + " " + yearMonth.getYear());
	        System.out.println("MON TUE WED THU FRI SAT SUN");

	        // 첫 번째 날짜의 요일까지 공백 출력
	        for (int i = 1; i < dayOfWeek; i++) {
	            System.out.print("    ");
	        }

	        // 날짜 출력
	        for (int day = 1; day <= lastDayOfMonth; day++) {
	            System.out.printf("%3d ", day);
	            if ((day + dayOfWeek - 1) % 7 == 0) {
	                System.out.println();
	            }
	        }
	    }
	}


}
