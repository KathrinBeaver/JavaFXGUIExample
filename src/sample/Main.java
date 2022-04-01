package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.components.ElementsFlowPane;
import sample.components.ElementsGridPane;
import sample.components.ElementsGroup;
import sample.components.FiguresGroup;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("GUIMainForm");

        Label helloWorldLabel = new Label("Label on custom scene!");
        helloWorldLabel.setAlignment(Pos.CENTER);
        Group root = new ElementsFlowPane();
        primaryStage.setScene(new Scene(root, 300, 275));

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
