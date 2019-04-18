package com.example.iexpens.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.iexpens.R;

public class AddAccountActivity extends AppCompatActivity {

    private EditText ip_acc_no;
    private EditText ip_acc_name;
    private EditText ip_acc_amount;
    private Spinner spinner_banks;
    private Spinner spinner_acctype;
    private Button button_add_acc;
    private Button button_acc_clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);

        ip_acc_no = findViewById(R.id.ip_acc_no);
        ip_acc_name = findViewById(R.id.ip_acc_name);
        ip_acc_amount = findViewById(R.id.ip_acc_amount);
        spinner_banks = findViewById(R.id.spinner_banks);
        spinner_acctype = findViewById(R.id.spinner_acctype);

        button_add_acc = findViewById(R.id.button_add_acc);
        button_add_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_add_acc_onClick(v);
            }
        });

        button_acc_clear = findViewById(R.id.button_acc_clear);
        button_acc_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_acc_clear_onClick(v);
            }
        });

    }

    private void button_add_acc_onClick(View v) {

    }

    private void button_acc_clear_onClick(View v) {

    }


}
