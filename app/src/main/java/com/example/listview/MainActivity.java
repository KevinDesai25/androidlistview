package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv1;

    ArrayList<String> names = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv1 = findViewById(R.id.lv1);

        //
        names.add("abc");
        names.add("eee");
        names.add("qqq");
        names.add("www");
        names.add("ttt");
        final ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,names);

        lv1.setAdapter(arrayAdapter);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

                Toast.makeText(MainActivity.this, "Deleted Name:" + names.get(pos), Toast.LENGTH_SHORT).show();

                //for delete
                names.remove(pos);
                arrayAdapter.notifyDataSetChanged();

            }
        });
    }
}
