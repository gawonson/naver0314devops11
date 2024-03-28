package day0328;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.text.StyledEditorKit.BoldAction;

public class Ex5_SwingCanvas extends JFrame{
	//캔버스 변수 선언
	MyDraw draw=new MyDraw();
	//음식사진 경로
	String foodImage="D:\\naver0314\\workall\\image\\음식사진\\11.jpg";
	String foodImage2="D:\\naver0314\\workall\\image\\음식사진\\1.jpg";
	
	public Ex5_SwingCanvas(String title)
	{
		super(title);
		this.setLocation(100,100);
		this.setSize(500,500);
		//this.getContentPane().setBackground(Color.pink);//배경색 변경
		//this.getContentPane().setBackground(new Color(93,56,56);//배경색 변경
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 종료
		this.initDesign();//각종 컴포넌트 생성
		this.setVisible(true);
	}
	
	//캔버스를 상속받는 내부클래스
	class MyDraw extends Canvas
	{
		//처음 시작시, 프레임 크기 변경시에 자동호출 그 외에는 강제 호출 필요(repaint)
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			
			//색상 변경
			g.setColor(Color.magenta);
			//테두리만 있는 타원 그리기
			g.drawOval(30, 30, 100, 100);
			
			//채워진 동그라미
			g.setColor(Color.orange);
			g.fillOval(150, 30, 100, 100);
			
			//테두리만 있는 사각형
			g.setColor(new Color(8,207,7));
			g.drawRect(30, 150, 100, 100);
			
			//채워진 사각형
			g.setColor(new Color(1,8,86));
			g.fillRect(150, 150, 100, 100);
			
			//그래픽 글자 
			g.setFont(new Font("Comic Sans MS",Font.BOLD,30));
			g.drawString("Good Day!!", 50, 350);
			
			//한글 글자
			g.setFont(new Font("궁서체",Font.BOLD,30));
			g.drawString("안녕하세요", 250, 350);
			
			//사진 그리기 방법 #1
			Image image1=new ImageIcon(foodImage).getImage();
			g.drawImage(image1, 300, 10, 130, 130, this);
			
			//사진 그리기 방법 #2
			Image image2=Toolkit.getDefaultToolkit().getImage(foodImage2);
			g.drawImage(image2, 300, 150, 130, 130, this);
		}
	}
	public void initDesign()
	{
		//기본 레이아웃의 Center 에 캔버스를 추가
		this.add("Center",draw);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex5_SwingCanvas a=new Ex5_SwingCanvas("캔버스");
	}
}
