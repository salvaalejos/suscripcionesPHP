/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Entities;

/**
 *
 * @author hfyh
 */
public class Sucursal {
    private Integer idSucursal;
    private String name;
    private String direction;
    private Double percentageAdmin;
    private Double percentageSucursal;
    private String phone;
    private boolean status;

    // Nombres de las columnas en la base de datos
    public static final String ID_SUCURSAL = "idSucursal";
    public static final String NAME = "name";
    public static final String DIRECTION = "direction";
    public static final String PERCENTAGE_ADMIN = "percentageAdmin";
    public static final String PERCENTAGE_SUCURSAL = "percentageSucursal";
    public static final String PHONE = "phone";
    public static final String STATUS = "status";

    public Sucursal(Integer idSucursal, String name, String direction, Double percentageAdmin, Double percentageSucursal, String phone, boolean status) {
        this.idSucursal = idSucursal;
        this.name = name;
        this.direction = direction;
        this.percentageAdmin = percentageAdmin;
        this.percentageSucursal = percentageSucursal;
        this.phone = phone;
        this.status = status;
    }

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Double getPercentageAdmin() {
        return percentageAdmin;
    }

    public void setPercentageAdmin(Double percentageAdmin) {
        this.percentageAdmin = percentageAdmin;
    }

    public Double getPercentageSucursal() {
        return percentageSucursal;
    }

    public void setPercentageSucursal(Double percentageSucursal) {
        this.percentageSucursal = percentageSucursal;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return this.getName(); // Devuelve el nombre como representación
    }
}
