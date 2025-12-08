package com.example.project02group7;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project02group7.viewHolders.recipesPage.UserLikedRecipesAdapter;
import com.example.project02group7.viewHolders.recipesPage.UserLikedRecipesViewModel;

import java.util.ArrayList;

public class LikedRecipesFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate layout for fragment
        View view = inflater.inflate(R.layout.fragment_liked_recipes, container, false);

        // Instantiate VM
        UserLikedRecipesViewModel recipeViewModel = new ViewModelProvider(this).get(UserLikedRecipesViewModel.class);

        // Find recycler view
        RecyclerView recyclerView = view.findViewById(R.id.likedRecipesRecyclerView);
        final UserLikedRecipesAdapter adapter = new UserLikedRecipesAdapter(new ArrayList<>());

        // set adapter & layout manager
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // observe VM
        recipeViewModel.getListOfAllLikedRecipes().observe(getViewLifecycleOwner(), recipes -> {
            adapter.setRecipes(recipes);
        });

        return view;
    }
}