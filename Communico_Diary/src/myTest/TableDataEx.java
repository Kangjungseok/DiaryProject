package myTest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dao.DAO;
import dto.DTO;
import javax.swing.JLayeredPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class TableDataEx extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JPanel addPanel;
    private JLabel create;

    private DefaultTableModel dtm;
    private Vector<Vector<Object>> data;
    private JLayeredPane layeredPane;

    /**
     * 애플리케이션을 실행합니다.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TableDataEx frame = new TableDataEx();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 프레임을 생성합니다.
     */
    public TableDataEx() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        layeredPane = new JLayeredPane();
        contentPane.add(layeredPane, BorderLayout.CENTER);

        // 테이블 데이터 초기화
        data = new Vector<>();
        loadData();

        Vector<String> columnNames = new Vector<>();
        columnNames.add("번호");
        columnNames.add("작업");
        columnNames.add("매니저");
        columnNames.add("마감일");

        dtm = new DefaultTableModel(data, columnNames);

        JScrollPane scrollPane = new JScrollPane();
        layeredPane.addComponentListener(new ComponentAdapter() {
		    @Override
		    public void componentResized(ComponentEvent e) {
		        scrollPane.setBounds(0, 0, layeredPane.getWidth(), layeredPane.getHeight());
		    }
		});
        layeredPane.add(scrollPane, JLayeredPane.PALETTE_LAYER);

        table = new JTable(dtm);
        scrollPane.setViewportView(table);
        
        JPanel properties = new JPanel();
        properties.setBackground(new Color(245, 235, 224));
        properties.setBounds(123, 67, 56, 81);
		layeredPane.add(properties, JLayeredPane.DEFAULT_LAYER);
        
        GridBagLayout gbl_properties = new GridBagLayout();
        gbl_properties.columnWidths = new int[]{0, 0};
        gbl_properties.rowHeights = new int[]{0, 0};
        gbl_properties.columnWeights = new double[]{0.0, Double.MIN_VALUE};
        gbl_properties.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        properties.setLayout(gbl_properties);
        
        JLabel delete = new JLabel("\uC791\uC5C5 \uC0AD\uC81C");
        delete.setOpaque(true);
        GridBagConstraints gbc_delete = new GridBagConstraints();
        gbc_delete.gridx = 0;
        gbc_delete.gridy = 0;
        properties.add(delete, gbc_delete);

        addPanel = new JPanel();
        contentPane.add(addPanel, BorderLayout.SOUTH);

        create = new JLabel("작업 추가");
        
        addPanel.add(create);
        
     

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	int sensitive = 20;
                int selectedColumn = table.getSelectedColumn();
                int selectedRow = table.getSelectedRow();
                
                //마우스 우클릭 이벤트
                if(e.getButton() == MouseEvent.BUTTON3) {
                	properties.setLocation(e.getX(), e.getY()+sensitive);
                	layeredPane.setLayer(properties, JLayeredPane.POPUP_LAYER);
                }else {
                	layeredPane.setLayer(properties, JLayeredPane.DEFAULT_LAYER);
				}
            }
        });
        
      
        table.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int row = e.getFirstRow();
                    int column = e.getColumn();
                    TableModel model = (TableModel) e.getSource();

                    // 변경된 셀의 위치에 해당하는 데이터를 가져옵니다.
                    String task = (String) model.getValueAt(row, 1); // 예시로 task는 두 번째 열에 위치한다고 가정합니다.
                    String manager = (String) model.getValueAt(row, 2);
                    Date dday = (Date) model.getValueAt(row, 3);
                    int num = (int) model.getValueAt(row, 0); // 예시로 num은 첫 번째 열에 위치한다고 가정합니다.
                    // 나머지 필드도 필요에 따라 가져와야 합니다.

                    // DTO 객체를 생성하고 변경된 데이터를 설정합니다.
                    DTO dto = new DTO();
                    dto.setNum(num);
                    dto.setTask(task);
                    dto.setManager(manager);
                    dto.setDday(dday);
                    // 나머지 필드도 필요에 따라 설정합니다.

                    // DAO를 사용하여 데이터베이스에 변경 내용을 반영합니다.
                    DAO dao = DAO.getinstance();
                    try {
                        dao.updateData(dto); // updateData 메소드는 DTO를 사용하여 해당 레코드를 업데이트하는 메소드로 가정합니다.
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        
     // properties 패널의 자식 컴포넌트들에 대한 MouseListener 추가
     		for (Component component : properties.getComponents()) {
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
     		
     		delete.addMouseListener(new MouseAdapter() {
     			@Override
     			public void mouseClicked(MouseEvent e) {
     				deleteRow();
     			}
     			
			});
			
        create.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DAO dao = DAO.getinstance();
                DTO dto = new DTO();
                try {
                    dao.insertData(dto);
                    // 새로운 행을 테이블에 추가합니다.
                    addRow(dao.getLastRow());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        //table.revalidate();
        //table.repaint();
    }

    private void loadData() {
        DAO dao = DAO.getinstance();
        Vector<DTO> datas = dao.getAllData();
        for (int i = 0; i < datas.size(); i++) {
            int num = datas.get(i).getNum();
            String task = datas.get(i).getTask();
            String manager = datas.get(i).getManager();
            Date dday = datas.get(i).getDday();
            Vector<Object> row = new Vector<>();
            row.add(num);
            row.add(task);
            row.add(manager);
            row.add(dday);
            data.add(row);
        }
    }

    

    private void addRow(DTO dto) {
        Vector<Object> row = new Vector<>();
        row.add(dto.getNum());
        row.add(dto.getTask());
        row.add(dto.getManager());
        row.add(dto.getDday());
        data.add(row);
        dtm.fireTableDataChanged();
    }
    
    private void deleteRow() {
    	int selectedColumn = table.getSelectedColumn();
		int selectedRow = table.getSelectedRow();//1행부터!	
			DTO dto = new DTO();
			dto.setNum((int)table.getValueAt(selectedRow, 0));
			try {
				DAO.getinstance().deleteData(dto);
				System.out.println("선택된 행 : " + selectedRow+1);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
			dtm.fireTableDataChanged();
    }
    
}
