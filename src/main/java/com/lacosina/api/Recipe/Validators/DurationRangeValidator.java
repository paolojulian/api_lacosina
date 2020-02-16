package com.lacosina.api.Recipe.Validators;

import com.lacosina.api.Recipe.DTO.RecipeDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DurationRangeValidator implements ConstraintValidator<DurationRange, RecipeDTO> {

    @Override
    public boolean isValid(RecipeDTO dto, ConstraintValidatorContext constraintValidatorContext) {
        if (dto.getDurationFrom_minutes() == null || dto.getDurationTo_minutes() == null) {
            return true;
        }
        return dto.getDurationFrom_minutes() < dto.getDurationTo_minutes();
    }
}
