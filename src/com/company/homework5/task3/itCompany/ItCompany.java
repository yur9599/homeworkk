package com.company.homework5.task3.itCompany;

public class ItCompany {

    protected int countOfEmployers;
    protected String companyName;

    public ItCompany(){
        this.companyName="Isn`t defined";
    }

    public ItCompany(int countOfEmployers,String companyName){
        this.countOfEmployers=countOfEmployers;
        this.companyName=companyName;
    }

    public void account(){
        System.out.println("Accounting");
    }

    @Override
    public String toString() {
        return "ItCompany{" +
                "countOfEmployers=" + countOfEmployers +
                ", companyName='" + companyName + '\'' +
                '}';
    }

}
