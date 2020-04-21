import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Hello world!
 */
public class Launcher extends Application
{
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Title of the window");
 
        Button button = new Button();
        button.setText("Quitter");
 
        StackPane layout = new StackPane();
        layout.getChildren().add(button);
 
        Scene scene = new Scene(layout, 300,255);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
