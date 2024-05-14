package com.example.project;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        GridPane root = new GridPane();
        root.setHgap(5);
        root.setVgap(5);

        //buttons

        Button b1 = new Button("PieChart");
        Button b2 = new Button("LineChart");
        Button b3 = new Button("AreaChart");
        Button b4 = new Button("BarChart");
        Button b5 = new Button("BubbleChart");
        Button b6 = new Button("ScatterChart");

        //piechart

        PieChart pieChart = new PieChart();
        pieChart.setData(getMyData());
        pieChart.setLegendSide(Side.LEFT);
        pieChart.setTitle("Flower Popularity in the World");

        //linechart

        final NumberAxis xaxis = new NumberAxis(2008,2018,1);
        final NumberAxis yaxis = new NumberAxis(10,80,5);

        xaxis.setLabel("Year");
        yaxis.setLabel("Price");

        LineChart linechart = new LineChart(xaxis,yaxis);
        XYChart.Series series = new XYChart.Series();

        series.setName("Stock Analysis");
        series.getData().add(new XYChart.Data(2009,25));
        series.getData().add(new XYChart.Data(2010,15));
        series.getData().add(new XYChart.Data(2011,68));
        series.getData().add(new XYChart.Data(2012,60));
        series.getData().add(new XYChart.Data(2013,35));
        series.getData().add(new XYChart.Data(2014,55));
        series.getData().add(new XYChart.Data(2015,45));
        series.getData().add(new XYChart.Data(2016,67));
        series.getData().add(new XYChart.Data(2017,78));

        linechart.getData().add(series);

        //areachart

        NumberAxis xxaxis = new NumberAxis(1,5,1);
        NumberAxis yyaxis = new NumberAxis(10,510,50);
        xxaxis.setLabel("Month of the year");
        yyaxis.setLabel("Sales value (lacs)");

        AreaChart<Number,Number> areaChart = new AreaChart(xxaxis,yyaxis);

        areaChart.setTitle("RegionWise Sales");

        XYChart.Series seriesNorth = new XYChart.Series();
        seriesNorth.setName("North");
        seriesNorth.getData().add(new XYChart.Data(1,120));
        seriesNorth.getData().add(new XYChart.Data(2,140));
        seriesNorth.getData().add(new XYChart.Data(3,50));
        seriesNorth.getData().add(new XYChart.Data(4,80));
        seriesNorth.getData().add(new XYChart.Data(5,150));

        //Configuring series for East sales
        XYChart.Series seriesEast = new XYChart.Series();
        seriesEast.setName("East");
        seriesEast.getData().add(new XYChart.Data(1,500));
        seriesEast.getData().add(new XYChart.Data(2,200));
        seriesEast.getData().add(new XYChart.Data(3,300));
        seriesEast.getData().add(new XYChart.Data(4,290));
        seriesEast.getData().add(new XYChart.Data(5,150));

        areaChart.getData().addAll(seriesNorth,seriesEast);

        //barchart

        //Configuring category and NumberAxis
        CategoryAxis xxxaxis = new CategoryAxis();
        NumberAxis yyyaxis = new NumberAxis(0.1,2,0.1);
        xxxaxis.setLabel("Currency");
        yyyaxis.setLabel("Dollar price");

        //Configuring BarChart
        BarChart<String,Float> barChart = new BarChart(xxxaxis,yyyaxis);
        barChart.setTitle("Dollar Conversion chart");

        //Configuring Series for XY chart
        XYChart.Series<String,Float> seriess = new XYChart.Series<>();
        seriess.getData().add(new XYChart.Data("Euro",0.83));
        seriess.getData().add(new XYChart.Data("Pound",0.73));
        seriess.getData().add(new XYChart.Data("French",1.00));
        seriess.getData().add(new XYChart.Data("A_Dollar",1.32));

        //Adding series to the barchart
        barChart.getData().add(seriess);

        //BubbleChart
        NumberAxis x1axis = new NumberAxis(2012,2022,2);
        NumberAxis y1axis = new NumberAxis(10,100,10);
        x1axis.setLabel("Year");
        y1axis.setLabel("Popularity (%)");

        BubbleChart bubbleChart = new BubbleChart(x1axis, y1axis);
        bubbleChart.setTitle("Programming Language Popularity");

        XYChart.Series pythonx = new XYChart.Series<>();
        pythonx.setName("Python");
        pythonx.getData().add(new XYChart.Data(2012,40));
        pythonx.getData().add(new XYChart.Data(2014,30));
        pythonx.getData().add(new XYChart.Data(2016,45));
        pythonx.getData().add(new XYChart.Data(2018,70));
        pythonx.getData().add(new XYChart.Data(2020,60));
        pythonx.getData().add(new XYChart.Data(2022,90));

        bubbleChart.getData().add(pythonx);

        //ScatterChart
        NumberAxis x2axis = new NumberAxis(2012,2022,2);
        NumberAxis y2axis = new NumberAxis(10,100,10);
        x2axis.setLabel("Year");
        y2axis.setLabel("Popularity (%)");

        ScatterChart scatterChart = new ScatterChart(x2axis,y2axis);
        scatterChart.setTitle("Programming Language Popularity");

        XYChart.Series pythone = new XYChart.Series<>();
        pythone.setName("Python");
        pythone.getData().add(new XYChart.Data(2012,40));
        pythone.getData().add(new XYChart.Data(2014,30));
        pythone.getData().add(new XYChart.Data(2016,45));
        pythone.getData().add(new XYChart.Data(2018,70));
        pythone.getData().add(new XYChart.Data(2020,60));
        pythone.getData().add(new XYChart.Data(2022,90));

        scatterChart.getData().add(pythone);

        //button action

        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                root.addRow(0,pieChart);
            }
        });
        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                root.addRow(1,linechart);
            }
        });
        b3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                root.addRow(2,areaChart);
            }
        });
        b4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                root.addRow(3,barChart);
            }
        });
        b5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                root.addRow(4,bubbleChart);
            }
        });
        b6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                root.addRow(5,scatterChart);
            }
        });

        //add buttons on UI

        root.addRow(0,b1);
        root.addRow(1,b2);
        root.addRow(2,b3);
        root.addRow(3,b4);
        root.addRow(4,b5);
        root.addRow(5,b6);

        // Encapsulate the GridPane within a ScrollPane
        ScrollPane scrollPane = new ScrollPane(root);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        Scene scene = new Scene(scrollPane, 320, 240);
        stage.setTitle("Multiple Charts");
        stage.setScene(scene);
        stage.show();
    }

    //piechart data
    private ObservableList<PieChart.Data> getMyData() {
        ObservableList<PieChart.Data> l = FXCollections.observableArrayList();
        l.add(new PieChart.Data("Rose", 85.0));
        l.add(new PieChart.Data("SunFlower", 55.0));
        l.add(new PieChart.Data("Hydrangea", 45.0));
        l.add(new PieChart.Data("Lavender", 35.0));
        l.add(new PieChart.Data("Peony", 20.0));

        return l;
    }

    //main function

    public static void main(String[] args) {
        launch();
    }
}
