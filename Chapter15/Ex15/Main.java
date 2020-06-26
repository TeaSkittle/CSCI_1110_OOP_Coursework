// (c) Travis Dowd
// (d) 6-26-2020
//
// Chapter 15, animation exercise

package Ex15;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;
import javafx.animation.FadeTransition;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane pane = new Pane();

        // Rectangle
        Rectangle rectangle = new Rectangle(0,0,50,100);
        rectangle.setFill(Color.BLACK);

        // Pentagon
        Polygon pentagon = new Polygon();
        pentagon.getPoints().addAll( new Double[]{
                250.0, 50.0,
                375.0, 150.0,
                325.0, 275.0,
                175.0, 275.0,
                125.0, 150.0,
        });
        pentagon.setFill( Color.GRAY);

        // Add stuff to pane
        pane.getChildren().add( pentagon );
        pane.getChildren().add( rectangle );

        // PathTransition
        PathTransition pt = new PathTransition();
        pt.setDuration( Duration.millis( 10000 ));
        pt.setPath( pentagon );
        pt.setNode( rectangle );
        pt.setOrientation( PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT );
        pt.setCycleCount( Timeline.INDEFINITE );
        pt.play();

        // FadeTransition
        FadeTransition ft = new FadeTransition( Duration.millis( 5000 ), rectangle );
        ft.setFromValue( 1 );
        ft.setToValue( 0 );
        ft.setCycleCount( Timeline.INDEFINITE );
        ft.setAutoReverse( true );
        ft.play();

        // Mouse action
        final int[] clicks = { 0 };
        pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle( MouseEvent e ) {
                if ( clicks[ 0 ] == 0 ) {
                    pt.pause();
                    ft.pause();
                    clicks[ 0 ]++;
                } else if ( clicks[0] != 0 ){
                    pt.play();
                    ft.play();
                    clicks[ 0 ]--;
                }
            }
        });

        // Scene
        Scene scene = new Scene( pane, 500, 350 );
        primaryStage.setTitle( "Exercise 15" );
        primaryStage.setScene( scene );
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch( args );
    }
}
