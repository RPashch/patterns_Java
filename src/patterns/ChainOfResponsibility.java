package patterns;

/**
 * ���������� �������� Chain of Responsibility:
 * 
 * ������� Chain of Responsibility ��������� �������� ������� �����������
 * ����������� ������� �� ��� ����������, ��� ���� ������ ����� ���� ���������
 * ����������� ���������. �������-���������� ����������� � �������. ������
 * ���������� �� ���� �������, ���� �� ����� ���������. ������ �����������
 * ��������� ��� ������� � ���������� ��������� ������������.
 * ��������-��������������� ��������� ������ � ����������� �������.
 * 
 * 
 * �������� ��������:
 * 
 * ������� ����� �������� � ���������� ����� "������������" ���� ��������.
 * ���������� ���������� ������������ ������� ��� ������� �������� � ��
 * ������������, ��� ���� ������ ����� ���� ��������� ����� ������������.
 * 
 * @author �����
 *
 */
public class ChainOfResponsibility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SMSLoger log1 = new SMSLoger(Level.ERROR);
		FileLoger log2 = new FileLoger(Level.DEBUG);
		EmailLoger log3 = new EmailLoger(Level.INFO);
		log1.setNext(log2);
		log2.setNext(log3);
		log1.writeMessage("Only info mesage", Level.INFO);// 3
		log1.writeMessage("Debug the system", Level.DEBUG);// 2
		log1.writeMessage("System failure", Level.ERROR);// 1

	}

}

class Level {
	public static final int ERROR = 1;
	public static final int DEBUG = 2;
	public static final int INFO = 3;
}
// ����� ���������� ���� ��������� � �������� �����
// ���� �������� ��� ����, ������� ����� � ������
// ��� ��������� ������ �������� ���� ����������� �����
// ��� ����? - ��� �����������!
interface Logger {
	void writeMessage(String message, int level);
}

class SMSLoger implements Logger {
	int priority;
	Logger next;

	public SMSLoger(int priority) {
		this.priority = priority;
	}

	public void setNext(Logger next) {
		this.next = next;
	}

	@Override
	public void writeMessage(String message, int level) {
		// TODO Auto-generated method stub
		if (level <= priority) {
			System.out.println("SMS: " + message);
		}

		if (next != null) {
			next.writeMessage(message, level);
		}
	}

}

class FileLoger implements Logger {
	int priority;
	Logger next;

	public FileLoger(int priority) {
		this.priority = priority;
	}

	public void setNext(Logger next) {
		this.next = next;
	}

	@Override
	public void writeMessage(String message, int level) {
		// TODO Auto-generated method stub
		if (level <= priority) {
			System.out.println("���������� ����: " + message);
		}

		if (next != null) {
			next.writeMessage(message, level);
		}
	}

}

class EmailLoger implements Logger {
	int priority;
	Logger next;

	public EmailLoger(int priority) {
		this.priority = priority;
	}

	public void setNext(Logger next) {
		this.next = next;
	}

	@Override
	public void writeMessage(String message, int level) {
		// TODO Auto-generated method stub
		if (level <= priority) {
			System.out.println("������� �� ����� ���������: " + message);
		}

		if (next != null) {
			next.writeMessage(message, level);
		}
	}

}
