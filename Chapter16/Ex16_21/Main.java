// (c) Travis Dowd
// (d) 7-7-2020
//
// Chapter 16, exercise 16-21

package Ex16_21;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Main extends Application {
    // Text Field
    private TextField t = new TextField();
    int amount; // number of countdown cycles

    @Override
    public void start( Stage primaryStage ) throws Exception {
        // Create pane
        StackPane pane = new StackPane();
        t.setEditable( true );
        t.setFont(Font.font( "Verdana", 30 ));
        pane.getChildren().add( t );

        // Media
        Media media = new Media( "https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3" );
        MediaPlayer mediaPlayer = new MediaPlayer( media );

        // Animation for countdown
        Timeline timeline = new Timeline( new KeyFrame( Duration.millis( 1000 ), e -> { // animate every second
            if ( amount > 0 ) {
                amount--;
                t.setText(Integer.toString( amount ));
            } else {
                mediaPlayer.play();
            }
        }));

        // Enter key
        pane.setOnKeyPressed( new EventHandler<KeyEvent>() {
            @Override
            public void handle( KeyEvent event ) {
                KeyCode kc = event.getCode();
                if ( kc.equals( KeyCode.ENTER )) {
                    amount = Integer.valueOf( t.getText() );
                    timeline.setCycleCount( amount + 1 );
                    timeline.play();
                }
            }
        });

        // Init
        Scene scene = new Scene( pane, 200, 75 );
        primaryStage.setTitle( "Exercise 16-21" );
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main( String[] args ) {
        launch( args );
    }
}


