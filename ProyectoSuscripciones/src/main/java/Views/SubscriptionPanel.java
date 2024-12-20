
package Views;

import Models.Entities.*;
import Models.ModelComition;
import Models.ModelPayment;
import Models.ModelSubscription;
import Utilities.Util;
import Views.Client_Views.ControlPanelClients;
import Views.Seller_Views.HomeSellerPanel;
import com.google.gson.Gson;
import org.apache.http.client.fluent.Form;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.time.LocalDate;


/**
 *
 * @author hfyh
 */
public class SubscriptionPanel extends javax.swing.JPanel {

    //////////// Listo con WS ////////////

    private SubscriptionPlan plan;
    private User user = new User();
    private User seller = null;
    private HomeSellerPanel sellerFrame = null;
    private JFrame parent;

    public SubscriptionPanel() {
        initComponents();
    }

    public SubscriptionPanel(SubscriptionPlan plan, User user, JFrame parent) {
        this.plan = plan;
        this.user = user;
        this.parent = parent;
        initComponents();
        showSubscriptions();
    }

    SubscriptionPanel(SubscriptionPlan plan, User user, JFrame parent, User seller, HomeSellerPanel sellerFrame) {
        this.sellerFrame = sellerFrame;
        this.seller = seller;
        this.plan = plan;
        this.user = user;
        this.parent = parent;
        initComponents();
        showSubscriptions();
    }

    private void showSubscriptions() {
        lblTitle.setText(plan.getTitle());
        lblPrice.setText("$ " + plan.getPrice() + " mxn/mes");
        descriptionArea.setText(plan.getDescription());
    }


    private void addPayment(Payment payment) {
        try {
            new ModelPayment().addPayment(payment);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private String getStartDate(){
        LocalDate date = LocalDate.now();
        String startDate = date.toString();

        return startDate;
    }

    private String getEndDate(){
        LocalDate date = LocalDate.now().plusMonths(1);
        String endDate = date.toString();

        return endDate;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonRound1 = new org.edisoncor.gui.button.ButtonRound();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionArea = new javax.swing.JTextArea();
        btnChoose = new org.edisoncor.gui.button.ButtonSeven();

        buttonRound1.setText("buttonRound1");

        jPanel1.setBackground(new java.awt.Color(245, 245, 249));

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));

        lblTitle.setBackground(new java.awt.Color(51, 102, 255));
        lblTitle.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Nombre suscripción");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        lblPrice.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        lblPrice.setForeground(new java.awt.Color(0, 0, 0));
        lblPrice.setText("$ 0.00 mxn/mes");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        descriptionArea.setBackground(new java.awt.Color(245, 245, 249));
        descriptionArea.setColumns(20);
        descriptionArea.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        descriptionArea.setForeground(new java.awt.Color(0, 0, 0));
        descriptionArea.setLineWrap(true);
        descriptionArea.setRows(5);
        descriptionArea.setText("Obten un plan básico para que tengas comida dia a dia, por un modico precio");
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setViewportView(descriptionArea);

        btnChoose.setBackground(new java.awt.Color(0, 102, 255));
        btnChoose.setText("Escoger plan");
        btnChoose.setColorBrillo(new java.awt.Color(204, 204, 204));
        btnChoose.setColorDeSombra(new java.awt.Color(102, 102, 102));
        btnChoose.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        btnChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(btnChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPrice)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseActionPerformed
        // TODO add your handling code here:
        try {
            if (user == null || plan == null) {
                JOptionPane.showMessageDialog(this, "Usuario o plan no válido.");
                return;
            }
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas contratar este plan?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirmar == JOptionPane.NO_OPTION) {
                return;
            }

            Subscription s = new ModelSubscription().byUser(user.getIdUser());

            if (s != null) {
                JOptionPane.showMessageDialog(null, "Plan cambiado con éxito");
                s.setSubscriptionPlan_idSubscriptionPlan(this.plan.getIdSubscriptionPlan());
                s.setStart_date(getStartDate());
                s.setEnd_date(getEndDate());
                new ModelSubscription().update(s);


                Payment payment = new Payment(
                        null,
                        s.getIdSubscription(),
                        plan.getPrice(),
                        getStartDate()
                );
                addPayment(payment);
                new ControlPanelClients(user).setVisible(true);
                this.parent.dispose();
                return;
            }



            s = new Subscription(
                    null,
                    user.getIdUser(),
                    getStartDate(),
                    getEndDate(),
                    true,
                    plan.getIdSubscriptionPlan()
            );
            // new Payment
            // Añadir para cuando vende alguien

            addSubscription(s);
            Subscription newSub = new ModelSubscription().byUser(user.getIdUser());

            Payment payment = new Payment(
                    null,
                    newSub.getIdSubscription(),
                    plan.getPrice(),
                    getStartDate()
            );

            addPayment(payment);

            if(seller != null){
                Comition comition = new Comition(
                        null,
                        seller.getIdUser(),
                        newSub.getIdSubscription(),
                        payment.getAmount() * 0.1,
                        getStartDate()
                );
                addComition(comition);
                JOptionPane.showMessageDialog(null, "Plan vendido con éxito");
                sellerFrame.updateUI();

            } else{
                JOptionPane.showMessageDialog(null, "Plan contratado con éxito");
                new ControlPanelClients(user).setVisible(true);

            }
            this.parent.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al contratar plan: "+e.getMessage());
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnChooseActionPerformed

    private void addSubscription(Subscription subscription) {
        try {
            new ModelSubscription().addSubscription(subscription);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addComition(Comition comition) {
        try {
            new ModelComition().addComition(comition);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonSeven btnChoose;
    private org.edisoncor.gui.button.ButtonRound buttonRound1;
    private javax.swing.JTextArea descriptionArea;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
