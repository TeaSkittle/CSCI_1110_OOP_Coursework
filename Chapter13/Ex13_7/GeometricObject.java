// (c) Travis Dowd
// (d) 5-1-2020 ( modified on 6-9-2020 )
//
// Chapter 13 exercise 13-7

package Ex13_7;

import java.util.Date;

public abstract class GeometricObject {
	private String color;
	private boolean filled;
	private Date dateCreated = new Date();
	protected GeometricObject(){}
	protected GeometricObject( String color, boolean filled ){
		this.color = color;
		this.filled = filled;
	}
	public String getColor(){
		return color;
	}
	public java.util.Date getDateCreated() {
		return dateCreated;
	}
	public void setColor( String color ){
		this.color = color;
	}
	public void setFilled( boolean filled ) {
		this.filled = filled;
	}
	public boolean isFilled() {
		return filled;
	}
	@Override
	public String toString() {
		return "created on: " + dateCreated + "\ncolor: " + color +
				" and filled: " + filled;
	}
	public abstract double getArea();
	public abstract double getPerimeter();
}