package com.example.listview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    ArrayList<Product> products;
    Context context;

    public ProductAdapter(ArrayList<Product> products, Context context) {
        this.products = products;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        CardView card;
        TextView pName, pPrice;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            pName = itemView.findViewById(R.id.tvProductName);
            pPrice = itemView.findViewById(R.id.tvProductPrice);
            card = itemView.findViewById(R.id.card);
        }


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.item_card, null, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.pName.setText(products.get(position).getpName());
        holder.pPrice.setText(products.get(position).getpRice());

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(context, ProductDetails.class);
                i.putExtra("pName", products.get(position).getpName());
                i.putExtra("pPrice", products.get(position).getpRice());
                context.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }


}