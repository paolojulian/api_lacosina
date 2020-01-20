package com.lacosina.api.Recipe;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecipeMutation implements GraphQLMutationResolver {

    @Autowired
    private RecipeService recipeService;

    public Recipe createRecipe(Recipe recipe) {
        return this.recipeService.createRecipe(recipe);
    }
}
