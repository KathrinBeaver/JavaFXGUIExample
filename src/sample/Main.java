package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.components.ElementsFlowPane;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("GUIMainForm");

        Pane root = new ElementsFlowPane();
        primaryStage.setScene(new Scene(root, 600, 550));

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
