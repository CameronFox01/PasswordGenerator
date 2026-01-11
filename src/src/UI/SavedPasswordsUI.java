package UI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.beans.EventHandler;

public class SavedPasswordsUI extends Application {
    @Override
    public void start(Stage primaryStage){
        Label title = new Label("Save a Password");

        VBox titleRow = new VBox(10);
        Label titleLabel = new Label("Title Password");
        TextField titleField= new TextField();
        titleRow.getChildren().addAll(titleLabel, titleField);

        VBox usernameRow = new VBox(10);
        Label usernameLabel = new Label("Username");
        TextField usernameField = new TextField();
        usernameRow.getChildren().addAll(usernameLabel, usernameField);

        VBox passwordRow = new VBox(10);
        Label passwordLabel = new Label("Password");
        TextField passwordField1 = new TextField();
        TextField passwordField2 = new TextField();
        passwordField2.setPromptText("Re-enter password");
        passwordRow.getChildren().addAll(passwordLabel, passwordField1, passwordField2);

        Button save = new Button("Save");
        save.setOnAction(e-> {
            System.out.println("Print");
        });

        VBox root = new VBox(10);
        root.getChildren().addAll(title, titleRow, usernameRow, passwordRow, save);

        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
