package com.example.noteapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.example.noteapp.databinding.FragmentHomeBinding;
import com.example.noteapp.ui.model.TaskModel;

import org.jetbrains.annotations.NotNull;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new HomeAdapter();
        adapter.addModel(new TaskModel("Ташболотова", "Алина"));
        adapter.addModel(new TaskModel("Дюшебаев", "Эржан"));
        adapter.addModel(new TaskModel("Женишказиев", "Аслан"));

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        initRecycler();
        setResultLis();
        return binding.getRoot();
    }

    private void initRecycler() {
        // adapter = new HomeAdapter();
        binding.rvView.setAdapter(adapter);
//        adapter.addModel(new TaskModel("Ташболотова", "Алина"));
//        adapter.addModel(new TaskModel("Дюшебаев", "Эржан"));
//        adapter.addModel(new TaskModel("Женишказиев", "Аслан"));
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setResultLis() {
        getParentFragmentManager().setFragmentResultListener("task", getViewLifecycleOwner(), new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull @NotNull String requestKey, @NonNull @NotNull Bundle result) {
                TaskModel taskModel = (TaskModel) result.getSerializable("key");
                if (taskModel != null) {
                    adapter.addModel(taskModel);

                }

            }
        });
    }
}