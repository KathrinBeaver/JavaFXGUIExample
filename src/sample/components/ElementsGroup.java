package sample.components;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ElementsGroup extends Group {

    public ElementsGroup() {
        fillContent();
    }

    private void fillContent() {
        for (int i = 0; i < 10; i++) {
            this.getChildren().add(new Label("Label " + (i +1)));
            this.getChildren().add(new Button("Button " + (i +1)));
        }
    }
}
