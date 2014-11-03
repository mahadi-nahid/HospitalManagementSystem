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
public class SearchOutdoorPatient extends javax.swing.JFrame
        implements ActionListener {

    public SearchOutdoorPatient() {
        initComponents();

        setPosition();
        buttonGroup1.add(idradioButton);
        buttonGroup1.add(mobRadioButton);
        buttonGroup1.add(firstNameRadioButton);
        buttonGroup1.add(lastNameRadioButton);
        buttonGroup1.add(departmentRadioButton);
        buttonGroup1.add(doctorRadioButton);

        searchButton.addActionListener(this);
        closeButton.addActionListener(this);


        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void setPosition() {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screanSize = toolkit.getScreenSize();

        int screanHeight = screanSize.height;
        int screanWidth = screanSize.width;
        setLocation(screanWidth / 10, screanHeight / 25);

    }
    @Override
    public void actionPerformed(ActionEvent event) {
        DB db = new DB();

        DefaultTableModel dtm = new DefaultTableModel();
        ArrayList<String> info = new ArrayList<String>();
        if (event.getSource() == searchButton) {

            if (idradioButton.isSelected()) {
                info = db.searchOutdoorPatient(1, searchKeyField.getText());
            } else if (mobRadioButton.isSelected()) {
                info = db.searchOutdoorPatient(2, searchKeyField.getText());
            } else if (firstNameRadioButton.isSelected()) {
                info = db.searchOutdoorPatient(3, searchKeyField.getText());
            } else if (lastNameRadioButton.isSelected()) {
                info = db.searchOutdoorPatient(4, searchKeyField.getText());
            } else if (departmentRadioButton.isSelected()) {
                info = db.searchOutdoorPatient(5, searchKeyField.getText());
            } else if (doctorRadioButton.isSelected()) {
                info = db.searchOutdoorPatient(6, searchKeyField.getText());
            }



            //-----------------------------

            if (info.size() == 0) {
                JOptionPane.showMessageDialog(this, "Not Found " + info.size());
            } else {


                dtm.addColumn("P_ID");
                dtm.addColumn("P_FNAME");
                dtm.addColumn("P_LNAME");

                dtm.addColumn("P_AGE");
                dtm.addColumn("P_SEX");
                dtm.addColumn("P_DEPT");
                dtm.addColumn("P_ADDRESS");
                dtm.addColumn("MOB");
                dtm.addColumn("DOCTOR");

                dtm.addColumn("P_MEDICINE");

                dtm.addColumn("P_DATE");


                String[] row = new String[11];
                int j = 0;

                //JOptionPane.showMessageDialog(this, "" + info.size());

                for (int i = 1; i <= info.size(); i++) {
                    row[j] = info.get(i - 1);
                    if (i % 11 == 0) {
                        System.out.println("j:in " + j);
                        row[j] = info.get(i - 1);
                        dtm.addRow(row);
                        j = -1;
                        System.out.println("i = " + i);
                    }
                    System.out.println("j: " + j);
                    j++;
                }

                //JScrollPane jScrollPane = new JScrollPane(searchResultTable);
                outPatientinfoTable.setModel(dtm);

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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        idradioButton = new javax.swing.JRadioButton();
        mobRadioButton = new javax.swing.JRadioButton();
        firstNameRadioButton = new javax.swing.JRadioButton();
        lastNameRadioButton = new javax.swing.JRadioButton();
        departmentRadioButton = new javax.swing.JRadioButton();
        doctorRadioButton = new javax.swing.JRadioButton();
        searchButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        searchKeyField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        outPatientinfoTable = new javax.swing.JTable();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Search Outdoor Patient");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(307, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(292, 292, 292))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jLabel2.setText("Search By:");

        idradioButton.setText("Id");

        mobRadioButton.setText("Mob");

        firstNameRadioButton.setText("First Name");

        lastNameRadioButton.setText("Last Name");

        departmentRadioButton.setText("Department");

        doctorRadioButton.setText("Doctor");

        searchButton.setText("Search");

        jLabel3.setText("Key:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(mobRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lastNameRadioButton))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(idradioButton)
                                .addGap(27, 27, 27)
                                .addComponent(firstNameRadioButton)))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(departmentRadioButton)
                            .addComponent(doctorRadioButton)))
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(searchKeyField, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(searchButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idradioButton)
                    .addComponent(firstNameRadioButton)
                    .addComponent(departmentRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mobRadioButton)
                    .addComponent(lastNameRadioButton)
                    .addComponent(doctorRadioButton))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchButton)
                    .addComponent(jLabel3)
                    .addComponent(searchKeyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(outPatientinfoTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );

        closeButton.setText("Close");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(closeButton)
                .addGap(94, 94, 94))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(closeButton)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton closeButton;
    private javax.swing.JRadioButton departmentRadioButton;
    private javax.swing.JRadioButton doctorRadioButton;
    private javax.swing.JRadioButton firstNameRadioButton;
    private javax.swing.JRadioButton idradioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton lastNameRadioButton;
    private javax.swing.JRadioButton mobRadioButton;
    private javax.swing.JTable outPatientinfoTable;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchKeyField;
    // End of variables declaration//GEN-END:variables
}
