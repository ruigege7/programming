package com.example.tongxunlu;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ruigege on 2017/8/29.
 */

public class CorsorToList {

    public static ArrayList<HashMap<String,Object>> toList(Cursor cursor){

        ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();

        int count = cursor.getColumnCount();
        while (cursor.moveToNext()){
            HashMap<String,Object> map = new HashMap<String,Object>();
            for(int i = 0; i<count; i++){
                String columnName = cursor.getColumnName(i);
                Object columnValue =null;
                int type = cursor.getType(i);
                switch(type){
                    case 1:
                        columnValue =cursor.getInt(i);
                        break;
                    case 3:
                        columnValue =cursor.getString(i);
                        break;
                }
                map.put(columnName,columnValue);
            }
            list.add(map);
        }

        return list;
    }
}
