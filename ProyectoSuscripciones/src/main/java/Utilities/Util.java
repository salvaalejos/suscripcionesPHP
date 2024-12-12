package Utilities;

import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Link
 */
public class Util {
    public static final String URL = "http://localhost/suscripcionesPHP/Models/";

    public static JSONArray requestArray(Form form, String url) {
        String ws = URL + url;
        System.out.println(ws);
        try {
            String result = Request.Post(ws).bodyForm(form.build())
                    .execute().returnContent().asString();

            System.out.println(result);

            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(result);

            return jsonArray;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JSONObject requestJsonObj(Form form, String url) {
        String ws = URL + url;
        System.out.println(ws);
        try {
            String result = Request.Post(ws).bodyForm(form.build())
                    .execute().returnContent().asString();

            System.out.println(result);

            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(result);

            return json;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void request(Form form, String url) {
        String ws = URL + url;
        System.out.println(ws);
        try {
            Request.Post(ws).bodyForm(form.build()).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}