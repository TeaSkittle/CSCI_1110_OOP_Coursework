// (c) Travis Dowd
// (d) 6-17-2020
//
// RPN calc ( with ints )
// based off of: https://www.programcreek.com/2012/12/leetcode-evaluate-reverse-polish-notation/

import java.util.Stack;
import java.lang.Math;
import java.util.Scanner;

public class Untitled {
	public static void main(String[] args) {
		repl();
	}
	public static void repl() {
		try ( Scanner input = new Scanner( System.in )) {
			String tokensStr = input.nextLine();
			String[] tokens = new String[] { tokensStr };
			System.out.println(tokens);
			//String[] tokens = new String[] { "2", "1", "+", "3", "^" };
			System.out.println(evalRPN(tokens));
		} catch ( Exception e ) {
			System.out.println("error");
		}
	}
	public static int evalRPN(String[] tokens) throws java.lang.NumberFormatException {
		int returnValue = 0;
		String operators = "+-*/^";
		Stack<String> stack = new Stack<String>();
		for(String t : tokens){
			if(!operators.contains(t)){
				stack.push(t);
			} else {
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());
				int index = operators.indexOf(t);
				switch(index){
					case 0: stack.push(String.valueOf(a+b)); break;
					case 1: stack.push(String.valueOf(b-a)); break;
					case 2: stack.push(String.valueOf(a*b)); break;
					case 3: stack.push(String.valueOf(b/a)); break;
					case 4: stack.push(String.valueOf(((int)Math.pow(a, b)))); break;
				}
			}
		}
		return Integer.valueOf(stack.pop());
	}
}