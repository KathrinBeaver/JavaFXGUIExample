package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.components.ElementsFlowPane;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("GUIMainForm");

//        Label helloWorldLabel = new Label("Label on custom scene!");
//        helloWorldLabel.setAlignment(Pos.CENTER);
//        Scene primaryScene = new Scene(helloWorldLabel);
//        primaryStage.setScene(primaryScene);

//        Group root = new FiguresGroup();
//        Group root = new ElementsGroup();
//        Pane root = new ElementsGridPane();
        Pane root = new ElementsFlowPane();
        primaryStage.setScene(new Scene(root, 300, 275));

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
