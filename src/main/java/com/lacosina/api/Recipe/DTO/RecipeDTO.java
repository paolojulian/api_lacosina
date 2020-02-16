package com.lacosina.api.Recipe.DTO;

import com.lacosina.api.Recipe.RecipeIngredient;
import com.lacosina.api.Recipe.RecipeProcedure;
import com.lacosina.api.Recipe.Validators.DurationRange;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DurationRange
public class RecipeDTO {

    @NotNull(message = "Please enter a name for the recipe.")
    @Size(min = 1, max = 30)
    private String name;

    @Size(max = 1000)
    private String description;

    @Min(value = 0)
    private Long durationFrom_minutes;

    @Min(value = 0)
    private Long durationTo_minutes;

    private Set<RecipeIngredient> ingredients;

    private Set<RecipeProcedure> procedures;
}
