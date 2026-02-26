package shapes;

public class Pyramid extends Shape
{
	private double side;

	public Pyramid(double h, double s) {
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
	 * 
	 * 	base area = s^2
	 */
	@Override
	public double calcBaseArea() {
		return side * side;
	}

	/**
	 * 	volume    = (1/3) s^2 h
	 */
	@Override
	public double calcVolume() {
		return calcBaseArea() * height / 3.0;
	}

}
