package com.lacosina.api.Recipe;

import com.lacosina.api.Ingredient.Ingredient;
import com.lacosina.api.Ingredient.IngredientRepository;
import com.lacosina.api.Recipe.DTO.FullRecipeDTO;
import com.lacosina.api.Recipe.DTO.RecipeIngredientDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeIngredientRepository recipeIngredientRepository;
    private final IngredientRepository ingredientRepository;

    /**
     * Creates a recipe
     * @param recipeDTO - The request data
     *
     * @return Recipe
     */
    @Transactional
    public Recipe createRecipe(FullRecipeDTO recipeDTO) {
        // Set the recipes
        Recipe recipe = new Recipe();
        recipe.setName(recipeDTO.getName());
        recipe.setDescription(recipeDTO.getDescription());
        recipe.setDurationFrom_minutes(recipeDTO.getDurationFrom_minutes());
        recipe.setDurationTo_minutes(recipeDTO.getDurationTo_minutes());

        return this.recipeRepository.save(this.updateRecipeIngredients(recipe, recipeDTO.getRecipeIngredients()));
    }

    /**
     * Updates a recipe
     * @param id - Recipe to be updated
     * @param recipe - The new recipe
     * @return Recipe
     */
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
    public Recipe updateRecipeIngredients(Recipe recipe, Set<RecipeIngredientDTO> recipeIngredientDTOSet) {
        // Set the ingredients
        Set<RecipeIngredient> recipeIngredientSet = new HashSet<RecipeIngredient>();
        for (RecipeIngredientDTO recipeIngredientDTO: recipeIngredientDTOSet) {
            // Fetch the ingredient if it exists
            Ingredient ingredient = ingredientRepository.findById(recipeIngredientDTO.getIngredientId()).orElseThrow();
            // Set the values
            RecipeIngredient recipeIngredient = new RecipeIngredient();
            recipeIngredient.setMeasurement(recipeIngredientDTO.getMeasurement());
            recipeIngredient.setIngredient(ingredient);
            // Save and add the recipeIngredient
            recipeIngredientSet.add(recipeIngredientRepository.save(recipeIngredient));
        }
        recipe.setIngredients(recipeIngredientSet);

        return recipe;
    }

    /**
     * Deletes a recipe
     * @param id - Recipe to be deleted
     */
    @Transactional
    public void deleteRecipe(final int id) {
        this.recipeRepository.deleteById(id);
    }

    /**
     * Fetches the recipe by its id
     * @param id - The recipe to be fetched
     * @return Recipe
     */
    @Transactional(readOnly = true)
    public Recipe getRecipe(final int id) {
        return this.recipeRepository.findById(id).orElseThrow();
    }

    /**
     * TODO - Add pagination
     * Fetches all the recipes
     * @return List of recipes
     */
    @Transactional(readOnly = true)
    public List<Recipe> getAllRecipe() {
        return this.recipeRepository.findAll();
    }
}
