package patterns;

/**
 * Назначение паттерна Proxy:
 * 
 * Паттерн Proxy является суррогатом или замеcтителем другого объекта и
 * контролирует доступ к нему. Предоставляя дополнительный уровень косвенности
 * при доступе к объекту, может применяться для поддержки распределенного,
 * управляемого или интеллектуального доступа. Являясь "оберткой" реального
 * компонента, защищает его от излишней сложности.
 * 
 * Решаемая проблема: Вам нужно управлять ресурсоемкими объектами. Вы не хотите
 * создавать экземпляры таких объектов до момента их реального использования.
 * 
 * @author Роман
 *
 */
public class ProxySurrogate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Image image = new ProxyImage("D:/images/my.jpg");
		// image.display();
	}

}

interface Image {
	void display();
}

class RealImage implements Image {
	String file;

	public RealImage(String file) {
		this.file = file;
		load();
	}

	void load() {
		System.out.println("Loading... " + file);
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Show... " + file);
	}

}

class ProxyImage implements Image {
	String file;
	RealImage image;

	public ProxyImage(String file) {
		this.file = file;
	}

	public void display() {
		if (image == null) {
			image = new RealImage(file);
		}
		image.display();
	}
}