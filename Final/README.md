# Final

## Calc

This calculator is stack based and uses Reverse Polish Notation( RPN or Postfix notation ). It can do all sorts of calculations, but the syntax is different from what we are normally use to. For example in normal syntax ( infix ), a simple addition problem looks as such:
```Lisp
12 + 7 = 17
```
With RPN that is done like this:
```Lisp
12 7 + = 17
```

It takes some time to get used to but you can do complex calcutaions even without the need to use parenthesis. A good example of its capabalities is converting Celcius to Fahrenheit. Here is an example converting 20°C to 68°F:
```Lisp
Infix:
( 20 × 9/5 ) + 32 = 68

Postfix:
20 9 5 / * 32 + = 68
```

> Worth noting that this calculator handles both integers and floating pint numbers.

### Operators

```
1. + : Addition
2. - : Subtraction
3. * : Multiplication
4. / : Division
5. ^ : Exponents
6. % : Modulo
7. ! : Factorial
```
> Factorial if the only odd one here, the calcutalor expects atlteast two numbers and an operator, so if you only want to the facotial of one number place a 0 before( although this issue is not present if more than 1 number is given ). Here is an example of finding 10 factorial:

```Lisp
// Will not work
> 10 !
error

// This works
> 0 10 !
362880.0

// No 0 needed if other values are present
> 2 10 ! *
725760.0
```

### Examples

Here is a simple example using each operator above
1 . Addition
```Lisp
5 2 + = 7
```
2. Subtraction
```Lisp
10 2 - = 8
```
3. Multiplication
```Lisp
3 6 * = 18
```
4. Division
```Lisp
25 5 / = 5
```
5. Exponents
```Lisp
3 2 ^ = 9
```
6. Modulo
```Lisp
10 6 % = 4
```
7. Factorial
```Lisp
0 5 ! = 24
```

### Use in code

To use Calc.java in another project is quite simple, create with simple contructr and either call the REPL for interactive use, or call with String[] argument for a single calcutalation.
```Java
// Create new Calc object
Calc calc = new Calc();

// Create String[] to calculate
String[] tokens = new String[] { "2", "1", "+", "3", "*" };

// Will print out calculation ( "9" in this example )
System.out.println( calc.run( tokens ));

// Call the interactive Read Eval Print Loop
calc.repl();
```
