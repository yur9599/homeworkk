package com.company.homework5.task3.marketing;

import com.company.homework5.task3.itCompany.ItCompany;

public class Marketing extends ItCompany {

    protected int countOfEmployers;
    protected String departmentName;

    public Marketing(){
        this.departmentName="Isn`t defined";
    }

    public Marketing(int countOfEmployers,String departmentName){
        this.countOfEmployers=countOfEmployers;
        this.departmentName=departmentName;
    }

    public void marketing() {
        System.out.println("Marketing");
    }

    @Override
    public String toString() {
        return "Marketing{" +
                "countOfEmployers=" + countOfEmployers +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }

}
