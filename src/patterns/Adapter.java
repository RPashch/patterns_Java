package patterns;
//В стандартной библиотеке тоже можно встретить примеры использования Адаптера.
//Наверное, самый популярный вариант использования - это java.io.InputStreamReader и OutputStreamWriter.
//Конструктор InputStreamReader принимает на вход InputStream и в результате адаптирует поток в Reader.
/**
 * Шаблон Адаптер позволяет в процессе проектирования не принимать во 
 * внимание возможные различия в интерфейсах уже существующих классов. 
 *	Если есть класс, обладающий требуемыми методами и свойствами 
 *	(по крайней мере, концептуально), то при необходимости всегда можно 
 *	воспользоваться шаблоном Адаптер для приведения его интерфейса к нужному виду.
 */


public class Adapter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1-ый способ - через наследование
		VectorGraphicsInterface g1 = new VectorAdapterFromRaster();
		g1.drawLine();
		g1.drawSquare();
		
		// 2-ой способ через композицию
		
		VectorGraphicsInterface g2 = new VectorAdapterFromRaster2();
		g2.drawLine();
		g2.drawSquare();
	}

}

interface VectorGraphicsInterface{
	void drawLine();
	void drawSquare();
}

class RasterGraphics{
	void drawRasterLine(){
		System.out.println("Draw line");
	}
	void drawRasterSquare(){
		System.out.println("Draw square");
	}
}

class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicsInterface{

	@Override
	public void drawLine() {
		drawRasterLine();		
	}

	@Override
	public void drawSquare() {
		drawRasterSquare();
	}
	
}

class VectorAdapterFromRaster2 implements VectorGraphicsInterface{
	RasterGraphics rg = new RasterGraphics();
	@Override
	public void drawLine() {
		rg.drawRasterLine();
	}

	@Override
	public void drawSquare() {
		rg.drawRasterSquare();
	}
	
}

