package day0329;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ex7_SwingFileMunje extends JFrame{
	JButton btnSave, btnDelete;
	JTextField tfName;
	JTable tableSawon;
	JScrollPane title;
	DefaultTableModel tableModel;
	String []comboLabel1={"A","B","O","AB"};
	String []comboLabel2={"서울","대구","대전","부산","광주","제주도"};
	String []comboLabel3={"과장","차장","대리","사원","인턴"};
	Vector<String> ovector=new Vector<String>();
	String name,blood,city,level;
	String FILENAME="D:\\naver0314\\sawon.txt";
	public Ex7_SwingFileMunje(String title)
	{

		super(title);
		this.setLocation(100,100);
		this.setSize(400,400);
		//this.getContentPane().setBackground(Color.pink);//배경색 변경
		//this.getContentPane().setBackground(new Color(93,56,56);//배경색 변경
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 종료
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				FileWriter fw=null;

				try {
					fw=new FileWriter(FILENAME);
					for(int i=0;i<tableSawon.getRowCount();i++)
					{
						String name=tableSawon.getValueAt(i, 0).toString();
						String blood=tableSawon.getValueAt(i, 1).toString();
						String city=tableSawon.getValueAt(i, 2).toString();
						String addr=tableSawon.getValueAt(i, 3).toString();
						String s=name+","+blood+","+city+","+addr+"\n";
						fw.write(s);
					}JOptionPane.showMessageDialog(Ex7_SwingFileMunje.this, "입력한 데이터를 저장하였습니다.");

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					try {
						fw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

				System.exit(0);
			}
		});

		this.initDesign();//각종 컴포넌트 생성

		this.fileRead();
		this.setVisible(true);
	}
	public void fileRead() {
		FileReader fr=null;
		BufferedReader br=null;

		try {
			fr=new FileReader(FILENAME);
			br=new BufferedReader(fr);

			while(true)
			{	String n=br.readLine();
			if(n==null)
				break;
			tableModel.addRow(n.split(","));


			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(Ex7_SwingFileMunje.this, "불러올 파일이 없습니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException|NullPointerException e) {
				// TODO Auto-generated catch block
			}
		}
	}
	public void initDesign()
	{
		//타이틀 스크롤로 

		/////////////////버튼 추가/////////////////////
		//상단에 저장 삭제 버튼 추가//

		JPanel top=new JPanel();
		btnSave=new JButton("사원정보추가");
		btnDelete=new JButton("사원정보삭제");

		top.add(btnSave);
		top.add(btnDelete);
		this.add("North",top);
		String [] title = {"이름","혈액형","지역","직급"};
		tableModel=new DefaultTableModel(title,0);
		tableSawon=new JTable(tableModel);
		this.add("Center",new JScrollPane(tableSawon));
		//하단 텍스트 입력 #1 이름//
		JPanel bottom=new JPanel();
		tfName=new JTextField(5);
		bottom.add(new JLabel("이름"));
		bottom.add(tfName);
		//#2 혈액형
		JComboBox<String> cmblood=new JComboBox<String>(comboLabel1);
		bottom.add(new JLabel("혈액형"));
		bottom.add(cmblood);
		//#3 직급
		JComboBox<String> comCity =new JComboBox<String>(comboLabel2);
		bottom.add(new JLabel("지역"));
		bottom.add(comCity);
		//# 4 직급
		JComboBox<String> comLevel =new JComboBox<String>(comboLabel3);
		bottom.add(new JLabel("직급"));
		bottom.add(comLevel);
		this.add("South",bottom);
		////////////////////////////////////////
		//필드값을 백터에 저장
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tfName.getText().length()==0) {
					JOptionPane.showMessageDialog(Ex7_SwingFileMunje.this,"이름을 정확하게 입력하세요");
					return;
				}
				name=tfName.getText();
				Vector<String> vector=new Vector<String>(); 

				blood=cmblood.getSelectedItem()+"";
				city=comCity.getSelectedItem()+"";
				level=comLevel.getSelectedItem()+"";
				vector.add(name);
				vector.add(blood);
				vector.add(city);
				vector.add(level);
				tableModel.addRow(vector);
				tfName.setText("");
				//				System.out.println(vector);

			}

		});
		//삭제이벤트
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row;
				row=tableSawon.getSelectedRow();
				if(row==-1)
					JOptionPane.showMessageDialog(Ex7_SwingFileMunje.this,"삭제할 행을 선택하세요");
				else
					tableModel.removeRow(row);
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex7_SwingFileMunje a=new Ex7_SwingFileMunje("사원리스트");

	}
}
