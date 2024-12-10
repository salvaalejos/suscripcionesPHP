package Models;

import Models.Entities.Subscription;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static Models.Entities.Subscription.*;

public class ModelSubscription {
    private DBManager db;

    public ModelSubscription() {
        db = new DBManager("localhost", "3306", "root", "0451alejos@", "proyectoSuscripciones");
    }

    public ModelSubscription(DBManager db) {
        this.db = db;
    }

    public Subscription byUser(Integer idUser) throws Exception {
        Subscription s = null;

        String sql = "SELECT * FROM subscription WHERE User_idUser = ? LIMIT 1";
        db.open();
        PreparedStatement pstmt = db.getCon().prepareStatement(sql);
        pstmt.setInt(1, idUser);

        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Integer idSubscription = rs.getInt(ID_SUBSCRIPTION);
            String startDate = rs.getString(START_DATE);
            String endDate = rs.getString(END_DATE);
            boolean status = rs.getBoolean(STATUS);
            Integer subscriptionPlan = rs.getInt(SUBSCRIPTION_PLAN);

            s = new Subscription(idSubscription, idUser, startDate, endDate, status, subscriptionPlan);
        }
        rs.close();
        pstmt.close();
        db.close();

        return s;
    }

    public void update(Subscription subscription) throws Exception {
        String sql = "UPDATE subscription SET start_date = ?, end_date = ?, status = ?, SubscriptionPlan_idSubscriptionPlan = ? WHERE idSubscription = ?";
        db.open();
        PreparedStatement pstmt = db.getCon().prepareStatement(sql);

        pstmt.setString(1, subscription.getStart_date());
        pstmt.setString(2, subscription.getEnd_date());
        pstmt.setBoolean(3, subscription.isStatus());
        pstmt.setInt(4, subscription.getSubscriptionPlan());
        pstmt.setInt(5, subscription.getId_subscription());

        pstmt.executeUpdate();
        pstmt.close();
        db.close();
    }

    public void addSubscription(Subscription subscription) throws Exception {
        String sql = "INSERT INTO subscription (User_idUser, start_date, end_date, status, SubscriptionPlan_idSubscriptionPlan) VALUES (?, ?, ?, ?, ?)";
        db.open();

        PreparedStatement pstmt = db.getCon().prepareStatement(sql);

        pstmt.setInt(1, subscription.getUser());
        pstmt.setString(2, subscription.getStart_date());
        pstmt.setString(3, subscription.getEnd_date());
        pstmt.setBoolean(4, subscription.isStatus());
        pstmt.setInt(5, subscription.getSubscriptionPlan());

        pstmt.executeUpdate();
        pstmt.close();
        db.close();
    }

    public Subscription byId(Integer idSubscription) throws Exception {
        Subscription s = null;

        String sql = "SELECT * FROM subscription WHERE idSubscription = ?";
        db.open();
        PreparedStatement pstmt = db.getCon().prepareStatement(sql);
        pstmt.setInt(1, idSubscription);

        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Integer idUser = rs.getInt(USER);
            String startDate = rs.getString(START_DATE);
            String endDate = rs.getString(END_DATE);
            boolean status = rs.getBoolean(STATUS);
            Integer subscriptionPlan = rs.getInt(SUBSCRIPTION_PLAN);

            s = new Subscription(idSubscription, idUser, startDate, endDate, status, subscriptionPlan);
        }
        rs.close();
        pstmt.close();
        db.close();

        return s;
    }
}
