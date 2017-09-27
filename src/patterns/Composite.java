package patterns;

import java.util.ArrayList;
import java.util.List;

public class Composite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle rectangle1 = new Rectangle();
		Rectangle rectangle2 = new Rectangle();
		Rectangle rectangle3 = new Rectangle();

		Triangle triangle1 = new Triangle();
		Triangle triangle2 = new Triangle();
		Triangle triangle3 = new Triangle();

		CompositeComponent compositeComponent1 = new CompositeComponent();
		CompositeComponent compositeComponent2 = new CompositeComponent();
		CompositeComponent compositeComponent3 = new CompositeComponent();
		
		compositeComponent1.addComponent(triangle3);
		
		compositeComponent2.addComponent(triangle2);
		compositeComponent2.addComponent(rectangle2);
		compositeComponent2.addComponent(rectangle3);
		
		compositeComponent3.addComponent(rectangle1);
		compositeComponent3.addComponent(triangle1);
		
		compositeComponent1.addComponent(compositeComponent2);
		
		compositeComponent1.addComponent(compositeComponent3);
		
		compositeComponent1.draw();
		
		//"сумка в сумке", то есть в сумке может быть вещи и сумки, в которых также могут быть сумки
		//но при вызове метода из объекта "главной сумки", этот метод будет вызван у каждого товара
	}

}

interface Shape {
	void draw();
}

class Rectangle implements Shape {

	@Override
	public void draw() {
		System.out.println("Rectangle");

	}

}

class Triangle implements Shape {

	@Override
	public void draw() {
		System.out.println("Triangle");

	}

}

class CompositeComponent implements Shape {
	private List<Shape> components = new ArrayList<>();

	public void addComponent(Shape component) {
		components.add(component);
	}

	public void removeComponent(Shape component) {
		components.remove(component);
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		for (Shape shape : components) {
			shape.draw();
		}
	}

}