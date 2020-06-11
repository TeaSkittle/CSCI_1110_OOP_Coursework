// (c) Travis Dowd
// (d) 6-11-2020
//
// Chapter 13 exercise 13-11

package Ex13_11;

class test {
	public static void main( String[] args ) throws CloneNotSupportedException {
		// Get random single digit int
		int number = ( int )( Math.random() * 10 );
		Octagon oct = new Octagon( number );
		Octagon octClone = ( Octagon )oct.clone();
		System.out.println( "Octagaon1 - Area: " + oct.getArea());
		System.out.println( "Octagaon2 - Area: " + octClone.getArea());
		System.out.print( "compareTo(): " );
		System.out.print( oct.compareTo( octClone ) + "\n\t( 0 means they are equal )" );
	}
}