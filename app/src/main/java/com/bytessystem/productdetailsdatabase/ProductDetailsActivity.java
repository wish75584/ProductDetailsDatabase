package com.bytessystem.productdetailsdatabase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ProductDetailsActivity extends AppCompatActivity implements View.OnClickListener {



    EditText pname,pprice,pdescr;
    Button save;
    Spinner spn;
    String[] li;
    ArrayAdapter<String> adp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

            pname = findViewById(R.id.pname);
            pprice = findViewById(R.id.pprice);
            pdescr =findViewById(R.id.pdescr);
            save = findViewById(R.id.save);
            spn = findViewById(R.id.spn);

        DbHelper mdb = new DbHelper(this);
        SQLiteDatabase db =mdb.getReadableDatabase();



        String[] cols ={"cat1","cat2","cat3","cat4","cat5"};

        Cursor cursor =db.query("CATEGORY",cols,"",null,"","","");

        while(cursor.moveToNext()) {
            String cat1 = cursor.getString(cursor.getColumnIndexOrThrow("cat1"));
            String cat2 = cursor.getString(cursor.getColumnIndexOrThrow("cat2"));
            String cat3 = cursor.getString(cursor.getColumnIndexOrThrow("cat3"));
            String cat4 = cursor.getString(cursor.getColumnIndexOrThrow("cat4"));
            String cat5 = cursor.getString(cursor.getColumnIndexOrThrow("cat5"));

            Log.e("cat1",cat1+"");
            Log.e("cat2",cat2+"");
            Log.e("cat3",cat3+"");
            Log.e("cat4",cat5+"");
            Log.e("cat5",cat4+"");

            li =  new String[5];
            li[0]=cat1;
            li[1]=cat2;
            li[2]=cat3;
            li[3]=cat4;
            li[4]=cat5;

            adp = new ArrayAdapter<String>(this,android.R.layout.simple_gallery_item,li);
            spn.setAdapter(adp);

                  }

        save.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String category = spn.getSelectedItem().toString();

        DbHelper2 mdb2 = new DbHelper2(this);
        SQLiteDatabase db2 =mdb2.getWritableDatabase();


        String pnames =pname.getText().toString();
        String pprices = pprice.getText().toString();
        String pdescs = pdescr.getText().toString();

        Log.e("pnames",pnames+"");
        Log.e("pprices",pprices+"");
        Log.e("pdescs",pdescs+"");
        Log.e("category",category+"");



//selecting string from spinner and passing it to string category and then passing category to values


        ContentValues values = new ContentValues();
        values.put("pname",pnames);
        values.put("pprice",pprices);
        values.put("pdescription",pdescs);
        values.put("pcategory",category);



        long newRowId = db2.insert("PRODUCTS",null,values);

        Toast.makeText(this,"Products inserted",Toast.LENGTH_LONG).show();




    }
}
