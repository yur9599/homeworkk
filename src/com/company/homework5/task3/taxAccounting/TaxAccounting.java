package com.company.homework5.task3.taxAccounting;


import com.company.homework5.task3.accounting.Accounting;

public class TaxAccounting extends Accounting {

    public TaxAccounting(){}

    public TaxAccounting(int countOfEmployers, String departmentName) {
        super(countOfEmployers,departmentName);
    }

    @Override
    public void account(){
        System.out.println("Calculating tax of company");
    }

    @Override
    public String toString() {
        return "TaxAccounting{" +
                "countOfEmployers=" + countOfEmployers +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }

}
