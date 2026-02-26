package shapes;

public class Cone extends Shape
{
	private double radius;

	
	public Cone(double h, double r) {
		super(h);
		this.radius = r;
	}	
	

	public double getRadius() {
		return radius;
	}


	public void setRadius(double radius) {
		this.radius = radius;
	}


	/**
	 * base area = π r^2
	 */
	@Override
	public double calcVolume() {
		return Math.PI * radius * radius;
	}

	/**
	 * volume = (1/3) π r^2 h
	 */
	@Override
	public double calcBaseArea() {
		return calcVolume() * height / 3.0;
	}

}
