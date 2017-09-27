package patterns;

public class Facade {

	public static void main(String[] args) {
		/*Power power = new Power();
		power.on();
		
		DVDRom dvd = new DVDRom();
		dvd.load();
		
		HDD hdd = new HDD();
		hdd.copyFromDVD(dvd);
		
		//можно так написать, как выше, или создать один класс, который будет в себе
		//скрывать реализацию всех этих объектов и таким образом выполнять роль фасада
		*/
		
		Computer comp = new Computer();
		comp.copy();

	}

}

class Computer{
	Power power = new Power();
	DVDRom dvd = new DVDRom();
	HDD hdd = new HDD();
	
	void copy(){
		power.on();
		dvd.load();
		hdd.copyFromDVD(dvd);
	}
}

class Power{
	void on(){
		System.out.println("Power switch on");
	}
	void off(){
		System.out.println("Power switch off");
	}
}

class DVDRom{
	private boolean data = false;
	public boolean hasData(){
		return data;
	}
	void load(){
		data = true;
	}
	void unload(){
		data= false;
	}
}

class HDD{
	void copyFromDVD (DVDRom dvd){
		if(dvd.hasData()){
			System.out.println("Copy from DVD");
		}
		else{
			System.out.println("Put the DVD");
		}
	}
}


