package patterns;

public class Prototype {

	public static void main(String[] args) {
		Human inna =new Human (15,25);
		Human copeInna = (Human)inna.copy();
		System.out.println(inna);
		System.out.println(copeInna);
	}

}

interface Copyble {
	Object copy();
}

class Human implements Copyble {

	int age;
	int id;

	public Human(int age, int id) {
		this.age = age;
		this.id = id;
	}

	@Override
	public Object copy() {
		// TODO Auto-generated method stub
		return new Human(this.age,this.id);
	}

	@Override
	public String toString() {
		return "Human [age=" + age + ", id=" + id + "]";
	}

	
}