package shapes;

public class Cylinder extends Shape
{
	private double radius;
	
	public Cylinder(double h, double r) {
		super(h);
		this.radius = r;
		// TODO Auto-generated constructor stub
	}

	/**
	 * base area = π r^2
	 */
	@Override
	public double calcVolume() {
		return Math.PI * radius * radius;
	}

	/**
	 * volume = π r^2 h
	 */
	@Override
	public double calcBaseArea() {
		return calcVolume() * height;
	}

}
