// Author: Travis Dowd
// Date: 4-24-2020
// Chapter 10, exercise 10-7

package exercise;

import java.util.Scanner;

public class atm {
	public static void main( String[] args ) {
		// create 10 new accounts
		Account[] acc = new Account[ 10 ];
		acc[ 0 ] = new Account( 0, 100.00 );
		acc[ 1 ] = new Account( 1, 100.00 );
		acc[ 2 ] = new Account( 2, 100.00 );
		acc[ 3 ] = new Account( 3, 100.00 );
		acc[ 4 ] = new Account( 4, 100.00 );
		acc[ 5 ] = new Account( 5, 100.00 );
		acc[ 6 ] = new Account( 6, 100.00 );
		acc[ 7 ] = new Account( 7, 100.00 );
		acc[ 8 ] = new Account( 8, 100.00 );
		acc[ 9 ] = new Account( 9, 100.00 );
		// Create scanner instance
		// Note: Use try to avoid scanner staying open
		try( Scanner input = new Scanner( System.in )){
		// Get account id
		System.out.print( "Enter an ID: " );
		int idSelect = input.nextInt();
		int idReal = acc[ idSelect ].getId();
		// start loop
		while ( true ) {
			// Get options from user
			System.out.println( "Main menu" );
			System.out.println( "1: check balance" );
			System.out.println( "2: withdraw" );
			System.out.println( "3: deposit" );
			System.out.println( "4: exit" );
			System.out.print(   "> " );
			int option = input.nextInt();
			// Logic stuff here
			if ( option == 1 ) {
				System.out.println(acc[ idReal ].getBalance());
			} if ( option == 2 ) {
				System.out.print( "Enter an amount to withdraw: " );
				double amount = input.nextDouble();
				acc[ idReal ].withdraw( amount );
			} if ( option == 3 ) {
				System.out.print( "Enter an amount to deposit: " );
				double amount = input.nextDouble();
				acc[ idReal ].deposit( amount );
			} if ( option == 4 ) {
				System.out.print( "Enter an ID: " );
				idSelect = input.nextInt();
				idReal = acc[ idSelect ].getId();
			}
			}
		}
	}

}
