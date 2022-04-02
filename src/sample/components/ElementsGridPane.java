package sample.components;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class ElementsGridPane extends GridPane {

    protected final int SIZE = 5;

    public ElementsGridPane() {
        fillContent();
    }

    private void fillContent() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++){
                this.add(new Button("Button " + (i * SIZE + j + 1)), i, j);
            }
        }
    }

}
