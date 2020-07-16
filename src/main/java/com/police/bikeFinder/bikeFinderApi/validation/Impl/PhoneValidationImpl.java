package com.police.bikeFinder.bikeFinderApi.validation.Impl;

import com.police.bikeFinder.bikeFinderApi.validation.NationCodeValidation;
import com.police.bikeFinder.bikeFinderApi.validation.PhoneValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidationImpl implements ConstraintValidator<PhoneValidation,String > {


    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return (s.length() == 11) && (s.charAt(0) == '0');
    }
}
