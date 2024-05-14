package com.example.lab2_bai4;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnAdd;
    ListView lv_Employee;
    ArrayList<Bai4_Employee> bai4Employees;
    EditText edtName;
    CheckBox chbxManager;
    EmployeeAdapter adapter;
    EditText edtID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edtName = findViewById(R.id.eT_name);
        chbxManager = findViewById(R.id.chbxManager);
        btnAdd =  findViewById(R.id.bt_add);
        lv_Employee = findViewById(R.id.lv_person);
        bai4Employees = new ArrayList<Bai4_Employee>();
        edtID = findViewById(R.id.eT_id);

        adapter = new EmployeeAdapter(this, R.layout.item_employee, bai4Employees);
        lv_Employee.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString();
                String id = edtID.getText().toString();
                if (!name.isEmpty() && !id.isEmpty())
                {
                    Bai4_Employee bai4Employee = new Bai4_Employee();
                    if (chbxManager.isChecked())
                    {
                        bai4Employee.setManager(true);
                    }
                    else
                    {
                        bai4Employee.setManager(false);
                    }
                    bai4Employee.setFullName(name);
                    //employee => ArrayList
                    bai4Employees.add(bai4Employee);
                    //update UI
                    adapter.notifyDataSetChanged();
                    edtID.getText().clear();
                    edtName.getText().clear();
                    Toast.makeText(MainActivity.this, "ADDED SUCCESSFULLY!", Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(MainActivity.this, "FILL IN THE BOX PLEASE!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}