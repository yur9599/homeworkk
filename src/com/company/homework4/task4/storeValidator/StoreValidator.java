package com.company.homework4.task4.storeValidator;

import static com.company.homework1.Strings.*;

public class StoreValidator {

    private StoreValidator(){}

    public static boolean isValidCountofWorkers(int countOfWorkers) {
        return (countOfWorkers>=2 && countOfWorkers<=50);
    }

    public static boolean isVAlidName(String name) {
        return name != null && name.length() >= 3 && !isNumber(name);
    }

    public static boolean isValidPhoneNum(String phoneNum) {
        return phoneNum != null && phoneNum.length() == 8 && isNumber(phoneNum);
    }

}
