package com.bytessystem.productdetailsdatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button add_cat, add_prod,view_cat,view_prod;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add_cat = findViewById(R.id.add_cat);
        add_prod = findViewById(R.id.add_prod);
        view_cat = findViewById(R.id.view_cat);
        view_prod = findViewById(R.id.view_prod);

        add_cat.setOnClickListener(this);
        add_prod.setOnClickListener(this);
        view_cat.setOnClickListener(this);
        view_prod.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(add_cat == view){
            Intent intent = new Intent(MainActivity.this,AddCategoryActivity.class);
            startActivity(intent);
            }
        if(add_prod == view){
            Intent intent = new Intent(MainActivity.this,ProductDetailsActivity.class);
            startActivity(intent);
        }
        if(view_cat == view){
            Intent intent = new Intent(MainActivity.this,ViewCategoryActivity.class);
            startActivity(intent);
                    }
        if(view_prod == view){
            Intent intent = new Intent(MainActivity.this,ProductListActivity.class);
            startActivity(intent);

        }
    }
}
