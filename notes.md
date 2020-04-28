# Java OOP Notes
Quote from textbook:
> The three pillars of object-oriented programming are encapsulation, inheritance, and polymorphism.

## Inheritance
* Basically use a superclass as a parent to other classes as a basis to expand on. The child class can use maethods from the parent class, this reduces the need to rewrite as much code.
* Any class can be a "super-class', just call the child class with the keyword: __extend__. Example:  
```java
class A {
	// Class A code goes here
}

class B extends A {
	// class B code goes here
	// and can use code from class A
}
```
* Use the __super__ keyword to access data from parent classs, example:
```java
class A {
	String color = 'white";
}

class B extends A {
	String color = "black";
	System.out.println( color ); // prints "black"
	System.out.println( super.color ); // prints "white" 
}
```
* If wanting to override the orignal method from the parent class, remember to use the __@Override__ annotation. This is to avoid a compiler warning (not neeeded but VERY good practice). Example:
```java
class A {
	String color = "white";
}

class B extends A {
	@Override
	String color = "black";
	System.out.println( color ); // prints "black"
}
```

## Polymorphism

