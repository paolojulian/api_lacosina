package com.lacosina.api.Recipe;

import com.lacosina.api.Recipe.DTO.FullRecipeDTO;
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

//    @PostMapping
//    public Recipe createRecipe(@Valid @RequestBody Recipe recipe) {
//        return this.recipeService.createRecipe(recipe);
//    }
//
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

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRecipe(@PathVariable int id) {
        this.recipeService.deleteRecipe(id);
    }
}
