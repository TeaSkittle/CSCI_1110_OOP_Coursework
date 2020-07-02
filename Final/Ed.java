// (c) Travis Dowd
// (d) 7-1-2020
//
// A simple text editor
//
// TODO: - add file chooser
//       - Add emacs style binds
//

package Ed;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;

public class Ed extends Application {
    @Override
    public void start( Stage primaryStage ) throws Exception{
        // Pane
        BorderPane pane = new BorderPane();

        // Text input
        TextArea input = new TextArea();

        // Mode line
        // Want to show file name, read & write permissions, and maybe line info
        // Also have ability to input commands
        TextArea mode = new TextArea( "mode line" );
        mode.setPrefRowCount( 1 );
        mode.setEditable( false );

        // Init
        pane.setCenter( input );
        pane.setBottom( mode );
        Scene scene = new Scene( pane, 640, 480 );
        primaryStage.setTitle( "Ed" );
        primaryStage.setScene( scene );
        primaryStage.show();
    }

    public static void main( String[] args ) {
        launch( args );
    }
}
