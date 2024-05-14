package com.example.lab2_bai2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button buttonAdd;
    private ListView listView;
    private TextView tvText;

    private ArrayList<String> names;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        buttonAdd = findViewById(R.id.buttonAdd);
        listView = (ListView) findViewById(R.id.lv_person);
        tvText = (TextView) findViewById(R.id.tv_select);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        editText = (EditText) findViewById(R.id.editText);


        names = new ArrayList<String>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);
        listView.setAdapter(adapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                names.add(editText.getText().toString());
                adapter.notifyDataSetChanged();
                editText.setText("");
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String selectedItem = names.get(position);
//                textViewSelectedItem.setText("Selected Item: " + selectedItem + ", Position: " + position);

                String value = listView.getItemAtPosition(position).toString();
                tvText.setText("Position:" + position + " ; Value: " + value);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                names.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
    public void addItem(View view) {
        String newName = editText.getText().toString().trim();
        if (!newName.isEmpty()) {
            names.add(newName);
            adapter.notifyDataSetChanged();
            editText.setText("");
        }
    }

}