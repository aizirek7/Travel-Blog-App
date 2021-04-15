package com.example.travelblogapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TravelAdapter extends RecyclerView.Adapter<TravelAdapter.GoodHolder>{
    private ItemClickListener listener;

    public void setItemClickListener(ItemClickListener listener){
        this.listener = listener;
    }

    public interface ItemClickListener{
        void ItemClick(int position);
    }


    public static class GoodHolder extends RecyclerView.ViewHolder{
         TextView goodTitle, goodDescription, goodPrice;
         ImageView goodImage;

        public GoodHolder(@NonNull View itemView, ItemClickListener listener, ArrayList<Order> orders) {
            super(itemView);
            goodTitle = itemView.findViewById(R.id.goodTitle);
            goodDescription = itemView.findViewById(R.id.goodDescription);
            goodPrice = itemView.findViewById(R.id.goodPrice);
            goodImage = itemView.findViewById(R.id.goodImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    listener.ItemClick(position);
                }
            });

        }
    }

    private ArrayList<Order> ordersArray;
    public TravelAdapter(ArrayList<Order> orders){
        this.ordersArray = orders;
    }

    @NonNull
    @Override
    public GoodHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new GoodHolder(view,listener, ordersArray);
    }

    @Override
    public void onBindViewHolder(@NonNull GoodHolder holder, int position) {
        Order currentItem = ordersArray.get(position);
        holder.goodImage.setImageResource(currentItem.getGoodImage());
        holder.goodTitle.setText(currentItem.getGoodTitle());
        holder.goodDescription.setText(currentItem.getGoodDescription());
        holder.goodPrice.setText(currentItem.getGoodPrice());

    }

    @Override
    public int getItemCount() {
        return ordersArray.size();
    }
}
