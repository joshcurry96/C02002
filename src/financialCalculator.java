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

	public double workingCapital(TextField wCA, TextField wCL){
		double assets = Double.parseDouble(wCA.getText());
		double liabilities = Double.parseDouble(wCL.getText());
		double result = assets - liabilities;
		return result;
		
	}
	
	public double currentRatio(TextField cRA, TextField cRL){
		double assets = Double.parseDouble(cRA.getText());
		double liabilites = Double.parseDouble(cRL.getText());
		double result = assets / liabilites; 
		return result;
	}
	
	public double debtToEquity(TextField dTED, TextField dTEE){
		double debt = Double.parseDouble(dTED.getText());
		double equity = Double.parseDouble(dTEE.getText());
		double result = debt / equity;
		return result;
	}
	
	public double grossProfitMargin(TextField gPMGP, TextField gPMR){
		double grossProfit = Double.parseDouble(gPMGP.getText());
		double revenue = Double.parseDouble(gPMR.getText());
		double result = grossProfit / revenue;
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
		
		TextField futureValueResult = new TextField();
		Button futureValue = new Button("Future Value");
		futureValue.setOnAction(event -> futureValueResult.setText(Double.toString(futureValue(initialInvestment, interestRate, timePeriod))));
		
		buttons.getChildren().addAll(futureValue, futureValueResult);
		
		VBox input2 = new VBox(20);
		input2.setAlignment(Pos.CENTER);
		Label label3 = new Label("Present Value");
		TextField futureValue2 = new TextField("Please enter the Future Value: ");
		
		TextField interestRate2 = new TextField("Please enter the interest rate in %");
		
		TextField timePeriod2 = new TextField("Please enter the time period");
		
		
		
		Label label4 = new Label("Press the button to perform the calculation");
		
		input2.getChildren().addAll(label3, futureValue2, interestRate2, timePeriod2, label4);
		
		HBox buttons2 = new HBox(10);
		buttons2.setAlignment(Pos.CENTER);
		TextField presentValueResult = new TextField();
		presentValue.setOnAction(event -> presentValueResult.setText(Double.toString(presentValue(futureValue2, interestRate2, timePeriod2))));
		buttons2.getChildren().addAll(presentValue, presentValueResult);
		
		
		Pane paneBack = new Pane();
		Button back = new Button("Back");
		paneBack.getChildren().add(back);
		back.setOnAction(event -> back.getScene().setRoot(content3()));

		VBox tab1 = new VBox(10);
		tab1.setPrefSize(500, 250);
		tab1.getChildren().addAll(input, buttons, input2,buttons2, paneBack);
		return tab1;
		
				
	}
	
	public Parent content2(){
		Label label = new Label("Working Capital Ratio");
		Label label2 = new Label("Current Ratio");
		Label label3 = new Label("Debt To Equity Ratio");
		Label label4 = new Label("Gross Profit Margin");
		
		TextField workingCapitalA = new TextField("Please enter the value of your Current Assets: ");
		TextField workingCapitalL = new TextField("Please enter the value of your Current Liabilities: ");
		TextField workingCapitalResult = new TextField();
		TextField currentRatioA = new TextField("Please enter the value of your Current Assets: ");
		TextField currentRatioL = new TextField("Please enter the value of your Current Liabilities: ");
		TextField currentRatioResult = new TextField();
		TextField debtToEquityD = new TextField("Please enter the value of your Total Debt: ");
		TextField debtToEquityE = new TextField("Please enter the value of your Total Equity: ");
		TextField debtToEquityResult = new TextField();
		TextField grossProfitMarginGP = new TextField("Please enter the value of your Gross Profit: ");
		TextField grossProfitMarginR = new TextField("Please enter the value of your Revenue: ");
		TextField grossProfitMarginResult = new TextField();
		
		
        Button currentRatio = new Button("Current Ratio");
		Button workingCapital = new Button("Working Capital Ratio");
		Button debtToEquity = new Button("Debt To Equity Ratio");
		Button grossProfitMargin = new Button("Gross Profit Margin");
		
		
		
		VBox vBox1 = new VBox(10);
		vBox1.setAlignment(Pos.CENTER);
		vBox1.getChildren().addAll(label,workingCapitalA,workingCapitalL);
		
		HBox hBox1 = new HBox(10);
		hBox1.setAlignment(Pos.CENTER);
		hBox1.getChildren().addAll(workingCapital, workingCapitalResult);
		workingCapital.setOnAction(event -> workingCapitalResult.setText(Double.toString(workingCapital(workingCapitalA, workingCapitalL))));
		
		VBox vBox2 = new VBox(10);
		vBox2.setAlignment(Pos.CENTER);
		vBox2.getChildren().addAll(label2, currentRatioA,currentRatioL);
		
		HBox hBox2 = new HBox(10);
		hBox2.setAlignment(Pos.CENTER);
		hBox2.getChildren().addAll(currentRatio, currentRatioResult);
		currentRatio.setOnAction(event -> currentRatioResult.setText(Double.toString(currentRatio(currentRatioA, currentRatioL))));
		
		VBox vBox3 = new VBox(10);
		vBox3.setAlignment(Pos.CENTER);
		vBox3.getChildren().addAll(label3, debtToEquityD, debtToEquityE);
		
		HBox hBox3 = new HBox(10);
		hBox3.setAlignment(Pos.CENTER);
		hBox3.getChildren().addAll(debtToEquity, debtToEquityResult);
		debtToEquity.setOnAction(event -> debtToEquityResult.setText(Double.toString(debtToEquity(debtToEquityD, debtToEquityE))));
		
		VBox vBox4 = new VBox(10);
		vBox4.setAlignment(Pos.CENTER);
		vBox4.getChildren().addAll(label4, grossProfitMarginGP, grossProfitMarginR);
		
		HBox hBox4 = new HBox(10);
		hBox4.setAlignment(Pos.CENTER);
		hBox4.getChildren().addAll(grossProfitMargin, grossProfitMarginResult);
		grossProfitMargin.setOnAction(event -> grossProfitMarginResult.setText(Double.toString(grossProfitMargin(grossProfitMarginGP, grossProfitMarginR))));
		
        Pane paneBack = new Pane();
		Button back = new Button("Back");
		paneBack.getChildren().add(back);
		back.setOnAction(event -> back.getScene().setRoot(content3()));
		
		VBox tab2 = new VBox(10);
		tab2.setPrefSize(500, 250);
		tab2.getChildren().addAll(vBox1,hBox1, vBox2, hBox2, vBox3,hBox3,vBox4,hBox4, paneBack);
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
