package com.lacosina.api.Recipe;

import com.lacosina.api.Recipe.DTO.FullRecipeDTO;
import com.lacosina.api.Recipe.DTO.RecipeIngredientSetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping
    public List<Recipe> getAllRecipe() {
        return this.recipeService.getAllRecipe();
    }

    @PostMapping
    public Recipe createRecipe(@Valid @RequestBody FullRecipeDTO recipe) {
        return this.recipeService.createRecipe(recipe);
    }

    @GetMapping("/{id}")
    public Recipe getRecipe(@PathVariable int id) {
        return this.recipeService.getRecipe(id);
    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@PathVariable int id, @RequestBody Recipe recipe) {
        return this.recipeService.updateRecipe(id, recipe);
    }

    /**
     * Updates the ingredients of the given recipe
     * @param id - Recipe.id
     */
    @PutMapping("/{id}/recipe-ingredients")
    public Recipe updateRecipeIngredients(
            @PathVariable int id,
            @RequestBody RecipeIngredientSetDTO recipeIngredientSetDTO
    ) {
        Recipe recipe = this.recipeService.getRecipe(id);
        return this.recipeService.updateRecipeIngredients(recipe, recipeIngredientSetDTO.getRecipeIngredients());
    }

    /**
     * Delete a recipe
     * @param id - Recipe id
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRecipe(@PathVariable int id) {
        this.recipeService.deleteRecipe(id);
    }
}
