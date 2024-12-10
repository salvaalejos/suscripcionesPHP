package Models;

import Models.Entities.Comition;
import Models.Entities.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static Models.Entities.Comition.*;

public class ModelComition {
    private DBManager db;

    public ModelComition() {
        db = new DBManager("localhost", "3306", "root", "0451alejos@", "proyectoSuscripciones");
    }

    public ModelComition(DBManager db) {
        this.db = db;
    }

    public void addComition(Comition comition) throws Exception {
        String sql = "INSERT INTO comition (Subscription_idSubscription, amount, comition_date, User_idSeller) VALUES (?,?,?,?);";

        db.open();
        PreparedStatement pstmt = db.getCon().prepareStatement(sql);

        pstmt.setInt(1, comition.getSubscription());
        pstmt.setDouble(2, comition.getAmount());
        pstmt.setString(3, comition.getComition_date());
        pstmt.setInt(4, comition.getSeller());

        pstmt.executeUpdate();
        pstmt.close();

        db.close();
    }

    public ArrayList<Comition> bySeller(User seller) throws Exception {
        String sql = "SELECT * FROM comition WHERE User_idSeller = ?;";
        db.open();
        PreparedStatement pstmt = db.getCon().prepareStatement(sql);
        pstmt.setInt(1, seller.getId_user());

        ResultSet rs = pstmt.executeQuery();
        ArrayList<Comition> comitions = new ArrayList<>();
        while (rs.next()) {

            Integer idComition = rs.getInt(ID_COMITION);
            Integer subscription= rs.getInt(ID_SUBSCRIPTION);
            Double amount = rs.getDouble(AMOUNT);
            String comition_date = rs.getString(COMITION_DATE);
            Comition comition = new Comition(idComition, seller.getId_user(), subscription, amount, comition_date);
            comitions.add(comition);
        }
        rs.close();
        pstmt.close();
        db.close();

        return comitions;
    }
}
