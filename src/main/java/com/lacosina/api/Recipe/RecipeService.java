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
}
