package Ed;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;

public class Ed extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        // Pane
        BorderPane pane = new BorderPane();
        TextArea input = new TextArea();
        TextArea lines = new TextArea();
        lines.setPrefColumnCount( 1 );
        lines.setEditable( false );

        pane.setCenter( input );
        pane.setLeft( lines );

        // Line Numbers
        input.getParagraphs().addListener((ListChangeListener) ov -> {
            String count = String.valueOf(input.getText().split("\n").length);
            lines.appendText( count + "\n"  );
        });

        // Stage
        Scene scene = new Scene( pane, 640, 480 );
        primaryStage.setTitle( "Ed" );
        primaryStage.setScene( scene );
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
