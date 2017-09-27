package patterns;

public class Delegate {
	public static void main(String[] args) {
	 B b = new B();
	 b.methodB();
	}
	
}

class A{
	public void methodA(){
		System.out.println("Method from class A has run ");
		
	}
}

class B{
	private A a = new A();
	public void methodB(){
		a.methodA(); // в данном случае класс В делигирует свои полномочия классу А
	}
}