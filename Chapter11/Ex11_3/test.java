// (c) Travis Dowd
// (d) 6-1-2020
// Test class for chapter 11 exercise 3

package Ex11_3;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		// Create new accounts
		Account core = new Account( 0, 1000.00 );
		Savings save = new Savings( 1, 100.00 );
		Checkings check = new Checkings( 2, 100, 100 );
		// toString()
		System.out.println( "Base account\n------------");
		System.out.println( core.toString() );
		System.out.println( "\nSavings account\n---------------");
		System.out.println( save.toString() );
		System.out.println( "\nCheckings account\n-----------------");
		System.out.println( check.toString() );		
		// Withdraw
		System.out.println("\nWithdraw\n---------------");
		try ( Scanner input = new Scanner( System.in )) {
			System.out.print( "Withdraw from account: " + save.getId() + "\nBalance: " + save.getBalance());
			System.out.print("\nWithdraw amount: ");
			double savepull = input.nextDouble();
			if (savepull > save.getBalance()) { 
				System.out.print("[!] Error: Can't overdraft account!\n");
			} else {
				save.withdraw( savepull );
			} System.out.println( "Remaining balance: " + save.getBalance());
			System.out.print( "\nWithdraw from account: " + check.getId() + "\nBalance: " + check.getBalance() );
			System.out.print("\nWithdraw amount ( -" + check.getOverdraft() + " overdraft limit ): ");
			double checkpull = input.nextDouble();
			if (checkpull >= (check.getBalance() + check.getOverdraft()) ) {
				 System.out.print("[!] Error: hit overdraft limit!\n");
			} else {
				check.withdraw( checkpull );
			} System.out.println( "Remaining balance: " + check.getBalance());					
		}
	}
}
