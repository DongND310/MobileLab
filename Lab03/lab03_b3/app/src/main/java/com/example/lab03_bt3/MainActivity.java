package com.example.lab03_bt3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener {
    private List<Student> students;
    private EditText edMSSV, edName, edClass;
    private RecyclerView recyclerView;
    private Button btn_add, btn_del, btn_update, btn_query;
    private StudentAdapter adapter;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edMSSV = findViewById(R.id.ed_mssv);
        edName = findViewById(R.id.ed_name);
        edClass = findViewById(R.id.ed_class);
        btn_add = findViewById(R.id.btn_add);
        btn_del = findViewById(R.id.btn_del);
        btn_update = findViewById(R.id.btn_update);
        btn_query = findViewById(R.id.btn_query);
        recyclerView = findViewById(R.id.rv_Result);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = new DatabaseHelper(this);

        Log.e("Reading: ", "Reading all contacts..");
        students = db.getAllStudents();
        showData(students);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student(edMSSV.getText().toString(), edName.getText().toString(), edClass.getText().toString());
                db.addStudent(student);
                showData(db.getAllStudents());
                clearFields();
            }
        });

        btn_del.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View v) {
                db.deleteStudent(edMSSV.getText().toString());
                showData(db.getAllStudents());
                clearFields();
            }
        });

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student(edMSSV.getText().toString(), edName.getText().toString(), edClass.getText().toString());
                db.updateStudent(student);
                showData(db.getAllStudents());
                clearFields();
            }
        });

        btn_query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Student> studentList = db.getStudent(edMSSV.getText().toString());
                showData(studentList);
                if (studentList.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Không tìm thấy sinh viên!", Toast.LENGTH_SHORT).show();
                }
                clearFields();
            }
        });
    }

    public void showData(List<Student> students) {
        this.students = students; // Update the activity's student list
        StudentAdapter adapter = new StudentAdapter(MainActivity.this, students, this);
        recyclerView.setAdapter(adapter);
    }

    private void clearFields() {
        edMSSV.setText("");
        edName.setText("");
        edClass.setText("");
    }

    @Override
    public void onClick(int position) {
        if (position >= 0 && position < students.size()) {
            Student student = students.get(position);
            edMSSV.setText(student.get_code());
            edName.setText(student.get_name());
            edClass.setText(student.get_class());
        } else {
            // Optional: Log or handle the out-of-bounds condition
            Log.e("MainActivity", "Index out of bounds: " + position);
        }}
}