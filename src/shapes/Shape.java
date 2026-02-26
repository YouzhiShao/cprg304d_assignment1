package shapes;

public abstract class  Shape implements Comparable<Shape> {
	protected double height;
	
	public Shape(double h){
		this.height = h;
	}
	
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	public abstract double calcVolume();
	public abstract double calcBaseArea();


    @Override
    public int compareTo(Shape other) {
        return Double.compare(other.height, this.height);
    }

    @Override
    public String toString() {
        return String.format("%s(h=%.6f, A=%.6f, V=%.6f)",
                getClass().getSimpleName(), height, calcBaseArea(), calcVolume());
    }


}
