package com.lacosina.api.Recipe.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeProcedureDTO {

    @Size(max = 1000)
    private String notes;

    @Min(value = 0)
    private Integer durationInSeconds;

    private Integer procedureId;
}
