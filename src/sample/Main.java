package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.components.ElementsGroup;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("GUIMainForm");

        Group root = new ElementsGroup();
        primaryStage.setScene(new Scene(root, 300, 275));

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
