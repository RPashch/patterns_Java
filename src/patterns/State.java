package patterns;

/**
 * Паттерн State позволяет объекту изменять свое поведение в зависимости от
 * внутреннего состояния. Создается впечатление, что объект изменил свой класс.
 * Паттерн State является объектно-ориентированной реализацией конечного
 * автомата. Решаемая проблема
 * 
 * Поведение объекта зависит от его состояния и должно изменяться во время
 * выполнения программы. Такую схему можно реализовать, применив множество
 * условных операторов: на основе анализа текущего состояния объекта
 * предпринимаются определенные действия. Однако при большом числе состояний
 * условные операторы будут разбросаны по всему коду, и такую программу будет
 * трудно поддерживать.
 * 
 * @author Роман
 *
 */
public class State {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Station dfm = new RadioProsto();
		Radio radio = new Radio();
		radio.setStation(dfm);

		for (int i = 0; i < 10; i++) {
			radio.play();
			radio.nextStation();

		}

		/*
		 * HumanContext human = new HumanContext();
		 * 
		 * human.setState(new Work()); for(int i=0;i<10;i++){
		 * human.doSomething(); }
		 */
	}

}

// Context
class HumanContext {
	private Activity state;

	public void setState(Activity state) {
		this.state = state;
	}

	public void doSomething() {
		state.doSomething(this);
	}
}

interface Activity {
	void doSomething(HumanContext context);
}

class Work implements Activity {

	@Override
	public void doSomething(HumanContext context) {
		// TODO Auto-generated method stub
		System.out.println("Work!!!");
		context.setState(new WeekEnd());
	}

}

class WeekEnd implements Activity {
	private int count = 0;

	@Override
	public void doSomething(HumanContext context) {
		if (count < 3) {
			System.out.println("Rest!!!");
			count++;
		} else {
			context.setState(new Work());
			context.doSomething();
		}

	}

}

// State (состояние)
interface Station {
	void play();
}

class RadioProsto implements Station {
	public void play() {
		System.out.println("RadioProsto");
	}
}

class RadioFeel implements Station {
	public void play() {
		System.out.println("RadioFeel");
	}
}

class RadioKiss implements Station {
	public void play() {
		System.out.println("RadioKiss");
	}
}

// context

class Radio {
	Station station;

	void setStation(Station station) {
		this.station = station;
	}

	void nextStation() {
		// station.play();
		if (station instanceof RadioProsto) {
			setStation(new RadioFeel());
		} else if (station instanceof RadioFeel) {
			setStation(new RadioKiss());
		} else if (station instanceof RadioKiss) {
			setStation(new RadioProsto());
		}

	}

	void play() {
		station.play();
	}
}
