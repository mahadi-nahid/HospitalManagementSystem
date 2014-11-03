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
public class SearchDoctor extends javax.swing.JFrame
        implements ActionListener {
    
    public SearchDoctor() {
        super("Search Doctor");
        initComponents();
        setPosition();
        
        buttonGroup1.add(doctorIdRadioButton);
        buttonGroup1.add(dMobRadioButton);
        buttonGroup1.add(firstNameRadioButton);
        buttonGroup1.add(lastNameRadioButton);
        buttonGroup1.add(deptRadioButton);
        buttonGroup1.add(degreeRadioButton);
        
        setVisible(true);
        setResizable(false);
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
        ArrayList<String> doctorInfo = new ArrayList<String>();
        DefaultTableModel dtm = new DefaultTableModel();
        
        if (event.getSource() == searchButton) {
            if (doctorIdRadioButton.isSelected()) {
                
                doctorInfo = db.searchDoctor(1, searchKeyField.getText());
                
            } else if (dMobRadioButton.isSelected()) {
                doctorInfo = db.searchDoctor(2, searchKeyField.getText());
            } else if (firstNameRadioButton.isSelected()) {
                doctorInfo = db.searchDoctor(3, searchKeyField.getText());
            } else if (lastNameRadioButton.isSelected()) {
                doctorInfo = db.searchDoctor(4, searchKeyField.getText());
            } else if (deptRadioButton.isSelected()) {
                doctorInfo = db.searchDoctor(5, searchKeyField.getText());
            } else if (degreeRadioButton.isSelected()) {
                doctorInfo = db.searchDoctor(6, searchKeyField.getText());
            }


            //-----------------
            
            if (doctorInfo.size() == 0) {
                JOptionPane.showMessageDialog(this, "Not Found");
            } else {
                dtm.addColumn("D_ID");
                dtm.addColumn("D_FNAME");
                dtm.addColumn("D_LNAME");
                
                dtm.addColumn("D_SEX");
                dtm.addColumn("D_DOB");
                dtm.addColumn("P_DEPT");
                dtm.addColumn("D_DEGREE");
                dtm.addColumn("SALARY");
                dtm.addColumn("D_ADDRESS");
                
                dtm.addColumn("MOB");
                
                
                
                String[] row = new String[10];
                int j = 0;

                //JOptionPane.showMessageDialog(this, "" + patientInfo.size());
                for (int i = 1; i <= doctorInfo.size(); i++) {
                    row[j] = doctorInfo.get(i - 1);
                    if (i % 10 == 0) {
                        row[j] = doctorInfo.get(i - 1);
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
        doctorIdRadioButton = new javax.swing.JRadioButton();
        firstNameRadioButton = new javax.swing.JRadioButton();
        dMobRadioButton = new javax.swing.JRadioButton();
        lastNameRadioButton = new javax.swing.JRadioButton();
        deptRadioButton = new javax.swing.JRadioButton();
        degreeRadioButton = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        searchKeyField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        searchResultTable = new javax.swing.JTable();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Maiandra GD", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Search Doctor");

        jSeparator1.setBackground(new java.awt.Color(51, 102, 255));
        jSeparator1.setForeground(new java.awt.Color(0, 51, 204));

        jLabel2.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        jLabel2.setText("Search By:");

        doctorIdRadioButton.setText("Doctor ID");

        firstNameRadioButton.setText("First Name");

        dMobRadioButton.setText("Mobile No.");

        lastNameRadioButton.setText("Last Name");

        deptRadioButton.setText("Department ");

        degreeRadioButton.setText("Degree");

        jLabel3.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        jLabel3.setText("Search Key:");

        searchButton.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        searchButton.setText("Search");

        jSeparator2.setBackground(new java.awt.Color(0, 102, 255));
        jSeparator2.setForeground(new java.awt.Color(0, 51, 204));

        jLabel5.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        jLabel5.setText("Result:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(369, 369, 369)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(358, 358, 358))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(156, 156, 156)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(doctorIdRadioButton)
                                    .addComponent(dMobRadioButton))
                                .addGap(51, 51, 51)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(firstNameRadioButton)
                                    .addComponent(lastNameRadioButton))
                                .addGap(51, 51, 51)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(degreeRadioButton)
                                    .addComponent(deptRadioButton)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addComponent(searchKeyField, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(102, 102, 102)
                                .addComponent(searchButton))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jLabel5)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(doctorIdRadioButton)
                    .addComponent(firstNameRadioButton)
                    .addComponent(deptRadioButton))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dMobRadioButton)
                    .addComponent(lastNameRadioButton)
                    .addComponent(degreeRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(searchKeyField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel5))
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(closeButton)
                        .addGap(58, 58, 58))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(closeButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton closeButton;
    private javax.swing.JRadioButton dMobRadioButton;
    private javax.swing.JRadioButton degreeRadioButton;
    private javax.swing.JRadioButton deptRadioButton;
    private javax.swing.JRadioButton doctorIdRadioButton;
    private javax.swing.JRadioButton firstNameRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JRadioButton lastNameRadioButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchKeyField;
    private javax.swing.JTable searchResultTable;
    // End of variables declaration//GEN-END:variables
}
