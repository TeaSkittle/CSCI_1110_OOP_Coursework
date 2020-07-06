// (c) Travis Dowd
// (d) 7-1-2020
//
// A simple text editor
//
// TODO: - Add OS detection ( for opening & saving files )
//

package Final;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import java.io.File;

public class Ed extends Application {
    // Variables
    public File file;
    
    // Key combinations
    public KeyCombination altX = new KeyCodeCombination( KeyCode.X, KeyCombination.ALT_DOWN );
    public KeyCombination ctrlO = new KeyCodeCombination( KeyCode.O, KeyCombination.CONTROL_DOWN );
    public KeyCombination ctrlX = new KeyCodeCombination( KeyCode.X, KeyCombination.CONTROL_DOWN );
    public KeyCombination ctrlF = new KeyCodeCombination( KeyCode.F, KeyCombination.CONTROL_DOWN );
    public KeyCombination ctrlB = new KeyCodeCombination( KeyCode.B, KeyCombination.CONTROL_DOWN );

    @Override
    public void start( Stage primaryStage ) throws Exception{
        // Panes
        BorderPane pane = new BorderPane();
        // Areas
        TextArea input = new TextArea();
        TextArea mode = new TextArea( "Pos: ");
        // ------------
        //  Mode Line
        // ------------
        mode.setPrefRowCount( 1 );
        mode.setEditable( true );
        // ----------
        //    Init
        // ----------
        pane.setCenter( input );
        pane.setBottom( mode );
        Scene scene = new Scene( pane, 640, 480 );
        scene.getStylesheets().add( getClass().getResource( "style.css" ).toExternalForm());
        primaryStage.setTitle( "Ed" );
        primaryStage.setScene( scene );
        primaryStage.show();
        input.requestFocus();
        // ------------
        //   Controls
        // ------------
        // Input
        input.setOnKeyPressed( new EventHandler<KeyEvent>() {
            @Override
            public void handle( KeyEvent event ) {
                // Switch to mode line
                if ( altX.match( event )) {
                    mode.requestFocus();
                    mode.clear();
                }  // Open file
                if ( ctrlO.match( event )) {
                    FileChooser openFileChooser = new FileChooser();
                    openFileChooser.setInitialDirectory( new File( "/Users/Student" ));
                    file = openFileChooser.showOpenDialog(primaryStage);
                }  // Save file
                if ( ctrlX.match( event )) {
                    FileChooser saveFileChooser = new FileChooser();
                    saveFileChooser.setInitialDirectory( new File( "/Users/Student" ));
                    file = saveFileChooser.showSaveDialog( primaryStage );
                } // Move Forward
                if ( ctrlF.match( event )) {
                    input.positionCaret( input.getCaretPosition() + 1 );
                } // Move Backwards
                if ( ctrlB.match( event )) {
                    input.positionCaret( input.getCaretPosition() - 1 );
                } else {
                    mode.clear();
                    mode.appendText( "Pos: " + String.valueOf( input.getCaretPosition() ));
                }
            }
        });
        // Mode Line
        mode.setOnKeyPressed( new EventHandler<KeyEvent>() {
            @Override
            public void handle( KeyEvent event ) {
                if ( altX.match( event )) {
                    input.requestFocus();
                    mode.clear();
                    mode.appendText( "Pos: " + String.valueOf( input.getCaretPosition() ))
                }
            }
        });
    }

    public static void main( String[] args ) {
        launch( args );
    }
}

