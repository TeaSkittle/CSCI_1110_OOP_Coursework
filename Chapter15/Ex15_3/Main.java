// (c) Travis Dowd
// (d) 6-24-2020
//
// Chapter 15, exercise 15

package Ex15_3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class Main extends Application {
    @Override
    public void start( Stage primaryStage ) throws Exception {

        // ----------------------
        //   Create the objects
        // ----------------------
        // Buttons
        HBox hbox = new HBox();
        hbox.setSpacing( 10 );
        hbox.setAlignment( Pos.BOTTOM_CENTER );
        Button btUp = new Button( "Up" );
        Button btDown = new Button( "Down" );
        Button btLeft = new Button( "Left" );
        Button btRight = new Button( "Right" );
        hbox.getChildren().setAll( btUp, btDown, btLeft, btRight );
        // Ball
        BallPane ball = new BallPane();
        BorderPane pane = new BorderPane();
        pane.setCenter( ball );
        pane.setBottom( hbox );

        // ------------------
        //   Move the ball
        // ------------------
        // Arrow Keys
        ball.setOnKeyPressed( e -> {
            switch ( e.getCode() ) {
                case UP: ball.moveUp(); break;
                case DOWN: ball.moveDown(); break;
                case LEFT: ball.moveLeft(); break;
                case RIGHT: ball.moveRight(); break;
                default:
            }
        });
        // Mouse buttons
        btUp.setOnAction( new EventHandler<ActionEvent>() {
            @Override public void handle( ActionEvent event ) { ball.moveUp(); }});
        btDown.setOnAction( new EventHandler<ActionEvent>()  {
            @Override public void handle( ActionEvent event ) { ball.moveDown(); }});
        btLeft.setOnAction( new EventHandler<ActionEvent>()  {
            @Override public void handle( ActionEvent event ) { ball.moveLeft(); }});
        btRight.setOnAction( new EventHandler<ActionEvent>() {
            @Override public void handle( ActionEvent event ) { ball.moveRight(); }});

        // ----------------
        //   Start scene
        // ----------------
        // Create scene and place in stage
        Scene scene = new Scene( pane, 250, 250 );
        primaryStage.setTitle( "Exercise 15" );
        primaryStage.setScene( scene );
        primaryStage.show();
        ball.requestFocus();
    }
    public static void main( String[] args ) {
        launch( args );
    }
}
