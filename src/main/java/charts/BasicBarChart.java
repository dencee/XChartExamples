package charts;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.style.Styler;

import java.util.Arrays;

/**
 * Basic Bar Chart
 *
 * Demonstrates the following:
 * <ul>
 * <li>Integer categories as List
 * <li>All positive values
 * <li>Single series
 * <li>Place legend at Inside-NW position
 * <li>Bar Chart Annotations
 */
public class BasicBarChart implements ExampleChart<CategoryChart>, Runnable {

    @Override
    public void run() {

        ExampleChart<CategoryChart> exampleChart = new BasicBarChart();
        CategoryChart chart = exampleChart.getChart();
        new SwingWrapper<CategoryChart>(chart).displayChart();
    }

    @Override
    public CategoryChart getChart() {

        // Create Chart
        CategoryChart chart = new CategoryChartBuilder().width(800).height(600).title("Score Histogram").xAxisTitle("Score").yAxisTitle("Number").build();

        // Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);

        // Series
        chart.addSeries("test 1", Arrays.asList(new Integer[] { 0, 1, 2, 3, 4 }), Arrays.asList(new Integer[] { 4, 5, 9, 6, 5 }));

        return chart;
    }

    @Override
    public String getExampleChartName() {
        return null;
    }

    @Override
    public String toString(){
        return "Bar Chart";
    }
}
