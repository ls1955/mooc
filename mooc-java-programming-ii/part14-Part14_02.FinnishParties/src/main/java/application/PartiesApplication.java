package application;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application {
    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        ArrayList<String> fileData = readData();
        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        XYChart.Series kokData = new XYChart.Series();
        XYChart.Series sdpData = new XYChart.Series();
        XYChart.Series keskData = new XYChart.Series();
        XYChart.Series vihrData = new XYChart.Series();
        XYChart.Series vasData = new XYChart.Series();
        XYChart.Series psData = new XYChart.Series();
        XYChart.Series rkpData = new XYChart.Series();
        Scene scene = new Scene(lineChart, 640, 480);
        
        lineChart.setTitle("Relative support of the parties");
        addDatas(kokData, fileData, 1);
        addDatas(sdpData, fileData, 2);
        addDatas(keskData, fileData, 3);
        addDatas(vihrData, fileData, 4);
        addDatas(vasData, fileData, 5);
        addDatas(psData, fileData, 6);
        addDatas(rkpData, fileData, 7);
        
        lineChart.getData().add(kokData);
        lineChart.getData().add(sdpData);
        lineChart.getData().add(keskData);
        lineChart.getData().add(vihrData);
        lineChart.getData().add(vasData);
        lineChart.getData().add(psData);
        lineChart.getData().add(rkpData);
        
        window.setScene(scene);
        window.show();
    }
    
    private ArrayList<String> readData() {
        ArrayList<String> datas = new ArrayList<>();
        
        try {
            Scanner fileReader = new Scanner(new File("partiesdata.tsv"));
            
            while (fileReader.hasNextLine()) {
                datas.add(fileReader.nextLine());
            }
        } catch(Exception e) {
            System.out.println("File not found");
        }
        
        return datas;
    }
    
    private void addDatas(XYChart.Series series, ArrayList<String> datas, int index) {
        String[] years = datas.get(0).split("\t");
        String[] rowData = datas.get(index).split("\t");
        
        series.setName(rowData[0]);
        for (int i = 1; i < rowData.length; i++) {
            if (rowData[i].equals("-")) continue;
            
            int year = Integer.valueOf(years[i]);
            Double data = Double.valueOf(rowData[i]);
            series.getData().add(new XYChart.Data(year, data));
        }
    }
}
