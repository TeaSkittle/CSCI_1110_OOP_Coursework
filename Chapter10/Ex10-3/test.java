/*
 * Author: Travis Dowd
 * Date: 4-21-2020
 * 
 * Chapter 10, exercise 3
 */

package exercise;

public class test {
	public static void main(String[] args) {
		char[] charArray = { '1', '2', '3' };
		MyInteger data = new MyInteger( 10 );
		System.out.printf("value is: \t");
		System.out.println(data.getValue());
		System.out.printf("Is value even? \t");
		System.out.println(data.isEven());
		System.out.printf("Is value odd? \t");
		System.out.println(data.isOdd());
		System.out.printf("Is value prime? ");
		System.out.println(data.isPrime());
		System.out.printf("value == 10? \t");
		System.out.println(data.equals( 10 ));
		System.out.printf("\nWith object as argument: \n");
		System.out.printf("Is value even? \t");
		System.out.println(data.isEven( data ));
		System.out.printf("Is value odd? \t");
		System.out.println(data.isOdd( data ));
		System.out.printf("Is value prime? ");
		System.out.println(data.isPrime( data ));
		System.out.printf("value == 10? \t");
		System.out.println(data.equals( data ));
		System.out.printf("\nparseInt() methods: \n");
		System.out.printf("String = '6' \t\t");
		System.out.println(MyInteger.parseInt( "6" ));
		System.out.printf("char[] = {'1','2','3'}\t");
		System.out.println(MyInteger.parseInt( charArray ));
	}
}
