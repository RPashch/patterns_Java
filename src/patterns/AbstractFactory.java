package patterns;

public class AbstractFactory {

	public static void main(String[] args) {

		Factory factory = getFactoryByName("UA");
		Mouse mouse = factory.getMouse();
		Keyboard keyboard = factory.getKeyboard();
		
		mouse.click();
		mouse.dblclick();
		mouse.scroll();
		keyboard.print();
	}

	public static Factory getFactoryByName(String country) {
		if (country.equals("EN")) {
			return new ENFactory();
		} else if (country.equals("UA")) {
			return new UAFactory();
		}
		throw new RuntimeException("Такой фабрики нету " + country);
	}

}

interface Mouse {
	void click();

	void dblclick();

	void scroll();
}

interface Keyboard {
	void print();
}

interface Factory {
	Mouse getMouse();

	Keyboard getKeyboard();
}

class UAMouse implements Mouse {

	@Override
	public void click() {
		// TODO Auto-generated method stub
		System.out.println("click UA mouse");
	}

	@Override
	public void dblclick() {
		// TODO Auto-generated method stub
		System.out.println("dblclick UA mouse");
	}

	@Override
	public void scroll() {
		// TODO Auto-generated method stub
		System.out.println("scroll UA mouse");
	}

}

class ENMouse implements Mouse {

	@Override
	public void click() {
		// TODO Auto-generated method stub
		System.out.println("click EN mouse");
	}

	@Override
	public void dblclick() {
		// TODO Auto-generated method stub
		System.out.println("dblclick EN mouse");
	}

	@Override
	public void scroll() {
		// TODO Auto-generated method stub
		System.out.println("scroll EN mouse");
	}

}

class UAKeyboard implements Keyboard {

	@Override
	public void print() {
		System.out.println("print UAkeyboard");

	}

}

class ENKeyboard implements Keyboard {

	@Override
	public void print() {
		System.out.println("print ENkeyboard");

	}
}

class ENFactory implements Factory {

	@Override
	public Mouse getMouse() {
		// TODO Auto-generated method stub
		return new ENMouse();
	}

	@Override
	public Keyboard getKeyboard() {
		// TODO Auto-generated method stub
		return new ENKeyboard();
	}

}

class UAFactory implements Factory {

	@Override
	public Mouse getMouse() {
		// TODO Auto-generated method stub
		return new UAMouse();
	}

	@Override
	public Keyboard getKeyboard() {
		// TODO Auto-generated method stub
		return new UAKeyboard();
	}

}
