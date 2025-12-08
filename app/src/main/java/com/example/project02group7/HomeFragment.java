package com.example.project02group7;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project02group7.database.entities.Recipe;
import com.example.project02group7.databinding.ActivityMainBinding;
import com.example.project02group7.viewHolders.RecipeAdapter;
import com.example.project02group7.viewHolders.RecipeViewModel;

import java.util.Random;

public class HomeFragment extends Fragment {

    private static final String PREF_RANDOM_RECIPE_ID =
            "com.example.project02group7.PREF_RANDOM_RECIPE_ID";
    private ActivityMainBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate layout for fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // instantiate view model
        RecipeViewModel recipeViewModel = new ViewModelProvider(this).get(RecipeViewModel.class);

        // find recycler view
        RecyclerView outerRecyclerView = view.findViewById(R.id.parentRecyclerView);
        final RecipeAdapter adapter = new RecipeAdapter(new RecipeAdapter.RecipeDiff());

        // set adapter & layout manager
        outerRecyclerView.setAdapter(adapter);
        outerRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // adds vertical scrolling animations
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(outerRecyclerView);

        SharedPreferences sharedPreferences = requireContext().getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE
        );

        // observe view model
        // replaced this -> getViewLifecycleOwner()
        recipeViewModel.getListOfAllRecipes().observe(getViewLifecycleOwner(), recipes -> {
            adapter.submitList(recipes);

            int savedRecipeId = sharedPreferences.getInt(PREF_RANDOM_RECIPE_ID, -1);
            int indexToShow = -1;

            if(savedRecipeId != -1){
                for(int i = 0; i < recipes.size(); i++){
                    Recipe r = recipes.get(i);
                    if (r.getId() == savedRecipeId) {
                        indexToShow = i;
                        break;
                    }
                }
            }

            if(indexToShow == -1){
                Random random = new Random();
                indexToShow = random.nextInt(recipes.size());
                Recipe chosen = recipes.get(indexToShow);

                sharedPreferences.edit()
                        .putInt(PREF_RANDOM_RECIPE_ID, chosen.getId())
                        .apply();
            }

            outerRecyclerView.scrollToPosition(indexToShow);
        });

        return view;
    }
}