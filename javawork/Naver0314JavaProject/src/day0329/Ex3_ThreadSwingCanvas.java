package day0329;

import java.awt.Color;

import javax.swing.JFrame;

public class Ex3_ThreadSwingCanvas extends JFrame{
	public Ex3_ThreadSwingCanvas(String title)
	{
		super(title);
		this.setLocation(100,100);
		this.setSize(300,300);
		this.getContentPane().setBackground(Color.pink);//배경색 변경
		//this.getContentPane().setBackground(new Color(93,56,56);//배경색 변경
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 종료
		this.initDesign();//각종 컴포넌트 생성
		this.setVisible(true);
	}
	
	
	public void initDesign()
	{
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex3_ThreadSwingCanvas a=new Ex3_ThreadSwingCanvas("기본창");
		
	}
}
