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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * Tie this in without using anything from Main in the Password Generation.
 * This will allow me to have a terminal version and a UI version.
 */
public class PasswordGeneratorUI extends Application {

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

        // Create toggle switches for password options
        HBox numbersRow = new HBox(10);
        Label numbersLabel = new Label("Include Numbers:");
        ToggleSwitch numbersToggle = new ToggleSwitch();
        numbersToggle.setSwitchedOn(true);
        numbersRow.getChildren().addAll(numbersLabel, numbersToggle);

        HBox specialCharsRow = new HBox(10);
        Label specialCharsLabel = new Label("Include Special Characters:");
        ToggleSwitch specialCharsToggle = new ToggleSwitch();
        specialCharsToggle.setSwitchedOn(true);
        specialCharsRow.getChildren().addAll(specialCharsLabel, specialCharsToggle);

        HBox leetSpeakRow = new HBox(10);
        Label leetSpeakLabel = new Label("Use Leet Speak:");
        ToggleSwitch leetSpeakToggle = new ToggleSwitch();
        leetSpeakRow.getChildren().addAll(leetSpeakLabel, leetSpeakToggle);

        HBox capitalRow = new HBox(10);
        Label capitalLabel = new Label("Use Capital Letters:");
        ToggleSwitch capitalToggle = new ToggleSwitch();
        capitalToggle.setSwitchedOn(true);
        capitalRow.getChildren().addAll(capitalLabel, capitalToggle);

        HBox pinRow = new HBox(10);
        Label pinLabel = new Label("Create a Pin:");
        ToggleSwitch pinToggle = new ToggleSwitch();
        pinToggle.setSwitchedOn(false);
        pinRow.getChildren().addAll(pinLabel, pinToggle);

        // Listen for PIN toggle changes
        pinToggle.switchedOnProperty().addListener((obs, oldVal, newVal) -> {
            boolean isPinMode = newVal;

            if (isPinMode) {
                // Disable and turn off other toggles when PIN mode is on
                numbersToggle.setSwitchedOn(false);
                numbersToggle.setDisable(true);

                specialCharsToggle.setSwitchedOn(false);
                specialCharsToggle.setDisable(true);

                leetSpeakToggle.setSwitchedOn(false);
                leetSpeakToggle.setDisable(true);

                capitalToggle.setSwitchedOn(false);
                capitalToggle.setDisable(true);
            } else {
                // Re-enable toggles when PIN mode is off
                numbersToggle.setDisable(false);
                specialCharsToggle.setDisable(false);
                leetSpeakToggle.setDisable(false);
                capitalToggle.setDisable(false);
            }
        });

        //Vbox for all the toggles to live in
        VBox toggleVBox = new VBox(10);
        toggleVBox.setAlignment(Pos.CENTER);
        toggleVBox.getChildren().addAll(numbersRow, specialCharsRow, leetSpeakRow, capitalRow, pinRow);

        // Button to Generate a Password
        Button generateButton = new Button("Generate");
        generateButton.setStyle("-fx-font-size: 40px;");
        generateButton.setOnAction(e -> {

            PasswordGenerator generator = new PasswordGenerator(dictionary);
            config.setIncludeNumbers(numbersToggle.isSwitchedOn());
            config.setIncludeSpecialChars(specialCharsToggle.isSwitchedOn());
            config.setLettersToNumbers(leetSpeakToggle.isSwitchedOn());
            config.setMakePinPassword(pinToggle.isSwitchedOn());
            boolean createPin = pinToggle.isSwitchedOn();
            String password;
            if (createPin) {
                password = generator.pinGenerate(config);
            } else {
                password = generator.generate(config);
            }
            System.out.println(password);
        });

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.getChildren().addAll(title, toggleVBox, generateButton);

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
