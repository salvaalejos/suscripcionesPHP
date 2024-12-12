package Models;

import Models.Entities.Comition;
import Models.Entities.Sucursal;
import Models.Entities.User;
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

import static Models.Entities.Comition.*;

public class ModelComition {

    public ModelComition() {
    }

    public void addComition(Comition comition) throws Exception {
        Form form = Form.form();
        form.add("Subscription_idSubscription", comition.getSubscription_idSubscription().toString());
        form.add("amount", comition.getAmount().toString());
        form.add("comition_date", comition.getComition_date());
        form.add("User_idSeller", comition.getUser_idSeller().toString());

        try{
            Util.request(form, "ModelComition/endPointAddComition.php");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Comition> bySeller(User seller) throws Exception {
        ArrayList<Comition> comitions = new ArrayList<Comition>();

        Form form = Form.form();
        form.add("idSeller", seller.getIdUser().toString());

        try {
            JSONArray array = Util.requestArray(form, "ModelComition/endPointComitionBySeller.php");

            if(array != null) {
                java.lang.reflect.Type listType = new TypeToken<ArrayList<Comition>>() {}.getType();
                comitions = new Gson().fromJson(array.toString(), listType);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return comitions;
    }
}
