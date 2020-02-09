package com.lacosina.api.Recipe.DTO;

import com.lacosina.api.Ingredient.Ingredient;
import com.lacosina.api.Recipe.RecipeIngredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeIngredientDTO {

    @Size(max = 30)
    private String measurement;

    private Integer ingredientId;

    /**
     * Converts the fields into a RecipeIngredient class
     * @return RecipeIngredient
     */
    public RecipeIngredient toRecipeIngredient() {
        RecipeIngredient recipeIngredient = new RecipeIngredient();
        recipeIngredient.setMeasurement(this.measurement);
        recipeIngredient.setIngredient(new Ingredient(this.ingredientId));

        return recipeIngredient;
    }
}
