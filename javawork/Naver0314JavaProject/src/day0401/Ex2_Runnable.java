package day0401;
//thread 를 상속받지 못할 상황에서는 runnable 을 이용
public class Ex2_Runnable implements Runnable{
	private String threadName;
	private int count;

	public Ex2_Runnable (String threadName, int count) { 
		// TODO Auto-generated constructor stub


		this.threadName=threadName;
		this.count=count;

	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1;i<=count;i++)
		{
			System.out.println(threadName+":"+i);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2_Runnable a=new Ex2_Runnable("1번 쓰레드", 300);
		Ex2_Runnable b=new Ex2_Runnable("2번 쓰레드", 300);
		Ex2_Runnable c=new Ex2_Runnable("3번 쓰레드", 300);
		
		Thread th1=new Thread(a);
		Thread th2=new Thread(b);
		Thread th3=new Thread(c);
		
		th1.start();
		th2.start();
		th3.start();
		}

}
