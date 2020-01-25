package com.lacosina.api.Recipe;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.lacosina.api.User.User;
import com.lacosina.api.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class RecipeQuery implements GraphQLQueryResolver {

    @Autowired
    private RecipeService recipeService;

    public Recipe getRecipe(final Integer id) {
        return this.recipeService.getRecipe(id);
    }
}
