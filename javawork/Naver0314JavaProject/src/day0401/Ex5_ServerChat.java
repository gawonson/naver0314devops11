package day0401;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex5_ServerChat extends JFrame implements Runnable{
	JTextArea area;
	Vector<ClientMember> list=new Vector<Ex5_ServerChat.ClientMember>();
	ServerSocket serverSocket; 
	public Ex5_ServerChat(String title)
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
	//접속하는 client 들을 허용하고 vector 에 저장하는 기능
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("서버소켓 생성 후 접속하는 클라이언트들 허용하는 run");

		//서버 소켓 생성
		try {
			serverSocket=new ServerSocket(6000);
			area.append("서버소켓생성성공\n");
			while (true)
			{
				//접속한 클라이언트를 허용하고 소켓을 생성
				Socket socket=serverSocket.accept();
				area.append("접속한 IP:"+socket.getInetAddress().getHostAddress()+"\n");
				this.autoScroll();

				//클라이언트 내부클래스 생성
				ClientMember cm=new ClientMember(socket);

				//벡터에 클라이언트들 저장
				list.add(cm);

				//각 클라이언트가 가진 run 메소드 호출
				cm.start();
			}
		} catch (IOException e) {
			area.append("서버 소켓 생성 오류"+e.getMessage()+"\n");
		}
	}
	//클라이언트 내부클래스
	class ClientMember extends Thread {
		Socket mySocket;
		String nickName;
		BufferedReader br;
		PrintWriter pw;
		//생성자
		public ClientMember(Socket socket) {
			//외부 run 메소드에서 생성시 소켓을 받아서 생성할것임
			mySocket=socket;

			//네트워크를 통해서 메세지를 읽고 쓸수 있도록 io 클래스 생성
			try {
				br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				pw=new PrintWriter(mySocket.getOutputStream());
			}catch(IOException e) {

			}
		}


		//각 client 로 부터 들어오는 메세지를 읽어서 모든 client 들에게 보내주는 기능
		@Override 
		public void run() {
			// TODO Auto-generated method stub
			//super.run();

			//클라이언트가 보내는 메세지를 언제든지 읽어서 보내줄 수 있도록 한다.
			while (true)
			{
				try {
					String msg=br.readLine();
					//클라이언트에서 보낸 메세지를 서버창에도 출력해보자
					area.append(msg+"\n");
					autoScroll();
					//|로 분리
					//처음 접속시 1|닉네임
					//메세지 전송시 2|메세지
					String []m=msg.split("\\|");
					switch(m[0])
					{
					case"1":
					{
						String senMessageString=m[1]+"님이 입장하였습니다\n";
						nickName=m[1];//닉네임을 멤버변수에 저장
						//이 메세지를 서버에 연결된 모든 클라이언트들한테 보낸다
						for(ClientMember cm:list)
						{
							cm.pw.write(senMessageString+"\n");
							cm.pw.flush();
						}
						break;

					}
					case"2":
					{
						String sendMessage=nickName+">>"+m[1]+"\n";
						//이 메세지를 서버에 연결된모든 클라이언트들한테 보낸다
						for (ClientMember cm:list) {
							cm.pw.write(sendMessage+"\n");
							cm.pw.flush();
						}
						break;
					}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	//채팅창에서 마지막줄로 자동이동
	public void autoScroll()
	{
		int n=area.getDocument().getLength();//총 라인수
		area.setCaretPosition(n);//마지막줄로 위치번경
	}

	public void initDesign()
	{
		area=new JTextArea();
		this.add(new JScrollPane(area));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex5_ServerChat a=new Ex5_ServerChat("클라이언트");
		Thread th=new Thread(a);
		th.start();

	}
}
