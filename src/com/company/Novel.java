package com.company;

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
        return super.getPrice() * 199.78;
    }

}
