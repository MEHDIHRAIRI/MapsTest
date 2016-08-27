package map;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    private Scene scene;
    static Browser browser;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Web View");
        browser = new Browser();
        scene = new Scene(browser, 750, 500, Color.web("#666970"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}