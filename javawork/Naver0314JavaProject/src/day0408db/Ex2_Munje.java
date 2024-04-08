package day0408db;

import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Db.common.Dbconnect;

public class Ex2_Munje extends JFrame{
	JButton btnAdd,btnDel;
	JTable table;
	JTextField tfName,tfScore;
	JComboBox<String> cbSex, cbBuseo,cbArray;
	JLabel lName,lScore,lSex,lBuseo;
	JRadioButton rbntot,rbnmale,rbnfemale;
	DefaultTableModel tableModel;
	Dbconnect db=new Dbconnect();
	String [] cmsexin= {"남자","여자"};
	String [] scbuseoin= {"인사부","홍보부","교육부"};
	int selcom1=1, selcom2=1, selcom3=0;
	int selrbn1=0,selrbn2=0,selrbn3=0;
	int rbnindex=0;
	JRadioButton []rb=new JRadioButton[3];
	
	public Ex2_Munje(String title)
	{
		super(title);
		this.setLocation(100,100);
		this.setSize(500,500);
		this.getContentPane().setBackground(Color.pink);//배경색 변경
		//this.getContentPane().setBackground(new Color(93,56,56);//배경색 변경
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 종료
		this.initDesign();//각종 컴포넌트 생성
		this.setVisible(true);
	}


	public void initDesign()
	{
		/////////// paneltop///////////
		JPanel jtop=new JPanel();
		jtop.add(new JLabel("이름"));
		tfName=new JTextField(5);
		jtop.add(tfName);


		jtop.add(new JLabel("점수"));
		tfScore=new JTextField(5);
		jtop.add(tfScore);

		jtop.add(new JLabel("성별"));
		cbSex=new JComboBox<String>(cmsexin);
		jtop.add(cbSex);

		jtop.add(new JLabel("부서"));
		cbBuseo=new JComboBox<String>(scbuseoin);
		jtop.add(cbBuseo);

		this.add("North",jtop);



		//////////////table띄우기///////////////
		String[]title= {"시퀀스","이름","점수","성별","부서"};
		tableModel=new DefaultTableModel(title,0);
		table =new JTable(tableModel);
		this.add("Center",new JScrollPane(table));

		////////////panelbo//////////////
		JPanel jbot=new JPanel();
		btnAdd=new JButton("추가");
		jbot.add(btnAdd);

		btnDel=new JButton("삭제");
		jbot.add(btnDel);


		cbArray=new JComboBox<String>(scbuseoin);
		jbot.add(new JLabel("부서별"));
		jbot.add(cbArray);


		ButtonGroup bg1=new ButtonGroup();
		rbntot=new JRadioButton("전체");
		bg1.add(rbntot);
		jbot.add(rbntot);

		rbnmale=new JRadioButton("남",true);
		bg1.add(rbnmale);
		jbot.add(rbnmale);
		rbnfemale=new JRadioButton("여");
		bg1.add(rbnfemale);
		jbot.add(rbnfemale);

		rbntot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				rbnindex=1;
			}
		});
		rbnmale.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				rbnindex=2;
			}
		});
		rbnfemale.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				rbnindex=3;
			}
		});


		this.add("South",jbot);

		////////////콤보박스#1(cbsex) 이벤트 ///////////
		cbArray.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				//				selcom1=cbSex.getSelectedIndex()+1;
				//				selcom2=cbBuseo.getSelectedIndex()+1;
				selcom3=cbArray.getSelectedIndex()+1;
				writesawon();

			}
		});
		//추가버튼 이벤트
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tfName.getText().length()==0)
					return;
				if(tfScore.getText().length()==0)
					return;
				//이름 입력값을 db에 넣기
				Connection conn=db.getConnection();
				PreparedStatement pstmt=null;
				String sql="insert into sawon values(null,?,?,?,?)";

				try {
					pstmt=conn.prepareStatement(sql);
					//바인딩
					pstmt.setString(1, tfName.getText());
					pstmt.setInt(2, Integer.parseInt(tfScore.getText()));
					pstmt.setString(3, cbSex.getSelectedItem().toString());
					pstmt.setString(4, cbBuseo.getSelectedItem().toString());

					pstmt.execute();

					tfName.setText("");
					tfScore.setText("");

					writesawon();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally
				{db.dbClose(pstmt, conn);
				}
			}
		});
		//삭제 이벤트 추가하기
		btnDel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row=table.getSelectedRow();

				if(row==-1)
				{
					JOptionPane.showMessageDialog(Ex2_Munje.this, "삭제할 행을 선택하세요");
					return;
				}
				String num=table.getValueAt(row, 0).toString();

				String sql="delete from sawon where num=?";

				Connection conn=db.getConnection();
				PreparedStatement pstmt=null;

				try {
					pstmt=conn.prepareStatement(sql);
					pstmt.setString(1, num);
					pstmt.execute();

					writesawon();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					db.dbClose(pstmt, conn);
				}


			}

		});

	
		writesawon();
	}
	public void writesawon() 
	{
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="";
		if(selcom3==0) {

			sql="select * from sawon order by num asc";
		}
		else if(selcom3==1) {


			sql="select * from sawon where buseo='인사부'";

		}
		else if(selcom3==2) {

			sql="select * from sawon where buseo='홍보부'";

		}
		else if(selcom3==3)
		{
			sql="select * from sawon where buseo='교육부'";

		}
		//		else 
		//			sql="select * from sawon";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();

			//기존 테이블의 데이터 지운 후 추가하기
			tableModel.setRowCount(0);

			while(rs.next())
			{
				Vector<String> data=new Vector<String>();
				data.add(rs.getString("num"));
				data.add(rs.getString("name"));
				data.add(rs.getString("score"));
				data.add(rs.getString("gender"));
				data.add(rs.getString("buseo"));

				tableModel.addRow(data);


			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn, rs);
		}


	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2_Munje a=new Ex2_Munje("기본창");

	}
}
