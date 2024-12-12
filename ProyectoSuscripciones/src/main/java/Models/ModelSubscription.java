package Models;

import Models.Entities.Subscription;
import Utilities.Util;
import com.google.gson.Gson;
import org.apache.http.client.fluent.Form;
import org.json.simple.JSONObject;


public class ModelSubscription {

    public ModelSubscription() {
    }


    public Subscription byUser(Integer idUser) throws Exception {
        Subscription s = null;

        Form form2 = Form.form();
        form2.add("idUser", idUser.toString());

        try {
            JSONObject json = Util.requestJsonObj(form2, "ModelSubscription/endPointByUser.php");
            if(json != null && !json.toString().equals("Error")) {
                s = new Gson().fromJson(json.toString(), Subscription.class);
            }
        } catch (Exception e) {
            System.out.println("Error controlado, primera vez que se registra un usuario");
        }

        return s;
    }

    public void update(Subscription s) throws Exception {
        Form updateForm = Form.form();
        updateForm.add("idSubscription", s.getIdSubscription().toString());
        updateForm.add("SubscriptionPlan_idSubscriptionPlan", s.getSubscriptionPlan_idSubscriptionPlan().toString());
        updateForm.add("start_date", s.getStart_date());
        updateForm.add("end_date", s.getEnd_date());
        updateForm.add("status", s.isStatus() ? "1" : "0");

        try{
            Util.request(updateForm, "ModelSubscription/endPointUpdateSubscription.php");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addSubscription(Subscription subscription) throws Exception {
        Form form = Form.form();
        form.add("idUser", subscription.getUser_idUser().toString());
        form.add("start_date", subscription.getStart_date());
        form.add("end_date", subscription.getEnd_date());
        form.add("status", subscription.isStatus() ? "1" : "0");
        form.add("idSubscriptionPlan", subscription.getSubscriptionPlan_idSubscriptionPlan().toString());

        try{
            Util.request(form, "ModelSubscription/endPointAddSubscription.php");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public Subscription byId(Integer idSubscription) throws Exception {
        Subscription s = null;

        Form form2 = Form.form();
        form2.add("idSubscription", idSubscription.toString());

        try {
            JSONObject json = Util.requestJsonObj(form2, "ModelSubscription/endPointByIdSubscription.php");
            if(json != null && !json.toString().equals("Error")) {
                s = new Gson().fromJson(json.toString(), Subscription.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return s;
    }
}
