package com.sust.db;

import com.sust.bed.Bed;
import com.sust.doc_staff.Doctor;
import com.sust.doc_staff.Staff;
import com.sust.patient.IndoorPatient;
import com.sust.patient.OutdoorPatient;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author MAHADI HASAN NAHID
 */
public class DB {

    private String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private String USER_NAME = "medical";
    private String PASSWORD = "medical";
    private Connection connect;
    private Statement statement;
    private ResultSet result;

    public DB() {
        try {
            connect = null;
            statement = null;
            result = null;
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connect = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            statement = connect.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Can not connect to DB");
        }
    }

    public void close() {
        if (connect != null && statement != null && result != null) {
            try {
                connect.close();
                statement.close();
                result.close();
            } catch (SQLException ex) {
            }
        }
    }

    //------------------WRITE-----------------
    public void writeIndoorPatientInfo(IndoorPatient patient) {

        //----------OK---------------

        PreparedStatement ps;
        try {
            //-------------
            ps = connect.prepareStatement("insert into indoor_patient values(?,?,?,?,?,?,?)");

            ps.setInt(1, patient.getPatientId());
            ps.setString(2, patient.getPatientFirstNmae());
            ps.setString(3, patient.getpatientLastname());
            ps.setInt(4, patient.getPatientAge());
            ps.setString(5, patient.getPatientSex());
            ps.setString(6, patient.getPatientDept());
            ps.setString(7, patient.getPatientAddress());
            int rowAffected = ps.executeUpdate();
            System.out.println(rowAffected + " Row Affected");

            //----------------
            ps = connect.prepareStatement("insert into indoor_patient_phone values(?,?)");

            ps.setInt(1, patient.getPatientId());
            ps.setInt(2, patient.getPatientMob());

            ps.executeUpdate();

            //---------------------
            ps = connect.prepareStatement("insert into indoor_patient_relative values(?,?,?,?,?)");
            ps.setInt(1, patient.getPatientId());
            ps.setString(2, patient.getRelativeFirstName());
            ps.setString(3, patient.getRelativeLastname());
            ps.setString(4, patient.getRelativeAddress());
            ps.setInt(5, patient.getrelativeMob());
            ps.executeUpdate();

            //---------------------------
            ps = connect.prepareStatement("insert into indoor_patient_bed values(?,?)");
            ps.setInt(1, patient.getPatientId());
            ps.setInt(2, patient.getPatientBedId());
            ps.executeUpdate();

            //--------------------------
            ps = connect.prepareStatement("insert into patient_dates values(?,current_date,null)");
            ps.setInt(1, patient.getPatientId());
            ps.executeUpdate();

            //-------------------
            ps = connect.prepareStatement("update bed set is_available = 0 where b_id = " + patient.getPatientBedId() + "");
            ps.executeUpdate();
            //--------------
            ps = connect.prepareStatement("insert into indoor_patient_disease values(" + patient.getPatientId() + ",null,null)");

            ps.executeUpdate();
            //System.out.println(rowAffected + " Row Affected");
            //--------------------
            ps = connect.prepareStatement("insert into indoor_patient_doctor values(" + patient.getPatientId() + ",0)");
            ps.executeUpdate();


        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Input The Informations  Correctly");
        }



    }

    public void writeOutdoorPatientInfo(OutdoorPatient patient) {

        //--------------OK----------------

        PreparedStatement ps;
        try {
            ps = connect.prepareStatement("insert into outdoor_patient values(?,?,?,?,?,?,?,?,?,?,current_date)");

            ps.setInt(1, patient.getPatientId());
            ps.setString(2, patient.getPatientFirstNmae());

            ps.setString(3, patient.getPatientFirstNmae());
            ps.setInt(4, patient.getPatientAge());
            ps.setString(5, patient.getPatientSex());
            ps.setString(6, patient.getPatientDept());
            ps.setString(7, patient.getPatientAddress());
            ps.setInt(8, patient.getPatientMob());
            ps.setString(9, patient.getDoctorName());
            ps.setString(10, patient.getMedicine());

            ps.executeUpdate();
            //int rowAffected = ps.executeUpdate();
            //System.out.println(rowAffected + " Row Affected");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Input The Informations  Correctly");
        }
    }

    public void writeDoctorInfo(Doctor doctor) {


        //------------------OK----------------------
        PreparedStatement ps;

        try {
            //-----------------

            ps = connect.prepareStatement("insert into doctor values(?,?,?,?,?,?,?,?,to_date('" + doctor.getDoctorDOB() + "','dd-mon-yyyy'))");
            ps.setInt(1, doctor.getDoctorId());
            ps.setString(2, doctor.getDoctorFirstName());
            ps.setString(3, doctor.getDoctorLastName());
            ps.setString(4, doctor.getDoctorSex());
            //ps.setDate(5, doctor.getDoctorDOB());
            ps.setString(5, doctor.getDoctorDept());
            ps.setString(6, doctor.getDoctorDegree());
            ps.setInt(7, doctor.getDoctorSalary());
            ps.setString(8, doctor.getDoctorAddress());
            int rowAffected = ps.executeUpdate();
            System.out.println(rowAffected + " Row Affected");

            //---------------------
            ps = connect.prepareStatement("insert into doctor_mob values(?,?)");
            ps.setInt(1, doctor.getDoctorId());
            ps.setInt(2, doctor.getDoctorMob());
            ps.executeUpdate();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Input The Informations  Correctly");
        }
    }

    public void writeStaffInfo(Staff staff) {


        //------------Ok-----------------

        PreparedStatement ps;
        try {
            //-----------------
            ps = connect.prepareStatement("insert into staff values(?,?,?,?,?,?,?,?)");
            ps.setInt(1, staff.getStaffId());
            ps.setString(2, staff.getStaffFirstName());
            ps.setString(3, staff.getStaffLastName());
            ps.setInt(4, staff.getStaffAge());
            ps.setString(5, staff.getStaffSex());
            ps.setString(6, staff.getStaffDept());
            ps.setInt(7, staff.getStaffSalary());
            ps.setString(8, staff.getStaffAddress());
            int rowAffected = ps.executeUpdate();
            System.out.println(rowAffected + " Row Affected");

            //---------------------
            ps = connect.prepareStatement("insert into staff_mob values(?,?)");
            ps.setInt(1, staff.getStaffId());
            ps.setInt(2, staff.getStaffMob());
            ps.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Input The Informations  Correctly");
        }

    }

    public void writeBedInfo(Bed bed) {
        PreparedStatement ps;
        try {
            ps = connect.prepareStatement("insert into bed values(?,?,?,?)");
            ps.setInt(1, bed.getBedId());
            ps.setInt(2, bed.getBedRet());
            ps.setInt(3, bed.getBedWord());
            ps.setInt(4, 1);
            int rowAffected = ps.executeUpdate();
            System.out.println(rowAffected + " Row Affected");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Input The Informations  Correctly");
        }

    }

    public void writePatientDisease(int p_id, int d_id,
            String description, String medicine) {

        //------------OK--------------
        PreparedStatement ps;
        try {

            ps = connect.prepareStatement("update indoor_patient_disease set description = '" + description + "',medicine = '" + medicine + "' where p_id = " + p_id + "");

            ps.executeUpdate();

            ps = connect.prepareStatement("update indoor_patient_doctor set d_id = " + d_id + " where p_id = " + p_id + "");

            ps.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Input The Informations  Correctly");
        }

    }

    public void writeDoctorSchedule(int id, String day, String start, String end) {

        PreparedStatement ps;
        try {
            ps = connect.prepareStatement("insert into doctor_duty  values(?,?,?,?)");
            ps.setInt(1, id);
            ps.setString(2, start);
            ps.setString(3, end);
            ps.setString(3, day);
            int rowAffected = ps.executeUpdate();
            System.out.println(rowAffected + " Row Affected");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Input The Informations  Correctly");
        }
    }
    //-----------------------------------------

    public void releaseIndoorPatient(int id) {

        //-------------ok------------

        PreparedStatement ps;
        try {

            ps = connect.prepareStatement("update patient_dates set release_date = current_date where p_id = " + id + "");

            ps.executeUpdate();

        } catch (Exception ex) {
        }
    }
    //------------READ-------------------------

    //-----------------------------------------
    //----------------SEARCH-------------------
    public ArrayList<String> serachPatient(int id, String key) {

        String[] patientInfo = new String[18];
        ArrayList<String> al = new ArrayList<>();
        //ArrayList<String> patientInfo = new ArrayList<String>();


        if (id == 1) {

            //--Ok--
            try {

                String sql;
                sql = "select P_ID,P_FNAME,P_LNAME,P_AGE,P_SEX,P_DEPT,"
                        + "P_ADDRESS,INDOOR_PATIENT_PHONE.PHONE_NO,"
                        + "INDOOR_PATIENT_BED.B_ID,DESCRIPTION,MEDICINE,"
                        + "D_ID,REL_FNAME,REL_LNAME,REL_ADDRESS,REL_MOB, "
                        + "ADMISSION_DATE, RELEASE_DATE from INDOOR_PATIENT "
                        + "natural join INDOOR_PATIENT_BED natural join "
                        + "INDOOR_PATIENT_DISEASE natural join "
                        + "INDOOR_PATIENT_DOCTOR  natural join "
                        + "INDOOR_PATIENT_PHONE natural join "
                        + "INDOOR_PATIENT_RELATIVE natural join "
                        + "PATIENT_DATES Where P_ID = " + Integer.parseInt(key) + "";
                result = statement.executeQuery(sql);


                while (result.next()) {

                    al.add(result.getString(1));
                    al.add(result.getString(2));
                    al.add(result.getString(3));
                    al.add(result.getString(4));
                    al.add(result.getString(5));
                    al.add(result.getString(6));
                    al.add(result.getString(7));
                    al.add(result.getString(8));
                    al.add(result.getString(9));
                    al.add(result.getString(10));
                    al.add(result.getString(11));
                    al.add(result.getString(12));
                    al.add(result.getString(13));
                    al.add(result.getString(14));
                    al.add(result.getString(15));
                    al.add(result.getString(16));
                    al.add(result.getString(17));
                    al.add(result.getString(18));


                }

            } catch (SQLException ex) {
            } catch (Exception ex) {
            }


            System.out.println(al.get(1) + "  " + al.get(2) + " " + al.size());

        } else if (id == 2) {
            //---Ok--
            try {

                String sql;
                sql = "select P_ID,P_FNAME,P_LNAME,P_AGE,P_SEX,P_DEPT,"
                        + "P_ADDRESS,INDOOR_PATIENT_PHONE.PHONE_NO,"
                        + "INDOOR_PATIENT_BED.B_ID,DESCRIPTION,MEDICINE,"
                        + "D_ID,REL_FNAME,REL_LNAME,REL_ADDRESS,REL_MOB, "
                        + "ADMISSION_DATE, RELEASE_DATE from INDOOR_PATIENT "
                        + "natural join INDOOR_PATIENT_BED natural join "
                        + "INDOOR_PATIENT_DISEASE natural join "
                        + "INDOOR_PATIENT_DOCTOR  natural join "
                        + "INDOOR_PATIENT_PHONE natural join "
                        + "INDOOR_PATIENT_RELATIVE natural join "
                        + "PATIENT_DATES Where INDOOR_PATIENT_PHONE.PHONE_NO = " + Integer.parseInt(key) + "";
                result = statement.executeQuery(sql);


                while (result.next()) {


                    al.add(result.getString(1));
                    al.add(result.getString(2));
                    al.add(result.getString(3));
                    al.add(result.getString(4));
                    al.add(result.getString(5));
                    al.add(result.getString(6));
                    al.add(result.getString(7));
                    al.add(result.getString(8));
                    al.add(result.getString(9));
                    al.add(result.getString(10));
                    al.add(result.getString(11));
                    al.add(result.getString(12));
                    al.add(result.getString(13));
                    al.add(result.getString(14));
                    al.add(result.getString(15));
                    al.add(result.getString(16));
                    al.add(result.getString(17));
                    al.add(result.getString(18));


                }

            } catch (SQLException ex) {
            } catch (Exception ex) {
            }

        } else if (id == 3) {
            //--ok--
            try {

                String sql;
                sql = "select P_ID,P_FNAME,P_LNAME,P_AGE,P_SEX,P_DEPT,"
                        + "P_ADDRESS,INDOOR_PATIENT_PHONE.PHONE_NO,"
                        + "INDOOR_PATIENT_BED.B_ID,DESCRIPTION,MEDICINE,"
                        + "D_ID,REL_FNAME,REL_LNAME,REL_ADDRESS,REL_MOB, "
                        + "ADMISSION_DATE, RELEASE_DATE from INDOOR_PATIENT "
                        + "natural join INDOOR_PATIENT_BED natural join "
                        + "INDOOR_PATIENT_DISEASE natural join "
                        + "INDOOR_PATIENT_DOCTOR  natural join "
                        + "INDOOR_PATIENT_PHONE natural join "
                        + "INDOOR_PATIENT_RELATIVE natural join "
                        + "PATIENT_DATES Where P_FNAME like '%" + key + "%'";
                result = statement.executeQuery(sql);


                while (result.next()) {


                    al.add(result.getString(1));
                    al.add(result.getString(2));
                    al.add(result.getString(3));
                    al.add(result.getString(4));
                    al.add(result.getString(5));
                    al.add(result.getString(6));
                    al.add(result.getString(7));
                    al.add(result.getString(8));
                    al.add(result.getString(9));
                    al.add(result.getString(10));
                    al.add(result.getString(11));
                    al.add(result.getString(12));
                    al.add(result.getString(13));
                    al.add(result.getString(14));
                    al.add(result.getString(15));
                    al.add(result.getString(16));
                    al.add(result.getString(17));
                    al.add(result.getString(18));


                }

            } catch (SQLException ex) {
            } catch (Exception ex) {
            }
        } else if (id == 4) {

            //--ok---

            try {

                String sql;
                sql = "select P_ID,P_FNAME,P_LNAME,P_AGE,P_SEX,P_DEPT,"
                        + "P_ADDRESS,INDOOR_PATIENT_PHONE.PHONE_NO,"
                        + "INDOOR_PATIENT_BED.B_ID,DESCRIPTION,MEDICINE,"
                        + "D_ID,REL_FNAME,REL_LNAME,REL_ADDRESS,REL_MOB, "
                        + "ADMISSION_DATE, RELEASE_DATE from INDOOR_PATIENT "
                        + "natural join INDOOR_PATIENT_BED natural join "
                        + "INDOOR_PATIENT_DISEASE natural join "
                        + "INDOOR_PATIENT_DOCTOR  natural join "
                        + "INDOOR_PATIENT_PHONE natural join "
                        + "INDOOR_PATIENT_RELATIVE natural join "
                        + "PATIENT_DATES Where P_LNAME like '%" + key + "%'";
                result = statement.executeQuery(sql);


                while (result.next()) {

                    al.add(result.getString(1));
                    al.add(result.getString(2));
                    al.add(result.getString(3));
                    al.add(result.getString(4));
                    al.add(result.getString(5));
                    al.add(result.getString(6));
                    al.add(result.getString(7));
                    al.add(result.getString(8));
                    al.add(result.getString(9));
                    al.add(result.getString(10));
                    al.add(result.getString(11));
                    al.add(result.getString(12));
                    al.add(result.getString(13));
                    al.add(result.getString(14));
                    al.add(result.getString(15));
                    al.add(result.getString(16));
                    al.add(result.getString(17));
                    al.add(result.getString(18));

                }

            } catch (SQLException ex) {
            } catch (Exception ex) {
            }
        } else if (id == 5) {
            //--ok--
            try {

                String sql;
                sql = "select P_ID,P_FNAME,P_LNAME,P_AGE,P_SEX,P_DEPT,"
                        + "P_ADDRESS,INDOOR_PATIENT_PHONE.PHONE_NO,"
                        + "INDOOR_PATIENT_BED.B_ID,DESCRIPTION,MEDICINE,"
                        + "D_ID,REL_FNAME,REL_LNAME,REL_ADDRESS,REL_MOB, "
                        + "ADMISSION_DATE, RELEASE_DATE from INDOOR_PATIENT "
                        + "natural join INDOOR_PATIENT_BED natural join "
                        + "INDOOR_PATIENT_DISEASE natural join "
                        + "INDOOR_PATIENT_DOCTOR  natural join "
                        + "INDOOR_PATIENT_PHONE natural join "
                        + "INDOOR_PATIENT_RELATIVE natural join "
                        + "PATIENT_DATES Where REL_FNAME like '%" + key + "%'";
                result = statement.executeQuery(sql);


                while (result.next()) {


                    al.add(result.getString(1));
                    al.add(result.getString(2));
                    al.add(result.getString(3));
                    al.add(result.getString(4));
                    al.add(result.getString(5));
                    al.add(result.getString(6));
                    al.add(result.getString(7));
                    al.add(result.getString(8));
                    al.add(result.getString(9));
                    al.add(result.getString(10));
                    al.add(result.getString(11));
                    al.add(result.getString(12));
                    al.add(result.getString(13));
                    al.add(result.getString(14));
                    al.add(result.getString(15));
                    al.add(result.getString(16));
                    al.add(result.getString(17));
                    al.add(result.getString(18));


                }

            } catch (SQLException ex) {
            } catch (Exception ex) {
            }
        } else if (id == 6) {
            //--ok--
            try {

                String sql;
                sql = "select P_ID,P_FNAME,P_LNAME,P_AGE,P_SEX,P_DEPT,"
                        + "P_ADDRESS,INDOOR_PATIENT_PHONE.PHONE_NO,"
                        + "INDOOR_PATIENT_BED.B_ID,DESCRIPTION,MEDICINE,"
                        + "D_ID,REL_FNAME,REL_LNAME,REL_ADDRESS,REL_MOB, "
                        + "ADMISSION_DATE, RELEASE_DATE from INDOOR_PATIENT "
                        + "natural join INDOOR_PATIENT_BED natural join "
                        + "INDOOR_PATIENT_DISEASE natural join "
                        + "INDOOR_PATIENT_DOCTOR  natural join "
                        + "INDOOR_PATIENT_PHONE natural join "
                        + "INDOOR_PATIENT_RELATIVE natural join "
                        + "PATIENT_DATES Where REL_MOB = " + Integer.parseInt(key) + "";
                result = statement.executeQuery(sql);

                while (result.next()) {


                    al.add(result.getString(1));
                    al.add(result.getString(2));
                    al.add(result.getString(3));
                    al.add(result.getString(4));
                    al.add(result.getString(5));
                    al.add(result.getString(6));
                    al.add(result.getString(7));
                    al.add(result.getString(8));
                    al.add(result.getString(9));
                    al.add(result.getString(10));
                    al.add(result.getString(11));
                    al.add(result.getString(12));
                    al.add(result.getString(13));
                    al.add(result.getString(14));
                    al.add(result.getString(15));
                    al.add(result.getString(16));
                    al.add(result.getString(17));
                    al.add(result.getString(18));


                }

            } catch (SQLException ex) {
            } catch (Exception ex) {
            }
        } else if (id == 7) {
            //0k--
            try {

                String sql;
                sql = "select P_ID,P_FNAME,P_LNAME,P_AGE,P_SEX,P_DEPT,"
                        + "P_ADDRESS,INDOOR_PATIENT_PHONE.PHONE_NO,"
                        + "INDOOR_PATIENT_BED.B_ID,DESCRIPTION,MEDICINE,"
                        + "D_ID,REL_FNAME,REL_LNAME,REL_ADDRESS,REL_MOB, "
                        + "ADMISSION_DATE, RELEASE_DATE from INDOOR_PATIENT "
                        + "natural join INDOOR_PATIENT_BED natural join "
                        + "INDOOR_PATIENT_DISEASE natural join "
                        + "INDOOR_PATIENT_DOCTOR  natural join "
                        + "INDOOR_PATIENT_PHONE natural join "
                        + "INDOOR_PATIENT_RELATIVE natural join "
                        + "PATIENT_DATES Where P_DEPT = '" + key + "'";
                result = statement.executeQuery(sql);


                while (result.next()) {


                    al.add(result.getString(1));
                    al.add(result.getString(2));
                    al.add(result.getString(3));
                    al.add(result.getString(4));
                    al.add(result.getString(5));
                    al.add(result.getString(6));
                    al.add(result.getString(7));
                    al.add(result.getString(8));
                    al.add(result.getString(9));
                    al.add(result.getString(10));
                    al.add(result.getString(11));
                    al.add(result.getString(12));
                    al.add(result.getString(13));
                    al.add(result.getString(14));
                    al.add(result.getString(15));
                    al.add(result.getString(16));
                    al.add(result.getString(17));
                    al.add(result.getString(18));


                }

            } catch (SQLException ex) {
            } catch (Exception ex) {
            }
        }


        // for (int l = 0; l < al.size(); l++) {
        //     System.out.print("" + al.get(l) + "| ");
        //     if (l % 18 == 0) {
        //         System.out.println();
        //     }
        // }

        //return patientInfo;
        return al;
    }

    public ArrayList<String> searchOutdoorPatient(int id, String key) {

        ArrayList<String> al = new ArrayList<>();

        if (id == 1) {
            try {

                String sql;
                sql = "select * from outdoor_patient where p_id = " + Integer.parseInt(key) + "";


                result = statement.executeQuery(sql);


                while (result.next()) {


                    al.add(result.getString(1));
                    al.add(result.getString(2));
                    al.add(result.getString(3));
                    al.add(result.getString(4));
                    al.add(result.getString(5));
                    al.add(result.getString(6));
                    al.add(result.getString(7));
                    al.add(result.getString(8));
                    al.add(result.getString(9));
                    al.add(result.getString(10));
                    al.add(result.getString(11));

                }

            } catch (SQLException ex) {
            } catch (Exception ex) {
            }



        } else if (id == 2) {
            try {

                String sql;
                sql = "select * from outdoor_patient where MOB = " + Integer.parseInt(key) + "";


                result = statement.executeQuery(sql);


                while (result.next()) {


                    al.add(result.getString(1));
                    al.add(result.getString(2));
                    al.add(result.getString(3));
                    al.add(result.getString(4));
                    al.add(result.getString(5));
                    al.add(result.getString(6));
                    al.add(result.getString(7));
                    al.add(result.getString(8));
                    al.add(result.getString(9));
                    al.add(result.getString(10));
                    al.add(result.getString(11));

                }

            } catch (SQLException ex) {
            } catch (Exception ex) {
            }



        } else if (id == 3) {
            try {

                String sql;
                sql = "select * from outdoor_patient where P_FNAME = '" + key + "'";


                result = statement.executeQuery(sql);


                while (result.next()) {


                    al.add(result.getString(1));
                    al.add(result.getString(2));
                    al.add(result.getString(3));
                    al.add(result.getString(4));
                    al.add(result.getString(5));
                    al.add(result.getString(6));
                    al.add(result.getString(7));
                    al.add(result.getString(8));
                    al.add(result.getString(9));
                    al.add(result.getString(10));
                    al.add(result.getString(11));

                }

            } catch (SQLException ex) {
            } catch (Exception ex) {
            }



        } else if (id == 4) {
            try {

                String sql;
                sql = "select * from outdoor_patient where P_LNAME = '" + key + "'";


                result = statement.executeQuery(sql);


                while (result.next()) {


                    al.add(result.getString(1));
                    al.add(result.getString(2));
                    al.add(result.getString(3));
                    al.add(result.getString(4));
                    al.add(result.getString(5));
                    al.add(result.getString(6));
                    al.add(result.getString(7));
                    al.add(result.getString(8));
                    al.add(result.getString(9));
                    al.add(result.getString(10));
                    al.add(result.getString(11));

                }

            } catch (SQLException ex) {
            } catch (Exception ex) {
            }



        } else if (id == 5) {
            try {

                String sql;
                sql = "select * from outdoor_patient where P_DEPT = '" + key + "'";


                result = statement.executeQuery(sql);


                while (result.next()) {


                    al.add(result.getString(1));
                    al.add(result.getString(2));
                    al.add(result.getString(3));
                    al.add(result.getString(4));
                    al.add(result.getString(5));
                    al.add(result.getString(6));
                    al.add(result.getString(7));
                    al.add(result.getString(8));
                    al.add(result.getString(9));
                    al.add(result.getString(10));
                    al.add(result.getString(11));

                }

            } catch (SQLException ex) {
            } catch (Exception ex) {
            }



        } else if (id == 5) {
            try {

                String sql;
                sql = "select * from outdoor_patient where DOCTOR = '" + key + "'";


                result = statement.executeQuery(sql);


                while (result.next()) {


                    al.add(result.getString(1));
                    al.add(result.getString(2));
                    al.add(result.getString(3));
                    al.add(result.getString(4));
                    al.add(result.getString(5));
                    al.add(result.getString(6));
                    al.add(result.getString(7));
                    al.add(result.getString(8));
                    al.add(result.getString(9));
                    al.add(result.getString(10));
                    al.add(result.getString(11));

                }

            } catch (SQLException ex) {
            } catch (Exception ex) {
            }



        }


        return al;
    }

    public ArrayList<String> searchDoctor(int id, String key) {

        ArrayList<String> al = new ArrayList<>();
        String[] doctorInfo = new String[18];

        if (id == 1) {
            try {

                String sql;
                sql = "select D_ID,D_FNAME,D_LNAME,D_SEX,D_DOB,D_DEPT,D_DEGREE,"
                        + "SALARY,D_ADDRESS,MOB "
                        + "from doctor natural join doctor_mob "
                        + "where d_id = " + Integer.parseInt(key) + "";

                result = statement.executeQuery(sql);


                while (result.next()) {


                    al.add(result.getString(1));
                    al.add(result.getString(2));
                    al.add(result.getString(3));
                    al.add(result.getString(4));
                    al.add(result.getString(5));
                    al.add(result.getString(6));
                    al.add(result.getString(7));
                    al.add(result.getString(8));
                    al.add(result.getString(9));
                    al.add(result.getString(10));


                }

            } catch (SQLException ex) {
            } catch (Exception ex) {
            }

        } else if (id == 2) {

            try {

                String sql;
                sql = "select D_ID,D_FNAME,D_LNAME,D_SEX,D_DOB, D_DEPT,D_DEGREE,"
                        + "SALARY,D_ADDRESS,MOB "
                        + "from doctor natural join doctor_mob "
                        + "where MOB = " + Integer.parseInt(key) + "";

                result = statement.executeQuery(sql);


                while (result.next()) {


                    al.add(result.getString(1));
                    al.add(result.getString(2));
                    al.add(result.getString(3));
                    al.add(result.getString(4));
                    al.add(result.getString(5));
                    al.add(result.getString(6));
                    al.add(result.getString(7));
                    al.add(result.getString(8));
                    al.add(result.getString(9));
                    al.add(result.getString(10));


                }

            } catch (SQLException ex) {
            } catch (Exception ex) {
            }

        } else if (id == 3) {

            try {

                String sql;
                sql = "select D_ID,D_FNAME,D_LNAME,D_SEX,D_DOB, D_DEPT,D_DEGREE,"
                        + "SALARY,D_ADDRESS,MOB "
                        + "from doctor natural join doctor_mob "
                        + "where D_FNAME like '%" + key + "%'";
                result = statement.executeQuery(sql);


                while (result.next()) {


                    al.add(result.getString(1));
                    al.add(result.getString(2));
                    al.add(result.getString(3));
                    al.add(result.getString(4));
                    al.add(result.getString(5));
                    al.add(result.getString(6));
                    al.add(result.getString(7));
                    al.add(result.getString(8));
                    al.add(result.getString(9));
                    al.add(result.getString(10));


                }

            } catch (SQLException ex) {
            } catch (Exception ex) {
            }

        } else if (id == 4) {

            try {

                String sql;

                sql = "select D_ID,D_FNAME,D_LNAME,D_SEX,D_DOB, D_DEPT,D_DEGREE,"
                        + "SALARY,D_ADDRESS,MOB "
                        + "from doctor natural join doctor_mob "
                        + "where D_LNAME like '%" + key + "%'";
                result = statement.executeQuery(sql);


                while (result.next()) {


                    al.add(result.getString(1));
                    al.add(result.getString(2));
                    al.add(result.getString(3));
                    al.add(result.getString(4));
                    al.add(result.getString(5));
                    al.add(result.getString(6));
                    al.add(result.getString(7));
                    al.add(result.getString(8));
                    al.add(result.getString(9));
                    al.add(result.getString(10));



                }

            } catch (SQLException ex) {
            } catch (Exception ex) {
            }

        } else if (id == 5) {
            try {

                String sql;
                sql = "select D_ID,D_FNAME,D_LNAME,D_SEX,D_DOB, D_DEPT,D_DEGREE,"
                        + "SALARY,D_ADDRESS,MOB "
                        + "from doctor natural join doctor_mob "
                        + "where D_DEPT = '" + key + "'";
                result = statement.executeQuery(sql);


                while (result.next()) {


                    al.add(result.getString(1));
                    al.add(result.getString(2));
                    al.add(result.getString(3));
                    al.add(result.getString(4));
                    al.add(result.getString(5));
                    al.add(result.getString(6));
                    al.add(result.getString(7));
                    al.add(result.getString(8));
                    al.add(result.getString(9));
                    al.add(result.getString(10));


                }

            } catch (SQLException ex) {
            } catch (Exception ex) {
            }
        } else if (id == 6) {
            try {

                String sql;
                sql = "select D_ID,D_FNAME,D_LNAME,D_SEX,D_DOB, D_DEPT,D_DEGREE,"
                        + "SALARY,D_ADDRESS,MOB "
                        + "from doctor natural join doctor_mob "
                        + "where D_DEGREE = '" + key + "'";
                result = statement.executeQuery(sql);


                while (result.next()) {


                    al.add(result.getString(1));
                    al.add(result.getString(2));
                    al.add(result.getString(3));
                    al.add(result.getString(4));
                    al.add(result.getString(5));
                    al.add(result.getString(6));
                    al.add(result.getString(7));
                    al.add(result.getString(8));
                    al.add(result.getString(9));
                    al.add(result.getString(10));


                }

            } catch (SQLException ex) {
            } catch (Exception ex) {
            }
        }


        // for (int l = 0; l < al.size(); l++) {
        //     System.out.print("" + al.get(l) + "| ");
        //     if (l % 9 == 0) {
        //         System.out.println();
        //      }
        //  }

        return al;
    }

    public ArrayList<String> searchStaff(int id, String key) {
        //-----------ok-----------

        ArrayList<String> al = new ArrayList<>();
        String[] staffInfo = new String[18];

        if (id == 1) {

            try {

                String sql;
                sql = "select S_ID, S_FNAME,S_LNAME,S_AGE,"
                        + "S_SEX,S_DEPT,S_SALARY,S_ADDRESS, MOB "
                        + "from staff natural join staff_mob "
                        + "where s_id = " + Integer.parseInt(key) + "";

                result = statement.executeQuery(sql);


                while (result.next()) {


                    al.add(result.getString(1));
                    al.add(result.getString(2));
                    al.add(result.getString(3));
                    al.add(result.getString(4));
                    al.add(result.getString(5));
                    al.add(result.getString(6));
                    al.add(result.getString(7));
                    al.add(result.getString(8));
                    al.add(result.getString(9));


                }

            } catch (SQLException ex) {
            } catch (Exception ex) {
            }


        } else if (id == 2) {
            try {

                String sql;
                sql = "select S_ID, S_FNAME,S_LNAME,S_AGE,"
                        + "S_SEX,S_DEPT,S_SALARY,S_ADDRESS, MOB "
                        + "from staff natural join staff_mob "
                        + "where MOB = " + Integer.parseInt(key) + "";
                result = statement.executeQuery(sql);


                while (result.next()) {


                    al.add(result.getString(1));
                    al.add(result.getString(2));
                    al.add(result.getString(3));
                    al.add(result.getString(4));
                    al.add(result.getString(5));
                    al.add(result.getString(6));
                    al.add(result.getString(7));
                    al.add(result.getString(8));
                    al.add(result.getString(9));


                }

            } catch (SQLException ex) {
            } catch (Exception ex) {
            }

        } else if (id == 3) {
            try {

                String sql;
                sql = "select S_ID, S_FNAME,S_LNAME,S_AGE,"
                        + "S_SEX,S_DEPT,S_SALARY,S_ADDRESS,MOB "
                        + "from staff natural join staff_mob "
                        + "where S_FNAME like '%" + key + "%'";
                result = statement.executeQuery(sql);


                while (result.next()) {


                    al.add(result.getString(1));
                    al.add(result.getString(2));
                    al.add(result.getString(3));
                    al.add(result.getString(4));
                    al.add(result.getString(5));
                    al.add(result.getString(6));
                    al.add(result.getString(7));
                    al.add(result.getString(8));
                    al.add(result.getString(9));


                }

            } catch (SQLException ex) {
            } catch (Exception ex) {
            }

        } else if (id == 4) {
            try {

                String sql;
                sql = "select S_ID, S_FNAME,S_LNAME,S_AGE,"
                        + "S_SEX,S_DEPT,S_SALARY,S_ADDRESS,MOB "
                        + "from staff natural join staff_mob "
                        + "where S_LNAME like '%" + key + "%'";
                result = statement.executeQuery(sql);


                while (result.next()) {


                    al.add(result.getString(1));
                    al.add(result.getString(2));
                    al.add(result.getString(3));
                    al.add(result.getString(4));
                    al.add(result.getString(5));
                    al.add(result.getString(6));
                    al.add(result.getString(7));
                    al.add(result.getString(8));
                    al.add(result.getString(9));


                }

            } catch (SQLException ex) {
            } catch (Exception ex) {
            }

        } else if (id == 5) {
            try {

                String sql;

                sql = "select S_ID, S_FNAME,S_LNAME,S_AGE,"
                        + "S_SEX,S_DEPT,S_SALARY,S_ADDRESS,MOB "
                        + "from staff natural join staff_mob "
                        + "where S_DEPT = '" + key + "'";

                result = statement.executeQuery(sql);


                while (result.next()) {


                    al.add(result.getString(1));
                    al.add(result.getString(2));
                    al.add(result.getString(3));
                    al.add(result.getString(4));
                    al.add(result.getString(5));
                    al.add(result.getString(6));
                    al.add(result.getString(7));
                    al.add(result.getString(8));
                    al.add(result.getString(9));


                }

            } catch (SQLException ex) {
            } catch (Exception ex) {
            }
        }

        for (int l = 0; l < al.size(); l++) {
            System.out.print("" + al.get(l) + "| ");
            if (l % 9 == 0) {
                System.out.println();
            }
        }


        return al;
    }

    public ArrayList<String> searchBed(String key) {
        ArrayList<String> al = new ArrayList<>();
        try {
            result = statement.executeQuery("SELECT WORD, RET FROM bed where b_id = " + Integer.parseInt(key) + "");

            while (result.next()) {
                al.add(result.getString(1));
                al.add(result.getString(2));
            }

            result = statement.executeQuery("SELECT p_id FROM INDOOR_PATIENT_BED "
                    + "where b_id = " + Integer.parseInt(key) + "");
            while (result.next()) {
                al.add(result.getString(1));
            }

            result = statement.executeQuery("SELECT P_FNAME FROM INDOOR_PATIENT_BED natural join INDOOR_PATIENT where b_id = " + Integer.parseInt(key) + "");
            while (result.next()) {
                al.add(result.getString(1));
            }

        } catch (SQLException ex) {
        } catch (Exception ex) {
        }

        return al;
    }

    public ArrayList<String> searchAvailableBed() {
        ArrayList<String> al = new ArrayList<>();
        try {
            result = statement.executeQuery("SELECT b_id  ,ret  ,word  FROM bed"
                    + "where is_available  = 1");
            while (result.next()) {
                al.add(result.getString(1));
                al.add(result.getString(2));
                al.add(result.getString(3));
            }

        } catch (SQLException ex) {
        } catch (Exception ex) {
        }

        return al;

    }

    public ArrayList<String> searchSchedule(int id) {
        ArrayList<String> al = new ArrayList<>();
        try {
            result = statement.executeQuery("SELECT d_id ,start_time ,end_time ,day  FROM doctor_duty  "
                    + "where d_id = " + id + "");
            while (result.next()) {
                al.add(result.getString(1));
                al.add(result.getString(2));
                al.add(result.getString(3));
                al.add(result.getString(4));
            }

        } catch (SQLException ex) {
        } catch (Exception ex) {
        }

        return al;
    }
    //-----------------------------------------

    public void deleteEntry(int id, int key) {
        PreparedStatement ps;
        String sql;
        if (id == 1) {
            //indoor patient

            try {

                sql = "delete from indoor_patient where p_id = " + key + "";
                ps = connect.prepareStatement(sql);
                ps.executeUpdate();

                sql = "delete from indoor_patient_phone where p_id = " + key + "";
                ps = connect.prepareStatement(sql);
                ps.executeUpdate();

                sql = "delete from indoor_patient_relative where p_id = " + key + "";
                ps = connect.prepareStatement(sql);
                ps.executeUpdate();

                sql = "delete from patient_dates where p_id = " + key + "";
                ps = connect.prepareStatement(sql);
                ps.executeUpdate();

                sql = "delete from indoor_patient_doctor where p_id = " + key + "";
                ps = connect.prepareStatement(sql);
                ps.executeUpdate();

                sql = "delete from indoor_patient_bed where p_id = " + key + "";
                ps = connect.prepareStatement(sql);
                ps.executeUpdate();

                sql = "delete from indoor_patient_bill where p_id = " + key + "";
                ps = connect.prepareStatement(sql);
                ps.executeUpdate();

                sql = "delete from indoor_patient_disease where p_id = " + key + "";
                ps = connect.prepareStatement(sql);
                ps.executeUpdate();

            } catch (SQLException ex) {
            } catch (Exception ex) {
            }

        } else if (id == 2) {
            //outdoor patient

            try {
                sql = "delete from outdoor_patient where p_id = " + key + "";
                ps = connect.prepareStatement(sql);
                ps.executeUpdate();

            } catch (SQLException ex) {
            } catch (Exception ex) {
            }
        } else if (id == 3) {
            //doctor           

            try {
                sql = "delete from doctor where d_id = " + key + "";
                ps = connect.prepareStatement(sql);
                ps.executeUpdate();
                sql = "delete from doctor_mob where d_id = " + key + "";
                ps = connect.prepareStatement(sql);
                ps.executeUpdate();
                sql = "delete from doctor_duty where d_id = " + key + "";
                ps = connect.prepareStatement(sql);
                ps.executeUpdate();
                sql = "delete from indoor_patient_doctor where d_id = " + key + "";
                ps = connect.prepareStatement(sql);
                ps.executeUpdate();
            } catch (SQLException ex) {
            } catch (Exception ex) {
            }
        } else if (id == 4) {
            //staff


            try {
                sql = "delete from staff where s_id = " + key + "";
                ps = connect.prepareStatement(sql);
                ps.executeUpdate();
                sql = "delete from staff_mob where s_id = " + key + "";
                ps = connect.prepareStatement(sql);
                ps.executeUpdate();
            } catch (SQLException ex) {
            } catch (Exception ex) {
            }
        } else if (id == 5) {
            //bed

            try {
                System.out.println(id);
                sql = "delete from bed where b_id = " + key + "";

                ps = connect.prepareStatement(sql);
                ps.executeUpdate();
                sql = "delete from indoor_patient_bed where b_id = " + key + "";
                ps = connect.prepareStatement(sql);
                ps.executeUpdate();
            } catch (SQLException ex) {
            } catch (Exception ex) {
            }
        }


    }
    //--------------------------------------

    //------------------------
    public void createAllTables() {

        String sql;
        PreparedStatement ps;
        try {


            sql = "create table indoor_patient( "
                    + "p_id numeric(25,0),"
                    + "p_fname varchar2(50),"
                    + "p_lname varchar2(50),"
                    + "p_age numeric(3,0),"
                    + "p_sex varchar2(10),"
                    + "p_dept varchar2(15),"
                    + "p_address varchar2(300),"
                    + "primary key(p_id));";
            ps = connect.prepareStatement(sql);
            ps.executeUpdate();

            sql = "create table outdoor_patient("
                    + "p_id numeric(25,0),"
                    + "p_fname varchar2(50),"
                    + "p_lname varchar2(50),"
                    + "p_age numeric(3,0),"
                    + "p_sex varchar2(10),"
                    + "p_dept varchar2(15),"
                    + "p_address varchar2(300),"
                    + "mob numeric(11,0),"
                    + "doctor varchar2(100),"
                    + "p_medicine varchar2(200),"
                    + "p_date date,"
                    + "primary key(p_id) );";
            ps = connect.prepareStatement(sql);
            ps.executeUpdate();


            sql = "create table indoor_patient_phone("
                    + "p_id numeric(25,0),"
                    + "phone_no numeric(11,0),"
                    + "primary key(p_id));";
            ps = connect.prepareStatement(sql);
            ps.executeUpdate();


            sql = "create table indoor_patient_relative("
                    + "p_id numeric(25,0),"
                    + "rel_fname varchar2(50),"
                    + "rel_lname varchar2(50),"
                    + "rel_address varchar2(300),"
                    + "rel_mob numeric(11,0),"
                    + "primary key(p_id));";
            ps = connect.prepareStatement(sql);
            ps.executeUpdate();

            sql = "create table patient_dates("
                    + "p_id numeric(25,0),"
                    + "admission_date date,"
                    + "release_date date,"
                    + "primary key(p_id));";
            ps = connect.prepareStatement(sql);
            ps.executeUpdate();

            sql = "create table staff("
                    + "s_id numeric (5,0),"
                    + "s_fname varchar2(50),"
                    + "s_lname varchar2(50),"
                    + "s_age numeric(3,0),"
                    + "s_sex varchar2(10),"
                    + "s_dept varchar2(15),"
                    + "s_salary numeric(7,2),"
                    + "s_address varchar2(300),"
                    + "primary key(s_id));";
            ps = connect.prepareStatement(sql);
            ps.executeUpdate();

            sql = "create table staff_mob("
                    + "s_id numeric(5,0),"
                    + "mob numeric(11,0),"
                    + "primary key (s_id));";
            ps = connect.prepareStatement(sql);
            ps.executeUpdate();

            sql = "create table doctor("
                    + "d_id numeric(5,0),"
                    + "d_fname varchar2(50),"
                    + "d_lname varchar2(50),"
                    + "d_sex varchar2(15),"
                    + "d_dept varchar2(15),"
                    + "d_degree varchar2(30),"
                    + "salary numeric(10,2),"
                    + "d_address varchar2(300),"
                    + "d_dob date,"
                    + "primary key(d_id));";
            ps = connect.prepareStatement(sql);
            ps.executeUpdate();

            sql = "create table doctor_mob("
                    + "d_id numeric(5,0),"
                    + "mob numeric(11,0),"
                    + "primary key(d_id));";
            ps = connect.prepareStatement(sql);
            ps.executeUpdate();

            sql = "create table doctor_duty("
                    + "d_id numeric (5,0),"
                    + "start_time varchar2(10),"
                    + "end_time varchar2(10),"
                    + "day varchar2(10),"
                    + "primary key(d_id));";
            ps = connect.prepareStatement(sql);
            ps.executeUpdate();

            sql = "create table indoor_patient_doctor("
                    + "p_id numeric(25,0),"
                    + "d_id numeric(5,0),"
                    + "primary key (p_id,d_id));";
            ps = connect.prepareStatement(sql);
            ps.executeUpdate();

            sql = "create table bed("
                    + "b_id numeric(5,0),"
                    + "ret numeric(7,2),"
                    + "word numeric(5,0),"
                    + "is_available numeric(2,0),"
                    + "primary key(b_id));";
            ps = connect.prepareStatement(sql);
            ps.executeUpdate();

            sql = "create table indoor_patient_bed("
                    + "p_id numeric(25,0),"
                    + "b_id numeric(5,0),"
                    + "primary key(p_id,b_id));";
            ps = connect.prepareStatement(sql);
            ps.executeUpdate();

            sql = "create table indoor_patient_bill("
                    + "p_id numeric(25,0),"
                    + "total_bill numeric(10,2),"
                    + "primary key(p_id));";
            ps = connect.prepareStatement(sql);
            ps.executeUpdate();

            sql = "create table indoor_patient_disease("
                    + "p_id numeric(25,0),"
                    + "description varchar2(1000),"
                    + "medicine varchar2(500),"
                    + "primary key(p_id));";

            ps = connect.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException ex) {
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error..");
        }

    }

    public void dropAllTables() {
        String sql;
        PreparedStatement ps;
        try {


            sql = "drop table bed;";
            ps = connect.prepareStatement(sql);
            ps.executeUpdate();
            sql = "drop table doctor;";
            ps = connect.prepareStatement(sql);
            ps.executeUpdate();
            sql = "drop table doctor_duty;";
            ps = connect.prepareStatement(sql);
            ps.executeUpdate();
            sql = "drop table doctor_mob;";
            ps = connect.prepareStatement(sql);
            ps.executeUpdate();
            sql = "drop table indoor_patient;";
            ps = connect.prepareStatement(sql);
            ps.executeUpdate();

            sql = "drop table indoor_patient_bed;";
            ps = connect.prepareStatement(sql);
            ps.executeUpdate();
            sql = "drop table indoor_patient_bill;";
            ps = connect.prepareStatement(sql);
            ps.executeUpdate();

            sql = "drop table indoor_patient_disease;";
            ps = connect.prepareStatement(sql);
            ps.executeUpdate();
            sql = "drop table inddor_patient_doctor;";
            ps = connect.prepareStatement(sql);
            ps.executeUpdate();

            sql = "drop table indoor_patient_phone;";
            ps = connect.prepareStatement(sql);
            ps.executeUpdate();
            sql = "drop table indoor_patient_relative;";
            ps = connect.prepareStatement(sql);
            ps.executeUpdate();

            sql = "drop table outdoor_patient;";
            ps = connect.prepareStatement(sql);
            ps.executeUpdate();
            sql = "drop table patient_dates;";
            ps = connect.prepareStatement(sql);
            ps.executeUpdate();
            sql = "drop table staff;";
            ps = connect.prepareStatement(sql);
            ps.executeUpdate();
            sql = "drop table staff_mob;";

            ps = connect.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error..");
        }
    }

    public void write(int reg, String name) {
        PreparedStatement ps;
        try {
            ps = connect.prepareStatement("insert into info values(?,?)");
            ps.setInt(2, reg);
            ps.setString(1, name);
            int rowAffected = ps.executeUpdate();
            System.out.println(rowAffected + " Row Affected");
        } catch (Exception ex) {
        }
    }

    public void read() {
        try {
            result = statement.executeQuery("SELECT * FROM doctor_mob");
            System.out.println("\n############ Updated Result ##############\n");

            while (result.next()) {
                System.out.println(result.getInt(2) + " " + result.getString(1));
            }
        } catch (SQLException ex) {
        } catch (Exception ex) {
        }
    }
}
