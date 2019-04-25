package com.example.iexpens.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.iexpens.R;

import java.util.ArrayList;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;


public class HomeFragment extends Fragment {

    PieChartView pieChartView;
    ListView lv_expenses;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mainview = inflater.inflate(R.layout.fragment_home, container, false);

        lv_expenses = mainview.findViewById(R.id.lv_expenses);
        pieChartView = mainview.findViewById(R.id.chart);

        //interacting with the listview
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Our");
        arrayList.add("AWESOMMMNMME");
        arrayList.add("App");

        ArrayAdapter <String> arrayAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                arrayList
        );

        lv_expenses.setAdapter(arrayAdapter);

        List<SliceValue> pieData = new ArrayList<SliceValue>();
        pieData.add(new SliceValue(15, Color.BLUE).setLabel("Q1: $10"));
        pieData.add(new SliceValue(25, Color.GRAY).setLabel("Q2: $4"));
        pieData.add(new SliceValue(10, Color.RED).setLabel("Q3: $18"));
        pieData.add(new SliceValue(60, Color.LTGRAY).setLabel("Q4: $28"));

        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        pieChartData.setHasCenterCircle(true).setCenterText1("Expenses").setCenterText1FontSize(15).setCenterText1Color(Color.parseColor("#080808"));
        pieChartView.setPieChartData(pieChartData);

        return mainview;
    }
}