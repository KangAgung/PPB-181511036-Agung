package com.kangagung.mytask.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.kangagung.mytask.R;
import com.kangagung.mytask.TaskViewModel;
import com.kangagung.mytask.data.Task;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {
    private List<Task> mDataset;
    private LayoutInflater layoutInflater;
    private TaskViewModel viewModel;

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public ConstraintLayout constraintLayout;
        public MyViewHolder(ConstraintLayout v){
            super(v);
            constraintLayout = v;
        }
    }

    public TaskAdapter(Context context){
        layoutInflater = LayoutInflater.from(context);
        viewModel = new ViewModelProvider((MainActivity)context).get(TaskViewModel.class);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        ConstraintLayout v = (ConstraintLayout) layoutInflater.inflate(R.layout.list_item, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        CheckBox task = (CheckBox)  holder.constraintLayout.getViewById(R.id.checkBox);
        TextView startDate = (TextView) holder.constraintLayout.getViewById(R.id.startDate);
        TextView endDate = (TextView) holder.constraintLayout.getViewById(R.id.endDate);

        if (mDataset != null) {
            Task current = mDataset.get(position);
            task.setText(current.getName());
            startDate.setText(new SimpleDateFormat("dd-MM-yy").format(current.getStartDateTimestamp()));
            endDate.setText(new SimpleDateFormat("dd-MM-yy").format(current.getEndDateTimestamp()));
            task.setChecked(current.isChecked());
        } else {
            task.setText("There is no Task");
        }

        final int pos = position;
        task.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mDataset.get(pos).setChecked(isChecked);
                viewModel.update(mDataset.get(pos));
            }
        });
    }

    public void setTasks(List<Task> tasks){
        Collections.sort(tasks);
        mDataset = tasks;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount(){
        if (mDataset!=null){
            return mDataset.size();
        }
        return 0;
    }
}
