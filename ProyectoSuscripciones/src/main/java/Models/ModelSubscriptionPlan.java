package Models;

import Models.Entities.SubscriptionPlan;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static Models.Entities.SubscriptionPlan.*;

public class ModelSubscriptionPlan {
    private DBManager db;

    public ModelSubscriptionPlan() {
        db = new DBManager("localhost", "3306", "root", "0451alejos@", "proyectoSuscripciones");
    }

    public ModelSubscriptionPlan(DBManager db) {
        this.db = db;
    }

    public SubscriptionPlan byId(Integer idSubscriptionPlan) throws Exception {
        SubscriptionPlan s = null;

        String sql = "SELECT * FROM subscriptionplan WHERE idSubscriptionPlan = ?;";
        db.open();
        PreparedStatement pstmt = db.getCon().prepareStatement(sql);
        pstmt.setInt(1, idSubscriptionPlan);

        ResultSet rs = pstmt.executeQuery();
        while(rs.next()) {
            String title = rs.getString(TITLE);
            Double price = rs.getDouble(PRICE);
            String description = rs.getString(DESCRIPTION);
            boolean status = rs.getBoolean(STATUS);
            Integer idSucursal = rs.getInt(ID_SUCURSAL);

            s = new SubscriptionPlan(idSubscriptionPlan,price, title, description, idSucursal, status );
        }
        rs.close();
        pstmt.close();

        db.close();

        return s;
    }

    public ArrayList<SubscriptionPlan> bySucursal(Integer idSucursal) throws Exception {
        ArrayList<SubscriptionPlan> subscriptionPlans = new ArrayList<>();

        String sql = "SELECT * FROM subscriptionplan WHERE Sucursal_idSucursal = ?;";
        db.open();
        PreparedStatement pstmt = db.getCon().prepareStatement(sql);
        pstmt.setInt(1, idSucursal);

        ResultSet rs = pstmt.executeQuery();
        while(rs.next()) {
            Integer idSubscriptionPlan = rs.getInt(ID_SUBSCRIPTION_PLAN);
            String title = rs.getString(TITLE);
            Double price = rs.getDouble(PRICE);
            String description = rs.getString(DESCRIPTION);
            boolean status = rs.getBoolean(STATUS);

            SubscriptionPlan s = new SubscriptionPlan(idSubscriptionPlan,price, title, description, idSucursal, status );
            subscriptionPlans.add(s);
        }
        rs.close();
        pstmt.close();
        db.close();

        return subscriptionPlans;
    }

    public ArrayList<SubscriptionPlan> getAll() throws Exception {
        ArrayList<SubscriptionPlan> subscriptionPlans = new ArrayList<>();

        String sql = "SELECT * FROM subscriptionplan;";
        db.open();

        ResultSet rs = db.getStm().executeQuery(sql);
        while(rs.next()) {
            Integer idSubscriptionPlan = rs.getInt(ID_SUBSCRIPTION_PLAN);
            String title = rs.getString(TITLE);
            Double price = rs.getDouble(PRICE);
            String description = rs.getString(DESCRIPTION);
            boolean status = rs.getBoolean(STATUS);
            Integer idSucursal = rs.getInt(ID_SUCURSAL);

            SubscriptionPlan s = new SubscriptionPlan(idSubscriptionPlan,price, title, description, idSucursal, status );
            subscriptionPlans.add(s);
        }
        rs.close();

        db.close();

        return subscriptionPlans;
    }

    public void add(SubscriptionPlan s) throws Exception {
        String sql = "INSERT INTO subscriptionplan (price, title, description, Sucursal_idSucursal, status) VALUES (?, ?, ?, ?, ?);";
        db.open();
        PreparedStatement pstmt = db.getCon().prepareStatement(sql);
        pstmt.setDouble(1, s.getPrice());
        pstmt.setString(2, s.getTitle());
        pstmt.setString(3, s.getDescription());
        pstmt.setInt(4, s.getSucursal());
        pstmt.setBoolean(5, s.isStatus());

        pstmt.executeUpdate();
        pstmt.close();

        db.close();
    }

    public boolean delete(Integer idSubscriptionPlan) throws Exception {
        String sql = "DELETE FROM subscriptionplan WHERE idSubscriptionPlan = ?;";
        db.open();
        PreparedStatement pstmt = db.getCon().prepareStatement(sql);
        pstmt.setInt(1, idSubscriptionPlan);


        int rows = pstmt.executeUpdate();

        pstmt.close();
        db.close();

        return rows > 0;
    }

    public void update(SubscriptionPlan s) throws Exception {
        String sql = "UPDATE subscriptionplan SET price = ?, title = ?, description = ?, Sucursal_idSucursal = ?, status = ? WHERE idSubscriptionPlan = ?;";
        db.open();
        PreparedStatement pstmt = db.getCon().prepareStatement(sql);
        pstmt.setDouble(1, s.getPrice());
        pstmt.setString(2, s.getTitle());
        pstmt.setString(3, s.getDescription());
        pstmt.setInt(4, s.getSucursal());
        pstmt.setBoolean(5, s.isStatus());
        pstmt.setInt(6, s.getIdSubscriptionPlan());


        pstmt.executeUpdate();
        pstmt.close();
        db.close();
    }
}
