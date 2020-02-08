package com.lacosina.api.Recipe.DTO;

import com.lacosina.api.Recipe.Recipe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullRecipeDTO {
    private String name;
    private String description;
    private Long durationFrom_minutes;
    private Long durationTo_minutes;
    private Set<Integer> ingredientIds;
    private Integer userId;
}
