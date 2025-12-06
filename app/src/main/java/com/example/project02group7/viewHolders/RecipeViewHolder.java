package com.example.project02group7.viewHolders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project02group7.R;

public class RecipeViewHolder extends RecyclerView.ViewHolder {
    private final TextView recipeViewItem;
    private RecipeViewHolder(@NonNull View recipeView) {
        super(recipeView);
        recipeViewItem = recipeView.findViewById(R.id.parentRecyclerView);
    }

    /**
     * Description: A method to set the text of a view holder (I think).
     * @param text a String
     */
    public void bind(String text) {
        recipeViewItem.setText(text);
    }

    static RecipeViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_recycler_item, parent, false);
        return new RecipeViewHolder(view);
    }
}
