package UI;

import PasswordGeneration.CreateDictionary;
import PasswordGeneration.PasswordConfig;
import PasswordGeneration.PasswordGenerator;
import PasswordGeneration.WordDictionary;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * Tie this in without using anything from Main in the Password Generation.
 * This will allow me to have a terminal version and a UI version.
 */
public class UI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Initialize Dictionary
        String filePath = "src/resources/words_alpha.txt";
        WordDictionary dictionary = CreateDictionary.createWordDictionary(filePath);

        // Initialize Password Configuration
        PasswordConfig config = new PasswordConfig();

        // Title for Generate a Password Screen
        Label title = new Label("Generate a Password");
        title.setAlignment(Pos.TOP_CENTER);
        title.setStyle("-fx-font-size: 40px;");

        // Button to Generate a Password
        Button generateButton = new Button("Generate");
        generateButton.setStyle("-fx-font-size: 40px;");
        generateButton.setOnAction(e -> {

            PasswordGenerator generator = new PasswordGenerator(dictionary);
            String password = generator.generate(config);
            System.out.println(password);
        });

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.getChildren().addAll(title, generateButton);

        Scene scene = new Scene(root);
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
