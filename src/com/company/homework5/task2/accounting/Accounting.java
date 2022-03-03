package com.company.homework5.task2.accounting;

public class Accounting {

    private int countOfEmployers;
    private String departmentName;

    public Accounting(){
        this.departmentName="Isn`t defined";
    }

    public Accounting(int countOfEmployers,String departmentName){
        this.countOfEmployers=countOfEmployers;
        this.departmentName=departmentName;
    }

    public void account(){
        System.out.println("Accounting");
    }

    public int getCountOfEmployers() {
        return countOfEmployers;
    }

    public void setCountOfEmployers(int countOfEmployers) {
        this.countOfEmployers = countOfEmployers;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Accounting{" +
                "countOfEmployers=" + countOfEmployers +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
