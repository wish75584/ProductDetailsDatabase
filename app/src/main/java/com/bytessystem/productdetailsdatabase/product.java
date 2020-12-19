package com.bytessystem.productdetailsdatabase;

import java.util.ArrayList;

public class product  {
    String prod_name,prod_price,prod_category,prod_desc;

    public product(String prod_name, String prod_price, String prod_category, String prod_desc) {
        this.prod_name = prod_name;
        this.prod_price = prod_price;
        this.prod_category = prod_category;
        this.prod_desc = prod_desc;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public String getProd_price() {
        return prod_price;
    }

    public void setProd_price(String prod_price) {
        this.prod_price = prod_price;
    }

    public String getProd_category() {
        return prod_category;
    }

    public void setProd_category(String prod_category) {
        this.prod_category = prod_category;
    }

    public String getProd_desc() {
        return prod_desc;
    }

    public void setProd_desc(String prod_desc) {
        this.prod_desc = prod_desc;
    }
}
