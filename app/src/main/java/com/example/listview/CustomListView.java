package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomListView extends AppCompatActivity {


    ListView listview;
    ArrayList<Student> students = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);

        listview = findViewById(R.id.listview);

        students.add(new Student("Raj", "988765"));
        students.add(new Student("Raj", "988765"));
        students.add(new Student("Raj", "988765"));
        students.add(new Student("Raj", "988765"));
        students.add(new Student("Raj", "988765"));

        final MyAdapter myAdapter = new MyAdapter(students, CustomListView.this);

        listview.setAdapter(myAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

                Toast.makeText(CustomListView.this, "Selected: " + students.get(pos).sName, Toast.LENGTH_SHORT).show();

                students.get(pos).setsName("xyz");
                students.get(pos).setsContact("0000999988");

                myAdapter.notifyDataSetChanged();

            }
        });

    }
}
