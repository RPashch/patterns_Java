package patterns;

/**
 * Назначение паттерна Chain of Responsibility:
 * 
 * Паттерн Chain of Responsibility позволяет избежать жесткой зависимости
 * отправителя запроса от его получателя, при этом запрос может быть обработан
 * несколькими объектами. Объекты-получатели связываются в цепочку. Запрос
 * передается по этой цепочке, пока не будет обработан. Вводит конвейерную
 * обработку для запроса с множеством возможных обработчиков.
 * Объектно-ориентированный связанный список с рекурсивным обходом.
 * 
 * 
 * Решаемая проблема:
 * 
 * Имеется поток запросов и переменное число "обработчиков" этих запросов.
 * Необходимо эффективно обрабатывать запросы без жесткой привязки к их
 * обработчикам, при этом запрос может быть обработан любым обработчиком.
 * 
 * @author Роман
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
// можно переписать этот интерфейс в абстракт класс
// туда записать все поля, которые нужны и методы
// все остальные классы расширят этот абстрактный класс
// для чего? - для оптимизации!
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
			System.out.println("Записываем файл: " + message);
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
			System.out.println("Выслать на почту сообщение: " + message);
		}

		if (next != null) {
			next.writeMessage(message, level);
		}
	}

}
