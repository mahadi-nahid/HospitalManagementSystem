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
public class SearchStaff extends javax.swing.JFrame
        implements ActionListener {

    /**
     * Creates new form SearchStaff
     */
    public SearchStaff() {
        super("Search Staff");
        initComponents();
        setPosition();

        buttonGroup1.add(staffIdRadioButton);
        buttonGroup1.add(sMobRadioButton);
        buttonGroup1.add(firstNameRadioButton);
        buttonGroup1.add(lastNameRadioButton);
        buttonGroup1.add(deptRadioButton);

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
        ArrayList<String> staffInfo = new ArrayList<String>();
        DefaultTableModel dtm = new DefaultTableModel();

        if (event.getSource() == searchButton) {
            if (staffIdRadioButton.isSelected()) {
                staffInfo = db.searchStaff(1, searchKeyField.getText());
            } else if (sMobRadioButton.isSelected()) {
                staffInfo = db.searchStaff(2, searchKeyField.getText());
            } else if (firstNameRadioButton.isSelected()) {
                staffInfo = db.searchStaff(3, searchKeyField.getText());
            } else if (lastNameRadioButton.isSelected()) {
                staffInfo = db.searchStaff(4, searchKeyField.getText());
            } else if (deptRadioButton.isSelected()) {
                staffInfo = db.searchStaff(5, searchKeyField.getText());
            }

            //---------------

            if (staffInfo.size() == 0) {
                JOptionPane.showMessageDialog(this, "Not Found");
            } else {
                dtm.addColumn("S_ID");
                dtm.addColumn("S_FNAME");
                dtm.addColumn("S_LNAME");
                dtm.addColumn("S_AGE");
                dtm.addColumn("S_SEX");

                dtm.addColumn("S_DEPT");
                dtm.addColumn("SALARY");
                dtm.addColumn("S_ADDRESS");

                dtm.addColumn("MOB");



                String[] row = new String[9];
                int j = 0;

                //JOptionPane.showMessageDialog(this, "" + patientInfo.size());
                for (int i = 1; i <= staffInfo.size(); i++) {
                    row[j] = staffInfo.get(i - 1);
                    if (i % 9 == 0) {
                        row[j] = staffInfo.get(i - 1);
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
        staffIdRadioButton = new javax.swing.JRadioButton();
        sMobRadioButton = new javax.swing.JRadioButton();
        firstNameRadioButton = new javax.swing.JRadioButton();
        lastNameRadioButton = new javax.swing.JRadioButton();
        deptRadioButton = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        searchKeyField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        searchResultTable = new javax.swing.JTable();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Maiandra GD", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Search Staff");

        jSeparator1.setBackground(new java.awt.Color(0, 153, 255));
        jSeparator1.setForeground(new java.awt.Color(0, 51, 255));

        jLabel2.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        jLabel2.setText("Search By:");

        staffIdRadioButton.setText("Staff ID");

        sMobRadioButton.setText("Mobile No.");

        firstNameRadioButton.setText("First Name");

        lastNameRadioButton.setText("Last Name");

        deptRadioButton.setText("Department");

        jLabel3.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        jLabel3.setText("Search Key:");

        searchKeyField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        searchButton.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        searchButton.setText("Search");

        jSeparator2.setBackground(new java.awt.Color(0, 153, 255));
        jSeparator2.setForeground(new java.awt.Color(0, 51, 255));

        jLabel4.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        jLabel4.setText("Result:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(368, 368, 368)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(399, 399, 399))
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(168, 168, 168)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(staffIdRadioButton)
                                    .addComponent(sMobRadioButton))
                                .addGap(78, 78, 78)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lastNameRadioButton)
                                    .addComponent(firstNameRadioButton))))
                        .addGap(64, 64, 64)
                        .addComponent(deptRadioButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(searchKeyField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(searchButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel4)))
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
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(staffIdRadioButton)
                    .addComponent(firstNameRadioButton)
                    .addComponent(deptRadioButton))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameRadioButton)
                    .addComponent(sMobRadioButton))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(searchKeyField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(closeButton)
                        .addGap(58, 58, 58))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(closeButton)
                .addContainerGap(16, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
    private javax.swing.JRadioButton sMobRadioButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchKeyField;
    private javax.swing.JTable searchResultTable;
    private javax.swing.JRadioButton staffIdRadioButton;
    // End of variables declaration//GEN-END:variables
}
