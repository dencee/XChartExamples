package charts;

import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.PieSeries;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.demo.charts.ExampleChart;

public class DonutChart implements ExampleChart<PieChart>, Runnable {

    @Override
    public void run() {

        ExampleChart<PieChart> exampleChart = new DonutChart();
        PieChart chart = exampleChart.getChart();
        new SwingWrapper<PieChart>(chart).displayChart();
    }

    @Override
    public PieChart getChart() {

        // Create Chart
        PieChart chart = new PieChartBuilder().width(800).height(600).title(getClass().getSimpleName()).build();

        // Customize Chart
        chart.getStyler().setLegendVisible(false);
        chart.getStyler().setPlotContentSize(.9);
        chart.getStyler().setDefaultSeriesRenderStyle(PieSeries.PieSeriesRenderStyle.Donut);
        // chart.getStyler().setCircular(false);

        // Series
        chart.addSeries("A", 22);
        chart.addSeries("B", 10);
        chart.addSeries("C", 34);
        chart.addSeries("D", 22);
        chart.addSeries("E", 29);
        chart.addSeries("F", 40);

        return chart;
    }

    @Override
    public String getExampleChartName() {
        return null;
    }

    @Override
    public String toString(){
        return "Donut Chart";
    }
}
