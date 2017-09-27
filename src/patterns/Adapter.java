package patterns;
//� ����������� ���������� ���� ����� ��������� ������� ������������� ��������.
//��������, ����� ���������� ������� ������������� - ��� java.io.InputStreamReader � OutputStreamWriter.
//����������� InputStreamReader ��������� �� ���� InputStream � � ���������� ���������� ����� � Reader.
/**
 * ������ ������� ��������� � �������� �������������� �� ��������� �� 
 * �������� ��������� �������� � ����������� ��� ������������ �������. 
 *	���� ���� �����, ���������� ���������� �������� � ���������� 
 *	(�� ������� ����, �������������), �� ��� ������������� ������ ����� 
 *	��������������� �������� ������� ��� ���������� ��� ���������� � ������� ����.
 */


public class Adapter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1-�� ������ - ����� ������������
		VectorGraphicsInterface g1 = new VectorAdapterFromRaster();
		g1.drawLine();
		g1.drawSquare();
		
		// 2-�� ������ ����� ����������
		
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

