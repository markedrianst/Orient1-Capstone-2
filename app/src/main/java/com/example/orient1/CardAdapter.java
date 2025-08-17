package com.example.orient1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {
    private List<CardItem> items; // Changed to custom object

    public static class CardItem {
        int imageRes;
        String description;

        public CardItem(int imageRes, String description) {
            this.imageRes = imageRes;
            this.description = description;
        }
    }

    public CardAdapter(List<CardItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        CardItem item = items.get(position % items.size());
        holder.imageView.setImageResource(item.imageRes);
        holder.descriptionView.setText(item.description);
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE; // Infinite looping
    }

    static class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView descriptionView;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.cardImage);
            descriptionView = itemView.findViewById(R.id.cardDescription);
        }
    }
}