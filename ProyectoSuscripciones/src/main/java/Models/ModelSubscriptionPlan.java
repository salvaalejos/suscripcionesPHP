package Models;

import Models.Entities.Comition;
import Models.Entities.SubscriptionPlan;
import Utilities.Util;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Form;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static Models.Entities.SubscriptionPlan.*;

public class ModelSubscriptionPlan {

    public ModelSubscriptionPlan() {}


    public SubscriptionPlan byId(Integer idSubscriptionPlan) throws Exception {
        SubscriptionPlan s = null;

        Form form = Form.form();
        form.add("idSubscriptionPlan", idSubscriptionPlan.toString());

        try {
            JSONObject json = Util.requestJsonObj(form, "ModelSubscriptionPlan/endPointByIdSubscriptionPlan.php");
            if(json != null && !json.toString().equals("Error")) {
                s = new Gson().fromJson(json.toString(), SubscriptionPlan.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return s;
    }

    public ArrayList<SubscriptionPlan> bySucursal(Integer idSucursal) throws Exception {
        ArrayList<SubscriptionPlan> subscriptionPlans = new ArrayList<>();

        Form form = Form.form();
        form.add("idSucursal", idSucursal.toString());

        try {
            JSONArray array = Util.requestArray(form, "ModelSubscriptionPlan/endPointBySucursal.php");

            if(array != null) {
                java.lang.reflect.Type listType = new TypeToken<ArrayList<SubscriptionPlan>>() {}.getType();
                subscriptionPlans = new Gson().fromJson(array.toString(), listType);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return subscriptionPlans;
    }

    public ArrayList<SubscriptionPlan> getAll() throws Exception {
        ArrayList<SubscriptionPlan> subscriptionPlans = new ArrayList<>();

        try {
            Form form = Form.form();
            JSONArray array = Util.requestArray(form, "ModelSubscriptionPlan/endPointGetAllPlan.php");

            if(array != null) {
                java.lang.reflect.Type listType = new TypeToken<ArrayList<SubscriptionPlan>>() {}.getType();
                subscriptionPlans = new Gson().fromJson(array.toString(), listType);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return subscriptionPlans;
    }

    public void add(SubscriptionPlan s) throws Exception {
        Form form = Form.form();
        form.add("price", s.getPrice().toString());
        form.add("title", s.getTitle());
        form.add("description", s.getDescription());
        form.add("Sucursal_idSucursal", s.getSucursal_idSucursal().toString());
        form.add("status", s.isStatus() ? "1" : "0");

        try{
            Util.request(form, "ModelSubscriptionPlan/endPointAddPlan.php");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean delete(Integer idSubscriptionPlan) throws Exception {
        boolean result = false;

        Form form = Form.form();
        form.add("idSubscriptionPlan", idSubscriptionPlan.toString());

        try {
            JSONObject json = Util.requestJsonObj(form, "ModelSubscriptionPlan/endPointDeletePlan.php");
            if(json != null && !json.toString().equals("Error")) {
                result = new Gson().fromJson(json.toString(), boolean.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public void update(SubscriptionPlan s) throws Exception {
        Form form = Form.form();
        form.add("idSubscriptionPlan", s.getIdSubscriptionPlan().toString());
        form.add("price", s.getPrice().toString());
        form.add("title", s.getTitle());
        form.add("description", s.getDescription());
        form.add("idSucursal", s.getSucursal_idSucursal().toString());
        form.add("status", s.isStatus() ? "1" : "0");

        try{
            Util.request(form, "ModelSubscriptionPlan/endPointUpdatePlan.php");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
