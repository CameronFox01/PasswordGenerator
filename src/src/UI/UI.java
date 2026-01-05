package UI;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class UI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label hello = new Label("Hello World");
        Scene scene = new Scene(hello);
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();

        // Code for full screen
        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());

        // Basic Code to Show the window
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
