package com.company.homework4.task1_2.personValidator;

import static com.company.homework1.Strings.isNumber;

public final class PersonValidator {

    private PersonValidator(){}

    public static boolean isValidName(String name) {
        if (name==null || name.length()==0){
            return false;
        }
        if (name.length()>=3 && name.length()<=15){
            return true;
        }
        return false;
    }

    public static boolean isValidSurName(String surName) {
        if (surName==null || surName.length()==0){
            return false;
        }
        if (surName.length()>=6 && surName.length()<=20){
            return true;
        }
        return false;
    }

    public static boolean isValidPassportId(String id) {
        if (id==null || id.length()==0 || id.length()>8){
            return false;
        }
        if (id.substring(0,2).equals("AN") && isNumber(id.substring(2))){
            return true;
        }
        return false;
    }

    public static boolean isValidAge(int age) {
        return (age>=18) && (age<=99) ;
    }

    public static boolean isValidGender(String gender) {
        if ("male".compareToIgnoreCase(gender)==0 || "female".compareToIgnoreCase(gender)==0){
            return true;
        }
        return false;
    }

}
