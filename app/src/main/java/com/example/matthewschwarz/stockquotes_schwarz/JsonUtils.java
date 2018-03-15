package com.example.matthewschwarz.stockquotes_schwarz;

import android.util.Log;

import org.json.JSONObject;

/**
 * Created by matthewschwarz on 3/14/18.
 */

public class JsonUtils {

    public static JSONObject parseStockJson(String json){
        JSONObject quote = null;
        try {
            JSONObject jsonObject = new JSONObject(json);
            quote = jsonObject.getJSONObject("quote");
            Log.i("JSON", quote.toString());
        }catch (Exception e){
            Log.e("JSON", "Error parsing JSON");
        }
        return quote;
    }
}
