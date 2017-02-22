import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class financialCalculator extends Application{

	public double presentValue;
	public double futureValue;
	
	public double futureValue(TextField iT, TextField iR, TextField tP) {
		double investment = Double.parseDouble(iT.getText()); 
		double interestRate = Double.parseDouble(iR.getText());
		double timePeriod = Double.parseDouble(tP.getText());
		
		double power = Math.pow((1+interestRate), timePeriod);
		
		double result = investment * power;
		System.out.println(result);
		return result;
	}
	
	public double presentValue(TextField fv2, TextField ir2, TextField tp2){
		double futureValue = Double.parseDouble(fv2.getText()); 
		double interestRate = Double.parseDouble(ir2.getText());
		double timePeriod = Double.parseDouble(tp2.getText());
		
		double power = Math.pow((1+interestRate), timePeriod);
		
		double result = futureValue/power;
		System.out.println(result);
		return result;
	}
	
	
	public Parent content(){
		
		VBox input = new VBox(20);
		
		input.setAlignment(Pos.CENTER);
	
		Label label1 = new Label("Future value");
		
		TextField initialInvestment = new TextField();
		
		TextField interestRate = new TextField();
		
		TextField timePeriod = new TextField();
	
		Label label2 = new Label("Press the button to perform the calculation");
		
		input.getChildren().addAll(label1, initialInvestment, interestRate, timePeriod, label2);
		
		HBox buttons = new HBox(10);
		buttons.setAlignment(Pos.CENTER);
		
		Button presentValue = new Button("Present Value");
		
		
		Button futureValue = new Button("Future Value");
		futureValue.setOnAction(event -> futureValue(initialInvestment, interestRate, timePeriod));
		TextField futureValueResult = new TextField();
		buttons.getChildren().addAll(futureValue, futureValueResult);
		
		VBox input2 = new VBox(20);
		input2.setAlignment(Pos.CENTER);
		Label label3 = new Label("Present Value");
		TextField futureValue2 = new TextField("Please enter the Future Value: ");
		
		TextField interestRate2 = new TextField("Please enter the interest rate in %");
		
		TextField timePeriod2 = new TextField("Please enter the time period");
		
		presentValue.setOnAction(event -> presentValue(futureValue2, interestRate2, timePeriod2));
		
		Label label4 = new Label("Press the button to perform the calculation");
		
		input2.getChildren().addAll(label3, futureValue2, interestRate2, timePeriod2, label4);
		
		HBox buttons2 = new HBox(10);
		buttons2.setAlignment(Pos.CENTER);
		TextField presentValueResult = new TextField();
		buttons2.getChildren().addAll(presentValue, presentValueResult);
		
		
		Pane paneBack = new Pane();
		Button back = new Button("Back");
		paneBack.getChildren().add(back);
		back.setOnAction(event -> back.getScene().setRoot(content3()));

		VBox tab1 = new VBox(10);
		tab1.setPrefSize(500, 250);
		tab1.getChildren().addAll(input, buttons,input2,buttons2, paneBack);
		return tab1;
		
				
	}
	
	public Parent content2(){
		Label label = new Label("Financial ratios");
		VBox vBox1 = new VBox();
		vBox1.setAlignment(Pos.CENTER);
		vBox1.getChildren().add(label);
		
		Label label2 = new Label("Please choose the ratio you desire");
		
		
		VBox input = new VBox(20);
		input.setAlignment(Pos.CENTER);
		TextField ratio1 = new TextField("Enter number 1:");
		TextField ratio2 = new TextField("Enter number 2:");
		input.getChildren().addAll(ratio1, ratio2);
		
		VBox vBox2 = new VBox();
		vBox2.setAlignment(Pos.CENTER);
		vBox2.getChildren().add(label2);
		
		
		HBox buttons1 = new HBox(10);
		buttons1.setAlignment(Pos.CENTER);
		HBox buttons2 = new HBox(10);
		buttons2.setAlignment(Pos.CENTER);
		
		Button currentRatio = new Button("Current Ratio");
		
		Button workingCapital = new Button("Working Capital Ratio");
		
		Button debtToEquity = new Button("Debt To Equity Ratio");
		
		Button grossProfitMargin = new Button("Gross Profit Margin");
		
		buttons1.getChildren().addAll(currentRatio, workingCapital);
		buttons2.getChildren().addAll(debtToEquity, grossProfitMargin);
		
		VBox paneBack = new VBox();
	    paneBack.setAlignment(Pos.BOTTOM_LEFT);
		Button back = new Button("Back");
		paneBack.getChildren().add(back);
		back.setOnAction(event -> back.getScene().setRoot(content3()));
		
		VBox tab2 = new VBox(10);
		tab2.setPrefSize(500, 250);
		tab2.getChildren().addAll(vBox1,input, vBox2, buttons1, buttons2, paneBack);
		return tab2;
	}
	
	public Parent content3(){
		Button tab1 = new Button("Future/Present values");
		Button tab2 = new Button("Ratios");
		Label label = new Label("Please choose which calculations you would like to perform");
		
		Pane pane = new Pane();
		pane.setPrefSize(1000,800);
		pane.getChildren().addAll(label, tab1, tab2);
		tab1.setLayoutX(50);
		tab1.setLayoutY(100);
		tab2.setLayoutX(300);
		tab2.setLayoutY(100);
		label.setLayoutX(50);
		label.setLayoutY(30);
		
		tab1.setOnAction(event -> tab1.getScene().setRoot(content()));
		tab2.setOnAction(event -> tab2.getScene().setRoot(content2()));
		
		return pane;
	}
	
	public void start(Stage primaryStage) throws Exception {
		
		Scene scene1 = new Scene(content3());
	
		primaryStage.setTitle("Financial calculator");
		primaryStage.setScene(scene1);
		primaryStage.show();
	}
	public static void main(String[] args){
		launch(args);	
	}

}
