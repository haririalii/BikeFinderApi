package com.police.bikeFinder.bikeFinderApi.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = NationCodeValidation.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NationCodeAnno {
    public String message() default "invalid Number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
