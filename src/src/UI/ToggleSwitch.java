package UI;

// ToggleSwitch.java - Custom Toggle Switch Component
import javafx.animation.TranslateTransition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Cursor;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class ToggleSwitch extends Pane {
    private final BooleanProperty switchedOn = new SimpleBooleanProperty(false);
    private final TranslateTransition animation = new TranslateTransition(Duration.millis(200));
    private Rectangle background = null;
    private Circle trigger = null;

    public ToggleSwitch() {
        // Background track
        background = new Rectangle(50, 25);
        background.setArcWidth(25);
        background.setArcHeight(25);
        background.setFill(Color.LIGHTGRAY);

        // Circle that moves
        trigger = new Circle(12.5);
        trigger.setCenterX(12.5);
        trigger.setCenterY(12.5);
        trigger.setFill(Color.WHITE);
        trigger.setStroke(Color.LIGHTGRAY);

        getChildren().addAll(background, trigger);

        // Set up animation
        animation.setNode(trigger);

        // Click handler
        setOnMouseClicked(event -> switchedOn.set(!switchedOn.get()));

        // Listen for state changes
        switchedOn.addListener((obs, oldState, newState) -> {
            boolean isOn = newState;
            animation.setToX(isOn ? 25 : 0);
            animation.play();

            background.setFill(isOn ? Color.LIMEGREEN : Color.LIGHTGRAY);
        });

        // Hover effect
        setOnMouseEntered(e -> setCursor(Cursor.HAND));
        setOnMouseExited(e -> setCursor(Cursor.DEFAULT));
    }

    // Property accessor (so you can bind to it)
    public BooleanProperty switchedOnProperty() {
        return switchedOn;
    }

    public boolean isSwitchedOn() {
        return switchedOn.get();
    }

    public void setSwitchedOn(boolean value) {
        switchedOn.set(value);
    }
}
