package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage; //메인창
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

// 이름, 주소, 전화번호를 받아서 버튼을 클릭하면 입력한 내용을 출력해보자.
public class HelloFX02 extends Application {
    

	
	
	@Override
    public void start(Stage stage) {
		///UI 구성 요소
		Label lb_name = new Label("이름 : ");
		TextField tx_name = new TextField();
		
		Label lb_addr = new Label("주소 : ");
		TextField tx_addr = new TextField();	
		
		Label lb_phone = new Label("전화번호 : ");
		TextField tx_phone = new TextField();	
		
		
		Button bt = new Button("확인");
		Button bt_cancle = new Button("취소");
		
		Label res_message = new Label(); //출력할 내용 결과
		
		//버튼을 클릭 했을 때 이벤트 발생 코드를 작성하자.
		bt_cancle.setOnAction(e->{
			tx_name.setText(""); //null값 
			tx_addr.setText("");
			tx_phone.setText("");
			res_message.setText("");
		});
		// handle(T event)
		bt.setOnAction(e->{  // 버튼 이벤트는 on시리즈 EventHandler는  functional 인터페이스라서 람다 사용 가능
			// 명령 수행 코드
			
			String res_name = tx_name.getText(); //라벨에 있는 값 가져오기
			String res_addr = tx_addr.getText();
			String res_phone = tx_phone.getText();
			
			String format_res = String.format("입력한 내용 \n 이름 : %10s 주소 : %10s 전화번호 : %10s \n", res_name, res_addr, res_phone);
			
			res_message.setText(format_res); //출력한 결과 라벨에 값 주기
			
		});   
		//레이아웃 구성
		VBox root = new VBox();
		root.getChildren().addAll(
				lb_name, tx_name, 
				lb_addr, tx_addr,
				lb_phone, tx_phone,
				bt, bt_cancle, res_message
				);
		
        root.setSpacing( 10.0d );
        root.setAlignment(Pos.CENTER );
        root.setPadding( new Insets(40) );
		
		
        stage.setScene(new Scene(root, 500, 500)); //Button : 자체 이벤트 있음
        stage.setTitle("JavaFX 테스트");
        stage.show();
    }
    

    
    public static void main(String[] args) {
        launch(args);
    }
}
