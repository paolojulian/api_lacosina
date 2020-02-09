package com.lacosina.api.Recipe;

import com.lacosina.api.Ingredient.Ingredient;
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

    @Transactional
    public Recipe createRecipe(FullRecipeDTO recipeDTO) {
        Recipe recipe = new Recipe();
        recipe.setName(recipeDTO.getName());
        recipe.setDescription(recipeDTO.getDescription());
        recipe.setDurationFrom_minutes(recipeDTO.getDurationFrom_minutes());
        recipe.setDurationTo_minutes(recipeDTO.getDurationTo_minutes());

        Set<RecipeIngredient> recipeIngredientSet = new HashSet<RecipeIngredient>();

        // TODO - Rework
        for (RecipeIngredientDTO recipeIngredientDTO: recipeDTO.getRecipeIngredients()) {
            RecipeIngredient recipeIngredient = new RecipeIngredient();
            recipeIngredient.setMeasurement(recipeIngredientDTO.getMeasurement());
            Ingredient ingredient = new Ingredient(recipeIngredientDTO.getIngredientId());
            recipeIngredient.setIngredient(ingredient);

            recipeIngredientSet.add(recipeIngredientRepository.save(recipeIngredient));
        }

        recipe.setIngredients(recipeIngredientSet);

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
