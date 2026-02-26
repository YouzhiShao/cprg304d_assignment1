package shapes;

public class SquarePrism extends Shape
{
	private double side;
	
	public SquarePrism(double h, double s) {
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
	 * volume  = s^2 h
	 */
	@Override
	public double calcVolume() {
		return calcBaseArea() * height;
	}

	/**
	 * 
	 * base area = s^2
	 */
	@Override
	public double calcBaseArea() {
		return side*side;
	}
	
	

}
