package application;

import javafx.application.Application;
import javafx.stage.Stage; //메인창
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloFX01 extends Application {
    
	
	private Button createButton() {
		Button bt = new Button("Hello JavaFX 🎶");
		return bt;
	}
	
	
	@Override
    public void start(Stage stage) {
		Button bt = createButton(); //리턴받은 bt값을 bt가 참조
        stage.setScene(new Scene(bt, 300, 100)); //Button : 자체 이벤트 있음
        stage.setTitle("JavaFX 테스트");
        stage.show();
    }
    
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
