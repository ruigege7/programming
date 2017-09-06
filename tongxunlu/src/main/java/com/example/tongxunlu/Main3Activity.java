package com.example.tongxunlu;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main3Activity extends AppCompatActivity {


    private ListView lianxiren;
    private Button xinjian;

    public ArrayList<HashMap<String,Object>>  getData(){
        CreateDb db = new CreateDb(Main3Activity.this);
        SQLiteDatabase sqLiteDatabase = db.getReadableDatabase();
        //sqLiteDatabase.delete("tongxunlu",null,null );
        Cursor cursor = sqLiteDatabase.rawQuery("select * from tongxunlu order by id",null);
        ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
        list =CorsorToList.toList(cursor);

       /* ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
        list =CorsorToList.toList(cursor);
        for(Map a: list){
            Log.i("数据库动态","编号="+a);
        }*/
        return list;


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        lianxiren = (ListView) findViewById(R.id.lianxiren);
        xinjian = (Button) findViewById(R.id.xinjian);

        lianxiren.setAdapter(new MyAdapter());
        lianxiren.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Main3Activity.this,Main4Activity.class);
                HashMap<String,Object> aa =getData().get(position);
                Object name =aa.get("name");
                Object phonenum =aa.get("phonenum");
                Bundle bundle = new Bundle();
                bundle.putString("name",name.toString());
                bundle.putString("phone",phonenum.toString());

                intent.putExtras(bundle);
                startActivityForResult(intent,200);//配套函数






                startActivity(intent);;//配套函数
            }
        });

        xinjian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Main3Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return getData().size();
        }

        @Override
        public Object getItem(int i) {
            return getData().get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View myView;
            //获取外部的配置xml ==一个view
            if (view == null) {
                myView = LayoutInflater.from(Main3Activity.this).inflate(R.layout.lianxiren, null);
            } else {
                myView = view;
            }
            //取出listView 中的各个控件

            TextView name = (TextView) myView.findViewById(R.id.item);


            //给各个控件赋值

            name.setText(getData().get(i).get("name").toString());


            return myView;
        }
    }





}
