/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

/**
 *
 * @author suong
 */

import addschedule.AddSchedule;
import java.util.Date;
import java.text.SimpleDateFormat;
public class FillDateTime extends javax.swing.JFrame {

    /**
     * Creates new form FillDateTime
     */
    public FillDateTime(AddSchedule addSchedule) {
        initComponents();
        setLocationRelativeTo(null);
        this.addSchedule = addSchedule;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        announcement = new javax.swing.JLabel();
        DateField = new javax.swing.JTextField();
        TimeField = new javax.swing.JTextField();
        SubmitButton = new javax.swing.JButton();
        ReturnButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ngày:");

        jLabel2.setText("Giờ:");

        announcement.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        announcement.setText("Vui lòng nhập ngày và thời gian bắt đầu của suất chiếu!");

        DateField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        TimeField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TimeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimeFieldActionPerformed(evt);
            }
        });

        SubmitButton.setText("Xác Nhận");
        SubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitButtonActionPerformed(evt);
            }
        });

        ReturnButton.setText("Quay Lại");
        ReturnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(announcement, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TimeField, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(DateField))))
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SubmitButton)
                .addGap(29, 29, 29)
                .addComponent(ReturnButton)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(announcement)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(DateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TimeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SubmitButton)
                    .addComponent(ReturnButton))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TimeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TimeFieldActionPerformed

    private void SubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitButtonActionPerformed
        // TODO add your handling code here:
        if(CheckValidDate(DateField.getText() , TimeField.getText()))
        {
            addSchedule.setDateTime(DateField.getText().trim() + " " +  TimeField.getText().trim());
            dispose();
            new FillPriceTicket(addSchedule).setVisible(true);
        }
        else
        {
            announcement.setText("Vui lòng nhập ngày và giờ đúng quy định!");
            DateField.setText("dd/MM/yyyy");
            TimeField.setText("HH:mm:ss");
        }
    }//GEN-LAST:event_SubmitButtonActionPerformed

    private void ReturnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnButtonActionPerformed
        // TODO add your handling code here:
        dispose();
        new ChoiceRoomFrm(addSchedule).setVisible(true);
    }//GEN-LAST:event_ReturnButtonActionPerformed

    private boolean CheckValidDate(String Date , String Time)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date nowDate = new Date();
        try
        {
            Date checkDate = sdf.parse(Date.trim() + " " + Time.trim());
            if (checkDate.compareTo(nowDate) >= 0)
            {
                return true;
            }
            else return false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    private AddSchedule addSchedule;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DateField;
    private javax.swing.JButton ReturnButton;
    private javax.swing.JButton SubmitButton;
    private javax.swing.JTextField TimeField;
    private javax.swing.JLabel announcement;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
