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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ex6_SwingTableShop extends JFrame{
	JTable table;
	DefaultTableModel tableModel;
	JButton btnAdd, btnDelete;
	JTextField tfSang,tfSu,tfDan;
	final static String FILENAME="d:/naver0314/myshop.txt";
	public Ex6_SwingTableShop(String title)
	{
		super(title);
		this.setLocation(100,100);
		this.setSize(400,400);
		//		this.getContentPane().setBackground(Color.pink);//배경색 변경
		//this.getContentPane().setBackground(new Color(93,56,56);//배경색 변경
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 종료
		//윈도우 종료시 테이블의 내용을 파일에 저장 후 종료
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				FileWriter fw=null;
				try {
					fw=new FileWriter(FILENAME);
					//테이블의 행 갯수만큼 반복해서데이터를 읽고 저장
					for(int i=0;i<table.getRowCount();i++)
					{
						String sang=table.getValueAt(i, 0).toString();
						String su=table.getValueAt(i, 1).toString();
						String dan=table.getValueAt(i, 2).toString();
						String tot=table.getValueAt(i, 3).toString();

						String s=sang+","+su+","+dan+","+tot+"\n";
						//파일에 저장
						fw.write(s);

					}JOptionPane.showMessageDialog(Ex6_SwingTableShop.this, "입력한 데이터를 저장하였습니다.");

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
		///////////////////////////////////////////////	
		this.initDesign();//각종 컴포넌트 생성
		//파일의 내용을 불러오려면 테이블이 생성된 후
		this.shopFileRead();
		this.setVisible(true);
	}

	//파일 불러와서 테이블에 추가하기
	public void shopFileRead() {
		//열때 파일 불러오기
		FileReader fr=null;
		BufferedReader br=null;

		try {
			fr=new FileReader(FILENAME);
			br=new BufferedReader(fr);
			while (true)
			{
				String s=br.readLine();
				if(s==null)
					break;
				String []data=s.split(",");
				tableModel.addRow(data);

			}
		} catch (FileNotFoundException e) {
			System.out.println("파일없음: "+e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
				fr.close();
			}catch(NullPointerException|IOException e)
			{
			}
		}
	}
	public void initDesign()
	{
		//상단에는 추가,삭제 버튼
		JPanel pTop=new JPanel();
		btnAdd=new JButton("상품정보추가");
		btnDelete=new JButton("상품정보삭제");
		pTop.add(btnAdd);
		pTop.add(btnDelete);
		this.add("North",pTop);

		//중간에는 테이블 추가
		String [] title= {"상품명","수량","단가","총금액"};
		tableModel=new DefaultTableModel(title,0);
		table=new JTable(tableModel);
		this.add("Center",new JScrollPane(table));

		//하단에는 입력 컴포넌트들
		tfSang=new JTextField(7);
		tfSu=new JTextField(4);
		tfDan=new JTextField(7);

		JPanel pBottom=new JPanel();
		pBottom.add(new JLabel("상품명"));
		pBottom.add(tfSang);
		pBottom.add(new JLabel("수량"));
		pBottom.add(tfSu);
		pBottom.add(new JLabel("단가"));
		pBottom.add(tfDan);

		this.add("South",pBottom);

		//추가버튼 이벤트
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//입력 안했을 경우 종료 
				if(tfSang.getText().length()==0) {
					JOptionPane.showMessageDialog(Ex6_SwingTableShop.this,"상품명을 입력해주세요.");
					return;
				}
				if(tfSu.getText().length()==0) {
					JOptionPane.showMessageDialog(Ex6_SwingTableShop.this,"수량을 입력해주세요.");
					return;
				}
				if(tfDan.getText().length()==0) {
					JOptionPane.showMessageDialog(Ex6_SwingTableShop.this,"단가를 입력해주세요.");
					return;
				}

				String sang=tfSang.getText();
				int su=0,dan=0, total=0;
				try {
					su=Integer.parseInt(tfSu.getText());
					dan=Integer.parseInt(tfDan.getText());
					total=su*dan;}
				catch(NumberFormatException e1) {
					System.out.println("문자입력오류");
					JOptionPane.showMessageDialog(Ex6_SwingTableShop.this, "수량, 단가는 숫자로만 입력해주새요");
				}

				//vector 로 데이터를 담는다( data)
				Vector<String> vector=new Vector<String>();

				vector.add(sang);
				vector.add(""+su);
				vector.add(""+dan);
				vector.add(""+total);

				//tablemodel로 추가 addrow

				tableModel.addRow(vector);
				System.out.println(vector);
				//입력박스의 데이터는 지운다(SETTEXT이용)
				tfSang.setText("");
				tfSu.setText("");
				tfDan.setText("");
			}
		});

		//삭제이벤트 : 행을 선택시 행의 뎅터 삭제 (선택안했을경우 경고메세지)
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row=table.getSelectedRow();
				if(row==-1)
					JOptionPane.showMessageDialog(Ex6_SwingTableShop.this,"삭제할 행을 선택해주세요");

				else
					tableModel.removeRow(row);
			}
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex6_SwingTableShop a=new Ex6_SwingTableShop("상품등록및삭제");
	}
}
