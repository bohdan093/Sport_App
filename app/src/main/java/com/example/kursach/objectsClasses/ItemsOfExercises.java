package com.example.kursach.objectsClasses;

import androidx.annotation.StringRes;

import com.example.kursach.R;

import java.util.ArrayList;
import java.util.ResourceBundle;

public class ItemsOfExercises {
    private static ArrayList<String> photo_of_exercise = new ArrayList<>();
    private static ArrayList <Integer> name_of_exercise = new ArrayList<>();
    private static ArrayList <Integer> short_description = new ArrayList<>();

    public static ArrayList<Integer> getName_of_exercise() {
        return name_of_exercise;
    }
    public static ArrayList<String> getPhoto_of_exercise() {
        return photo_of_exercise;
    }

    public static ArrayList<Integer> getShort_description() {
        return short_description;
    }

    public static void setShort_description(ArrayList<Integer> short_description) {
        ItemsOfExercises.short_description = short_description;
    }

    public static void add_names_into_array(){

            name_of_exercise.add(R.string.ex1_name);
            name_of_exercise.add(R.string.ex2_name);
            name_of_exercise.add(R.string.ex3_name);
            name_of_exercise.add(R.string.ex4_name);
            name_of_exercise.add(R.string.ex5_name);
            name_of_exercise.add(R.string.ex6_name);
            name_of_exercise.add(R.string.ex7_name);
            name_of_exercise.add(R.string.ex8_name);
            name_of_exercise.add(R.string.ex9_name);
            name_of_exercise.add(R.string.ex10_name);
            name_of_exercise.add(R.string.ex11_name);
            name_of_exercise.add(R.string.ex12_name);
            name_of_exercise.add(R.string.ex13_name);
            name_of_exercise.add(R.string.ex14_name);
            name_of_exercise.add(R.string.ex15_name);
            name_of_exercise.add(R.string.ex16_name);
            name_of_exercise.add(R.string.ex17_name);
            name_of_exercise.add(R.string.ex18_name);
            name_of_exercise.add(R.string.ex19_name);
            name_of_exercise.add(R.string.ex20_name);
            name_of_exercise.add(R.string.ex21_name);
            name_of_exercise.add(R.string.ex22_name);
          //  name_of_exercise.add(R.string.ex23_name);


    }
    public static void add_images_into_array(){
        for(int i=1; i< 22; i++){
            photo_of_exercise.add( "file:android_asset/pic"+String.valueOf(i)+".gif");
        }
    }

    public static void add_description_array(){

        short_description.add(R.string.description_1);
        short_description.add(R.string.description_2);
        short_description.add(R.string.description_3);
        short_description.add(R.string.description_4);
        short_description.add(R.string.description_5);
        short_description.add(R.string.description_6);
        short_description.add(R.string.description_7);
        short_description.add(R.string.description_8);
        short_description.add(R.string.description_9);
        short_description.add(R.string.description_10);
        short_description.add(R.string.description_11);
        short_description.add(R.string.description_12);
        short_description.add(R.string.description_13);
        short_description.add(R.string.description_14);
        short_description.add(R.string.description_15);
        short_description.add(R.string.description_16);
        short_description.add(R.string.description_17);
        short_description.add(R.string.description_18);
        short_description.add(R.string.description_19);
        short_description.add(R.string.description_20);
        short_description.add(R.string.description_21);

    }

}
