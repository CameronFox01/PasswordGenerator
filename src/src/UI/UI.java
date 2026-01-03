package UI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class UI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label hello = new Label("Hello World");
        Scene scene = new Scene(hello, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
