

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class financialCalculator extends Application{
	
	public double futureValueCompound(TextField iT, TextField iR, TextField tP) {
		double investment = Double.parseDouble(iT.getText()); 
		double interest = Double.parseDouble(iR.getText()) / 100;
		System.out.println(interest);
		double timePeriod = Double.parseDouble(tP.getText());
		
		double interestRate = 1 + interest;
		
		double power = Math.pow(interestRate, timePeriod);
		
		double result = investment * power;
		System.out.println(result);
		result = Math.round(result*100)/100.0d;
		return result;

	}
	
	public double futureValueAnnual(TextField iT, TextField iR, TextField tP){
		double investment = Double.parseDouble(iT.getText()); 
		double interest = Double.parseDouble(iR.getText()) / 100;
		System.out.println(interest);
		double timePeriod = Double.parseDouble(tP.getText());
		
		double brackets = 1 + (interest * timePeriod);
		
		double result = investment * brackets;
		System.out.println(result);
		result = Math.round(result*100)/100.0d;
		return result;

	}
	
	public double presentValueCompound(TextField fv2, TextField ir2, TextField tp2){

		double futureValue = Double.parseDouble(fv2.getText()); 
		double interestRate = Double.parseDouble(ir2.getText()) / 100;
		double timePeriod = Double.parseDouble(tp2.getText());
		
		double power = Math.pow((1+interestRate), timePeriod);
		
		double result = futureValue/power;
		System.out.println(result);
		result = Math.round(result*100)/100.0d;
		return result;
	}
	
	public double presentValueAnnual(TextField fv2, TextField ir2, TextField tp2){

		double futureValue = Double.parseDouble(fv2.getText()); 
		double interestRate = Double.parseDouble(ir2.getText()) / 100;
		double timePeriod = Double.parseDouble(tp2.getText());
		
		double brackets = 1 + (interestRate * timePeriod);
		
		double result = futureValue/brackets;
		System.out.println(result);
		result = Math.round(result*100)/100.0d;
		return result;
	}

	public double workingCapital(TextField wCA, TextField wCL){
		double assets = Double.parseDouble(wCA.getText());
		double liabilities = Double.parseDouble(wCL.getText());
		double result = assets - liabilities;
		System.out.println(result);
		result = Math.round(result*100)/100.0d;
		return result;
		
	}
	
	public double currentRatio(TextField cRA, TextField cRL){
		double assets = Double.parseDouble(cRA.getText());
		double liabilites = Double.parseDouble(cRL.getText());
		double result = assets / liabilites; 
		System.out.println(result);
		result = Math.round(result*100)/100.0d;
		return result;
	}
	
	public double debtToEquity(TextField dTED, TextField dTEE){
		double debt = Double.parseDouble(dTED.getText());
		double equity = Double.parseDouble(dTEE.getText());
		double result = debt / equity;
		System.out.println(result);
		result = Math.round(result*100)/100.0d;
		return result;
	}
	
	public double grossProfitMargin(TextField gPMGP, TextField gPMR){
		double grossProfit = Double.parseDouble(gPMGP.getText());
		double revenue = Double.parseDouble(gPMR.getText());
		double result = grossProfit / revenue;
		System.out.println(result);
		result = Math.round(result*100)/100.0d;
		return result;
	}
	
	public void clear(TextField iI, TextField iR, TextField tP, TextField FVR, TextField PVR){
		iI.clear();
		iR.clear();
		tP.clear();
		FVR.clear();
		PVR.clear();
	}
	
	public void clear2(TextField TF1, TextField TF2, TextField TF3){
		TF1.clear();
		TF2.clear();
		TF3.clear();
	}
	
	public Parent content(){
		
		VBox input = new VBox(20);
		input.setAlignment(Pos.CENTER);
		Label label1 = new Label("Future/Present value");
		TextField initialInvestment = new TextField("Please enter the Present Value or Future Value: ");
		initialInvestment.textProperty().addListener(new ChangeListener<String>(){
			@Override
			 public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
	            if (!newValue.matches("\\d*")) {
	                initialInvestment.setText(newValue.replaceAll("[^\\d]", ""));
	            }
			}
		});
		TextField interestRate = new TextField("Please enter the interest rate in %: ");
		interestRate.textProperty().addListener(new ChangeListener<String>(){
			@Override
			 public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
	            if (!newValue.matches("\\d*")) {
	                interestRate.setText(newValue.replaceAll("[^\\d]", ""));
	            }
			}
		});
		
		TextField timePeriod = new TextField("Please enter the time period in years: ");
		timePeriod.textProperty().addListener(new ChangeListener<String>(){
			@Override
			 public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
	            if (!newValue.matches("\\d*")) {
	                timePeriod.setText(newValue.replaceAll("[^\\d]", ""));
	            }
			}
		});
		Label label2 = new Label("Please choose the formulae as well as the type of interest you wish to use.");
		input.getChildren().addAll( label1, initialInvestment, interestRate, timePeriod, label2);
		
		HBox buttons = new HBox(10);
		buttons.setAlignment(Pos.CENTER);
		TextField futureValueResult = new TextField();
		futureValueResult.setEditable(false);
		Label labelFuture = new Label("Future value: ");
		Button annualInterest = new Button("Annual interest");
		Button compoundInterest = new Button("Compound interest");
		compoundInterest.setOnAction(event -> futureValueResult.setText(Double.toString(futureValueCompound(initialInvestment, interestRate, timePeriod))));
		annualInterest.setOnAction(event -> futureValueResult.setText(Double.toString(futureValueAnnual(initialInvestment, interestRate, timePeriod))));
		buttons.getChildren().addAll(labelFuture, annualInterest, compoundInterest, futureValueResult);
		
		
		HBox buttons2 = new HBox(10);
		buttons2.setAlignment(Pos.CENTER);
		Label labelPresent = new Label("Present value: ");
		Button presentCompound = new Button("Compound Interest");
		Button presentAnnual = new Button("Annual Interest");
		TextField presentValueResult = new TextField();
		presentValueResult.setEditable(false);
		presentCompound.setOnAction(event -> presentValueResult.setText(Double.toString(presentValueCompound(initialInvestment, interestRate, timePeriod))));
		presentAnnual.setOnAction(event -> presentValueResult.setText(Double.toString(presentValueAnnual(initialInvestment, interestRate, timePeriod))));
		buttons2.getChildren().addAll(labelPresent, presentAnnual, presentCompound, presentValueResult);
		
		
		HBox clearBack = new HBox();
		clearBack.setAlignment(Pos.BOTTOM_LEFT);
		Button back = new Button("Back");
		Button clear = new Button("Clear");
		clearBack.getChildren().addAll(back,clear);
		back.setOnAction(event -> back.getScene().setRoot(content3()));
		clear.setOnAction(event -> clear(initialInvestment, interestRate, timePeriod, futureValueResult, presentValueResult));
		
		VBox tab1 = new VBox(10);
		tab1.getChildren().addAll(input, buttons,buttons2, clearBack);
		return tab1;
	}
	
	public Parent content2(){
	
		VBox vBox = new VBox(10);
		vBox.setAlignment(Pos.TOP_CENTER);
		Label label = new Label("Please choose the ratio you wish to calculate: ");
		final ComboBox<String> ratioComboBox = new ComboBox<String>();
		ratioComboBox.getItems().addAll(
				"Working Capital Ratio",
				"Current Ratio",
				"Debt To Equity",
				"Gross Profit Margin"
				);
		ratioComboBox.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent e) {
				String output = ratioComboBox.getValue();
				if(output == "Working Capital Ratio"){
				ratioComboBox.getScene().setRoot(content4());
				}
				if(output == "Current Ratio"){
				ratioComboBox.getScene().setRoot(content5());
				}
				if(output == "Debt To Equity"){
				ratioComboBox.getScene().setRoot(content6());
				}
				if(output == "Gross Profit Margin"){
				ratioComboBox.getScene().setRoot(content7());
				}
			}
		});
	    Button back = new Button("Back");
	    back.setAlignment(Pos.BOTTOM_LEFT);
	    back.setOnAction(event -> back.getScene().setRoot(content3()));
		vBox.getChildren().addAll(label, ratioComboBox, back);
		return vBox;
		
	}

	public Parent content3(){
		Button tab1 = new Button("Future/Present values");
		Button tab2 = new Button("Ratios");
		Label label = new Label("Please choose which calculations you would like to perform");
		
		VBox vBox = new VBox(20);
		vBox.setAlignment(Pos.TOP_CENTER);
		vBox.getChildren().addAll(label,tab1,tab2);
		
		
		
		tab1.setOnAction(event -> tab1.getScene().setRoot(content()));
		tab2.setOnAction(event -> tab2.getScene().setRoot(content2()));
		
		VBox vBox2 = new VBox();
		vBox2.setPrefHeight(300);
		vBox2.setPrefWidth(500);
		vBox2.setAlignment(Pos.TOP_CENTER);
		vBox2.getChildren().add(vBox);
		
		return vBox2;
	}
	
	public Parent content4(){
		Label label = new Label("Working Capital Ratio");
		TextField workingCapitalA = new TextField("Please enter the value of your Current Assets: ");
		TextField workingCapitalL = new TextField("Please enter the value of your Current Liabilities: ");
		TextField workingCapitalResult = new TextField();
		Button workingCapital = new Button("Working Capital Ratio");
		workingCapitalResult.setEditable(false);
		
		VBox vBox1 = new VBox(10);
		vBox1.setAlignment(Pos.CENTER);
		vBox1.getChildren().addAll(label,workingCapitalA,workingCapitalL);
		
		HBox hBox1 = new HBox(10);
		hBox1.setAlignment(Pos.CENTER);
		hBox1.getChildren().addAll(workingCapital, workingCapitalResult);
		workingCapital.setOnAction(event -> workingCapitalResult.setText(Double.toString(workingCapital(workingCapitalA, workingCapitalL))));
		
		HBox clearBack = new HBox();
		clearBack.setAlignment(Pos.BOTTOM_LEFT);
		Button back = new Button("Back");
		Button clear = new Button("Clear");
		clearBack.getChildren().addAll(back,clear);
		back.setOnAction(event -> back.getScene().setRoot(content3()));
		clear.setOnAction(event -> clear2(workingCapitalA, workingCapitalL, workingCapitalResult));
		VBox vBox2 = new VBox(10);
		vBox2.getChildren().addAll(vBox1, hBox1, clearBack);
		return vBox2;
	}
	
	public Parent content5(){
		Label label1 = new Label("Current Ratio");
		TextField currentRatioA = new TextField("Please enter the value of your Current Assets: ");
		TextField currentRatioL = new TextField("Please enter the value of your Current Liabilities: ");
		TextField currentRatioResult = new TextField();
		 Button currentRatio = new Button("Current Ratio");
		 currentRatioResult.setEditable(false);
		 
		 VBox vBox1 = new VBox(10);
			vBox1.setAlignment(Pos.CENTER);
			vBox1.getChildren().addAll(label1, currentRatioA,currentRatioL);
			
			HBox hBox1 = new HBox(10);
			hBox1.setAlignment(Pos.CENTER);
			hBox1.getChildren().addAll(currentRatio, currentRatioResult);
			currentRatio.setOnAction(event -> currentRatioResult.setText(Double.toString(currentRatio(currentRatioA, currentRatioL))));
		
			HBox clearBack = new HBox();
			clearBack.setAlignment(Pos.BOTTOM_LEFT);
			Button back = new Button("Back");
			Button clear = new Button("Clear");
			clearBack.getChildren().addAll(back,clear);
			back.setOnAction(event -> back.getScene().setRoot(content3()));
			clear.setOnAction(event -> clear2(currentRatioA, currentRatioL, currentRatioResult));
			
			VBox vBox2 = new VBox(10);
			vBox2.setAlignment(Pos.TOP_CENTER);
			vBox2.getChildren().addAll(vBox1, hBox1, clearBack);
			return vBox2;
	}
	
	public Parent content6(){
		Label label1 = new Label("Debt To Equity Ratio");
		TextField debtToEquityD = new TextField("Please enter the value of your Total Debt: ");
		TextField debtToEquityE = new TextField("Please enter the value of your Total Equity: ");
		TextField debtToEquityResult = new TextField();
		Button debtToEquity = new Button("Debt To Equity Ratio");
		debtToEquityResult.setEditable(false);
		
		VBox vBox1 = new VBox(10);
		vBox1.setAlignment(Pos.CENTER);
		vBox1.getChildren().addAll(label1, debtToEquityD, debtToEquityE);
		
		HBox hBox1 = new HBox(10);
		hBox1.setAlignment(Pos.CENTER);
		hBox1.getChildren().addAll(debtToEquity, debtToEquityResult);
		debtToEquity.setOnAction(event -> debtToEquityResult.setText(Double.toString(debtToEquity(debtToEquityD, debtToEquityE))));
		
		HBox clearBack = new HBox();
		clearBack.setAlignment(Pos.BOTTOM_LEFT);
		Button back = new Button("Back");
		Button clear = new Button("Clear");
		clearBack.getChildren().addAll(back,clear);
		back.setOnAction(event -> back.getScene().setRoot(content3()));
		clear.setOnAction(event -> clear2(debtToEquityD, debtToEquityE, debtToEquityResult));
		
		VBox vBox2 = new VBox(10);
		vBox2.setAlignment(Pos.TOP_CENTER);
		vBox2.getChildren().addAll(vBox1, hBox1, clearBack);
		return vBox2;
	}
	
	public Parent content7(){


		Label label1 = new Label("Gross Profit Margin");
		TextField grossProfitMarginGP = new TextField("Please enter the value of your Gross Profit: ");
		TextField grossProfitMarginR = new TextField("Please enter the value of your Revenue: ");
		TextField grossProfitMarginResult = new TextField();
		Button grossProfitMargin = new Button("Gross Profit Margin");
		grossProfitMarginResult.setEditable(false);
		
		VBox vBox1 = new VBox(10);
		vBox1.setAlignment(Pos.CENTER);
		vBox1.getChildren().addAll(label1, grossProfitMarginGP, grossProfitMarginR);
		
		HBox hBox1 = new HBox(10);
		hBox1.setAlignment(Pos.CENTER);
		hBox1.getChildren().addAll(grossProfitMargin, grossProfitMarginResult);
		grossProfitMargin.setOnAction(event -> grossProfitMarginResult.setText(Double.toString(grossProfitMargin(grossProfitMarginGP, grossProfitMarginR))));
		
		HBox clearBack = new HBox();
		clearBack.setAlignment(Pos.BOTTOM_LEFT);
		Button back = new Button("Back");
		Button clear = new Button("Clear");
		clearBack.getChildren().addAll(back,clear);
		back.setOnAction(event -> back.getScene().setRoot(content3()));
		clear.setOnAction(event -> clear2(grossProfitMarginGP, grossProfitMarginR, grossProfitMarginResult));
		
		VBox vBox2 = new VBox(10);
		vBox2.setAlignment(Pos.TOP_CENTER);
		vBox2.getChildren().addAll(vBox1, hBox1, clearBack);
		return vBox2;
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
