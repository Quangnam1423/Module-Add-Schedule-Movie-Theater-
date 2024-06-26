/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

/**
 *
 * @author suong
 */

import model.*;
import DAO.*;
import addschedule.AddSchedule;
import javax.swing.SwingUtilities;
public class LoginFrm extends javax.swing.JFrame {

    /**
     * Creates new form LoginFrm
     */
    public LoginFrm(AddSchedule addSchedule) {
        initComponents();
        userDAO = new UserDAO();
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

        UsernameField = new javax.swing.JTextField();
        PasswordField = new javax.swing.JPasswordField();
        UserLabel = new javax.swing.JLabel();
        PasswordLabel = new javax.swing.JLabel();
        SubmitButton = new javax.swing.JButton();
        Announcement = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        UserLabel.setText("UserName:");

        PasswordLabel.setText("Password: ");

        SubmitButton.setText("Xác Nhận");
        SubmitButton.setActionCommand("Đăng Nhập");
        SubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitButtonActionPerformed(evt);
            }
        });

        Announcement.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Announcement.setText("Vui lòng nhập Username và Password");
        Announcement.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(UserLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                    .addComponent(PasswordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(PasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(UsernameField))
                .addGap(105, 105, 105))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(Announcement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(187, Short.MAX_VALUE)
                .addComponent(SubmitButton)
                .addGap(185, 185, 185))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(Announcement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UserLabel))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PasswordLabel))
                .addGap(71, 71, 71)
                .addComponent(SubmitButton)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitButtonActionPerformed
        // TODO add your handling code here:
        String username = UsernameField.getText();
        String password = PasswordField.getText();
        boolean check = userDAO.checkValidLogin(new User(username , password));
        if(check)
        {
            dispose();
            new ManagementFrm(addSchedule).setVisible(true);
        }
        else
        {
            Announcement.setText("Vui lòng nhập lại tài khoản hoặc mật khẩu!");
            UsernameField.setText("");
            PasswordField.setText("");
        }
    }//GEN-LAST:event_SubmitButtonActionPerformed

//    public static void main(String[] args) {
//        // Tạo và hiển thị MainFrame
//        AddSchedule addSchedule = new AddSchedule();
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new LoginFrm(addSchedule).setVisible(true);
//            }
//        });
//    }
    
    private UserDAO userDAO;
    private AddSchedule addSchedule;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Announcement;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JButton SubmitButton;
    private javax.swing.JLabel UserLabel;
    private javax.swing.JTextField UsernameField;
    // End of variables declaration//GEN-END:variables
}

