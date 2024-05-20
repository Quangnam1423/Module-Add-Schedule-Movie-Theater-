/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import addschedule.AddSchedule;

/**
 *
 * @author suong
 */
public class ManagementFrm extends javax.swing.JFrame {

    /**
     * Creates new form ManagementFrm
     */
    public ManagementFrm(AddSchedule addSchedule) {
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

        AddScheduleButton = new javax.swing.JButton();
        DeleteScheduleButton = new javax.swing.JButton();
        ShowScheduleMovie = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AddScheduleButton.setText("Thêm Lịch Chiếu");
        AddScheduleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddScheduleButtonActionPerformed(evt);
            }
        });

        DeleteScheduleButton.setText("Xóa Lịch Chiếu");
        DeleteScheduleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteScheduleButtonActionPerformed(evt);
            }
        });

        ShowScheduleMovie.setText("Xem Lịch Chiếu");
        ShowScheduleMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowScheduleMovieActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Vui lòng chọn chức năng bên dưới!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DeleteScheduleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ShowScheduleMovie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AddScheduleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(60, 60, 60)
                .addComponent(AddScheduleButton)
                .addGap(29, 29, 29)
                .addComponent(DeleteScheduleButton)
                .addGap(33, 33, 33)
                .addComponent(ShowScheduleMovie)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddScheduleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddScheduleButtonActionPerformed
        // TODO add your handling code here:
        dispose();
        new ChoiceMovieFrm(addSchedule).setVisible(true);
    }//GEN-LAST:event_AddScheduleButtonActionPerformed

    private void DeleteScheduleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteScheduleButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteScheduleButtonActionPerformed

    private void ShowScheduleMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowScheduleMovieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ShowScheduleMovieActionPerformed

    private AddSchedule addSchedule;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddScheduleButton;
    private javax.swing.JButton DeleteScheduleButton;
    private javax.swing.JButton ShowScheduleMovie;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
