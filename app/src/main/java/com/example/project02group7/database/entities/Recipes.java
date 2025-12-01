package com.example.project02group7.database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.project02group7.database.RecipeDatabase;

import java.util.Objects;

@Entity(tableName = RecipeDatabase.RECIPE_TABLE)
public class Recipes {
    // Api will have:
    // 1: Instructions
    // 2: Ingredients
    // Need (maybe if we have time):
    // Prices of ingredients
    @PrimaryKey(autoGenerate = true) // generates unique ids when something is added
    private int id;
    private String instructions;
    private String ingredients;

    public Recipes() {
        // don't want to be able to change these outside of the db
        instructions = "";
        ingredients = "";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Recipes recipes = (Recipes) o;
        return id == recipes.id && Objects.equals(instructions, recipes.instructions) && Objects.equals(ingredients, recipes.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, instructions, ingredients);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}
