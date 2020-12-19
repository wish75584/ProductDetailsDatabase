package com.bytessystem.productdetailsdatabase;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_LONG;

public class ProductListActivity extends AppCompatActivity {


    ListView plv;
    ArrayList<product> arli;
    ArrayAdapter<product> adp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        plv = findViewById(R.id.plv);



        DbHelper2 mdb2 = new DbHelper2(this);
        SQLiteDatabase db = mdb2.getReadableDatabase();

        String[] cols = {"pname","pprice","pcategory","pdescription"};
        Cursor cursor = db.query("PRODUCTS", cols, "", null, "", "", "");

        arli = new ArrayList<product>();
        while (cursor.moveToNext()) {
            String pname1 = cursor.getString(cursor.getColumnIndexOrThrow("pname"));
            String pprice1 = cursor.getString(cursor.getColumnIndexOrThrow("pprice"));
            String pcategory1 = cursor.getString(cursor.getColumnIndexOrThrow("pcategory"));
            String pdesc1 =  cursor.getString(cursor.getColumnIndexOrThrow("pdescription"));
            Log.e("pname1", pname1 + " ");


            product p1 = new product(" " + pname1,""+pprice1,""+pcategory1,""+pdesc1);

            arli.add(p1);

        }

        adp = new CustomAdapter(this, arli);

        plv.setAdapter(adp);

        plv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {



                Intent intent = new Intent(ProductListActivity.this,ShowProductDetailsActivity.class);
                product p = arli.get(i);
                intent.putExtra("name",p.getProd_name());
                intent.putExtra("price",p.getProd_price());
                intent.putExtra("category",p.getProd_category());
                intent.putExtra("desc",p.getProd_desc());

                Log.e("in prod list",p.getProd_name()+"");
                Log.e("in prod list",p.getProd_price()+"");
                Log.e("in prod list",p.getProd_category()+"");
                Log.e("in prod list",p.getProd_desc()+"");
                startActivity(intent);
                Toast.makeText(ProductListActivity.this, "Product clicked", Toast.LENGTH_SHORT).show();
            }

        });

    }


}