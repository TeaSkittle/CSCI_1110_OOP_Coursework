// (c) Travis Dowd
// (d) 7-7-2020
//
//  Simple interpeter for shell like commands
//
// https://www.freecodecamp.org/news/the-programming-language-pipeline-91d3f449c919/
// 

package Final;

import java.util.*;
import java.util.Stack;
import java.util.Scanner;
import java.util.EmptyStackException;

public class Shell {
    // --------
    //   REPL  
    // --------
	  public static void repl() {
		int run = 1;
		try ( Scanner input = new Scanner( System.in )) {
			while ( run > 0 ) {
				System.out.print( "> " );
				String[] source = input.nextLine().split( " " );
				try { 
				    System.out.println( lexer( source ));
				} catch ( EmptyStackException e ) {
				    System.out.println( "[-]Error: Empty stack" );
				}
			}
		}
	}
    
    // --------
    //   Run
    // --------
    // Run a single command
    public void run( String[] args ){
		try { 
			System.out.println( lexer( args ));
		} catch ( EmptyStackException e ) {
		    System.out.println( "[-]Error: Empty stack" );
		}
	}
	
    // ---------
    //   Lexer
    // ---------
    public static String[] lexer( String[] args ) throws EmptyStackException {
        if( args[ 0 ].equals( "print" )){
            for( int i = 1; i < args.length; i++ ){
                System.out.print( args[ i ] + " " );
            } System.out.printf( "\n" );
        } if ( args[ 0 ].equals( "calc" )){
            System.out.println( "opening calc.." );
            List<String> list = new ArrayList<String>();
            for( int i = 1; i < args.length; i++){
                list.add( args[ i ]);
            } 
            // Print list for testing
            System.out.println( list );
            //
            // Create new Calc Object:
            // Calc calc = new Calc();
            //
            // And run as:
            // System.out.println( calc.run( list ));
            //
        } if ( args[ 0 ].equals( "quit" )) {
            System.exit( 0 );
        }
        return args;
    }
    
    // ----------
    //   Parser
    // ----------
    public static String[] parser( String[] args ){
        // This doens't seem to be needed
        return args;
    }
    
    // ----------
    //    Main
    // ----------
	public static void main(String[] args) {
		repl();
	}
}
