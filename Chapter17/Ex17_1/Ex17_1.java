// (c) Traivs Dowd
// (d) 7-10-2020
//
// Chapter 17, exercise 17-1

import java.io.*;

class Ex17_1 {
	public static void main( String[] args ) throws IOException {
		File f = new File( "Exercise17_01.txt" );
		if ( f.exists() ){
			writeData( f );
		} else {
			f.createNewFile();
			writeData( f );
		}
	}
	public static void writeData( File f ) throws IOException {
		PrintWriter out = new PrintWriter( f );
		for( int i = 0; i < 100; i++ ){
			int x = ( int )( Math.random() * (  100 - 1 ) + 1 );
			out.print( x + " " );
		} out.close();
	}
}