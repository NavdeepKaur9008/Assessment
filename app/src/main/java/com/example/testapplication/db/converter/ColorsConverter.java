package com.example.testapplication.db.converter;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.objectbox.converter.PropertyConverter;

public class ColorsConverter implements PropertyConverter<List<String>, String> {

    @Override
    public List<String> convertToEntityProperty(String dbColors) {

        Gson gson = new Gson();
        Type type = new TypeToken<List<String>>() {
        }.getType();

        Log.e("colors fethed",dbColors);
        List<String> colors = gson.fromJson(dbColors, type);

        return colors;
    }

    @Override
    public String convertToDatabaseValue(List<String> entityProperty) {

        JsonArray ja = new JsonArray();

        for(int i =0; i<entityProperty.size();i++)
        {
            ja.add(entityProperty.get(i));
        }

        return ja.toString();
    }
}
