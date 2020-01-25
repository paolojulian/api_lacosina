package com.lacosina.api.Recipe.DTO;

import com.lacosina.api.Recipe.Recipe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasicRecipeInput {
    private String name;
    private String description;
    private Long durationFrom;
    private Long durationTo;

    public Recipe toRecipe() {
        return new Recipe(
                this.name,
                this.description,
                this.durationFrom,
                this.durationTo
        );
    }
}
