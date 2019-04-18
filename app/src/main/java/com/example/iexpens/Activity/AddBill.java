package com.example.iexpens.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.iexpens.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddBill extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bill);

        final Calendar myCalendar = Calendar.getInstance();

        final EditText edittext= (EditText) findViewById(R.id.DueDateValue);
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(edittext,myCalendar);
            }
        };
        edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(AddBill.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        EditText eText = (EditText) findViewById(R.id.DueDateValue);
        eText.setHint("Add Due Date");
    }
    private void updateLabel(EditText edittext, Calendar myCalendar) {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        Log.d("text value",myCalendar.getTime().toString());
        edittext.setText(sdf.format(myCalendar.getTime()));
    }

    public void addBill(View view) {
        Spinner accountValue = (Spinner) findViewById(R.id.AccountValue);
        EditText amountValue= (EditText) findViewById(R.id.AmountValue);
        EditText dueDateValue= (EditText) findViewById(R.id.DueDateValue);

        String strAcoountType = accountValue.getSelectedItem().toString();
        String strAmount = amountValue.getText().toString();
        String strdueDate = dueDateValue.getText().toString();

        saveBillToDatabase(strAcoountType,strAmount,strdueDate);
    }

    private void saveBillToDatabase(String strAcoountType, String strAmount, String strdueDate) {
        Log.d("Account Type",strAcoountType);
        Log.d("Amount",strAmount);
        Log.d("Due Date",strdueDate);
    }

    public void cancelBill(View view) {
        Log.d("Message","Add Bill Cancelled");
    }
}
