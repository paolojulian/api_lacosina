package com.lacosina.api.Recipe;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.lacosina.api.Recipe.DTO.BasicRecipeInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecipeMutation implements GraphQLMutationResolver {

    @Autowired
    private RecipeService recipeService;

    public Recipe createRecipe(BasicRecipeInput input) {
        return this.recipeService.createRecipe(input.toRecipe());
    }
}
