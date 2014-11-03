package com.sust.gui;

import com.sust.db.DB;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MAHADI HASAN NAHID
 */
public class SearchPatient extends javax.swing.JFrame
        implements ActionListener {

    public SearchPatient() {
        super("Search Patient");
        initComponents();
        setPosition();

        buttonGroup1.add(patientIdRadioButton);
        buttonGroup1.add(pMobRadioButton);
        buttonGroup1.add(firstNameRadioButton);
        buttonGroup1.add(lastNameRadioButton);
        buttonGroup1.add(relNameRadioButton);
        buttonGroup1.add(relMobRadioButton);
        buttonGroup1.add(deptRadioButton);

        setVisible(true);
        //setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        searchButton.addActionListener(this);
        closeButton.addActionListener(this);
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

        DB db = new DB();

        ArrayList<String> patientInfo = null;
        DefaultTableModel dtm = new DefaultTableModel();

        if (event.getSource() == searchButton) {

            if (patientIdRadioButton.isSelected()) {

                patientInfo = db.serachPatient(1, searchKeyField.getText());
                //db.serachPatient(1, searchKeyField.getText());

            } else if (pMobRadioButton.isSelected()) {

                patientInfo = db.serachPatient(2, searchKeyField.getText());

                searchResultTable.setModel(dtm);
            } else if (firstNameRadioButton.isSelected()) {
                //db.serachPatient(3, searchKeyField.getText());
                patientInfo = db.serachPatient(3, searchKeyField.getText());
            } else if (lastNameRadioButton.isSelected()) {
                patientInfo = db.serachPatient(4, searchKeyField.getText());
                // patient = db.serachPatient(4, searchKeyField.getText());
            } else if (relNameRadioButton.isSelected()) {
                patientInfo = db.serachPatient(5, searchKeyField.getText());
                // patient = db.serachPatient(5, searchKeyField.getText());
            } else if (relMobRadioButton.isSelected()) {
                patientInfo = db.serachPatient(6, searchKeyField.getText());
                //  patient = db.serachPatient(6, searchKeyField.getText());
            } else if (deptRadioButton.isSelected()) {
                patientInfo = db.serachPatient(7, searchKeyField.getText());
                // patient = db.serachPatient(7, searchKeyField.getText());
            }



            //-------------Table Insert------------------

            if (patientInfo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Not Found " + patientInfo.size());
            } else {
                dtm.addColumn("P_ID");
                dtm.addColumn("P_FNAME");
                dtm.addColumn("P_LNAME");

                dtm.addColumn("P_AGE");
                dtm.addColumn("P_SEX");
                dtm.addColumn("P_DEPT");
                dtm.addColumn("P_ADDRESS");
                dtm.addColumn("PHONE_NO");
                dtm.addColumn("B_ID");

                dtm.addColumn("DESCRIPTION");
                dtm.addColumn("MEDICINE");
                dtm.addColumn("D_ID");
                dtm.addColumn("REL_FNAME");
                dtm.addColumn("REL_LNAME");
                dtm.addColumn("REL_ADDRESS");
                dtm.addColumn("REL_MOB");
                dtm.addColumn("ADMISSION_DATE");
                dtm.addColumn("RELEASE_DATE");



                String[] row = new String[18];
                int j = 0;

                //JOptionPane.showMessageDialog(this, "" + patientInfo.size());
                for (int i = 1; i <= patientInfo.size(); i++) {
                    row[j] = patientInfo.get(i - 1);
                    if (i % 18 == 0) {
                        row[j] = patientInfo.get(i - 1);
                        dtm.addRow(row);
                        j = -1;
                    }
                    j++;
                }

                //JScrollPane jScrollPane = new JScrollPane(searchResultTable);
                searchResultTable.setModel(dtm);

            }
        } else if (event.getSource() == closeButton) {
            dispose();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        patientIdRadioButton = new javax.swing.JRadioButton();
        pMobRadioButton = new javax.swing.JRadioButton();
        firstNameRadioButton = new javax.swing.JRadioButton();
        lastNameRadioButton = new javax.swing.JRadioButton();
        relNameRadioButton = new javax.swing.JRadioButton();
        relMobRadioButton = new javax.swing.JRadioButton();
        deptRadioButton = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        searchKeyField = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        searchResultTable = new javax.swing.JTable();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Maiandra GD", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Search Patient");

        jSeparator1.setBackground(new java.awt.Color(0, 153, 204));
        jSeparator1.setForeground(new java.awt.Color(0, 51, 204));

        jLabel2.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        jLabel2.setText("Search By:");

        searchButton.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        searchButton.setText("Search");
        searchButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        patientIdRadioButton.setText("Patient ID");

        pMobRadioButton.setText("Patient Mobile No.");

        firstNameRadioButton.setText("First Name");

        lastNameRadioButton.setText("Last Name");

        relNameRadioButton.setText("Relative Name");

        relMobRadioButton.setText("Relative Mobile No.");

        deptRadioButton.setText("Department");

        jLabel3.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        jLabel3.setText("Search Key:");

        jSeparator2.setBackground(new java.awt.Color(0, 102, 255));
        jSeparator2.setForeground(new java.awt.Color(0, 51, 204));

        jLabel4.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        jLabel4.setText("Result:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(357, 357, 357)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(370, 370, 370))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(patientIdRadioButton)
                                    .addComponent(pMobRadioButton))
                                .addGap(53, 53, 53)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(firstNameRadioButton)
                                    .addComponent(lastNameRadioButton)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addComponent(searchKeyField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(searchButton)
                                .addComponent(relMobRadioButton))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(relNameRadioButton)
                                .addGap(51, 51, 51)
                                .addComponent(deptRadioButton))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel4)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(patientIdRadioButton)
                    .addComponent(firstNameRadioButton)
                    .addComponent(relNameRadioButton)
                    .addComponent(deptRadioButton))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pMobRadioButton)
                    .addComponent(lastNameRadioButton)
                    .addComponent(relMobRadioButton))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(searchKeyField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(21, 21, 21))
        );

        jScrollPane1.setViewportView(searchResultTable);

        closeButton.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        closeButton.setText("Close");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(closeButton)
                        .addGap(69, 69, 69))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(closeButton)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton closeButton;
    private javax.swing.JRadioButton deptRadioButton;
    private javax.swing.JRadioButton firstNameRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JRadioButton lastNameRadioButton;
    private javax.swing.JRadioButton pMobRadioButton;
    private javax.swing.JRadioButton patientIdRadioButton;
    private javax.swing.JRadioButton relMobRadioButton;
    private javax.swing.JRadioButton relNameRadioButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchKeyField;
    private javax.swing.JTable searchResultTable;
    // End of variables declaration//GEN-END:variables
}
