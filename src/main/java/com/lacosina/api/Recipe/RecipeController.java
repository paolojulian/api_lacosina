package com.lacosina.api.Recipe;

import com.lacosina.api.Recipe.DTO.RecipeDTO;
import com.lacosina.api.Recipe.DTO.RecipeIngredientSetDTO;
import org.modelmapper.ModelMapper;
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

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<Recipe> getAllRecipe() {
        return this.recipeService.getAllRecipe();
    }

    @PostMapping
    public Recipe createRecipe(@Valid @RequestBody RecipeDTO recipeDTO) {
        Recipe recipe = convertToEntity(recipeDTO);
        return recipeService.createRecipe(recipe);
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

    /**
     * Converts RecipeDTO into a Recipe Entity
     * @param recipeDTO - The Data transfer object of recipe
     * @return Converted recipe (With Procedures and Ingredients)
     */
    private Recipe convertToEntity(RecipeDTO recipeDTO) {
        Recipe recipe = modelMapper.map(recipeDTO, Recipe.class);
        return recipe;
    }
}
