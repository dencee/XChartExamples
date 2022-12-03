package charts;

import org.knowm.xchart.BubbleChart;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.style.Styler;

import javax.management.timer.Timer;
import javax.swing.JFrame;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Real-time Bubble Chart
 *
 * Demonstrates the following:
 * <ul>
 * <li>real-time chart updates
 * <li>multiple series
 * <li>Bubble chart
 * <li>GGPlot2 chart
 */
public class RealTimeChart implements ExampleChart<BubbleChart>, Runnable {

    private List<Double> yData;
    private List<Double> bubbleData;
    public static final String SERIES_NAME = "series1";

    @Override
    public void run() {

        // Set up the panel
        final RealTimeChart realTimeChart = new RealTimeChart();
        final XChartPanel<BubbleChart> chartPanel = realTimeChart.buildPanel();

        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                // Create and set up the window.
                JFrame frame = new JFrame("XChart");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(chartPanel);

                // Display the window.
                frame.pack();
                frame.setVisible(true);
            }
        });

        // Simulate a data feed
        TimerTask chartUpdaterTask = new TimerTask() {

            @Override
            public void run() {

                realTimeChart.updateData();
//                chartPanel.updateSeries(SERIES_NAME, null, realTimeChart.getyData(), realTimeChart.getbubbleData());

            }
        };

        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(chartUpdaterTask, 0, 500);

    }

    public XChartPanel<BubbleChart> buildPanel() {

        return new XChartPanel<BubbleChart>(getChart());
    }

    @Override
    public BubbleChart getChart() {

        yData = getRandomData(5);
        bubbleData = getRandomData(5);

        // Create Chart
        BubbleChart chart = new BubbleChart(500, 400, Styler.ChartTheme.GGPlot2);
        chart.setTitle("Real-time Bubble Chart");
        chart.setXAxisTitle("X");
        chart.setYAxisTitle("Y");

        chart.addSeries(SERIES_NAME, null, yData, bubbleData);

        return chart;
    }

    @Override
    public String getExampleChartName() {
        return null;
    }

    private List<Double> getRandomData(int numPoints) {

        List<Double> data = new CopyOnWriteArrayList<Double>();
        for (int i = 0; i < numPoints; i++) {
            data.add(Math.random() * 100);
        }
        return data;
    }

    public void updateData() {

        // Get some new data
        List<Double> newData = getRandomData(1);
        yData.addAll(newData);
        // Limit the total number of points
        while (yData.size() > 20) {
            yData.remove(0);
        }

        // Get some new data
        newData = getRandomData(1);
        bubbleData.addAll(newData);
        // Limit the total number of points
        while (bubbleData.size() > 20) {
            bubbleData.remove(0);
        }

    }

    public List<Double> getyData() {

        return yData;
    }

    public List<Double> getbubbleData() {

        return bubbleData;
    }

    @Override
    public String toString(){
        return "Real-time Chart";
    }
}