package com.sust.patient;

/**
 *
 * @author MAHADI HASAN NAHID
 */
public class IndoorPatient {

    private int p_id;
    private String firstName;
    private String lastName;
    private String sex;
    private int age;
    private String dept;
    private String address;
    private int mob;
    private int bed;
    private String relFirstName;
    private String relLastName;
    private String relAddress;
    private int relMob;
    private String admissionDate;
    private String releaseDate;
    private String disease;

    //private int d_id;
    public IndoorPatient(int p_id, String firstName, String lastName,
            String sex, int age, String dept, String address, int mob,
            int bed, String relFirstName, String relLastName, String relAddress,
            int relMob, String admissionDate,
            String releaseDate, String disease) {

        this.p_id = p_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
        this.dept = dept;
        this.address = address;
        this.mob = mob;
        this.bed = bed;

        this.relFirstName = relFirstName;
        this.relLastName = relLastName;
        this.relAddress = relAddress;
        this.relMob = relMob;

        this.admissionDate = admissionDate;
        this.releaseDate = releaseDate;
        this.disease = disease;
        //this.d_id = d_id;
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

    public int getPatientBedId() {
        return bed;
    }

    public String getRelativeFirstName() {
        return relFirstName;
    }

    public String getRelativeLastname() {
        return relLastName;
    }

    public String getRelativeAddress() {
        return relAddress;
    }

    public int getrelativeMob() {
        return relMob;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public String getPatientDisease() {
        return disease;
    }
    // public int getPatientDoctorId(){
    //    return d_id;
    // }
}
