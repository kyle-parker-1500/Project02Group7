package com.example.project02group7;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class AdminFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_admin, container, false);

        Button manageRecipesButton = view.findViewById(R.id.manageRecipesButton);
        Button viewUsersButton = view.findViewById(R.id.viewUsersButton);
        Button removeUsersButton = view.findViewById(R.id.removeUsersButton);

        manageRecipesButton.setOnClickListener(v ->{
            // TODO: open RecipeManager or Activity
            Toast.makeText(requireContext(), "It works!", Toast.LENGTH_SHORT).show();
        });

        viewUsersButton.setOnClickListener(v ->{
            // TODO: Open ViewUsersFragment or Activity
            Toast.makeText(requireContext(), "It works too!", Toast.LENGTH_SHORT).show();
        });

        removeUsersButton.setOnClickListener(v ->{
            // TODO: Open remove users from app
            Toast.makeText(requireContext(), "It also works!", Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}