package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject mObject = new JSONObject(json);
            JSONObject name = mObject.getJSONObject("name");
            String mainName = name.getString("mainName");

            JSONArray alsoKnownAs = name.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAsList = new ArrayList<String>();
            for(int i = 0 ; i < alsoKnownAs.length() ; i++){
                alsoKnownAsList.add(alsoKnownAs.getString(i));
            }

            String placesOfOrigin = mObject.getString("placeOfOrigin");

            String description = mObject.getString("description");

            String image = mObject.getString("image");

            JSONArray ingredients = mObject.getJSONArray("ingredients");
            List<String> ingredientsList = new ArrayList<>();
            for(int i = 0 ; i < ingredients.length() ; i++){
                ingredientsList.add(ingredients.getString(i));
            }

            return new Sandwich(mainName,alsoKnownAsList,placesOfOrigin , description , image , ingredientsList);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
