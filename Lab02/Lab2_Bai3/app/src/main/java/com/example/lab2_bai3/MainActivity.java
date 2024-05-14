package com.example.lab2_bai3;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etId;
    EditText etName;
    RadioButton rd_FT, rdBtnKhong;
    RadioGroup rgType;
    Button btnadd;
    ListView lvPerson;
    ArrayList<Employee> employees;
    ArrayAdapter<Employee> adapter;
    Employee employee;
    TextView label;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        etId = (EditText) findViewById(R.id.eT_id);
        etName = (EditText) findViewById(R.id.eT_name);
        rgType = (RadioGroup) findViewById(R.id.rgType);
        btnadd = (Button) findViewById(R.id.bt_add);
        lvPerson = (ListView) findViewById(R.id.lv_person);
        label = findViewById(R.id.tv_select);
        employees = new ArrayList<Employee>();
        adapter = new ArrayAdapter<Employee>(this, android.R.layout.simple_list_item_1,employees);

        lvPerson.setAdapter(adapter);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etId.getText().toString().isEmpty() || etName.getText().toString().isEmpty())
                {}
                else {
                    int radId = rgType.getCheckedRadioButtonId();
                    String id = etId.getText().toString();
                    String name = etName.getText().toString();
                    if (radId == R.id.rd_FT) {
                        //create instance: Fulltime
                        employee = new EmployeeFulltime();
                    } else {
                        //create instance: parttime
                        employee = new EmployeeParttime();
                    }

                    employee.setId(id);
                    employee.setName(name);
                    //add employee into ArrayList
                    employees.add(employee);
                    //Update UI
                    adapter.notifyDataSetChanged();
                    etId.getText().clear();
                    etName.getText().clear();
                }
            }
        });

        lvPerson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>parent, View view, int position, long id) {
                String value = lvPerson.getItemAtPosition(position).toString();
                label.setText("Position:" + position + " ; Value: " + value);
            }
        });
        lvPerson.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                employees.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}