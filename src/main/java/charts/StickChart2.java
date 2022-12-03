package charts;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.CategorySeries;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.style.Styler;

import java.util.ArrayList;
import java.util.List;

public class StickChart2 implements ExampleChart<CategoryChart>, Runnable {

    @Override
    public void run(){

        ExampleChart<CategoryChart> exampleChart = new StickChart2();
        CategoryChart chart = exampleChart.getChart();
        new SwingWrapper<CategoryChart>(chart).displayChart();
    }

    @Override
    public CategoryChart getChart() {

        // Create Chart
        CategoryChart chart = new CategoryChartBuilder().width(800).height(600).title("Stick").build();

        // Customize Chart
        chart.getStyler().setChartTitleVisible(true);
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setDefaultSeriesRenderStyle(CategorySeries.CategorySeriesRenderStyle.Stick);

        // Series
        List<Integer> xData = new ArrayList<Integer>();
        List<Integer> yData = new ArrayList<Integer>();
        for (int i = -3; i <= 24; i++) {
            xData.add(i);
            yData.add(i);
        }
        chart.addSeries("data", xData, yData);

        return chart;
    }

    @Override
    public String getExampleChartName() {
        return null;
    }

    @Override
    public String toString(){
        return "Stick Chart";
    }
}
