package com.lacosina.api.Recipe.DTO;

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
}
