package com.lacosina.api.Recipe;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

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
    public Recipe updateRecipe(final Integer id, Recipe recipe) {
        Recipe recipeToUpdate = this.getRecipe(id);
        recipeToUpdate.setName(recipe.getName());
        recipeToUpdate.setDescription(recipe.getDescription());
        recipeToUpdate.setDurationFrom(recipe.getDurationFrom());
        recipeToUpdate.setDurationTo(recipe.getDurationTo());
        return this.recipeRepository.save(recipeToUpdate);
    }

    @Transactional
    public void deleteRecipe(final Integer id) {
        this.recipeRepository.deleteById(id);
    }

    @Transactional
    public Recipe getRecipe(final Integer id) {
        return this.recipeRepository.findById(id).orElseThrow();
    }
}
