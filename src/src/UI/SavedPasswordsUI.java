package UI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SavedPasswordsUI extends Application {
    @Override
    public void start(Stage primaryStage){
        Label title = new Label("Saved passwords");
        Scene scene = new Scene(title, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
