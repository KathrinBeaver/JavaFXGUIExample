package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.components.ElementsFlowPane;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
//            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Parent root = FXMLLoader.load(getClass().getResource("sample2.fxml"));
            primaryStage.setScene(new Scene(root, 300, 275));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        primaryStage.setTitle("GUIMainForm");

//        Label helloWorldLabel = new Label("Label on custom scene!");
//        helloWorldLabel.setAlignment(Pos.CENTER);
//        Scene primaryScene = new Scene(helloWorldLabel);
//        primaryStage.setScene(primaryScene);

//        Group root = new FiguresGroup();
//        Group root = new ElementsGroup();
//        Pane root = new ElementsGridPane();
//        Pane root = new ElementsFlowPane();

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
