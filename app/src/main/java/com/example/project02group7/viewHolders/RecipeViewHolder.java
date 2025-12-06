package com.example.project02group7.viewHolders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project02group7.R;
import com.example.project02group7.database.entities.Recipe;

public class RecipeViewHolder extends RecyclerView.ViewHolder {
    private final TextView titleViewItem;
    private final TextView ingredientViewItem;
    private final TextView instructionsViewItem;
    private RecipeViewHolder(@NonNull View recipeView) {
        super(recipeView);
        titleViewItem = recipeView.findViewById(R.id.titleRecipeReyclerTextView);
        ingredientViewItem = recipeView.findViewById(R.id.ingredientsRecipeRecyclerTextView);
        instructionsViewItem = recipeView.findViewById(R.id.instructionsRecipeRecyclerTextView);
    }

    /**
     * Description: A method to set the text of a textviews in a recycler.
     * @param recipe a String
     */
    public void bind(Recipe recipe) {
        titleViewItem.setText(recipe.getTitle());
        ingredientViewItem.setText(recipe.getIngredients());
        instructionsViewItem.setText(recipe.getInstructions());
    }

    static RecipeViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_recycler_item, parent, false);
        return new RecipeViewHolder(view);
    }
}
