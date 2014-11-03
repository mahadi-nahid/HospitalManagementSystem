package com.sust.doc_staff;

import java.util.Date;

/**
 *
 * @author MAHADI HASAN NAHID
 */
public class Staff {

    private int s_id;
    private String firstName;
    private String lastName;
    private String sex;
    private int age;
    private String dept;
    private String address;
    private int salary;
    private int mob;

    public Staff(int s_id, String firstName, String lastName, String sex,
            int age, String dept, String addres,
            int salary, int mob) {
        this.s_id = s_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.dept = dept;
        this.salary = salary;
        this.mob = mob;
    }

    public int getStaffId() {
        return s_id;
    }

    public String getStaffFirstName() {
        return firstName;
    }

    public String getStaffLastName() {
        return lastName;
    }

    public String getStaffSex() {
        return sex;
    }

    public int getStaffAge() {
        return age;
    }

    public String getStaffDept() {
        return dept;
    }

    public String getStaffAddress() {
        return address;
    }

    public int getStaffSalary() {
        return salary;
    }

    public int getStaffMob() {
        return mob;
    }
}
