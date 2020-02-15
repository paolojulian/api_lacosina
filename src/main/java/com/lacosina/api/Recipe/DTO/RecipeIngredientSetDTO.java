package com.lacosina.api.Recipe.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeIngredientSetDTO {
    public Set<RecipeIngredientDTO> recipeIngredients;
}
