package day0328;

import java.awt.Canvas;

import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Ex8_SwingPhotoMunje extends JFrame{
	JButton openBtn;
	MyDraw draw=new MyDraw();
	String path;


	public Ex8_SwingPhotoMunje(String title)
	{
		super(title);
		this.setLocation(100,100);
		this.setSize(500,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 종료
		this.initDesign();//각종 컴포넌트 생성
		this.setVisible(true);
	}
	class MyDraw extends Canvas
	{	
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			if(path==null)
			{
				Image image=new ImageIcon("D:\\naver0314\\workall\\image\\연예인사진\\1.jpg").getImage();
				g.drawImage(image, 0, 20, 490, 400, this);
			}
			Image image1=new ImageIcon(path).getImage();
			g.drawImage(image1, 0, 20, 490, 400, this);
		}
	}

	public void initDesign()
	{this.add("Center",draw);
	//버튼 추가
	JPanel jtop=new JPanel();
	openBtn=new JButton("파일열기");
	jtop.add(openBtn);
	this.add("North",jtop);

	//버튼을 누르면 다이어로그가 나와야함.
	openBtn.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			FileDialog dlg=new FileDialog(Ex8_SwingPhotoMunje.this,"사진찾기",FileDialog.LOAD);
			dlg.setVisible(true);
			if(dlg.getDirectory()==null)
				return;
			path=dlg.getDirectory()+dlg.getFile();
			draw.repaint();	
		}
	});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex8_SwingPhotoMunje a=new Ex8_SwingPhotoMunje("저장된사진");
	}
}
