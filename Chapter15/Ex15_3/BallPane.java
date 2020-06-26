// (c) Travis Dowd
// (d) 6-24-2020
//
// Chapter 15, exercise 15

package Ex15_3;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class BallPane extends Pane {
    public final double radius = 25;
    Circle circle = new Circle( 125, 125, radius );
    public BallPane() { getChildren().add( circle ); }
    public double getRadius(){ return this.radius; }
    public double getX() { return circle.getCenterX(); }
    public double getY() { return circle.getCenterY(); }
    public void setX( double x ) { circle.setCenterX( x ); }
    public void setY( double y ) { circle.setCenterY( y ); }
    // Move ball
    public void moveLeft() {
        if ( getX() > getRadius() || getX() > getWidth() - getRadius() ) {
            setX( getX() - 5 );
        }
    }
    public void moveRight() {
        if( getX() < getRadius() || getX() < getWidth() - getRadius() ) {
            setX( getX() + 5 );
        }
    }
    public void moveUp() {
        if ( getY() > getRadius() || getY() > getHeight() - getRadius() ) {
            setY( getY() - 5 );
        }
    }
    public void moveDown() {
        if ( getY() < getRadius() || getY() < getHeight() - getRadius() ) {
            setY( getY() + 5 );
        }
    }
}
