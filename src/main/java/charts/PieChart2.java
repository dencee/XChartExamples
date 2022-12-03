package charts;

import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.demo.charts.pie.PieChart02;

import java.awt.*;

public class PieChart2 implements ExampleChart<PieChart>, Runnable {

    @Override
    public void run(){

        ExampleChart<PieChart> exampleChart = new PieChart02();
        PieChart chart = exampleChart.getChart();
        new SwingWrapper<PieChart>(chart).displayChart();
    }

    @Override
    public PieChart getChart() {

        // Create Chart
        PieChart chart = new PieChartBuilder().width(800).height(600).title(getClass().getSimpleName()).build();

        // Customize Chart
        Color[] sliceColors = new Color[] { new Color(224, 68, 14), new Color(230, 105, 62), new Color(236, 143, 110), new Color(243, 180, 159), new Color(246, 199, 182) };
        chart.getStyler().setSeriesColors(sliceColors);

        // Series
        chart.addSeries("Gold", 24);
        chart.addSeries("Silver", 21);
        chart.addSeries("Platinum", 39);
        chart.addSeries("Copper", 17);
        chart.addSeries("Zinc", 40);

        return chart;
    }

    @Override
    public String getExampleChartName() {
        return null;
    }

    @Override
    public String toString(){
        return "Pie Chart";
    }
}
