package shapes;

public class TriangularPrism extends Shape
{
	private static final double SQRT3_DIV_4 = Math.sqrt(3.0) / 4.0;
	private double side;
	
	public TriangularPrism(double h, double s) {
		super(h);
		this.side = s;
	}

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	/**
	 * volume = base area * h
	 */
	@Override
	public double calcVolume() {
		return calcBaseArea() * height;
	}

	/**
	 * base area A = (sqrt(3)/4) s^2
	 */
	@Override
	public double calcBaseArea() {
		return side * side * SQRT3_DIV_4;
	}
	

}
