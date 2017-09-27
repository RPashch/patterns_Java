package patterns;

import java.util.Date;

public class FactoryMethod {

	public static void main(String[] args) {
			
		/*WatchMaker maker = new DigitalWatchMaker();
		//фишка в том, что мы не меняем нижнюю (клиенсткий код) часть
		//а меняем лишь самого производителя часов
		Watch watch = maker.createWatch();
		watch.showTime();*/
		
		WatchMaker maker = getMakerByName("Digital");
	
		Watch watch = maker.createWatch();
		watch.showTime();
	}
	
	public static WatchMaker getMakerByName(String maker){
		if (maker.equals("Digital")){
			return new DigitalWatchMaker();
		}
		else if(maker.equals("Rome")){
			return new RomeWatchMaker();
		}
		throw new RuntimeException("Таких часов нету "+ maker);
	}

}

interface Watch {
	void showTime();
}

class DigitalWatch implements Watch {
	public void showTime() {
		System.out.println(new Date());
	}
}

class RomeWatch implements Watch {
	public void showTime() {
		System.out.println("VII-XX");
	}
}

interface WatchMaker{
	Watch createWatch();
}

class DigitalWatchMaker implements WatchMaker{
	public Watch createWatch() {
		return new DigitalWatch();
	}
}

class RomeWatchMaker implements WatchMaker{
	public Watch createWatch() {
		return new RomeWatch();
	}
}