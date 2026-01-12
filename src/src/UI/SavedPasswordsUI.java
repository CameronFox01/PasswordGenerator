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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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
            // TODO: I doubt this is how I want to do this for the finish project.
            //  Probably want to code it to be a map data structure so searching is
            //  is easy. This works for mean time testing.
            // Defining the file name of the file
            Path fileName = Path.of("src/src/SavedPasswords.txt");

            //Grabbing information to write.
            StringBuilder text = new StringBuilder();
            text.append("\n" + titleField.getText() + "\n");
            text.append(usernameField.getText() + "\n");
            text.append(passwordField1.getText() + "\n");

            try {
                Files.writeString(fileName, text);

                // Reading the content of the file
                String fileContent = Files.readString(fileName);

                // Printing the content inside the file
                System.out.println(fileContent);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
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
