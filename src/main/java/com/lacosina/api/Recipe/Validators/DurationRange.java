package com.lacosina.api.Recipe.Validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = DurationRangeValidator.class)
public @interface DurationRange {

    String message() default "Enter a valid duration range";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
