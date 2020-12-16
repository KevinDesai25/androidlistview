package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class RecyclerViewExample extends AppCompatActivity {

    RecyclerView rv;
    ArrayList<Product> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        products.add(new Product("Laptop", "58000"));
        products.add(new Product("Laptop1", "58000"));
        products.add(new Product("Laptop2", "58000"));
        products.add(new Product("Laptop3", "58000"));
        products.add(new Product("Laptop4", "58000"));

        rv = findViewById(R.id.rv);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);

        ProductAdapter productAdapter = new ProductAdapter(products, this);
        rv.setAdapter(productAdapter);
    }
}
