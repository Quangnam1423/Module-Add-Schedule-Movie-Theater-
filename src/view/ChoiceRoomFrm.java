/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

/**
 *
 * @author suong
 */

import DAO.*;
import addschedule.AddSchedule;
import model.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
public class ChoiceRoomFrm extends javax.swing.JFrame {

    /**
     * 
     * @param addSchedule 
     */
    public ChoiceRoomFrm(AddSchedule addSchedule) {
        initComponents();
        setLocationRelativeTo(null);
        roomDao = new RoomDAO();
        array = roomDao.getAllRoom();
        this.addSchedule = addSchedule;
        defaultTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
                jTable1.setModel(defaultTableModel);
        
        defaultTableModel.addColumn("Mã Phòng");
        defaultTableModel.addColumn("Tên Phòng");
        defaultTableModel.addColumn("Công Nghệ Chiếu");

        
        for (Room x : array)
        {
            defaultTableModel.addRow(new Object[]{
                            x.getRoomId() , x.getRoomName() , x.getMultiDemensional()
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        announcement = new javax.swing.JLabel();
        SubmitButton = new javax.swing.JButton();
        ReturnButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        RoomField = new javax.swing.JTextField();
        LocButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã Phòng", "Tên Phòng", "Công Nghệ Chiếu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        announcement.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        announcement.setText("Vui lòng chọn phòng chiếu!");

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

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tên Phòng");

        RoomField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        RoomField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomFieldActionPerformed(evt);
            }
        });

        LocButton.setBackground(new java.awt.Color(102, 204, 255));
        LocButton.setText("Lọc");
        LocButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(announcement, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(RoomField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LocButton)
                        .addGap(29, 29, 29)
                        .addComponent(SubmitButton)
                        .addGap(31, 31, 31)
                        .addComponent(ReturnButton)))
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(announcement)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(RoomField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SubmitButton)
                    .addComponent(ReturnButton)
                    .addComponent(LocButton))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RoomFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RoomFieldActionPerformed

    private void LocButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocButtonActionPerformed
       // TODO add your handling code here:
       if (!RoomField.getText().equals(""))
       {
            defaultTableModel.setColumnCount(0);

            array = roomDao.searchRoom(RoomField.getText());
            if(!array.isEmpty())
            {
                for (Room x : array)
                {
                    defaultTableModel.addRow(new Object[]{
                                    x.getRoomId() , x.getRoomName() , x.getMultiDemensional()
                    });
                }     
            }
            else
            {
                announcement.setText("Không có phòng nào giống như tên phòng đã nhập!");
            }
        }
    }//GEN-LAST:event_LocButtonActionPerformed

    private void SubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitButtonActionPerformed
        // TODO add your handling code here:
        if (jTable1.getSelectedRow() != -1)
        {
            int selectedRow = jTable1.getSelectedRow();
            
            int roomId = (int)jTable1.getValueAt(selectedRow , 0);
            String roomName = (String) jTable1.getValueAt(selectedRow, 1);
            String multiDimensional = (String) jTable1.getValueAt(selectedRow, 2);
            
            //set Room for addSchedule
            addSchedule.setRoom(new Room(roomId , roomName , multiDimensional));
            dispose();
            new FillDateTime(addSchedule).setVisible(true);
        }
        else
        {
            announcement.setText("Vui lòng chọn một phòng chiếu trước khi tiếp tục!");
        }

    }//GEN-LAST:event_SubmitButtonActionPerformed

    private void ReturnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnButtonActionPerformed
        // TODO add your handling code here:
        dispose();
        new ChoiceMovieFrm(addSchedule).setVisible(true);
    }//GEN-LAST:event_ReturnButtonActionPerformed

    private ArrayList<Room> array;
    private RoomDAO roomDao;
    private DefaultTableModel defaultTableModel;
    private AddSchedule addSchedule;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LocButton;
    private javax.swing.JButton ReturnButton;
    private javax.swing.JTextField RoomField;
    private javax.swing.JButton SubmitButton;
    private javax.swing.JLabel announcement;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
