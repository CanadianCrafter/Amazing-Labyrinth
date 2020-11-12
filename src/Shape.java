package shape;

public abstract class Shape {

	
	//fields - instance variable
	private String name;
	private double area;
	
	public Shape(String name) {
		super(); //Calling super constructor - Object class
		this.name=name;
	}
	
	//getters and setters
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public double getArea() {
		return area;
	}
	
	public void setArea(double area) {
		this.area=area;
	}
	
	//toString Method - used to display the objects contents
	public String toString() {
		return "Shape [name="+name+", area="+area+"]";
	}
	
	//abstract method - concrete implementation must be somewhere further down the hierarchy
	public abstract double calculateArea();

}
