package com.example.kursach.ui.foods_advices;

import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.kursach.R;

import java.util.ArrayList;

public class Food_obj {
    private ConstraintLayout item;
    private int calories = 0;


public Food_obj(ConstraintLayout item, int calories){
    this.item = item;
    this.calories = calories;
}

    public ConstraintLayout getItem() {
        return item;
    }

    public int getCalories() {
        return calories;
    }


    public static void selectionSort(ArrayList<Food_obj> array) {
        for (int i = 0; i < array.size(); i++) {
            Food_obj min = array.get(i);
            int minId = i;
            for (int j = i+1; j < array.size(); j++) {
                if (array.get(j).getCalories() < min.getCalories()) {
                    min = array.get(j);
                    minId = j;
                }
            }
            // замена
            Food_obj temp = array.get(i);
            array.set(i, min);
            array.set(minId, temp);
        }
    }

















}
