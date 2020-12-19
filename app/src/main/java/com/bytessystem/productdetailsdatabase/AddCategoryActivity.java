package com.bytessystem.productdetailsdatabase;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddCategoryActivity extends AppCompatActivity implements View.OnClickListener {


    EditText cat1, cat2, cat3, cat4, cat5;
    String cat1s, cat2s, cat3s, cat4s, cat5s;
    Button submit;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);

        cat1 = findViewById(R.id.cat1);
        cat2 = findViewById(R.id.cat2);
        cat3 = findViewById(R.id.cat3);
        cat4 = findViewById(R.id.cat4);
        cat5 = findViewById(R.id.cat5);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {




        DbHelper mdb = new DbHelper(this);
        SQLiteDatabase  db = mdb.getWritableDatabase();

        cat1s = cat1.getText().toString();
        cat2s = cat2.getText().toString();
        cat3s = cat3.getText().toString();
        cat4s = cat4.getText().toString();
        cat5s = cat5.getText().toString();

        ContentValues values = new ContentValues();
        values.put("cat1",cat1s);
        values.put("cat2",cat2s);
        values.put("cat3",cat3s);
        values.put("cat4",cat4s);
        values.put("cat5",cat5s);

        long newRowId = db.insert("CATEGORY" ,null,values);

        Toast.makeText(this,"category insreted",Toast.LENGTH_LONG).show();
    }
}















