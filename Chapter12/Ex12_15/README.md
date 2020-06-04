# Exercise 12-15

## Overview

* Create 100 random integers
```Java
import java.lang.Math;

int[] intArray = new int[ 100 ];
for ( int i = 0; i < 100; i++; ) {
    intArray[ i ] = ( int )( Math.random() * 1000 );
}
```
* Write the integers to a file ( seperated by spaces )
* Read the data back from file and display in increasing order

## Write to file

```Java
import java.io.*;

// Make sure main throws IOException
File file = new java.io.File( "Exercise12_15.txt" );

// Check for file
if ( file.exists() ) {
   System.out.println( "File already exists" );
   System.exit( 1 );
}

// Else, continue
PrintWriter output = new PrintWriter( file );
for( int i: intArray ) {
     output.print( i + " " );
}
output.close();
```

## Read from file

* Use the same file used above
```Java
import java.util.Scanner;

int[] sortedArray = new int[ intArray.length ];
int e = 0;
Scanner input = new Scanner ( file );
while ( input.hasNext() ) {
      int number = input.nextInt();
      sortedArray[ e ] = number;
      e++;
}
input.close();
```

## Sort the number and print

```Java
import java.util.Arrays;

Arrays.sort( sortedArray );
for ( int i: sortedArray ) {
    System.out.println( i );
}
```
