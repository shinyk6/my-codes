package application;

import javafx.application.Application;
import javafx.stage.Stage; //메인창
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloFX extends Application {
    @Override
    public void start(Stage stage) {
        stage.setScene(new Scene(new Button("Hello JavaFX 🎶"), 300, 100)); //Button : 자체 이벤트 있음
        stage.setTitle("JavaFX 테스트");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
