package com.example.testapplication.db.converter;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.objectbox.converter.PropertyConverter;

public class StoreConverter implements PropertyConverter<Map<String, String>, String> {

    @Override
    public Map<String, String> convertToEntityProperty(String dbStores) {

        Gson gson = new Gson();
        Type type = new TypeToken<Map<String,String>>() {
        }.getType();

        Log.e("colors fethed",dbStores);
        Map<String, String> stores = gson.fromJson(dbStores, type);

        return stores;
    }

    @Override
    public String convertToDatabaseValue(Map<String,String> map) {

        JsonObject jo = new JsonObject();

        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entrySet.iterator();

        while(iterator.hasNext())
        {
            Map.Entry<String, String> entry = iterator.next();
            jo.addProperty(entry.getKey(), entry.getValue());
        }


        return jo.toString();
    }
}
