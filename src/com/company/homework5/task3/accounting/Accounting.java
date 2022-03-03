package com.company.homework5.task3.accounting;

import com.company.homework5.task3.itCompany.ItCompany;

public class Accounting extends ItCompany {

    protected int countOfEmployers;
    protected String departmentName;

    public Accounting(){
        this.departmentName="Isn`t defined";
    }

    public Accounting(int countOfEmployers, String departmentName) {
        this.countOfEmployers = countOfEmployers;
        this.departmentName = departmentName;
    }

    @Override
    public void account(){
        System.out.println("Accounting");
    }

    @Override
    public String toString() {
        return "Accounting{" +
                "countOfEmployers=" + countOfEmployers +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
