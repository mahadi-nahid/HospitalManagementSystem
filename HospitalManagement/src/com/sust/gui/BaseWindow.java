package com.sust.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author MAHADI HASAN NAHID
 */
public class BaseWindow extends javax.swing.JFrame
        implements ActionListener {

    public BaseWindow() {
        super("Base Winfow");
        addLookAndFeel();
        initComponents();
        setPosition();
        setVisible(true);
        //setResizable(false);
        //setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        addingActionListeners();

    }

    public void addLookAndFeel() {
         try {
            // select Look and Feel
             UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
             //com.jtattoo.plaf.texture.TextureLookAndFeel
             //com.jtattoo.plaf.hifi.HiFiLookAndFeel
             //com.jtattoo.plaf.noire.NoireLookAndFeel
             //com.jtattoo.plaf.aero.AeroLookAndFeel
                     

            // start application
            
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private void addingActionListeners() {

        indoorPatientItem.addActionListener(this);
        outdoorPatientItem.addActionListener(this);
        releasePatientItem.addActionListener(this);
        exitItem.addActionListener(this);

        doctorEntryItem.addActionListener(this);
        staffEntryItem.addActionListener(this);
        bedEntryItem.addActionListener(this);
        scheduleEntryItem.addActionListener(this);
        patientDiseaseEntryItem.addActionListener(this);
        searchPatientItem.addActionListener(this);
        searchOutdoorPatientItem.addActionListener(this);
        searchDoctorItem.addActionListener(this);
        searchStaffItem.addActionListener(this);
        searchBedItem.addActionListener(this);


        availableBedInfoItem.addActionListener(this);
        doctorScheduleInfoItem.addActionListener(this);

        createAlltablesItem.addActionListener(this);
        dropAllTablesItem.addActionListener(this);
        deleteEntry.addActionListener(this);
        aboutUsItem.addActionListener(this);
        helpItem.addActionListener(this);


    }

    private void setPosition() {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screanSize = toolkit.getScreenSize();

        int screanHeight = screanSize.height;
        int screanWidth = screanSize.width;
        setLocation(screanWidth / 8, screanHeight / 10);

    }

    @Override
    public void actionPerformed(ActionEvent event) {

        addLookAndFeel();
        if (event.getSource() == indoorPatientItem) {
            new IndoorPatientAdmForm();
        } else if (event.getSource() == outdoorPatientItem) {
            new OutdoorPatientAdmForm();
        } else if (event.getSource() == releasePatientItem) {
            new ReleasePatient();
        } else if (event.getSource() == exitItem) {
            System.exit(0);
        } else if (event.getSource() == doctorEntryItem) {
            new DoctorEntryForm();
        } else if (event.getSource() == staffEntryItem) {
            new StaffEntryForm();
        } else if (event.getSource() == bedEntryItem) {
            new BedEntryForm();
        } else if (event.getSource() == scheduleEntryItem) {
            new DoctorScheduleEntry();

        } else if (event.getSource() == patientDiseaseEntryItem) {
            new PatientDiseasePass();
        } else if (event.getSource() == searchPatientItem) {
            new SearchPatient();
        } else if (event.getSource() == searchOutdoorPatientItem) {
            new SearchOutdoorPatient();
        } else if (event.getSource() == searchDoctorItem) {
            new SearchDoctor();
        } else if (event.getSource() == searchStaffItem) {
            new SearchStaff();
        } else if (event.getSource() == searchBedItem) {
            new SearchBed();
        } else if (event.getSource() == availableBedInfoItem) {
            new AvailableBed();
        } else if (event.getSource() == doctorScheduleInfoItem) {
            new SearchSchedule();
        } else if (event.getSource() == createAlltablesItem) {
            new CreateAllTables();
        } else if (event.getSource() == dropAllTablesItem) {
            //JOptionPane.showMessageDialog(this, "Under Co nstruction!!");
            new DropAllTables();
        } else if (event.getSource() == deleteEntry) {
            new DeleteEntry();
        } else if (event.getSource() == aboutUsItem) {
            JOptionPane.showMessageDialog(this, "Md. Mahadi Hasan Nahid\n"
                    + "Reg. No: 2010331044\n"
                    + "Dept. of CSE\n"
                    + "SUST\n"
                    + "Mob: 01738150127\n"
                    + "E-mail: nahidsust44@gmail.com");
        } else if (event.getSource() == helpItem) {
            JOptionPane.showMessageDialog(this, "------Help------\n");
        }



    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        indoorPatientItem = new javax.swing.JMenuItem();
        outdoorPatientItem = new javax.swing.JMenuItem();
        releasePatientItem = new javax.swing.JMenuItem();
        exitItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        doctorEntryItem = new javax.swing.JMenuItem();
        staffEntryItem = new javax.swing.JMenuItem();
        bedEntryItem = new javax.swing.JMenuItem();
        scheduleEntryItem = new javax.swing.JMenuItem();
        patientDiseaseEntryItem = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        searchPatientItem = new javax.swing.JMenuItem();
        searchOutdoorPatientItem = new javax.swing.JMenuItem();
        searchDoctorItem = new javax.swing.JMenuItem();
        searchStaffItem = new javax.swing.JMenuItem();
        searchBedItem = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        availableBedInfoItem = new javax.swing.JMenuItem();
        doctorScheduleInfoItem = new javax.swing.JMenuItem();
        dropTablesItem = new javax.swing.JMenu();
        createAlltablesItem = new javax.swing.JMenuItem();
        dropAllTablesItem = new javax.swing.JMenuItem();
        deleteEntry = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        aboutUsItem = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        helpItem = new javax.swing.JMenuItem();

        jMenuItem5.setText("jMenuItem5");

        jMenuItem8.setText("jMenuItem8");

        jMenuItem12.setText("jMenuItem12");

        jMenuItem17.setText("jMenuItem17");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("File");
        jMenu1.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N

        indoorPatientItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        indoorPatientItem.setText("Indoor Patient");
        jMenu1.add(indoorPatientItem);

        outdoorPatientItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        outdoorPatientItem.setText("Outdoor Patient");
        jMenu1.add(outdoorPatientItem);

        releasePatientItem.setText("Release Patient");
        jMenu1.add(releasePatientItem);

        exitItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        exitItem.setText("Exit");
        jMenu1.add(exitItem);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Data Entry");
        jMenu2.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N

        doctorEntryItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK));
        doctorEntryItem.setText("Doctor Entry");
        jMenu2.add(doctorEntryItem);

        staffEntryItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        staffEntryItem.setText("Staff Entry");
        jMenu2.add(staffEntryItem);

        bedEntryItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK));
        bedEntryItem.setText("Bed Entry");
        jMenu2.add(bedEntryItem);

        scheduleEntryItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        scheduleEntryItem.setText("Schedule Entry");
        
        jMenu2.add(scheduleEntryItem);

        patientDiseaseEntryItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        patientDiseaseEntryItem.setText("Patient-Disease");
        jMenu2.add(patientDiseaseEntryItem);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Search");
        jMenu3.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N

        searchPatientItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        searchPatientItem.setText("Indoor Patient");
        jMenu3.add(searchPatientItem);

        searchOutdoorPatientItem.setText("Outdoor Patient");
        jMenu3.add(searchOutdoorPatientItem);

        searchDoctorItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        searchDoctorItem.setText("Doctor");
        jMenu3.add(searchDoctorItem);

        searchStaffItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        searchStaffItem.setText("Staff");
        jMenu3.add(searchStaffItem);

        searchBedItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        searchBedItem.setText("Bed");
        jMenu3.add(searchBedItem);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Information");
        jMenu4.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N

        availableBedInfoItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        availableBedInfoItem.setText("Available Bed");
        jMenu4.add(availableBedInfoItem);

        doctorScheduleInfoItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        doctorScheduleInfoItem.setText("Doctor Schedule");
        jMenu4.add(doctorScheduleInfoItem);

        jMenuBar1.add(jMenu4);

        dropTablesItem.setText("Admin");
        dropTablesItem.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N

        createAlltablesItem.setText("Create All Tables");
        dropTablesItem.add(createAlltablesItem);

        dropAllTablesItem.setText("Drop All Tables");
        dropTablesItem.add(dropAllTablesItem);

        deleteEntry.setText("Delete Entry");
        dropTablesItem.add(deleteEntry);

        jMenuBar1.add(dropTablesItem);

        jMenu6.setText("About Us");
        jMenu6.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N

        aboutUsItem.setText("About Us");
        jMenu6.add(aboutUsItem);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Help");
        jMenu7.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N

        helpItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.SHIFT_MASK));
        helpItem.setText("Help");
        jMenu7.add(helpItem);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 757, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 451, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutUsItem;
    private javax.swing.JMenuItem availableBedInfoItem;
    private javax.swing.JMenuItem bedEntryItem;
    private javax.swing.JMenuItem createAlltablesItem;
    private javax.swing.JMenuItem deleteEntry;
    private javax.swing.JMenuItem doctorEntryItem;
    private javax.swing.JMenuItem doctorScheduleInfoItem;
    private javax.swing.JMenuItem dropAllTablesItem;
    private javax.swing.JMenu dropTablesItem;
    private javax.swing.JMenuItem exitItem;
    private javax.swing.JMenuItem helpItem;
    private javax.swing.JMenuItem indoorPatientItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem outdoorPatientItem;
    private javax.swing.JMenuItem patientDiseaseEntryItem;
    private javax.swing.JMenuItem releasePatientItem;
    private javax.swing.JMenuItem scheduleEntryItem;
    private javax.swing.JMenuItem searchBedItem;
    private javax.swing.JMenuItem searchDoctorItem;
    private javax.swing.JMenuItem searchOutdoorPatientItem;
    private javax.swing.JMenuItem searchPatientItem;
    private javax.swing.JMenuItem searchStaffItem;
    private javax.swing.JMenuItem staffEntryItem;
    // End of variables declaration//GEN-END:variables
}
