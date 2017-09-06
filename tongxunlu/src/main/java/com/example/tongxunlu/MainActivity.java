package com.example.tongxunlu;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    private Button add,quxiao;
    private EditText xingming,phonenumber;
    private ImageView touxiang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add= (Button) findViewById(R.id.add);
        quxiao =(Button) findViewById(R.id.quxiao);
        touxiang= (ImageView) findViewById(R.id.touxiang);
        xingming = (EditText) findViewById(R.id.xingming);
        phonenumber= (EditText) findViewById(R.id.phonenumber);
        quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main3Activity.class);
                startActivity(intent);

            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateDb db = new CreateDb(MainActivity.this);
                SQLiteDatabase sqLiteDatabase = db.getReadableDatabase();

                String xingming1 = xingming.getText().toString().trim();
                String phonenumber1 = phonenumber.getText().toString().trim();
                sqLiteDatabase.execSQL("insert into tongxunlu (name,phonenum) values ('"+xingming1+"','"+phonenumber1+"')");
                Toast.makeText(MainActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,Main3Activity.class);
                startActivity(intent);
            }
        });
        touxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
