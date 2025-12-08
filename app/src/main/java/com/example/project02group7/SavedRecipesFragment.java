package com.example.project02group7;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project02group7.viewHolders.recipesPage.UserLikedRecipesViewModel;
import com.example.project02group7.viewHolders.recipesPage.UserSavedRecipesAdapter;
import com.example.project02group7.viewHolders.recipesPage.UserSavedRecipesViewModel;

import java.util.ArrayList;

public class SavedRecipesFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate layout for fragment
        View view = inflater.inflate(R.layout.fragment_saved_recipes, container, false);

        SharedPreferences sharedPreferences = requireContext().getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        int userId = sharedPreferences.getInt(getString(R.string.preference_userId_key), -1);

        // Instantiate VM
        UserSavedRecipesViewModel recipeViewModel = new ViewModelProvider(this).get(UserSavedRecipesViewModel.class);

        // Find recycler view
        RecyclerView recyclerView = view.findViewById(R.id.savedRecipesRecyclerView);

        // check if recyclerView exists
        if (recyclerView == null) {
            return view;
        }

        // set adapter & layout manager
        final UserSavedRecipesAdapter adapter = new UserSavedRecipesAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // observe VM
        recipeViewModel.getSavedRecipesByUserId(userId).observe(getViewLifecycleOwner(), recipes -> {
            adapter.setRecipes(recipes);
        });

        return view;
    }
}