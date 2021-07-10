package com.example.noteapp.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.noteapp.R;
import com.example.noteapp.ui.model.TaskModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    ArrayList<TaskModel> list = new ArrayList<>();

    public void addModel(TaskModel model) {
        list.add(model);
        notifyDataSetChanged();//этот метод будет обновлять лист

    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        holder.onBind(list.get(position));

    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, description;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_title);
            description = itemView.findViewById(R.id.item_description);
        }

        public void onBind(TaskModel taskModel) {
            title.setText(taskModel.getTitle());
            description.setText(taskModel.getDescription());

        }
    }
}
