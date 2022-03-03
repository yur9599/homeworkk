package com.company.homework5.task2.taxAccounting;

import com.company.homework5.task2.accounting.Accounting;

public class TaxAccounting extends Accounting {

    private int countOfEmployers;
    private String departmentName;

    public TaxAccounting(){
        this.departmentName=super.getDepartmentName();
    }

    public TaxAccounting(int countOfEmployers,String departmentName){
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
