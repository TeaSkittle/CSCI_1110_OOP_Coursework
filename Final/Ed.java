// (c) Travis Dowd
// (d) 7-1-2020
//
// A simple text editor
//
// TODO: - Add search feature using modeline to search
//         - https://stackoverflow.com/a/42797402
//       - Use mode.getText() to get input when switching to mode line( can be used for search above )

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
import javafx.scene.control.TextField;
import java.io.*;
import java.util.Scanner;

public class Ed extends Application {
    // -------------
    //   Variables
    // -------------
    // System
    private File file;
    private String os = System.getProperty( "os.name" ); // May not be needed
    private String dir = System.getProperty( "user.dir" );
    private String filePath;
	// JavaFX
    TextArea input = new TextArea();
    // Key combinations
    public KeyCombination ctrlX = new KeyCodeCombination( KeyCode.X, KeyCombination.CONTROL_DOWN );
    public KeyCombination ctrlO = new KeyCodeCombination( KeyCode.O, KeyCombination.CONTROL_DOWN );
    public KeyCombination ctrlS = new KeyCodeCombination( KeyCode.S, KeyCombination.CONTROL_DOWN );
    public KeyCombination ctrlF = new KeyCodeCombination( KeyCode.F, KeyCombination.CONTROL_DOWN );
    public KeyCombination ctrlB = new KeyCodeCombination( KeyCode.B, KeyCombination.CONTROL_DOWN );

    @Override
    public void start( Stage primaryStage ) throws Exception {
        // ---------
        //   Input
        //----------
        input.setEditable( true );
        
        // ------------
        //  Mode Line
        // ------------
        TextField mode = new TextField();
        mode.getStyleClass().add("mode");
        mode.setEditable( true );
        
        // ----------
        //    Init
        // ----------
        BorderPane pane = new BorderPane();
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
                if ( ctrlX.match( event )) {
					mode.clear();
                    mode.requestFocus();
                    mode.clear();
                }  // Open file
                if ( ctrlO.match( event )) {
                    FileChooser openFileChooser = new FileChooser();
                    openFileChooser.setInitialDirectory( new File( dir ));
                    file = openFileChooser.showOpenDialog( primaryStage );
                    input.clear();
                    if ( file != null ){
                        filePath = file.getAbsolutePath();
		                Stage primaryStage = ( Stage ) pane.getScene().getWindow();
                        writeToInput();
                    }
                }  // Save file
                if ( ctrlS.match( event )) {
                    FileChooser saveFileChooser = new FileChooser();
                    saveFileChooser.setInitialDirectory( new File( dir ));
                    file = saveFileChooser.showSaveDialog( primaryStage );
                    try {
			            filePath = file.getAbsolutePath();
			            Stage primaryStage = ( Stage ) pane.getScene().getWindow();
			            BufferedWriter writer = new BufferedWriter( new FileWriter( file ));
			            PrintWriter output = new PrintWriter( writer );
			            output.write( input.getText() );
			            output.flush();
			            output.close();
		            } catch ( IOException e ) {
			            System.out.println( "[-]Error: " + file.getName() );
                    }
		        } // Move Forward
                if ( ctrlF.match( event )) {
                    input.positionCaret( input.getCaretPosition() + 1 );
                } // Move Backwards
                if ( ctrlB.match( event )) {
                    input.positionCaret( input.getCaretPosition() - 1 );
                } else {
                    mode.clear();
                    //mode.appendText( "Pos: " + String.valueOf( input.getCaretPosition() ));
                }
            }
        });
        // Mode Line
        mode.setOnKeyPressed( new EventHandler<KeyEvent>() {
            @Override
            public void handle( KeyEvent event ) {
                KeyCode kc = event.getCode();
                if ( ctrlX.match( event )) {
                    mode.clear();
					input.requestFocus();
                    //mode.appendText( "Pos: " + String.valueOf( input.getCaretPosition() ));
                } if ( kc.equals( KeyCode.ENTER )) {
                    String cmd = mode.getText();
                    mode.clear();
                    // Do something with a shell class like:
                    // Shell( cmd );
                }
            }
        });
    }
    
    // -----------------
    //   Write to file
    // -----------------
    public void writeToInput() {
		try {
			Scanner reader = new Scanner( file );
			while ( reader.hasNextLine() ) {
				String current = reader.nextLine();
				input.appendText( current + "\n" );
			}
			reader.close();
		} catch ( FileNotFoundException e ) {
			System.out.println( "Could not read file: " + file.getName() );
		}
	}

    // Main
    public static void main( String[] args ) {
        launch( args );
    }
}

