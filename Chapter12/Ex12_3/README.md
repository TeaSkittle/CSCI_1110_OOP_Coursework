# Exercise 12-3 Planning

## Overview

* declare array of 100 random int:  
```Java
int[] intArray = new int[100];
```

* To make random int:  
```Java
int number = ( int )( Math.random() )
```

* for loop through array and assin random int to each index:  
```Java
for( int i = 0; i < intArray.length; i++ ) {
     intArray[ i ] = ( int )( Math.random() );
}
```

## Error Handling

> The error handling should start with trying to get input from Scanner object, and needs to catch an exception if integer inputed is greater than 100.

* Should be as simple as this:
```Java
try( Scanner input = new Scanner( System.in )) {
     int number = input.nextInt();
}
catch ( ArrayIndexOutOfBoundsException ex ) {
      System.out.prinln("ERROR: Integer must be between 1 and 100");
}
```
