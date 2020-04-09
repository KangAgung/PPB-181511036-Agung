package com.example.aplikasiuntukuts.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aplikasiuntukuts.data.Cheese;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CheeseAdapter extends RecyclerView.Adapter<CheeseAdapter.ViewHolder> {
    private List<Cheese> mCheese;

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (mCheese.get(position ) != null) {
            holder.mText.setText(mCheese.get(position).getName());
        }
    }

    @Override
    public int getItemCount() {
        return mCheese == null ? 0 : mCheese.size();
    }


    public void setCheeses(List<Cheese> cheeses) {
        mCheese = cheeses;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView mText;

        ViewHolder(ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(
                    android.R.layout.simple_list_item_1, parent, false));
            mText = itemView.findViewById(android.R.id.text1);
        }

    }
}
