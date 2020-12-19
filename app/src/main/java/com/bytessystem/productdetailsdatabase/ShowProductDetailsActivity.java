package com.bytessystem.productdetailsdatabase;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ShowProductDetailsActivity extends AppCompatActivity {

    TextView name1,price1,category1,desciption1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_product_details);
        name1 = findViewById(R.id.name1);
        price1 = findViewById(R.id.price1);
        category1 = findViewById(R.id.category1);
        desciption1 = findViewById(R.id.desciption1);


        Bundle bun =getIntent().getExtras();
        String name = bun.getString("name");
        String price = bun.getString("price");
        String category = bun.getString("category");
        String desc = bun.getString("desc");

        Log.e("in details",name+"");
        Log.e("in details",price+"");
        Log.e("in details",category+"");
        Log.e("in details",desc+"");

        name1.setText(name);
        price1.setText(price);
        category1.setText(category);
        desciption1.setText(desc);

        }


    }

