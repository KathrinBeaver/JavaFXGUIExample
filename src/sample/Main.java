package sample;


import sample.components.ElementsFlowPane;

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
