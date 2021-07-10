package com.example.noteapp.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.noteapp.R;
import com.example.noteapp.databinding.FragmentFormBinding;
import com.example.noteapp.databinding.FragmentHomeBinding;
import com.example.noteapp.ui.model.TaskModel;

import org.jetbrains.annotations.NotNull;


public class FormFragment extends Fragment {

    @NonNull
    FragmentFormBinding binding;
    TaskModel model;
    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFormBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        // initClickListener(navController);
        return root;
    }

//    private void initClickListener(NavController navController) {
//        //  model = new TaskModel("Information", "Loren Ipsum to vechile");
//        binding.btnSave.setOnClickListener(v -> {
//            save();
//            navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main);
//            navController.navigateUp();
//
//
//        });
//    }


    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
    }

    private void save() {
        String title2 = binding.etTitle.getText().toString();
        String description2 = binding.etDescription.getText().toString();
        model = new TaskModel(title2, description2);
        Bundle bundle = new Bundle();
        bundle.putSerializable("key", model);
        getParentFragmentManager().setFragmentResult("task", bundle);
        Log.e("TAG", "save: " + model.getTitle() + model.getDescription());
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main);
        navController.navigateUp();
    }


}