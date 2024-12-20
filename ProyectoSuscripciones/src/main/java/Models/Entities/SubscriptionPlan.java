/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Entities;

/**
 *
 * @author JESUS
 */
public class SubscriptionPlan {
    
    private Integer idSubscriptionPlan;
    private Double price;
    private String title;
    private String description;
    private Integer Sucursal_idSucursal;
    private boolean status;

    // Nombre de las columnas en la base de datos
    public static final String ID_SUBSCRIPTION_PLAN = "idSubscriptionPlan";
    public static final String PRICE = "price";
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String ID_SUCURSAL = "Sucursal_idSucursal";
    public static final String STATUS = "status";

    public SubscriptionPlan(Integer idSubscriptionPlan, Double price, String title, String description, Integer Sucursal_idSucursal, boolean status) {
        this.idSubscriptionPlan = idSubscriptionPlan;
        this.price = price;
        this.title = title;
        this.description = description;
        this.Sucursal_idSucursal = Sucursal_idSucursal;
        this.status = status;
    }

    public Integer getIdSubscriptionPlan() {
        return idSubscriptionPlan;
    }

    public void setIdSubscriptionPlan(Integer idSubscriptionPlan) {
        this.idSubscriptionPlan = idSubscriptionPlan;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSucursal_idSucursal() {
        return Sucursal_idSucursal;
    }

    public void setSucursal_idSucursal(Integer sucursal_idSucursal) {
        this.Sucursal_idSucursal = sucursal_idSucursal;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    
    
    
    
}
