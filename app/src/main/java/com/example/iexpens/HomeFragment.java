package com.example.iexpens;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;
import me.ithebk.barchart.BarChart;
import me.ithebk.barchart.BarChartModel;


public class HomeFragment extends Fragment {

    private PieChartView pieChartView;
    private int Counter;

    public HomeFragment() {
        Counter = 0;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mainview = inflater.inflate(R.layout.fragment_home, container, false);

        /** My @param
         * pie
         * progressbars 1 and 2
         */

        pieChartView = mainview.findViewById(R.id.chart);
        ProgressBar progressBar = mainview.findViewById(R.id.progressBar1);
        ProgressBar progressBar2 = mainview.findViewById(R.id.progressBar2);


        //calling methods on piechart
        List<SliceValue> pieData = new ArrayList<SliceValue>();
        pieData.add(new SliceValue(15, Color.BLUE).setLabel("Current: $10"));
        pieData.add(new SliceValue(25, Color.GRAY).setLabel("Saving: $4"));
        pieData.add(new SliceValue(10, Color.RED).setLabel("Cash: $18"));
        pieData.add(new SliceValue(60, Color.GREEN).setLabel("Crypto: $28"));

        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        pieChartData.setHasCenterCircle(true).setCenterText1("Expenses").setCenterText1FontSize(13).setCenterText1Color(Color.parseColor("#080808"));
        pieChartView.setPieChartData(pieChartData);


        //calling methods on progressbars
        progressBar.onSaveInstanceState();
        progressBar.setProgress(4);
        //progressBar.setSecondaryProgress(9);
        progressBar.setMax(10);

        progressBar2.onSaveInstanceState();
        progressBar2.setProgress(6);
        //progressBar2.setSecondaryProgress(9);
        progressBar2.setMax(10);

        BarChart barChart = (BarChart) mainview.findViewById(R.id.bar_chart_horizontal);
        barChart.setBarMaxValue(100);

        //Add single bar
        BarChartModel barChartModel = new BarChartModel();
        barChartModel.setBarColor(Color.parseColor("#9C27B0"));
        //barChartModel.setBarTag(""); //You can set your own tag to bar model
        barChartModel.setBarText("Out");
        barChartModel.setBarValue(55);


        BarChartModel barChartModel2 = new BarChartModel();
        barChartModel2.setBarColor(Color.parseColor("#283881"));
        barChartModel2.setBarText("In");
        barChartModel2.setBarValue(90);

        BarChartModel barChartModel3 = new BarChartModel();
        barChartModel3.setBarColor(Color.parseColor("#ffff00"));
        barChartModel3.setBarText("Cash");
        barChartModel3.setBarValue(30);

        BarChartModel barChartModel4 = new BarChartModel();
        barChartModel4.setBarColor(Color.parseColor("#cd5c5c"));
        barChartModel4.setBarText("Crypto");
        barChartModel4.setBarValue(60);

        barChart.addBar(barChartModel);
        barChart.addBar(barChartModel2);
        barChart.addBar(barChartModel3);
        barChart.addBar(barChartModel4);


        //Add mutliple bar at once as list;
        List<BarChartModel> barChartModelList = new ArrayList<>();

        //populate bar array list and add to barchart as a list.
        barChart.addBar(barChartModelList);

        return mainview;
    }
}