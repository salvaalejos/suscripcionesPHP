package Models;

import Models.Entities.User;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static Models.Entities.User.*;

public class ModelUser {
    private DBManager db;
    String ruta = USERNAME;
    public ModelUser() {
        db = new DBManager("localhost", "3306", "root", "0451alejos@", "proyectoSuscripciones");
    }

    public ModelUser(DBManager db) {
        this.db = db;
    }

    public User login(String usr, String pass) throws Exception {
        String sql = "SELECT * FROM user WHERE username=? AND password=SHA1(?) LIMIT 1";

        User u = null;

        db.open();
        PreparedStatement pstmt = db.getCon().prepareStatement(sql);
        pstmt.setString(1, usr);
        pstmt.setString(2, pass);


        ResultSet rs = pstmt.executeQuery();
        if(rs.next()) {

            u = new User();
            u.setId_user(rs.getInt(ID_USER));
            u.setUsername(rs.getString(USERNAME));
            u.setPassword(rs.getString(PASSWORD));
            u.setName(rs.getString(NAME));
            u.setUser_type(rs.getInt(USER_TYPE));
            u.setPhone(rs.getString(PHONE));
            u.setStatus(rs.getBoolean(STATUS));
            u.setEmail(rs.getString(EMAIL));
            u.setSucursal(rs.getInt(ID_SUCURSAL));

        }
        rs.close();
        pstmt.close();
        db.close();

        return u;
    }

    public User register(User user) throws Exception {
        String name = user.getName();
        String username = user.getUsername();
        String phone = user.getPhone();
        int user_type = user.getUser_type();
        int idSucursal = user.getSucursal();
        String email = user.getEmail();
        boolean status = user.isStatus();
        String password = user.getPassword();

        String sql = "INSERT INTO user (name, username, phone, user_type, Sucursal_idSucursal, email, status, password) VALUES (?, ?, ?, ?, ?, ?, ?, SHA1(?))";

        User u = null;

        db.open();
        PreparedStatement pstmt = db.getCon().prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, username);
        pstmt.setString(3, phone);
        pstmt.setInt(4, user_type);
        pstmt.setInt(5, idSucursal);
        pstmt.setString(6, email);
        pstmt.setBoolean(7, status);
        pstmt.setString(8, password);


        pstmt.executeUpdate();
        pstmt.close();
        db.close();

        u = login(username, password);

        return u;
    }

    public void registerAdmin(User user) throws Exception {
        String name = user.getName();
        String username = user.getUsername();
        String phone = user.getPhone();
        int user_type = user.getUser_type();
        String email = user.getEmail();
        boolean status = user.isStatus();
        String password = user.getPassword();

        String sql = "INSERT INTO user (name, username, phone, user_type, email, status, password) VALUES (?, ?, ?, ?, ?, ?, SHA1(?))";

        User u = null;

        db.open();
        PreparedStatement pstmt = db.getCon().prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, username);
        pstmt.setString(3, phone);
        pstmt.setInt(4, user_type);
        pstmt.setString(5, email);
        pstmt.setBoolean(6, status);
        pstmt.setString(7, password);


        pstmt.executeUpdate();
        pstmt.close();
        db.close();
    }

    public User byId(Integer idUser) throws Exception {
        User u = null;

        String sql = "SELECT * FROM user WHERE idUser = ?;";
        db.open();
        PreparedStatement pstmt = db.getCon().prepareStatement(sql);
        pstmt.setInt(1, idUser);

        ResultSet rs = pstmt.executeQuery();
        while(rs.next()) {
            Integer id = rs.getInt(ID_USER);
            String name = rs.getString(NAME);
            String username = rs.getString(USERNAME);
            String phone = rs.getString(PHONE);
            int user_type = rs.getInt(USER_TYPE);
            int idSucursal = rs.getInt(ID_SUCURSAL);
            String email = rs.getString(EMAIL);
            boolean status = rs.getBoolean(STATUS);
            String password = rs.getString(PASSWORD);
            u = new User(id, name, username, phone, user_type, idSucursal, email, status, password);
        }
        rs.close();
        pstmt.close();
        db.close();

        return u;
    }

    public void update(User user) throws Exception {
        Integer idUser = user.getId_user();
        String name = user.getName();
        String username = user.getUsername();
        String phone = user.getPhone();
        int user_type = user.getUser_type();
        int idSucursal = user.getSucursal();
        String email = user.getEmail();
        boolean status = user.isStatus();

        String sql = "UPDATE user SET name = ?, username = ?, phone = ?, user_type = ?, Sucursal_idSucursal = ?, email = ?, status = ? WHERE idUser = ?";

        db.open();
        PreparedStatement pstmt = db.getCon().prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, username);
        pstmt.setString(3, phone);
        pstmt.setInt(4, user_type);
        pstmt.setInt(5, idSucursal);
        pstmt.setString(6, email);
        pstmt.setBoolean(7, status);
        pstmt.setInt(8, idUser);

        pstmt.executeUpdate();
        pstmt.close();
        db.close();
    }

    public ArrayList<User> getAll() throws Exception {
        ArrayList<User> users = new ArrayList<>();

        String sql = "SELECT * FROM user";
        db.open();

        ResultSet rs = db.getStm().executeQuery(sql);
        while(rs.next()) {
            Integer id = rs.getInt(ID_USER);
            String name = rs.getString(NAME);
            String username = rs.getString(USERNAME);
            String phone = rs.getString(PHONE);
            int user_type = rs.getInt(USER_TYPE);
            int idSucursal = rs.getInt(ID_SUCURSAL);
            String email = rs.getString(EMAIL);
            boolean status = rs.getBoolean(STATUS);
            String password = rs.getString(PASSWORD);
            User u = new User(id, name, username, phone, user_type, idSucursal, email, status, password);
            users.add(u);
        }
        rs.close();

        db.close();

        return users;
    }

    public ArrayList<User> getSellers() throws Exception {
        ArrayList<User> users = new ArrayList<>();

        String sql = "SELECT * FROM user WHERE user_type = 3";
        db.open();

        ResultSet rs = db.getStm().executeQuery(sql);
        while(rs.next()) {
            Integer id = rs.getInt(ID_USER);
            String name = rs.getString(NAME);
            String username = rs.getString(USERNAME);
            String phone = rs.getString(PHONE);
            int user_type = rs.getInt(USER_TYPE);
            int idSucursal = rs.getInt(ID_SUCURSAL);
            String email = rs.getString(EMAIL);
            boolean status = rs.getBoolean(STATUS);
            String password = rs.getString(PASSWORD);
            User u = new User(id, name, username, phone, user_type, idSucursal, email, status, password);
            users.add(u);
        }
        rs.close();

        db.close();

        return users;
    }

    public ArrayList<User> getAdmins() throws Exception {
        ArrayList<User> users = new ArrayList<>();

        String sql = "SELECT * FROM user WHERE user_type = 1";
        db.open();

        ResultSet rs = db.getStm().executeQuery(sql);
        while(rs.next()) {
            Integer id = rs.getInt(ID_USER);
            String name = rs.getString(NAME);
            String username = rs.getString(USERNAME);
            String phone = rs.getString(PHONE);
            int user_type = rs.getInt(USER_TYPE);
            int idSucursal = rs.getInt(ID_SUCURSAL);
            String email = rs.getString(EMAIL);
            boolean status = rs.getBoolean(STATUS);
            String password = rs.getString(PASSWORD);
            User u = new User(id, name, username, phone, user_type, idSucursal, email, status, password);
            users.add(u);
        }
        rs.close();

        db.close();

        return users;
    }

    public ArrayList<User> getClients() throws Exception {
        ArrayList<User> users = new ArrayList<>();

        String sql = "SELECT * FROM user WHERE user_type = 2";
        db.open();

        ResultSet rs = db.getStm().executeQuery(sql);
        while(rs.next()) {
            Integer id = rs.getInt(ID_USER);
            String name = rs.getString(NAME);
            String username = rs.getString(USERNAME);
            String phone = rs.getString(PHONE);
            int user_type = rs.getInt(USER_TYPE);
            int idSucursal = rs.getInt(ID_SUCURSAL);
            String email = rs.getString(EMAIL);
            boolean status = rs.getBoolean(STATUS);
            String password = rs.getString(PASSWORD);
            User u = new User(id, name, username, phone, user_type, idSucursal, email, status, password);
            users.add(u);
        }
        rs.close();

        db.close();

        return users;
    }

    public boolean delete(Integer idUser) throws Exception {
        String sql = "DELETE FROM user WHERE idUser = ?";
        db.open();
        PreparedStatement pstmt = db.getCon().prepareStatement(sql);
        pstmt.setInt(1, idUser);

        int rows = pstmt.executeUpdate();
        pstmt.close();
        db.close();
        return rows > 0;
    }


}
