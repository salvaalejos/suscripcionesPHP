package Models;

import Models.Entities.Payment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static Models.Entities.Payment.*;

public class ModelPayment {
    private DBManager db;

    public ModelPayment() {
        db = new DBManager("localhost", "3306", "root", "0451alejos@", "proyectoSuscripciones");
    }

    public ModelPayment(DBManager db) {
        this.db = db;
    }

    public ArrayList<Payment> getAll() throws Exception{
        ArrayList<Payment> payments = new ArrayList<>();

        String sql = "SELECT * FROM payment;";
        db.open();

        ResultSet rs = db.getStm().executeQuery(sql);
        while(rs.next()) {
            Integer idPayment = rs.getInt(ID_PAYMENT);
            Integer idSubscription = rs.getInt(ID_SUBSCRIPTION);
            Double amount = rs.getDouble(AMOUNT);
            String payment_date = rs.getString(PAYMENT_DATE);

            Payment p = new Payment(idPayment,idSubscription, amount, payment_date);
            payments.add(p);
        }
        rs.close();

        db.close();

        return payments;
    }

    public void addPayment(Payment payment) throws Exception {
        String sql = "INSERT INTO payment (Subscription_idSubscription, amount, payment_date) VALUES (?, ?, ?);";

        db.open();
        PreparedStatement pstmt = db.getCon().prepareStatement(sql);

        pstmt.setInt(1, payment.getSubscription());
        pstmt.setDouble(2, payment.getAmount());
        pstmt.setString(3, payment.getPayment_date());

        pstmt.executeUpdate();
        pstmt.close();

        db.close();
    }

    public ArrayList<Payment> getPaymentsBySubscription(Integer idSubscription) throws Exception {
        ArrayList<Payment> payments = new ArrayList<>();

        String sql = "SELECT * FROM payment WHERE Subscription_idSubscription = ?;";
        db.open();

        PreparedStatement pstmt = db.getCon().prepareStatement(sql);

        pstmt.setInt(1, idSubscription);




        ResultSet rs = pstmt.executeQuery();
        while(rs.next()) {
            Integer idPayment = rs.getInt(ID_PAYMENT);
            Double amount = rs.getDouble(AMOUNT);
            String payment_date = rs.getString(PAYMENT_DATE);

            Payment p = new Payment(idPayment, idSubscription, amount, payment_date);
            payments.add(p);
        }

        rs.close();
        pstmt.close();
        db.close();

        return payments;
    }
}
