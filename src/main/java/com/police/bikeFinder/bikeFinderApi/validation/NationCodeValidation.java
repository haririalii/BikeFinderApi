package com.police.bikeFinder.bikeFinderApi.validation;


import com.police.bikeFinder.bikeFinderApi.validation.Impl.NationCodeValidationImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = NationCodeValidationImpl.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NationCodeValidation {
    public String message() default "Invalid NationCode";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
