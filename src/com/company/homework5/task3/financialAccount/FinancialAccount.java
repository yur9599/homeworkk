package com.company.homework5.task3.financialAccount;


import com.company.homework5.task3.taxAccounting.TaxAccounting;

public class FinancialAccount extends TaxAccounting {

    public FinancialAccount(){}

    public FinancialAccount(int countOfEmployers,String departmentName){
        super(countOfEmployers, departmentName);
    }

    @Override
    public void account(){
        System.out.println("Calculating salary of employers");
    }

    @Override
    public String toString() {
        return "FinancialAccount{" +
                "countOfEmployers=" +countOfEmployers +
                ", departmentName='" +departmentName + '\'' +
                '}';
    }

}
