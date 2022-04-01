package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.components.ElementsFlowPane;
import sample.components.ElementsGridPane;
import sample.components.ElementsGroup;
import sample.components.FiguresGroup;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("GUIMainForm");

        Label helloWorldLabel = new Label("Label on custom scene!");
        helloWorldLabel.setAlignment(Pos.CENTER);
        Scene primaryScene = new Scene(helloWorldLabel);
        primaryStage.setScene(primaryScene);

        Group root0 = new FiguresGroup();
        Group root1 = new ElementsGroup();
        Pane root2 = new ElementsGridPane();
        Pane root3 = new ElementsFlowPane();
        primaryStage.setScene(new Scene(root2, 300, 275));

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
