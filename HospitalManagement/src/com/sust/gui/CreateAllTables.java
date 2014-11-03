
package com.sust.gui;

import com.sust.db.DB;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author MAHADI HASAN NAHID
 */
public class CreateAllTables extends javax.swing.JFrame 
implements ActionListener {


    public CreateAllTables() {
        super("Create All Tables");
        initComponents();
        setPosition();
        setVisible(true);
        setResizable(false);
        
        createAllTableButton.addActionListener(this);
        closeButton.addActionListener(this);
        statusArea.setText("create table indoor_patient\n"
                + "create table outdoor_patient\n"
                + "create table indoor_patient_phone\n"
                + "create table indoor_patient_relative\n"
                + "create table patient_dates\n"
                + "create table staff \n"
                + "create table staff_mob\n"
                + "create table doctor\n"
                + "create table doctor_mob\n"
                + "create table doctor_duty \n"
                + "create table indoor_patient_doctor\n"
                + "create table bed \n"
                + "create table indoor_patient_bed\n"
                + "create table indoor_patient_bill\n"
                + "create table indoor_patient_disease\n"
                + "");
        
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
        
        if(event.getSource()==createAllTableButton){
            db.createAllTables();
        }
        else if(event.getSource() == closeButton){
            dispose();
        }
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        createAllTableButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        statusArea = new javax.swing.JTextArea();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        createAllTableButton.setText("Create All Tables");

        statusArea.setColumns(20);
        statusArea.setRows(5);
        jScrollPane1.setViewportView(statusArea);

        closeButton.setText("Close");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(closeButton)
                .addGap(47, 47, 47))
            .addGroup(layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(createAllTableButton)
                .addContainerGap(164, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(createAllTableButton)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(closeButton)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JButton createAllTableButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea statusArea;
    // End of variables declaration//GEN-END:variables

    
}
