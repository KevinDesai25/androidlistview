package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    ArrayList<Student> students;
    Context context;

    public MyAdapter(ArrayList<Student> students, Context context) {
        this.students = students;
        this.context = context;
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int i) {
        return students.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int pos, View view, ViewGroup viewGroup) {

        View view1 = LayoutInflater.from(context).inflate(R.layout.list_item_layout, null, false);

        TextView tvName = view1.findViewById(R.id.tvName);
        TextView tvContact = view1.findViewById(R.id.tvContact);

        tvName.setText(students.get(pos).getsName());
        tvContact.setText(students.get(pos).getsContact());

        return view1;
    }
}
