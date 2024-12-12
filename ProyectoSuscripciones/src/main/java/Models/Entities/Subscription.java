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
    private Integer idSubscription;
    private Integer User_idUser;
    private String start_date;
    private String end_date;
    private boolean status;
    private Integer SubscriptionPlan_idSubscriptionPlan;

    // Nombre de las columnas en la base de datos
    public static final String ID_SUBSCRIPTION = "idSubscription";
    public static final String USER = "User_idUser";
    public static final String START_DATE = "start_date";
    public static final String END_DATE = "end_date";
    public static final String STATUS = "status";
    public static final String SUBSCRIPTION_PLAN = "SubscriptionPlan_idSubscriptionPlan";


    public Subscription(Integer idSubscription, Integer User_idUser, String start_date, String end_date, boolean status, Integer SubscriptionPlan_idSubscriptionPlan) {
        this.idSubscription = idSubscription;
        this.User_idUser = User_idUser;
        this.start_date = start_date;
        this.end_date = end_date;
        this.status = status;
        this.SubscriptionPlan_idSubscriptionPlan = SubscriptionPlan_idSubscriptionPlan;
    }

    public Integer getIdSubscription() {
        return idSubscription;
    }

    public Integer getUser_idUser() {
        return User_idUser;
    }

    public void setUser_idUser(Integer user_idUser) {
        this.User_idUser = user_idUser;
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

    public Integer getSubscriptionPlan_idSubscriptionPlan() {
        return SubscriptionPlan_idSubscriptionPlan;
    }

    public void setSubscriptionPlan_idSubscriptionPlan(Integer subscriptionPlan_idSubscriptionPlan) {
        this.SubscriptionPlan_idSubscriptionPlan = subscriptionPlan_idSubscriptionPlan;
    }
}
