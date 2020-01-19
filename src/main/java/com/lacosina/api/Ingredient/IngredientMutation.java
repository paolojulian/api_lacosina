package com.lacosina.api.Ingredient;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IngredientMutation implements GraphQLMutationResolver {

    @Autowired
    private IngredientService ingredientService;

    public Ingredient createIngredient(final String name, final String description, final String category) {
        return this.ingredientService.createIngredient(name,description,category);
    }

    public Ingredient createIngredient(final String name, final String description) {
        //optional category
        return this.ingredientService.createIngredient(name,description,"");
    }

    public Ingredient updateIngredient(Integer id, Ingredient ingredient) {
        return this.ingredientService.updateIngredient(id, ingredient);
    }

    public Boolean deleteIngredient(Integer id) { return this.ingredientService.deleteIngredient(id); }
}
