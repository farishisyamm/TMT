package com.sgedts.employee.bean;

import java.text.DecimalFormat;

public class EmployeeListResponseBean {
    private long id;
    private String name;
    private String position;
    private Double salary;

    public EmployeeListResponseBean(long id, String name, String position, Double salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }
    public String getFormattedSalary() {
        DecimalFormat df = new DecimalFormat("#,###.00");
        return df.format(salary);
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
