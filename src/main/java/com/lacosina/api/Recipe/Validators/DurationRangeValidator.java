package com.lacosina.api.Recipe.Validators;

import com.lacosina.api.Recipe.DTO.FullRecipeDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DurationRangeValidator implements ConstraintValidator<DurationRange, FullRecipeDTO> {

    @Override
    public boolean isValid(FullRecipeDTO dto, ConstraintValidatorContext constraintValidatorContext) {
        if (dto.getDurationFrom_minutes() == null || dto.getDurationTo_minutes() == null) {
            return true;
        }
        return dto.getDurationFrom_minutes() < dto.getDurationTo_minutes();
    }
}
