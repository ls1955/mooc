package application;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application {

    public static void main(String[] args) {
        launch(ShanghaiApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        NumberAxis xAxis = new NumberAxis(2006, 2017, 1);
        NumberAxis yAxis = new NumberAxis(0, 100, 10);
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        XYChart.Series helSinkiData = new XYChart.Series();
        Scene view = new Scene(lineChart, 640, 480);
        String[] rawDatas = {"2007 73", "2008 68", "2009 72", "2010 72", "2011 74", "2012 73", "2013 76", "2014 73", "2015 67", "2016 56", "2017 56"};
        ArrayList<Integer[]> processedData = processData(rawDatas);
        
        lineChart.setTitle("University of Helsinki, Shanghai ranking");
        lineChart.setLegendVisible(false);
        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");

        for (int i = 0; i < processedData.size(); i++) {
            Integer[] currData = processedData.get(i);
            
            helSinkiData.getData().add(new XYChart.Data(currData[0], currData[1]));
        }
        
        lineChart.getData().add(helSinkiData);
        
        window.setScene(view);
        window.show();
    }
    
    private ArrayList<Integer[]> processData(String[] rawData) {
        ArrayList<Integer[]> processedData = new ArrayList<>();
        
        for (int i = 0; i < rawData.length; i++) {
            String[] dataString = rawData[i].split(" ");
            Integer[] data = {Integer.valueOf(dataString[0]), Integer.valueOf(dataString[1])};
            
            processedData.add(data);
        }
        
        return processedData;
    }
}
