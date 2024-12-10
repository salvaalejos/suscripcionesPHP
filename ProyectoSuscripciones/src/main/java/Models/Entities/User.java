/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Entities;

import Models.DBManager;

import java.sql.ResultSet;

/**
 *
 * @author hfyh
 */
public class User {
    private Integer id_user;
    private String name;
    private String username;
    private String password;
    private String phone;
    private int user_type; // 1 = admin, 2 = user, 3 = cashier, 4 = sucursal
    private Integer idSucursal;
    private String email;
    private boolean status;

    // Nombres de las columnas en la base de datos
    public static final String ID_USER = "idUser";
    public static final String NAME = "name";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String PHONE = "phone";
    public static final String USER_TYPE = "user_type";
    public static final String ID_SUCURSAL = "Sucursal_idSucursal";
    public static final String EMAIL = "email";
    public static final String STATUS = "status";



    public User(Integer id_user, String name, String username, String phone, int user_type, Integer idSucursal, String email, boolean status, String password) {
        this.id_user = id_user;
        this.name = name;
        this.username = username;
        this.phone = phone;
        this.user_type = user_type;
        this.idSucursal = idSucursal;
        this.email = email;
        this.password = password;
        this.status = status;

    }




    public User(){}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getUser_type() {
        return user_type;
    }

    public void setUser_type(int user_type) {
        this.user_type = user_type;
    }

    public Integer getSucursal() {
        return idSucursal;
    }

    public void setSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public User getUser(){
        return this;
    }
    
}
