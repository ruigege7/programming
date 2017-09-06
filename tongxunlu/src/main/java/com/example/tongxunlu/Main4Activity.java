package com.example.tongxunlu;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

public class Main4Activity extends AppCompatActivity {

    private TextView names,phoneNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        names= (TextView) findViewById(R.id.names);
        phoneNum= (TextView) findViewById(R.id.phoneNum);


        Intent intent = getIntent();
        //get取值
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("name");
        String num = bundle.getString("phone");

        names.setText(name);
        phoneNum.setText(num);
        phoneNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              CharSequence a =  phoneNum.getText();
             String num = a.toString();

                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+num));
                if (ActivityCompat.checkSelfPermission(Main4Activity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(intent);

            }
        });
    }
}
