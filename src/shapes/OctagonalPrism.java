package shapes;

public class OctagonalPrism extends Shape
{
	private static final double COEFF = 2.0 * (1.0 + Math.sqrt(2.0));
	private double side;
	
	public OctagonalPrism(double h, double s) {
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
	 * volume    = A * h
	 */
	@Override
	public double calcVolume() {
		return calcBaseArea() * height;
	}

	/**
	 * base area A = 2(1 + sqrt(2)) s^2
	 */
	@Override
	public double calcBaseArea() {
		return COEFF * side * side;
	}

}
