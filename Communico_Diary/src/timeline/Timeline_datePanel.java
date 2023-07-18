package timeline;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.time.LocalDate;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Timeline_datePanel extends JPanel{
	
	
	
	public Timeline_datePanel() {
		GridBagLayout gbl_datePanel = new GridBagLayout();
		
		gbl_datePanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_datePanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_datePanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_datePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.setLayout(gbl_datePanel);
		
		JLabel lblNewLabel = new JLabel("\uC791\uC5C5\uC774 \uB4E4\uC5B4\uAC08 \uBD80\uBD84");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridx = 13;
		gbc_lblNewLabel.gridy = 5;
		this.add(lblNewLabel, gbc_lblNewLabel);
		
		//0행에 30개의 날짜를 만든다
		int size = 30;
		int before = 0;
		
		for(int i = 0 ; i<size;i++) {
			this.add(new JLabel(LocalDate.now().plusDays(i).toString()), -1);
		}
		for(int i = size ; i>0;i--) {
			this.add(new JLabel(LocalDate.now().plusDays(-i).toString()), 0);
		}
		
	}
	
	

}
