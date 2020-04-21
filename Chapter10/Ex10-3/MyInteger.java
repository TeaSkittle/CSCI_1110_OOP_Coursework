/*
 * Author: Travis Dowd
 * Date: 4-21-2020
 * 
 * Chapter 10, exercise 3
 */

package exercise;

import java.lang.Integer;
import java.lang.String;

public class MyInteger {
	private int value;
	// Constructor
	public MyInteger( int value ) {
		this.value = value;
	}
	// Getter
	public int getValue() {
		return value;
	}
	// Boolean Return Methods
	public boolean isEven() {
		if ( value % 2 == 0)
			return true;
		else
			return false;
	}
	public boolean isOdd() {
		if ( value % 2 != 0 ) 
			return true;
		else
			return false;
	}
	public boolean isPrime() {
		int prime = 0;
		for ( int i = 2; i <= value / 2; i++ ) {
			if ( value % i == 0 ) {
				prime = 0;
				break;
			} else {
				prime = 1;
			}
		} if ( prime == 0 )
			return false;
		else
			return true;
	}
	public boolean equals( int data ) {

		if ( data == value )
			return true;
		else
			return false;
	}
	// Return methods with object as argument
	public boolean isEven( MyInteger obj ) {
		if ( obj.value % 2 == 0)
			return true;
		else
			return false;
		}
	public boolean isOdd( MyInteger obj ) {
		if ( obj.value % 2 != 0 ) 
			return true;
		else
			return false;
	}
	public boolean isPrime( MyInteger obj ) {
		int prime = 0;
		for ( int i = 2; i <= obj.value / 2; i++ ) {
			if ( obj.value % i == 0 ) {
				prime = 0;
				break;
			} else {
				prime = 1;
			}
		} if ( prime == 0 )
			return false;
		else
			return true;
	}
	public boolean equals( MyInteger obj ) {
		if ( obj.value == value )
			return true;
		else
			return false;
	}
	// Parsing Methods
	// Note: these should be called as MyInteger.parseInt() 
	// and not child.ParseInt() since they are static.
	public static int parseInt( String data ) {
		return Integer.parseInt( data );
	}
	public static int parseInt( char[] data ) {
		String dataString = String.copyValueOf( data );
		return Integer.parseInt( dataString );
	}
}
