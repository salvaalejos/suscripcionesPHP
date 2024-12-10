/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Entities;

/**
 *
 * @author hfyh
 */
public class Subscription {
    private Integer id_subscription;
    private Integer user;
    private String start_date;
    private String end_date;
    private boolean status;
    private Integer subscriptionPlan;

    // Nombre de las columnas en la base de datos
    public static final String ID_SUBSCRIPTION = "idSubscription";
    public static final String USER = "User_idUser";
    public static final String START_DATE = "start_date";
    public static final String END_DATE = "end_date";
    public static final String STATUS = "status";
    public static final String SUBSCRIPTION_PLAN = "SubscriptionPlan_idSubscriptionPlan";


    public Subscription(Integer id_subscription, Integer user, String start_date, String end_date, boolean status, Integer subscriptionPlan) {
        this.id_subscription = id_subscription;
        this.user = user;
        this.start_date = start_date;
        this.end_date = end_date;
        this.status = status;
        this.subscriptionPlan = subscriptionPlan;
    }

    public Integer getId_subscription() {
        return id_subscription;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Integer getSubscriptionPlan() {
        return subscriptionPlan;
    }

    public void setSubscriptionPlan(Integer subscriptionPlan) {
        this.subscriptionPlan = subscriptionPlan;
    }
}
