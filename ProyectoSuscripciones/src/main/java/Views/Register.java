/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Models.Entities.Sucursal;
import Models.Entities.User;
import Models.ModelSucursal;
import Models.ModelUser;
import Utilities.Authentication;
import Utilities.Paths;
import static Utilities.Paths.SUCURSAL_FILE;
import static Utilities.Paths.USER_FILE;

import Views.Seller_Views.HomeSellerPanel;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author hfyh
 */
public class Register extends javax.swing.JFrame {

    /**
     * Creates new form Register
     */
    private int actualTheme;
    private ArrayList<Sucursal> sucursales = new ArrayList<Sucursal>();
    private ArrayList<Sucursal> sucursalesList = new ArrayList<Sucursal>();
    private User seller = null;
    private HomeSellerPanel parent = null;
    
    private ModelSucursal modelSucursal = new ModelSucursal();
    private ModelUser modelUser = new ModelUser();
    
    public Register() {
        initComponents();
        setLocationRelativeTo(null);
        panelImage1.setIcon(new ImageIcon(Paths.PONY_LOGO));
        setLocationRelativeTo(null);
    }
    
    public Register(int actualTheme) {
        this.actualTheme = actualTheme;
        if(actualTheme == 1){
            FlatLightLaf.setup();
        } else if(actualTheme == 0){
            FlatDarkLaf.setup();
        }
        initComponents();
        panelImage1.setIcon(new ImageIcon(Paths.PONY_LOGO));
        
        setLocationRelativeTo(null);
    }
    
    public Register(User seller, HomeSellerPanel parent) {
        this.parent = parent;
        this.seller = seller;
        initComponents();
        setLocationRelativeTo(null);
        panelImage1.setIcon(new ImageIcon(Paths.PONY_LOGO));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        jLabel1 = new javax.swing.JLabel();
        fieldName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        fieldPassword = new javax.swing.JPasswordField();
        btnTheme = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        fieldUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        fieldEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        fieldPhone = new javax.swing.JTextField();
        sucursalSelector = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fieldRepeatPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(245, 245, 249));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        jPanel1.add(panelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 250, 250));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nombre");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 180, -1));

        fieldName.setBackground(new java.awt.Color(255, 255, 255));
        fieldName.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        fieldName.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(fieldName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 180, 30));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Contraseña");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 170, -1));

        btnRegister.setBackground(new java.awt.Color(51, 51, 255));
        btnRegister.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister.setText("Registrar");
        btnRegister.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 580, 120, 40));

        btnCancel.setBackground(new java.awt.Color(255, 102, 102));
        btnCancel.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 580, 120, 40));

        fieldPassword.setBackground(new java.awt.Color(255, 255, 255));
        fieldPassword.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        fieldPassword.setForeground(new java.awt.Color(0, 0, 0));
        fieldPassword.setToolTipText("");
        jPanel1.add(fieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 190, 30));

        btnTheme.setBackground(new java.awt.Color(245, 245, 249));
        btnTheme.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemeActionPerformed(evt);
            }
        });
        jPanel1.add(btnTheme, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 580, 40, 40));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nombre de usuario");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 180, -1));

        fieldUsername.setBackground(new java.awt.Color(255, 255, 255));
        fieldUsername.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        fieldUsername.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(fieldUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 180, 30));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Sucursal");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 180, -1));

        fieldEmail.setBackground(new java.awt.Color(255, 255, 255));
        fieldEmail.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        fieldEmail.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(fieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 180, 30));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Telefono");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, 190, -1));

        fieldPhone.setBackground(new java.awt.Color(255, 255, 255));
        fieldPhone.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        fieldPhone.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(fieldPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 430, 190, 30));

        sucursalSelector.setBackground(new java.awt.Color(255, 255, 255));
        sucursalSelector.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        sucursalSelector.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(sucursalSelector, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 180, 30));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Email");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 180, -1));

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Repetir contraseña");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 190, -1));

        fieldRepeatPassword.setBackground(new java.awt.Color(255, 255, 255));
        fieldRepeatPassword.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        fieldRepeatPassword.setForeground(new java.awt.Color(0, 0, 0));
        fieldRepeatPassword.setToolTipText("");
        jPanel1.add(fieldRepeatPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, 190, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemeActionPerformed
        // TODO add your handling code here:
        if( actualTheme == 1){
            actualTheme = 0;
            FlatDarkLaf.setup();
            SwingUtilities.updateComponentTreeUI(this);
            this.pack();
        } else if (actualTheme == 0){
            actualTheme = 1;
            FlatLightLaf.setup();
            SwingUtilities.updateComponentTreeUI(this);
            this.pack();
        }
    }//GEN-LAST:event_btnThemeActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
        String name = fieldName.getText();
        String username = fieldUsername.getText();
        String password = new String(fieldPassword.getPassword());
        String repeatPassword = new String(fieldRepeatPassword.getPassword());
        boolean passwordMatch = password.equals(repeatPassword);
        String phone = fieldPhone.getText();
        String email = fieldEmail.getText();

        System.out.println("Password: " + password);
        System.out.println("Repeat Password: " + repeatPassword);

        Sucursal sucursal = (Sucursal) sucursalSelector.getSelectedItem();
        
        if(!Authentication.validateEmail(email)){
            JOptionPane.showMessageDialog(null,"Por favor ingrese un email válido");
            return;
        }

        if (password.length() < 8) {
            JOptionPane.showMessageDialog(null,"La contraseña debe tener al menos 8 caracteres");
            return;
        }

        if(phone.length()<8){
            JOptionPane.showMessageDialog(null,"Ingrese un telefono válido");
            return;
        }
        
        if(name == null || username == null || phone == null || email == null || sucursal == null){
            JOptionPane.showMessageDialog(null,"Por favor llene todos los campos");
            return;
        }

        if (passwordMatch) {
            
            
            User userToRegister = new User(null, name, username, phone, 2, sucursal.getIdSucursal(), email, true, password);
            User user = null;
            
            try {
                user = new ModelUser().register(userToRegister);

                JOptionPane.showMessageDialog(null,"Usuario registrado con éxito");
                System.out.println("Nombre usuario: "+user.getName()+"\nSucursal: "+modelSucursal.byUser(user.getSucursal()));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Error al registrar usuario");
                e.printStackTrace();
            }
            
            if(seller != null){
                new ChooseSubscription(user, seller, parent).setVisible(true);
            } else{
                new ChooseSubscription(user).setVisible(true);
            }
            
            dispose();
        } else {
            JOptionPane.showMessageDialog(null,"Las contraseñas no coinciden");
        }

        
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        readSucursales();
    }//GEN-LAST:event_formWindowOpened

    
    private void readSucursales(){
        sucursales.clear();
        sucursalSelector.removeAll();
        try {


            if(seller != null){
                Sucursal sucursalSeller = new ModelSucursal().byUser(seller.getId_user());
                sucursalesList.add(sucursalSeller);
            } else{
                sucursalesList = new ModelSucursal().getActives();;
            }

            for(Sucursal sucursal : sucursalesList){
                sucursalSelector.addItem(sucursal);
            }

            sucursalSelector.updateUI();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnTheme;
    private javax.swing.JTextField fieldEmail;
    private javax.swing.JTextField fieldName;
    private javax.swing.JPasswordField fieldPassword;
    private javax.swing.JTextField fieldPhone;
    private javax.swing.JPasswordField fieldRepeatPassword;
    private javax.swing.JTextField fieldUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private javax.swing.JComboBox<Sucursal> sucursalSelector;
    // End of variables declaration//GEN-END:variables
}
