package com.wwsi.ti.idx8558.models;

public class DishModel {

    private String dishName;

    public DishModel() {
    }

    public DishModel(String dishName) {
        this.dishName = dishName;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    @Override
    public String toString() {
        return "DishModel{" +
                "dishName='" + dishName + '\'' +
                '}';
    }
}
