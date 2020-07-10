// (c) Travis Dowd
// (d) 7-10-2020
//
// Chapter 17, exercise 17-3

import java.io.*;

class Ex17_3 {
	public static void main( String[] args ) {
		File f = new File( "Exercise17_03.dat" );
		try {
			writeData( f );
			readData( f );
		} catch ( IOException e ){
			e.printStackTrace();
		}
	}
	public static void writeData( File f ) throws IOException {
		if ( !f.exists() ){
			f.createNewFile();
		} BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream( f ));
		for( int i = 0; i < 100; i++ ){
				int x = ( int )( Math.random() * (  100 - 1 ) + 1 );
				out.write( x );
			} out.close();
	}
	public static void readData( File f ) throws IOException {
		BufferedInputStream in = new BufferedInputStream(new FileInputStream( f ));
		int r, x = 0;
		while(( r = in.read()) != - 1 ){
			x++;
		} System.out.println( x );
	}
}