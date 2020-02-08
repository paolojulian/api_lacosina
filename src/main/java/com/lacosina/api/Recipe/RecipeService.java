package com.lacosina.api.Recipe;

import com.lacosina.api.Ingredient.Ingredient;
import com.lacosina.api.Recipe.DTO.FullRecipeDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeIngredientRepository recipeIngredientRepository;

    @Transactional
    public Recipe createRecipe(FullRecipeDTO recipeDTO) {
        Recipe recipe = new Recipe();
        recipe.setName(recipeDTO.getName());
        recipe.setDescription(recipeDTO.getDescription());
        recipe.setDurationFrom_minutes(recipeDTO.getDurationFrom_minutes());
        recipe.setDurationTo_minutes(recipeDTO.getDurationTo_minutes());
        // TODO - Rework
        for (Integer ingredientId: recipeDTO.getIngredientIds()) {

            Ingredient ingredient = new Ingredient();
            ingredient.setId(ingredientId);

            RecipeIngredient recipeIngredient = new RecipeIngredient();
            recipeIngredient.setIngredient(ingredient);
            recipeIngredient.setMeasurement("Test");

            recipe.getIngredients().add(recipeIngredientRepository.save(recipeIngredient));

        }

        return this.recipeRepository.save(recipe);
    }

    @Transactional
    public Recipe updateRecipe(final int id, Recipe recipe) {
        Recipe recipeToUpdate = this.getRecipe(id);
        recipeToUpdate.setName(recipe.getName());
        recipeToUpdate.setDescription(recipe.getDescription());
        recipeToUpdate.setDurationFrom_minutes(recipe.getDurationFrom_minutes());
        recipeToUpdate.setDurationTo_minutes(recipe.getDurationTo_minutes());

        return this.recipeRepository.save(recipeToUpdate);
    }

    @Transactional
    public void deleteRecipe(final int id) {
        this.recipeRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Recipe getRecipe(final int id) {
        return this.recipeRepository.findById(id).orElseThrow();
    }

    @Transactional(readOnly = true)
    public List<Recipe> getAllRecipe() {
        return this.recipeRepository.findAll();
    }
}
