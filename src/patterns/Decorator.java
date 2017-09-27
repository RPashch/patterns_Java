package patterns;

/**
 * ���������� �������� Decorator:
 * 
 * ������� Decorator ����������� ��������� ����� ����������� �������. ����������
 * �������� ������ ������������� ���������� ���������� ��� ����������
 * ����������������. ���������� ���������� �������� ������. ������� Decorator
 * ���������� �����
 * "���������� �������, ������ ��� � �������, ���������� �������".
 * 
 * �������� ��������:
 * 
 * �� ������ �������� ����� ����������� � ��������� ��� ��������� ���������
 * �������� �� ����� ���������� ���������. ������������� ������������ ��
 * �������������� ���������, ��������� ��� ������� ����������� �
 * ���������������� ������� �� ���� �����.
 * 
 * @author �����
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