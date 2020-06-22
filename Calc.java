// (c) Travis Dowd
// (d) 6-17-2020
//
// RPN calc
// based off of: https://www.programcreek.com/2012/12/leetcode-evaluate-reverse-polish-notation/
//
// voerview: https://medium.com/@eauditory3/what-are-stack-based-calculators-cf2dbe249264
//
// TODO: 
//        - Implement parenthesis, have '(' create a new stack & ')' to end stack
//            - May do it already, just need to ignore ( & )
//        - Have repl be an infinte while loop ( clear stack after each loop )

import java.util.Stack;
import java.lang.Math;
import java.util.Scanner;

public class Calc {
	public static void main( String[] args ) {
		repl();
	}
	public static void repl() {
		try ( Scanner input = new Scanner( System.in )) {
			String[] tokens = input.nextLine().split( " " );
			System.out.println( rpn( tokens ));
		} catch ( Exception e ) {
			System.out.println( "error" );
		} 
	}
	public static double rpn( String[] tokens ) throws java.lang.NumberFormatException {
		int returnValue = 0;
		String operators = "+-*/^()";
		Stack<String> base = new Stack<String>();
		for( String t : tokens ){
			if( !operators.contains( t )){
				base.push( t );
			} else {
				double a = Double.valueOf( base.pop() );
				double b = Double.valueOf( base.pop() );
				int index = operators.indexOf( t );
				switch( index ){
					case 0: base.push( String.valueOf( a + b )); break;
					case 1: base.push( String.valueOf( b - a )); break;
					case 2: base.push( String.valueOf( a * b )); break;
					case 3: base.push( String.valueOf( b / a )); break;
					case 4: base.push( String.valueOf(( Math.pow( b, a )))); break;
					case 5: break;  // (
					case 6: break;  // )
				}
			}
		}
		return Double.valueOf( base.pop() );
	}
}
