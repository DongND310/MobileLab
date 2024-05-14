package com.example.lab2_bai1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lvPerson = (ListView) findViewById(R.id.lv_person);
        TextView lvText = (TextView) findViewById(R.id.lv_text);
        final String arr[] = {"Teo", "Ty", "Bin", "Bo"};

        ArrayAdapter<String> adapter = new
                ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, arr);
        lvPerson.setAdapter(adapter);
        lvPerson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                lvText.setText("position :" + position + "; value =" + arr[position]);
            }
        });
    }
}