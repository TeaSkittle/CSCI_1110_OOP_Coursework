// (c) Travis Dowd
// (d) 7-13-2020
//
// CHapter 17, exercise 14

import java.io.*;
import java.util.Scanner;

class Ex17_14 {
	public static void main( String[] args ) {
		try {
			// Get file names from user
			Scanner input = new Scanner( System.in );
			System.out.print( "Input file: " );
			String strIn = input.nextLine();
			System.out.print( "Output file: " );
			String strOut = input.nextLine();
			// Create File objects from input
			File in = new File( strIn );
			File out = new File( strOut );
			// Call encrypt method on file objects
			encrypt( in, out );
		} catch ( IOException e ){
			e.printStackTrace();
		}
	}
	public static void encrypt( File in, File out ) throws IOException {
		// Copy file & encrypt
		try (
			BufferedInputStream input = new BufferedInputStream( new FileInputStream( in ));
			BufferedOutputStream output = new BufferedOutputStream( new FileOutputStream( out ));
		) {
			int r = 0;
			while(( r = input.read()) != -1 ){
				output.write(( byte ) r );
				output.write(( byte ) 5 );
			}
		}
	}
}