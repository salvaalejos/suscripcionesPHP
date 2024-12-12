/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Entities;

/**
 *
 * @author hfyh
 */
public class User {
    private Integer idUser;
    private String name;
    private String username;
    private String password;
    private String phone;
    private Integer user_type; // 1 = admin, 2 = user, 3 = cashier, 4 = sucursal
    private Integer Sucursal_idSucursal;
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



    public User(Integer idUser, String name, String username, String phone, Integer user_type, Integer Sucursal_idSucursal, String email, boolean status, String password) {
        this.idUser = idUser;
        this.name = name;
        this.username = username;
        this.phone = phone;
        this.user_type = user_type;
        this.Sucursal_idSucursal = Sucursal_idSucursal;
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

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
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

    public Integer getUser_type() {
        return user_type;
    }

    public void setUser_type(Integer user_type) {
        this.user_type = user_type;
    }

    public Integer getSucursal() {
        return Sucursal_idSucursal;
    }

    public void setSucursal(Integer idSucursal) {
        this.Sucursal_idSucursal = idSucursal;
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
