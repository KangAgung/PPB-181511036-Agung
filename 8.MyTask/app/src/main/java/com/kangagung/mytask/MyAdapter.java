package com.kangagung.mytask;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Task[] mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public ConstraintLayout constraintLayout;
        public MyViewHolder(ConstraintLayout v){
            super(v);
            constraintLayout = v;
        }
    }

    public MyAdapter(Task[] myDataset){
        mDataset = myDataset;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        Log.d("Parent", parent.toString());
        ConstraintLayout v = (ConstraintLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        CheckBox task = (CheckBox)  holder.constraintLayout.getViewById(R.id.checkBox);
        task.setText(mDataset[position].getName());
    }

    @Override
    public int getItemCount(){
        return mDataset.length;
    }
}
