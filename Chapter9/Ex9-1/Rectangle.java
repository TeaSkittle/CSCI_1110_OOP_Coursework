// Author: Travis Dowd
// Date: 3-30-2020
// Chapter 9, exercise 9-1

public class Rectangle {
	double width = 1;
	double height = 1;
	
	public Rectangle() {
		
	}
	public Rectangle( double width, double height ) {
		this.width = width;
		this.height= height;
	}
	public double getArea() {
		double area = 0;
		area = width * height;
		return area;
	}
	public double getPerimeter() {
		double perimeter = 0;
		perimeter = ( width + height ) * 2;
		return perimeter;
	}
}
