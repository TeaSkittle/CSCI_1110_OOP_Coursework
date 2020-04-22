/*
 * Author: Travis Dowd
 * Date: 4-21-2020
 * 
 * Chapter 10, exercise 3
 */

package exercise;

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
	// Static boolean return methods
	public static boolean isEven( int val ) {
		if ( val % 2 == 0)
			return true;
		else
			return false;
	}
	public static boolean isOdd( int val ) {
		if ( val % 2 != 0 ) 
			return true;
		else
			return false;
	}
	public static boolean isPrime( int val ) {
		int prime = 0;
		for ( int i = 2; i <= val / 2; i++ ) {
			if ( val % i == 0 ) {
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
	// Return methods with object as argument
	public static boolean isEven( MyInteger obj ) {
		if ( obj.value % 2 == 0)
			return true;
		else
			return false;
		}
	public static boolean isOdd( MyInteger obj ) {
		if ( obj.value % 2 != 0 ) 
			return true;
		else
			return false;
	}
	public static boolean isPrime( MyInteger obj ) {
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
	public static int parseInt( String str ) {
		char[] data = str.toCharArray();
		int result = 0;
		int size = data.length;
		for( int i = 0; i < size; i++ ) {
			int digit = data[ i ] - '0';
			result = result * 10;
			result = result + digit;
		}
		return result;
	}
	public static int parseInt( char[] data ) {
		int result = 0;
		int size = data.length;
		for( int i = 0; i < size; i++ ) {
			int digit = data[ i ] - '0';
			result = result * 10;
			result = result + digit;
		}
		return result;
	}
}
