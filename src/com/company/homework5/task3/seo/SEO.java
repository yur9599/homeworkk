package com.company.homework5.task3.seo;

import com.company.homework5.task3.marketing.Marketing;

public class SEO extends Marketing {

    public SEO() {}

    public SEO(int countOfEmployers, String departmentName) {
        super(countOfEmployers, departmentName);
    }

    @Override
    public void marketing(){
        System.out.println("Search Engine Optimization");
    }

    @Override
    public String toString() {
        return "SEO{" +
                "countOfEmployers=" + countOfEmployers +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
