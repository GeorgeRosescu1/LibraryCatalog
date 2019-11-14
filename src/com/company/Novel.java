package com.company;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Novel extends Book {
    private String type;
    private int yearOfApparition;

    public int getYearOfApparition() {
        return yearOfApparition;
    }

    public void setYearOfApparition(int yearOfApparition) {
        this.yearOfApparition = yearOfApparition;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        double priceInDolars =  super.getPrice() * 1.0998; //Price in American Dolars
        Double price = priceInDolars;
        NumberFormat numberFormat = new DecimalFormat("#,##");
        price  = Double.valueOf(numberFormat.format(price));
        return price;
    }

}
