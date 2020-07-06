// (c) Travis Dowd
// (d) 6-17-2020
//
// RPN calc
//
// based off of: https://www.programcreek.com/2012/12/leetcode-evaluate-reverse-polish-notation/
// overview of stack based calc: https://medium.com/@eauditory3/what-are-stack-based-calculators-cf2dbe249264
//
// TODO: - Add ability to call as one commands, and not use repl. Ex- Calc( "2 3 * 2 ^" );
//       

package Final;

import java.util.Stack;
import java.lang.Math;
import java.util.Scanner;

public class Calc {
	// Constructor
	public Calc(){}
	
	// Caluclate an expression without the need for REPL loop
	public double run( String[] tokens ){
		return rpn( tokens );
	}
	// Loop and get input from user, use intereactively
	public static void repl() {
		int run = 1;
		try ( Scanner input = new Scanner( System.in )) {
			while ( run > 0 ) {
				System.out.print( "> " );
				String[] tokens = input.nextLine().split( " " );
				if ( tokens[0] == "q" || tokens[0] == "quit" ) {
					System.out.println( "pass" );
					run = 0;
				} else {
					System.out.println( rpn( tokens ));
				}
			}
		} catch ( Exception e ) {
			//run = 0;
			System.out.println( "error" );
		} 
	}
	public static double rpn( String[] tokens ) throws java.lang.NumberFormatException {
		double returnValue = 0;
		String operators = "+-*/^%!";
		Stack<String> stack = new Stack<String>();
		for( String t : tokens ){
			if( !operators.contains( t )){
				stack.push( t );
			} else {
				double a = Double.valueOf( stack.pop() );
				double b = Double.valueOf( stack.pop() );
				int index = operators.indexOf( t );
				switch( index ) {
					case 0: stack.push( String.valueOf( a + b )); break;
					case 1: stack.push( String.valueOf( b - a )); break;
					case 2: stack.push( String.valueOf( a * b )); break;
					case 3: stack.push( String.valueOf( b / a )); break;
					case 4: stack.push( String.valueOf(( Math.pow( b, a )))); break;
					case 5: stack.push( String.valueOf( b % a )); break;
					case 6: 
						double fact = 1;
						stack.push( String.valueOf( b ));
						for( int i = 1; i < a; i++){
							fact *= i;
						} stack.push( String.valueOf( fact ));
						break;
				}
			}
		} returnValue =  Double.valueOf( stack.pop() );
		stack.clear();
		return returnValue;
	}
	// Goes straight to repl if ran by itself
	public static void main( String[] args ) {
		repl();
	}
}
