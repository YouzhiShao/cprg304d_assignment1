package shapes;

public class PentagonalPrism extends Shape
{
	private static final double TAN_54 = Math.tan(Math.toRadians(54.0));
	private double side;
	
	public PentagonalPrism(double h, double s) {
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
	 * volume = A * h
	 */
	@Override
	public double calcVolume() {
		return calcBaseArea() * height;
	}

	/***
	 * base area A = (5 s^2 tan(54°))/4 
	 */
	@Override
	public double calcBaseArea() {
		return (5.0 * side * side * TAN_54) / 4.0;
	}
	
	

}
