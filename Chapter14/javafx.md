# JavaFX Notes

> JavaFX replaces the outdated wwing architecture whcih replaced AWT ( Abstract Windows Toolkit ).

## Structure 

* Make sure to import JavaFX: `import javafx.*`
* Every JavaFX program is defined in a class that extends javafx.application.Application.
* The launch method is a static method for launching a stand-alone JavaFX applications.
* After the JavaFX app is launched, the JVM goes to the start method( which should be overriden )
* An exmaple showing all of the above:  
```Java
import javafx.*;

public class TestClass extends Application {
  @Override
  public void start( Stage primaryStage ) {
    ..
  }
  public static void main( String[] args ) {
    Application.launch( args );
  }      
}
```

### Core Object Types

1. Button
2. Scene
3. Stage

* Button - self explanatory, it's a button. Constructed as: `Button btOK = new Button( "Ok" );`
* Scene - An object that conatains various nodes on the screen. Constructor is: `Scene( node, width, height )`
* Stage - a window object. The JVM automatically creates one called the **primary stage** when app is launched. To show the stage: `primaryStage.show();`
* Example using all the above concepts:  
```Java
import javafx.*; // This works but is not preferred

public class MyJavaFX extends Application {
  @Override
  public void start(Stage primaryStage) {
    Button btOK = new Button("OK");
    Scene scene = new Scene(btOK, 200, 250);
    primaryStage.setTitle("MyJavaFX"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }
  public static void main(String[] args) { 
    Application.launch(args); 
  }
}
```
* Layout is as such:  
![](layout.png)

## Panes

> Panes are use to hold nodes, nodes can be shapes, images views, UI controls, and other panes.

* The layout with a pane & nodes:  
![](pane.png)  

* You place nodes inside a pane and then places the plane into a cense ( like the above layout )
* Here is an example of using a pane:  
```Java
StackPane pane = new StackPane();
pane.getChildren().add( new BUTTON( "Ok" ));
Scene scene = new Scene( pane, 200, 500 ); // measured in pixels
```
* The x-coordinate increases from left to right and the y-coordinate increases downward in the Java coordinate system. For a visual explanation:  
![](cord.png)
