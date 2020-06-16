// (c) Travis Dowd
// (d) 6-16-2020
//
// Chapter 14, exercise 28

package Ex14_28;

import com.sun.istack.internal.NotNull;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import java.lang.Math;
import javafx.scene.Node;

public class test extends Application {
	//public static void main( String[] args ) {}
	@Override
	public void start( Stage primaryStage) {
		// Create clock
		Ex14_28.ClockPane clock = new Ex14_28.ClockPane();
		int x = ( int )( Math.random() * ( 12 - 1 ));
		int y = ( int )( Math.random() * ( 31 - 1 ));
		clock.setHour( x );
		clock.setMinute( y );
		clock.setHourHandVisible( true );
		clock.setMinuteHandVisible( true );
		clock.setSecondHandVisible( false );
		String timeString = clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond();
		Label lblTime = new Label( timeString );
		// Place clock and label in pane
		BorderPane pane = new BorderPane();
		pane.setCenter( clock );
		pane.setBottom( lblTime );
		BorderPane.setAlignment( lblTime, Pos.TOP_CENTER);
		// Create scene and place in stage
		Scene scene = new Scene( pane, 250, 250 );
		primaryStage.setTitle( "Clock" );
		primaryStage.setScene( scene );
		primaryStage.show();
	}
}
