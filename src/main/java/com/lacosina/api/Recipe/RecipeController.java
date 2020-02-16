package com.lacosina.api.Recipe;

import com.lacosina.api.Recipe.DTO.RecipeDTO;
import com.lacosina.api.Recipe.DTO.RecipeIngredientSetDTO;
import com.lacosina.api.Recipe.DTO.RecipeIngredientsDTO;
import com.lacosina.api.Recipe.DTO.RecipeProceduresDTO;
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

    @PutMapping("/{id}/procedures")
    public Recipe updateRecipeProcedures(
            @PathVariable final int id,
            @RequestBody RecipeProceduresDTO recipeProceduresDTO
    ) {
        return recipeService.updateRecipeProcedures(id, recipeProceduresDTO.getProcedures());
    }

    @PutMapping("/{id}/ingredients")
    public Recipe updateRecipeIngredients(
            @PathVariable int id,
            @RequestBody RecipeIngredientsDTO recipeIngredientsDTO
            ) {
        return this.recipeService.updateRecipeIngredients(id, recipeIngredientsDTO.getIngredients());
    }

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
