package Models;

import Models.Entities.Sucursal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static Models.Entities.Sucursal.*;

public class ModelSucursal {
    private DBManager db;

    public ModelSucursal() {
        db = new DBManager("localhost", "3306", "root", "0451alejos@", "proyectoSuscripciones");
    }

    public ModelSucursal(DBManager db) {
        this.db = db;
    }

    public ArrayList<Sucursal> getAll() throws Exception {
        String sql = "SELECT * FROM sucursal";

        ArrayList<Sucursal> sucursales = new ArrayList<Sucursal>();

        db.open();

        ResultSet rs = db.getStm().executeQuery(sql);
        while(rs.next()) {
            Integer idSucursal = rs.getInt(ID_SUCURSAL);
            String name = rs.getString(NAME);
            String direction = rs.getString(DIRECTION);
            Double percentageAdmin = rs.getDouble(PERCENTAGE_ADMIN);
            Double percetageSucursal = rs.getDouble(PERCENTAGE_SUCURSAL);
            String phone = rs.getString(PHONE);
            boolean status = rs.getBoolean(STATUS);
            Sucursal s = new Sucursal(idSucursal, name, direction, percentageAdmin, percetageSucursal, phone, status);

            sucursales.add(s);
        }
        rs.close();

        db.close();

        return sucursales;
    }

    public ArrayList<Sucursal> getActives() throws Exception {
        String sql = "SELECT * FROM sucursal WHERE status = 1";

        ArrayList<Sucursal> sucursales = new ArrayList<Sucursal>();

        db.open();

        ResultSet rs = db.getStm().executeQuery(sql);
        while(rs.next()) {
            Integer idSucursal = rs.getInt(ID_SUCURSAL);
            String name = rs.getString(NAME);
            String direction = rs.getString(DIRECTION);
            Double percentageAdmin = rs.getDouble(PERCENTAGE_ADMIN);
            Double percetageSucursal = rs.getDouble(PERCENTAGE_SUCURSAL);
            String phone = rs.getString(PHONE);
            boolean status = rs.getBoolean(STATUS);
            Sucursal s = new Sucursal(idSucursal, name, direction, percentageAdmin, percetageSucursal, phone, status);

            sucursales.add(s);
        }
        rs.close();

        db.close();

        return sucursales;
    }
    
    public Sucursal byUser(Integer idUser) throws Exception{
        Sucursal s = null;
        
        String sql = "SELECT * FROM Sucursal WHERE idSucursal = (SELECT idSucursal FROM User WHERE idUser = ?);";
        db.open();
        PreparedStatement pstmt = db.getCon().prepareStatement(sql);
        pstmt.setInt(1, idUser);

        
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()) {
            Integer idSucursal = rs.getInt(ID_SUCURSAL);
            String name = rs.getString(NAME);
            String direction = rs.getString(DIRECTION);
            Double percentageAdmin = rs.getDouble(PERCENTAGE_ADMIN);
            Double percetageSucursal = rs.getDouble(PERCENTAGE_SUCURSAL);
            String phone = rs.getString(PHONE);
            boolean status = rs.getBoolean(STATUS);
            s = new Sucursal(idSucursal, name, direction, percentageAdmin, percetageSucursal, phone, status);
        }
        rs.close();
        pstmt.close();
        db.close();
        
        return s;
    }

    public Sucursal byId(Integer idSucursal) throws Exception{
        Sucursal s = null;

        String sql = "SELECT * FROM Sucursal WHERE idSucursal = ?;";
        db.open();
        PreparedStatement pstmt = db.getCon().prepareStatement(sql);
        pstmt.setInt(1, idSucursal);

        ResultSet rs = pstmt.executeQuery();
        while(rs.next()) {
            Integer id = rs.getInt(ID_SUCURSAL);
            String name = rs.getString(NAME);
            String direction = rs.getString(DIRECTION);
            Double percentageAdmin = rs.getDouble(PERCENTAGE_ADMIN);
            Double percetageSucursal = rs.getDouble(PERCENTAGE_SUCURSAL);
            String phone = rs.getString(PHONE);
            boolean status = rs.getBoolean(STATUS);
            s = new Sucursal(id, name, direction, percentageAdmin, percetageSucursal, phone, status);
        }
        rs.close();
        pstmt.close();
        db.close();

        return s;
    }

    public void addSucursal(Sucursal s) throws Exception {
        String name = s.getNombre();
        String direction = s.getDireccion();
        Double percentageAdmin = s.getPorcentajeGananciaAdmin();
        Double percentageSucursal = 100-percentageAdmin;
        String phone = s.getTelefono();
        boolean status = s.isStatus();

        String sql = "INSERT INTO sucursal (name, direction, percentageAdmin, percentageSucursal, phone, status) VALUES (?, ?, ?, ?, ?, ?)";

        db.open();
        PreparedStatement pstmt = db.getCon().prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, direction);
        pstmt.setDouble(3, percentageAdmin);
        pstmt.setDouble(4, percentageSucursal);
        pstmt.setString(5, phone);
        pstmt.setBoolean(6, status);

        pstmt.executeUpdate();
        pstmt.close();
        db.close();
    }

    public void updateSucursal(Sucursal s) throws Exception {
        Integer idSucursal = s.getIdSucursal();
        String name = s.getNombre();
        String direction = s.getDireccion();
        Double percentageAdmin = s.getPorcentajeGananciaAdmin();
        Double percentageSucursal = 100-percentageAdmin;
        String phone = s.getTelefono();
        boolean status = s.isStatus();

        String sql = "UPDATE sucursal SET name = ?, direction = ?, percentageAdmin = ?, percentageSucursal = ?, phone = ?, status = ? WHERE idSucursal = ?;";

        db.open();
        PreparedStatement pstmt = db.getCon().prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, direction);
        pstmt.setDouble(3, percentageAdmin);
        pstmt.setDouble(4, percentageSucursal);
        pstmt.setString(5, phone);
        pstmt.setBoolean(6, status);
        pstmt.setInt(7, idSucursal);

        pstmt.executeUpdate();
        pstmt.close();
        db.close();
    }

    public void deleteSucursal(Integer idSucursal) throws Exception {
        String sql = "DELETE FROM sucursal WHERE idSucursal = ?;";

        db.open();
        PreparedStatement pstmt = db.getCon().prepareStatement(sql);
        pstmt.setInt(1, idSucursal);

        pstmt.executeUpdate();
        pstmt.close();
        db.close();
    }

}
