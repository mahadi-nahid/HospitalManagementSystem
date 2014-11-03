package com.sust.doc_staff;

import java.util.Date;

/**
 *
 * @author MAHADI HASAN NAHID
 */
public class Doctor {

    private int d_id;
    private String firstName;
    private String lastName;
    private String sex;
    private String dateOfBirth;
    //private Date dateOfBirth;
    private String dept;
    private String address;
    private String degree;
    private int salary;
    private int mob;

    public Doctor(int d_id, String firstName, String lastName, String sex,
            String dateOfBirth, String dept, String address, String degree,
            int salary, int mob) {
        this.d_id = d_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.dept = dept;
        this.address = address;
        this.degree = degree;
        this.salary = salary;
        this.mob = mob;
    }

    public int getDoctorId() {
        return d_id;
    }

    public String getDoctorFirstName() {
        return firstName;
    }

    public String getDoctorLastName() {
        return lastName;
    }

    public String getDoctorSex() {
        return sex;
    }

    public String getDoctorDOB() {
        return dateOfBirth;
    }

    public String getDoctorDept() {
        return dept;
    }

    public String getDoctorAddress() {
        return address;
    }

    public String getDoctorDegree() {
        return degree;
    }

    public int getDoctorSalary() {
        return salary;
    }

    public int getDoctorMob() {
        return mob;
    }
}
