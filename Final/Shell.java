// (c) Travis Dowd
// (d) 7-7-2020
//
// Simple interpeter for shell like commands, designed mainly for use inside Ed.java inside the mode line
//
// https://www.freecodecamp.org/news/the-programming-language-pipeline-91d3f449c919/
// 

package Final;

import java.util.*;
import java.util.Stack;
import java.util.Scanner;
import java.util.EmptyStackException;
import java.util.Arrays;

public class Shell {
    // Constructor
    public Shell(){}
    
    // --------
    //   REPL  
    // --------
    //
    // Read Eval Print Loop, a simple shell-like interpreter
    //
    public static void repl() {
        int run = 1;
            try ( Scanner input = new Scanner( System.in )) {
            while ( run > 0 ) {
                System.out.print( "> " );
                String[] source = input.nextLine().split( " " );
                //String  str = source.toString();
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
    //
    // Run a single command
    // Example:
    //   Shell.run( "calc 3 3 ^" );
    //   output: 27
    //
    public String[] run( String[] args ){
        try { 
            //System.out.println( lexer( args ));
            //String[] cmd = args.split( "" );
            return lexer( args );
        } catch ( EmptyStackException e ) {
            System.out.println( "[-]Error: Empty stack" );
        } return args;
    }
    
    // ---------
    //   Lexer
    // ---------
    //
    // This method is the core logic for the commands, it splits the args array and run commands based on the first arg
    // Example:
    //    lexer( "print hello world!" );
    //    output: hello world
    //
    public static String[] lexer( String[] args ) throws EmptyStackException {
        //String[] args = cmd.split( "" );
        if( args[ 0 ].equals( "print" )){
            for( int i = 1; i < args.length; i++ ){
                System.out.print( args[ i ] + " " );
            } System.out.printf( "\n" );
        } if ( args[ 0 ].equals( "calc" )){
            // Make List<String> from input
            List<String> list = new ArrayList<String>();
            for( int i = 1; i < args.length; i++){
                list.add( args[ i ]);
            } 
            // Make String[] from List<String>
            String[] tokens = new String[ list.size() ];
            for( int i = 0; i < list.size(); i++ ){
                tokens[ i ] = list.get( i );
            }
            Calc calc = new Calc();
            System.out.println( calc.run( tokens ));
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
        // may be useful in the future though
        return args;
    }
    
    // ----------
    //    Main
    // ----------
    public static void main( String[] args ) {
        repl();
    }
}
