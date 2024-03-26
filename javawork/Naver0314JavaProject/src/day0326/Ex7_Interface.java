package day0326;

interface StudyInter
{
	public void javaStudy();
	public void springStrudy();
	
}
interface PlayInter
{
	public void run();
	public void game();
	
}
class MyStudy implements StudyInter
{
	@Override
	public void javaStudy() {
		// TODO Auto-generated method stub
		System.out.println("자바를 공부합니다.");
		
	}
	@Override
	public void springStrudy() {
		// TODO Auto-generated method stub
		System.out.println("스프링을 공부합니다.");
	}
}
class MyPlay implements PlayInter
{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("달립니다.");
	}
	@Override
	public void game() {
		// TODO Auto-generated method stub
		System.out.println("게임합니다.");
	}
}
public class Ex7_Interface {
	static public void study(StudyInter s)
	{
		s.javaStudy();
		s.springStrudy();
	}
	static public void play(PlayInter p)
	{
		p.run();
		p.game();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		study(new MyStudy());
		play(new MyPlay());
		System.out.println();
		
	}

}
