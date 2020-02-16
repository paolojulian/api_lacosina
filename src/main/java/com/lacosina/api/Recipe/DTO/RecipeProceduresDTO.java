package com.lacosina.api.Recipe.DTO;

import com.lacosina.api.Recipe.RecipeProcedure;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeProceduresDTO {
    private Set<RecipeProcedure> procedures;
}
