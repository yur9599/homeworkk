package com.company.homework5.task3.smm;

import com.company.homework5.task3.marketing.Marketing;

public class SMM extends Marketing {

    public SMM() {}

    public SMM(int countOfEmployers, String departmentName) {
        super(countOfEmployers, departmentName);
    }

    @Override
    public void marketing() {
        System.out.println("Social Media Marketing");
    }

    @Override
    public String toString() {
        return "SMM{" +
                "countOfEmployers=" + countOfEmployers +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
