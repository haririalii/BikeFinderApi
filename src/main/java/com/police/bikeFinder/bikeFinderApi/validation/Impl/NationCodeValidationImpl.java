package com.police.bikeFinder.bikeFinderApi.validation.Impl;

import com.police.bikeFinder.bikeFinderApi.validation.NationCodeValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class NationCodeValidationImpl implements ConstraintValidator<com.police.bikeFinder.bikeFinderApi.validation.NationCodeValidation,String > {


    @Override
    public void initialize(com.police.bikeFinder.bikeFinderApi.validation.NationCodeValidation constraintAnnotation) {
//        String nationCode = constraintAnnotation

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        char[] c = s.toCharArray();
        int sum = 0;
        if (s.length() == 10) {
            for (int i = 10; i > 0; i--) {
                int j = Math.abs(10 - i);
                int k = Integer.parseInt(s.substring(j, j + 1));
                if (i != 1)
                    sum += k * i;
            }
            int b = sum % 11;
            if (b < 2) {
                return Integer.parseInt(s.substring(9)) ==  b;
            } else {
                return Integer.parseInt(s.substring(9)) == (11 - b);
            }
        }
        else return false;

    }
}
