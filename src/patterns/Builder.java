package patterns;

/**
 * ���� ��� ����������� � ���, ����� �������� ������� �������� ����������
 * �������� ������� �� ��� �������������. ����� �������, ����� ��������
 * ��������� ������������� �������, ��������� ���� � ��� �� "���������������"
 * �������.
 * 
 * ������������ ������������� �������� Builder: - ���� ������� �������� ���
 * ��������� �������� ��������; - ��������� ����������� ���������� �������������
 * �������; - �������� ������� ��������������� ������� �� ��� �����������
 * �������������
 * 
 * @author �����
 */
public class Builder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Director director = new Director();
		director.setBuilder(new CitroenBuilder());
		
		Car car = director.buildCar();
		System.out.println(car);
	}
	// ���� �� ������� ������� ����� ������ ������, �� ����� ������ �������
	// �����
	// CAR ������, ������ ��� ��������������� �������������� � ����� ��������
	// ����
	// ������ ������ ��������� � ������� ����� buildCar � ���������
}

enum Transmission {
	MANUAL, AUTO;
}

class Car {
	String maker;
	Transmission transmission;
	int speed;

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public void setTransmission(Transmission transmission) {
		this.transmission = transmission;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "Car [maker=" + maker + ", transmission=" + transmission + ", speed=" + speed + "]";
	}

}

abstract class CarBuilder {
	Car car;

	void createCar() {
		car = new Car();
	}

	abstract void buildMaker();

	abstract void buildTransmission();

	abstract void buildSpeed();

	Car getCar() {
		return car;
	}

}

class VAZBuilder extends CarBuilder {

	@Override
	void buildMaker() {
		// TODO Auto-generated method stub
		car.setMaker("VAZ 2101");

	}

	@Override
	void buildTransmission() {
		// TODO Auto-generated method stub
		car.setTransmission(Transmission.MANUAL);
	}

	@Override
	void buildSpeed() {
		// TODO Auto-generated method stub
		car.setSpeed(100);
	}

}

class CitroenBuilder extends CarBuilder {

	@Override
	void buildMaker() {
		// TODO Auto-generated method stub
		car.setMaker("Citroen");

	}

	@Override
	void buildTransmission() {
		// TODO Auto-generated method stub
		car.setTransmission(Transmission.AUTO);
	}

	@Override
	void buildSpeed() {
		// TODO Auto-generated method stub
		car.setSpeed(160);
	}

}

class Director {
	CarBuilder carbuilder;

	void setBuilder(CarBuilder b) {
		carbuilder = b;
	}

	Car buildCar() {
		carbuilder.createCar();
		carbuilder.buildMaker();
		carbuilder.buildSpeed();
		carbuilder.buildTransmission();
		return carbuilder.getCar();
		// return car;

	}
}