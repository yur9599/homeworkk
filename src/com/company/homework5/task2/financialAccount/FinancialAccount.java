package com.company.homework5.task2.financialAccount;

import com.company.homework5.task2.taxAccounting.TaxAccounting;

public class FinancialAccount extends TaxAccounting {

    private int countOfEmployers;
    private String departmentName;

    public FinancialAccount(){
        this.departmentName=super.getDepartmentName();
    }

    public FinancialAccount(int countOfEmployers,String departmentName){
        this.countOfEmployers=countOfEmployers;
        this.departmentName=departmentName;
    }

    @Override
    public int getCountOfEmployers() {
        return countOfEmployers;
    }

    @Override
    public void setCountOfEmployers(int countOfEmployers) {
        this.countOfEmployers = countOfEmployers;
    }

    @Override
    public String getDepartmentName() {
        return departmentName;
    }

    @Override
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public void account(){
        System.out.println("Calculating salary of employers");
    }

    @Override
    public String toString() {
        return "FinancialAccount{" +
                "countOfEmployers=" + countOfEmployers +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }

}
