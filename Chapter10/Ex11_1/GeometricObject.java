// Author: Travis Dowd
// Date: 5-1-2020
//
// Chapter 11, exercise 11-1

package Ex11_1;

import java.util.Date;

public class GeometricObject {
	// Private variables
	private String color;
	private boolean filled;
	private Date dateCreated = new Date();
	// Constructor methods
	GeometricObject(){}
	GeometricObject( String color, boolean filled){
		this.color = color;
		this.filled = filled;
	}
	// Getters
	public String getColor(){
		return color;
	}
	public java.util.Date getDateCreated() {
		return dateCreated;
	}
	// Setters
	public void setColor( String color ){
		this.color = color;
	}
	public void setFilled( boolean filled ) {
		this.filled = filled;
	}
	// Other methods
	public boolean isFilled() {
		return filled;
	}
	@Override
	public String toString() {
		return "created on: " + dateCreated + "\ncolor: " + color +
				" and filled: " + filled;
	}
}
