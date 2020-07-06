// (c) Travis Dowd
// (d) 7-6-2020
//
// Chapter 16, exercise 16-1

package Ex16_1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start( Stage primaryStage ) throws Exception {
        // ---------
        //   Panes
        // ---------
        BorderPane pane = new BorderPane();
        Pane textPane = new Pane();
        HBox top = new HBox();
        HBox btm = new HBox();
        top.setSpacing( 10 );
        btm.setSpacing( 10 );
        top.setAlignment( Pos.TOP_CENTER );
        btm.setAlignment( Pos.BOTTOM_CENTER );
        // Text
        Text text = new Text( 100, 100, "Programming is fun");
        textPane.getChildren().add( text );

        // -----------
        //   Buttons
        // -----------
        // Move text
        Button btLeft = new Button( "<=" );
        Button btRight = new Button( "=>" );
        // Change text color
        RadioButton rbRed = new RadioButton( "Red" );
        RadioButton rbYellow = new RadioButton( "Yellow" );
        RadioButton rbBlack = new RadioButton( "Black" );
        RadioButton rbOrange = new RadioButton( "Orange" );
        RadioButton rbGreen = new RadioButton( "Green" );
        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup( group );
        rbYellow.setToggleGroup( group );
        rbBlack.setToggleGroup( group );
        rbOrange.setToggleGroup( group );
        rbGreen.setToggleGroup( group );

        // -------------
        //   Listeners
        // -------------
        // Move text
        btLeft.setOnAction( e -> {
            if ( text.getX() >= 1 )
                text.setX( text.getX() - 10 );
        });
        btRight.setOnAction( e -> {
            if ( text.getX() < textPane.getWidth() - 120 )  // Not sure why this needs to be width - 120 ????
                text.setX( text.getX() + 10 );
        });
        // Change text color
        rbRed.setOnAction( e -> {
            if ( rbRed.isSelected() )
                text.setFill( Color.RED );
        });
        rbYellow.setOnAction( e -> {
            if ( rbYellow.isSelected() )
                text.setFill( Color.YELLOW );
        });
        rbBlack.setOnAction( e -> {
            if ( rbBlack.isSelected() )
                text.setFill( Color.BLACK );
        });
        rbOrange.setOnAction( e -> {
            if ( rbOrange.isSelected() )
                text.setFill( Color.ORANGE );
        });
        rbGreen.setOnAction( e -> {
            if ( rbGreen.isSelected() )
                text.setFill( Color.GREEN );
        });

        // -----------
        //    Init
        // -----------
        // Add stuff to pane
        pane.setTop( top );
        pane.setCenter( textPane );
        pane.setBottom( btm );
        top.getChildren().setAll( rbRed, rbYellow, rbBlack, rbOrange, rbGreen );
        btm.getChildren().setAll( btLeft, btRight );
        // Scene & Stage
        Scene scene = new Scene( pane, 400, 250 );
        primaryStage.setTitle( "Exercise 16-1" );
        primaryStage.setScene( scene );
        primaryStage.show();
    }

    public static void main( String[] args ) {
        launch( args );
    }
}