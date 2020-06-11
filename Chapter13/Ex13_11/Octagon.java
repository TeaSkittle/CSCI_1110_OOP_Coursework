// (c) Travis Dowd
// (d) 6-11-2020
//
// Chapter 13 exercise 13-11

package Ex13_11;

import java.lang.*;

public class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable {
	private double[] sideArray = new double[ 8 ];
	public Octagon(){}
	public Octagon( double side ) {
		for( int i = 0; i < sideArray.length; i++ ) {
			sideArray[i ]= side;
		}
	}
	public double getSide( int side ){
		return sideArray[ side ];
	}
	@Override
	public double getArea(){
		return ( 2 + ( 4 / Math.sqrt( 2 )) * ( getSide( 1 ) * 2 ));
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	@Override
	public int compareTo( Octagon o ){
		return Integer.compare((int)this.getArea(), (int)o.getArea());
	}
}