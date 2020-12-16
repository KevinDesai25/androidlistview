package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ProductDetails extends AppCompatActivity {

    TextView tvPDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        tvPDetails = findViewById(R.id.tvPDetails);

        Intent i = getIntent();
        if (i != null) {

            tvPDetails.setText("Product NAme:" + i.getStringExtra("pName") + ",\nProduct Price: " + i.getStringExtra("pPrice"));

        }
    }
}
