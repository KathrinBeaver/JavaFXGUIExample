package sample.components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

public class ElementsFlowPane extends FlowPane {

    protected final int SIZE = 10;

    public ElementsFlowPane() {
        fillContent();
    }

    private void fillContent() {
        Label resultLabel = new Label("кнопка не нажата. ");
        this.getChildren().add(resultLabel);

        EventHandler<ActionEvent> event = e -> resultLabel.setText("кнопка нажата! ");

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++){
                Button button = new Button("Button " + (i * SIZE + j + 1));
                this.getChildren().add(button);
                button.setOnAction(event);
            }
        }
    }
}
