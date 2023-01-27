package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane mainDiv = new BorderPane();
        VBox upperDiv = new VBox();
        BorderPane upperDivChild1 = new BorderPane();
        BorderPane upperDivChild2 = new BorderPane();
        Scene scene = new Scene(mainDiv, 320, 300);
        
        Label monthlySavingLabel = new Label("Monthly savings");
        Slider monthlySavingSlider = new Slider();
        Label monthlySavingDescription = new Label("25");
        
        Label yearlyInterestRateLabel = new Label("Yearly interest rate");
        Slider yearlyInterestRateSlider = new Slider(0, 10, 0);
        Label yearlyInterestRateDescription = new Label("0");
        
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();
        XYChart.Series savingsDatas = new XYChart.Series();
        XYChart.Series savingsWithInterestDatas = new XYChart.Series();
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        
        monthlySavingSlider.setMin(25);
        monthlySavingSlider.setMax(250);
        monthlySavingSlider.setMajorTickUnit(25);
        monthlySavingSlider.setShowTickLabels(true);
        monthlySavingSlider.setShowTickMarks(true);
        
        yearlyInterestRateSlider.setMinorTickCount(10);
        yearlyInterestRateSlider.setShowTickLabels(true);
        yearlyInterestRateSlider.setShowTickMarks(true);
        
        yAxis.setLowerBound(0);
        yAxis.setUpperBound(100);
        
        mainDiv.setTop(upperDiv);
        mainDiv.setCenter(lineChart);
        upperDiv.getChildren().addAll(upperDivChild1, upperDivChild2);
        upperDivChild1.setLeft(monthlySavingLabel);
        upperDivChild1.setCenter(monthlySavingSlider);
        upperDivChild1.setRight(monthlySavingDescription);
        upperDivChild2.setLeft(yearlyInterestRateLabel);
        upperDivChild2.setCenter(yearlyInterestRateSlider);
        upperDivChild2.setRight(yearlyInterestRateDescription);
        
        lineChart.setTitle("Savings");
        lineChart.setLegendVisible(false);
        
        updateData(savingsDatas, yAxis, monthlySavingSlider.getValue(), 0.0);
        updateData(savingsWithInterestDatas, yAxis, monthlySavingSlider.getValue(), 0.0);
        
        lineChart.getData().add(savingsDatas);
        lineChart.getData().add(savingsWithInterestDatas);
        
        monthlySavingSlider.valueProperty().addListener((event) -> {
            double currSaving = monthlySavingSlider.getValue();
            
            monthlySavingDescription.setText(String.valueOf(currSaving));
            updateData(savingsDatas, yAxis, currSaving, 0.0);
        });
        
        yearlyInterestRateSlider.valueProperty().addListener((event) -> {
            double currSaving = monthlySavingSlider.getValue();
            double interestRate = yearlyInterestRateSlider.getValue() / 100.0;
            
            yearlyInterestRateDescription.setText(String.valueOf(yearlyInterestRateSlider.getValue()));
            updateData(savingsWithInterestDatas, yAxis, currSaving, interestRate);
        });
        
        stage.setScene(scene);
        stage.show();
    }
    
    private void updateData(XYChart.Series datas, NumberAxis yAxis, double montlySaving, double interestRate) {
        datas.getData().clear();
        double upperBound = 0;
        double prevSaving = 0;
        
        for (int year = 0; year <= 30; year++) {
            double currSaving = year == 0 ? 0 : (prevSaving + (12 * montlySaving)) * (1.0 + interestRate);
            prevSaving = currSaving;
            
            datas.getData().add(new XYChart.Data(year, currSaving));
            upperBound = Math.max(upperBound, currSaving);
        }
                
        yAxis.setUpperBound(upperBound);
    }
}
