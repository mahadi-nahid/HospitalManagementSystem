
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
public class DropAllTables extends javax.swing.JFrame 
implements ActionListener{

    public DropAllTables() {
        super("Drop All Tables");
        
        initComponents();
        setPosition();
        statusArea.setText("drop table bed;drop table doctor;\n"
                + "drop table doctor_duty;\n"
                + "drop table doctor_mob;\n"
                + "drop table indoor_patient;\n"
                + "drop table indoor_patient_bed;\n"
                + "drop table indoor_patient_bill;\n"
                + "drop table indoor_patient_disease;\n"
                + "drop table inddor_patient_doctor;\n"
                + "drop table indoor_patient_phone;\n"
                + "drop table indoor_patient_relative;\n"
                + "drop table outdoor_patient;\n"
                + "drop table patient_dates;\n"
                + "drop table staff;\n"
                + "drop table staff_mob;");
        
        dropAllTablesButton.addActionListener(this);
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
        if(event.getSource() == dropAllTablesButton){
            DB db = new DB();
            db.dropAllTables();
        }
        else if(event.getSource() == closeButton){
            dispose();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dropAllTablesButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        statusArea = new javax.swing.JTextArea();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dropAllTablesButton.setText("Drop All Tables");

        statusArea.setColumns(20);
        statusArea.setRows(5);
        jScrollPane1.setViewportView(statusArea);

        closeButton.setText("Close");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(dropAllTablesButton)))
                .addContainerGap(86, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(closeButton)
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(dropAllTablesButton)
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(closeButton)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JButton dropAllTablesButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea statusArea;
    // End of variables declaration//GEN-END:variables

    
}
