package com.example.iexpens.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.iexpens.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;


public class OverviewFragment extends Fragment {

    private BarChart graph_expenses;
    private ListView lv_expenses;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mainview = inflater.inflate(R.layout.fragment_overview, container, false);

        graph_expenses = mainview.findViewById(R.id.graph_expenses);
        lv_expenses = mainview.findViewById(R.id.lv_expenses);


        //Create an array for x axis of bar chart
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(5, 0));
        barEntries.add(new BarEntry(7, 1));
        barEntries.add(new BarEntry(4, 2));
        barEntries.add(new BarEntry(6, 3));

        BarDataSet barDataSet = new BarDataSet(barEntries, "Total/Month");

        //Create an array for y axis of bar chart
        ArrayList<String> theDates = new ArrayList<>();
        //theDates.add("Jan");
        theDates.add("Feb");
        theDates.add("Mar");
        theDates.add("Apr");
        theDates.add("May");
        //theDates.add("June");
        //theDates.add("July");

        BarData expensesData = new BarData(theDates, barDataSet);
        graph_expenses.setData(expensesData);

        graph_expenses.setTouchEnabled(true);
        graph_expenses.setDragEnabled(true);
        graph_expenses.setScaleEnabled(true);
        graph_expenses.setDrawValueAboveBar(true);
        graph_expenses.setDrawBarShadow(true);


        //interacting with the listview
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Our");
        arrayList.add("AWESOMMMNMME");
        arrayList.add("App");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_selectable_list_item,
                arrayList
        );

        lv_expenses.setAdapter(arrayAdapter);
        return mainview;

    }
}