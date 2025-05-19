package application;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FirstApp extends Application {

    private TextArea area1 = new TextArea(); //TextArea : 멀티라인-한 줄 이상의 글자를 입출력 할수있는 상자
    private TextArea area2 = new TextArea();

    @Override
    public void start(Stage primaryStage) {
        area1.setEditable(false);
        area2.setEditable(false);

        HBox root = new HBox(10, area1, area2);
        Scene scene = new Scene(root, 500, 400);

        primaryStage.setTitle("스레드 GUI 예제 🧵");
        primaryStage.setScene(scene);
        primaryStage.show();

        // 스레드 시작
        new MyThread("야옹이 😺", area1).start();
        new MyThread("멍멍이 🐶", area2).start();
    }

    // 내부 클래스: 스레드 정의
    class MyThread extends Thread {
        private final TextArea area;

        public MyThread(String name, TextArea area) {
            super(name);
            this.area = area;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 50; i++) {
                final String msg = getName() + " - " + i + "\n";
                try {
                    Thread.sleep(500); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // JavaFX UI 업데이트는 반드시 Platform.runLater로! 백그라운드에서 업데이트 할 시 많이 사용
                Platform.runLater(() -> area.appendText(msg)); //다중 스레드 일 경우
                //area.appendText(msg); //단일 스레드 일 경우 
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
