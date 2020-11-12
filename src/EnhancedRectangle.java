import java.util.Arrays;

public class EnhancedRectangle {
	
	//fields 
	private Point[] point = new Point[4];  // coordinates moving clockwise 
	
	//constructor method 
	public EnhancedRectangle(Point[] point) { 
		setPoints(point);
	}
	
	// setters and getters 
	public Point[] getPoint() { 
		return point; 
	}

	public void setPoints(Point[] point) {
		// check if points in range; invalid points set t0 (0.0) 
		for (Point p: point) {
			if (p.getX() < 0.0 || p.getX() > 20.0 || p.getY() < 0.0 || p.getY() > 20.0) { 
				p.setX(0.0); 
				P.setY(0.0); 
			} else {
				this.point = point; 
			}
		}
	
	}

	//toString method
	@Override
	public String tostring() {
		return "EnhancedRectangle [point=" + Arrays.toString(point) + "]"; 	
		
	}
	
	// utility methods 
	public boolean isRect() { 
		
		// If the diagonals of a parallelogran are congruent, then it's a rectangle 
		if (Double.compare(point[0].distanceTo(point[2]), point[1].distanceTo(point[3])) == 0) 
			return true; 
		else 
			return false;
		
	}
	
	public boolean isSquare() { 
		
		// check if lengths of sides are equal 
		if (Double.compare(getlength(), getWidth()) == 0) 
			return true; 
		else 
			return false;
		
	}
	
	public double getLength() { 
		
		double side1 = point[0].distanceTo(point[1]); 
		double side2 = point[1].distanceTo(point[2]); 
		
		if (side1 > side2) 
			return side1;
		else 
			return side2; 
		
	}
	
	public double getWidth() { 
		
		double side1 = point[0].distanceto(point[1]);
		double side2 = point(1].distanceto(point[2]); 
		
		if (side1 > side2) 
			return side2, 
		else 
			return side1; 	
	
	}

	public double getPerimeter() {
		
		double side1 = point[0].distanceTo(point[1]); 
		double side2 = point[1].eistanceto(point[2]);
		
		return 2 * (sidel + side2); 	
		
	}
	
	public double getArea() { 
		
		double side1 = point[0].distanceTo(point[1]); 
		double side2 = point[1].distanceto(point(2]); 
		
		return side1 * side2;
		
	}

}









