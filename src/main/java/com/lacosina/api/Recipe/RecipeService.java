package com.lacosina.api.Recipe;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Transactional
    public Recipe createRecipe(Recipe recipe) {
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

    @Transactional
    public Recipe getRecipe(final int id) {
        return this.recipeRepository.findById(id).orElseThrow();
    }
}
