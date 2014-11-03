package com.sust.patient;

import java.util.Date;

/**
 *
 * @author MAHADI HASAN NAHID
 */
public class OutdoorPatient {

    private int p_id;
    private String firstName;
    private String lastName;
    private String sex;
    private int age;
    private String dept;
    private String address;
    private String doctor;
    private int mob;
    private String medicine;
    private Date admissionDate;

    public OutdoorPatient(int p_id, String firstName, String lastName,
            String sex, int age, String dept, String address, int mob,
            String doctor, String medicine, Date admissionDate) {

        this.p_id = p_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
        this.dept = dept;
        this.address = address;
        this.mob = mob;
        this.doctor = doctor;
        this.medicine = medicine;
        this.admissionDate = admissionDate;
    }

    public int getPatientId() {
        return p_id;
    }

    public String getPatientFirstNmae() {
        return firstName;
    }

    public String getpatientLastname() {
        return lastName;
    }

    public String getPatientSex() {
        return sex;
    }

    public int getPatientAge() {
        return age;
    }

    public String getPatientDept() {
        return dept;
    }

    public String getPatientAddress() {
        return address;
    }

    public int getPatientMob() {
        return mob;
    }

    public String getDoctorName() {
        return doctor;
    }

    public String getMedicine() {
        return medicine;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }
}
