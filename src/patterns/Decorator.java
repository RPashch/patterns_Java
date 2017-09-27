package patterns;

/**
 * Назначение паттерна Decorator:
 * 
 * Паттерн Decorator динамически добавляет новые обязанности объекту. Декораторы
 * являются гибкой альтернативой порождению подклассов для расширения
 * функциональности. Рекурсивно декорирует основной объект. Паттерн Decorator
 * использует схему
 * "обертываем подарок, кладем его в коробку, обертываем коробку".
 * 
 * Решаемая проблема:
 * 
 * Вы хотите добавить новые обязанности в поведении или состоянии отдельных
 * объектов во время выполнения программы. Использование наследования не
 * представляется возможным, поскольку это решение статическое и
 * распространяется целиком на весь класс.
 * 
 * @author Роман
 *
 */
public class Decorator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// PrinterInterface printer = new Printer("Hello");
		PrinterInterface printer = new QuotesDecorator(new Printer("Hello"));
		printer.print();
	}

}

interface PrinterInterface {
	void print();
}

class Printer implements PrinterInterface {
	String value;

	public Printer(String value) {
		this.value = value;
	}

	public void print() {
		// TODO Auto-generated method stub
		System.out.print(value);
	}

}

abstract class DecoratorAbsctract implements PrinterInterface {
	PrinterInterface component;

	public DecoratorAbsctract(PrinterInterface component) {
		this.component = component;
	}

	public void print() {
		component.print();
	}
}

class QuotesDecorator extends DecoratorAbsctract {
	// PrinterInterface component;

	public QuotesDecorator(PrinterInterface component) {
		super(component);
	}

	@Override
	public void print() {
		System.out.print("\"");
		super.print();
		System.out.print("\"");
	}

}