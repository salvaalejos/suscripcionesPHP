/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Models.Entities.SubscriptionPlan;
import Models.Entities.User;
import Models.ModelSubscriptionPlan;
import Models.ModelSucursal;
import Models.ModelUser;
import Utilities.Util;
import Views.Seller_Views.HomeSellerPanel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import static Utilities.Paths.SUBSCRIPTION_PLAN_FILE;
import Views.Client_Views.ControlPanelClients;
import org.apache.http.client.fluent.Form;
import org.json.simple.JSONArray;

/**
 *
 * @author hfyh
 */
public class ChooseSubscription extends javax.swing.JFrame {

    /**
     * Creates new form ChooseSubscription
     */
    private User user = new User();
    private HomeSellerPanel parent = null;
    private User seller = null;
    private ArrayList<SubscriptionPlan> plans = new ArrayList<SubscriptionPlan>();
    private ModelUser modelUser = new ModelUser();
    private ModelSubscriptionPlan modelSubscriptionPlan = new ModelSubscriptionPlan();
    private ModelSucursal modelSucursal = new ModelSucursal();
    


    public ChooseSubscription() {
        initComponents();
    }
    
    public ChooseSubscription(User user, User seller, HomeSellerPanel parent) {
        this.parent = parent;
        this.user = user;
        this.seller = seller;
        initComponents();
        btnContinue.setVisible(false);
        initializeData();
    }

    private void initializeData() {
        lblError.setVisible(false);
        showSubscriptions();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        System.out.println("Sucursal recibida: " + user.getSucursal());
    }

    public ChooseSubscription(User user) {
        this.user = user;
        System.out.println("Usuario: " + user.getName());
        System.out.println("Sucursal: "+user.getSucursal());
        this.seller = null;
        initComponents();
        btnContinue.setVisible(true);
        initializeData();
    }

    private void readSubscriptions() {
        plans.clear();

        try {
            plans = modelSubscriptionPlan.bySucursal(user.getSucursal());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showSubscriptions() {
        readSubscriptions();
        panelSubscriptions.removeAll();
        panelSubscriptions.revalidate();
        panelSubscriptions.repaint();

        int x = 10;
        int y = 10;
        int width = panelSubscriptions.getWidth()/2-10;
        int height = panelSubscriptions.getHeight()/2-10;
        if(plans.isEmpty()) {
            lblError.setVisible(true);
            return;
        }
        for (SubscriptionPlan plan : plans) {
            if(seller != null){
                SubscriptionPanel card = new SubscriptionPanel(plan, user, this, seller, parent); ///////////////////
                card.setBounds(x, y, width, height);
                panelSubscriptions.add(card);
                y += height + 10;
                if (y > panelSubscriptions.getHeight()) {
                    y = 10;
                    x += width + 10;
                }
                System.out.println("Creada tarjeta con vendedor");
            } else{
                SubscriptionPanel card = new SubscriptionPanel(plan, user, this);
                card.setBounds(x, y, width, height);
                panelSubscriptions.add(card);
                y += height + 10;
                if (y > panelSubscriptions.getHeight()) {
                    y = 10;
                    x += width + 10;
                }
            }

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

        jPanel1 = new javax.swing.JPanel();
        panelSubscriptions = new javax.swing.JPanel();
        btnContinue = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 245, 249));

        panelSubscriptions.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelSubscriptionsLayout = new javax.swing.GroupLayout(panelSubscriptions);
        panelSubscriptions.setLayout(panelSubscriptionsLayout);
        panelSubscriptionsLayout.setHorizontalGroup(
            panelSubscriptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        panelSubscriptionsLayout.setVerticalGroup(
            panelSubscriptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );

        btnContinue.setBackground(new java.awt.Color(51, 102, 255));
        btnContinue.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnContinue.setForeground(new java.awt.Color(255, 255, 255));
        btnContinue.setText("Continuar");
        btnContinue.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnContinue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinueActionPerformed(evt);
            }
        });

        lblError.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblError.setForeground(new java.awt.Color(204, 0, 0));
        lblError.setText("Lo sentimos! Aún no hay suscripciones para tu sucursal.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblError)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnContinue, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelSubscriptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(panelSubscriptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnContinue, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(11, 11, 11)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnContinueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinueActionPerformed
        // TODO add your handling code here:
        new ControlPanelClients(this.user).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnContinueActionPerformed

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
            java.util.logging.Logger.getLogger(ChooseSubscription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChooseSubscription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChooseSubscription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChooseSubscription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChooseSubscription().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinue;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblError;
    private javax.swing.JPanel panelSubscriptions;
    // End of variables declaration//GEN-END:variables
}
