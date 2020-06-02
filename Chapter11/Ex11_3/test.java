// (c) Travis Dowd
// (d) 6-1-2020
// Test class for chapter 11 exercise 3

package Ex11_3;

public class test {
	public static void main(String[] args) {
		// Create new accounts
		Account core = new Account( 0, 1000.00 );
		Savings save = new Savings( 1, 5025.00 );
		Checkings check = new Checkings( 1, 600.56, -100 );
		// toString()
		System.out.println( "Base account\n------------");
		System.out.println( core.toString() );
		System.out.println( "\nSavings account\n---------------");
		System.out.println( save.toString() );
		System.out.println( "\nCheckings account\n-----------------");
		System.out.println( check.toString() );
	}

}
