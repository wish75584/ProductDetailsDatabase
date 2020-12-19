package com.bytessystem.productdetailsdatabase;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewCategoryActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<String> listdata;
    ArrayAdapter<String> adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_category);

        lv = findViewById(R.id.clv);

            DbHelper mdb = new DbHelper(this);
        SQLiteDatabase db = mdb.getReadableDatabase();

        String[] cols ={"cat1","cat2","cat3","cat4","cat5"};

        Cursor cursor =db.query("CATEGORY",cols,"",null,"","","");

        while(cursor.moveToNext()){
                String cat1 = cursor.getString(cursor.getColumnIndexOrThrow("cat1"));
            String cat2 = cursor.getString(cursor.getColumnIndexOrThrow("cat2"));
            String cat3 = cursor.getString(cursor.getColumnIndexOrThrow("cat3"));
            String cat4 = cursor.getString(cursor.getColumnIndexOrThrow("cat4"));
            String cat5 = cursor.getString(cursor.getColumnIndexOrThrow("cat5"));


            Log.e("cat1",cat1+"");
            Log.e("cat2",cat2+"");
            Log.e("cat3",cat3+"");
            Log.e("cat4",cat4+"");
            Log.e("cat5",cat5+"");

            listdata = new ArrayList<String>();
            listdata.add(cat1);
            listdata.add(cat2);
            listdata.add(cat3);
            listdata.add(cat4);
            listdata.add(cat5);

            adp = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listdata);

            lv.setAdapter(adp);

        }
        cursor.close();

    }
}
