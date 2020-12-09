package com.example.kursach.ui.exercises;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.kursach.MainActivity;
import com.example.kursach.R;
import com.example.kursach.objectsClasses.ItemsOfExercises;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;



public class Items {
    private ConstraintLayout item;
    private int id = 0;
    private int level = 0;

    public Items(ConstraintLayout item, WebView exercise_photo, LinearLayout.LayoutParams margins, TextView name_exercises, ConstraintLayout.LayoutParams text, int level ){
        this.level = level;
        item.setBackgroundColor(Color.rgb(138, 211, 204));
        LinearLayout.LayoutParams size = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 250);
        size.topMargin = 2;

        item.addView(exercise_photo, margins);
        item.addView(name_exercises, text);
        this.item= item;

    }

    public ConstraintLayout getItem() {
        return item;
    }

    public int getLevel() {
        return level;
    }


    //сортування вставками
    public static void insertionSort(ArrayList<Items> array) {
        for (int i = 1; i < array.size(); i++) {
            Items current = array.get(i);
            int j = i - 1;
            while(j >= 0 && current.getLevel() < array.get(j).getLevel()) {
                array.set(j+1, array.get(j));
                j--;
            }
            array.set(j+1, current);
        }
    }



}
