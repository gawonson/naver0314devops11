package day0329;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex4_SwingTable extends JFrame{
	JTable table;
	JLabel lblMessage;
	
	public Ex4_SwingTable(String title)
	{
		super(title);
		this.setLocation(100,100);
		this.setSize(400,300);
		//this.getContentPane().setBackground(Color.pink);//배경색 변경
		//this.getContentPane().setBackground(new Color(93,56,56);//배경색 변경
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 종료
		this.initDesign();//각종 컴포넌트 생성
		this.setVisible(true);
	}
	
	
	public void initDesign()
	{
		String []title= {"이름","나이","혈액형","핸드폰","주소"};
		String [][]data= {
				{"이영자","32세","B","010-2000-6000","서울"},
				{"강호동","56","O","010-9487-1874","부산"},
				{"유재석","49","O","010-5649-4222","대구"},
				{"이효리","61","AB","010-8161-9822","뉴욕"}
		};
		table=new JTable(data, title);
		//상단에 제목 추가
		this.add("North",new JLabel("701 멤버현황",JLabel.CENTER ));
		//프레임의 센터에 추가
		this.add("Center",new JScrollPane(table));//데이블도 스크롤바가 생겨야한다(제목포함)
		//메세지 라벨을 SOUTH에 추가
		lblMessage=new JLabel("결과 나올곳,,,",JLabel.CENTER);
		lblMessage.setFont(new Font("",Font.BOLD,20));
		this.add("South",lblMessage);
		
		//테이블 이벤트
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				
				//선택한 행 번호
				int rowIndex=table.getSelectedRow();
				System.out.println(rowIndex);
				
				//클릭한 곳에서 이름,나이,주소정도만 얻어서 메세지에 출력해보자
				String name=table.getValueAt(rowIndex, 0).toString();
				String age=table.getValueAt(rowIndex, 1).toString();
				String addr=table.getValueAt(rowIndex, 4).toString();
				String m=name+"님은 "+age+"이며 "+addr+"에 살고있어요." ;
				lblMessage.setText(m);
			}
		});
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex4_SwingTable a=new Ex4_SwingTable("테이블");
		
	}
}
