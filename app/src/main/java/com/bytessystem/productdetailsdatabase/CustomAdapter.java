package com.bytessystem.productdetailsdatabase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter {

    ArrayList<product> productArrayList;
    Context context;
    TextView prod_name,prod_price,prod_category,prod_desc;


    public CustomAdapter(@NonNull Context context,ArrayList<product> objects) {
        super(context,R.layout.itemlayout, objects);

        this.context=context;
        productArrayList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){

            LayoutInflater  inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.itemlayout,null);

        }
        prod_name = convertView.findViewById(R.id.prod_name);
       // prod_price = convertView.findViewById(R.id.prod_price);
       // prod_category = convertView.findViewById(R.id.prod_category);
        //prod_desc = convertView.findViewById(R.id.prod_desc);


        prod_name.setText(productArrayList.get(position).getProd_name());
        // prod_price.setText(productArrayList.get(position).getProd_price());
        //prod_category.setText(productArrayList.get(position).getProd_category());
        //prod_desc.setText(productArrayList.get(position).getProd_desc());
        Log.e("prod_name",prod_name+"");
        Log.e("prod_name",prod_price+"");
        Log.e("prod_name",prod_category+"");
        Log.e("prod_name",prod_desc+"");
               return  convertView;
    }
}
