package com.example.kursach.ui.exercises;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.kursach.R;
import com.example.kursach.objectsClasses.ItemsOfExercises;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;

public class ExercisesFragment extends Fragment implements View.OnClickListener{
    private static LinearLayout layout;
    private ConstraintLayout item;
    private TextView name_exercises;
    private ImageView back;

    private  TextView diff;
    private  TextView textView;
    private YouTubePlayerView tubePlayerView;
    private YouTubePlayer.OnInitializedListener onInitializedListener;
    private static TextView information;
    public  FrameLayout frameLayout;
    private static ArrayList<Items> fields = new ArrayList<>();
    private int[] level_of_difficulty = new int[]{7, 1, 4, 2, 1, 2, 5, 9, 10, 9, 4, 3, 6, 8, 10, 7, 2, 8, 9, 10, 5};
    private static boolean key = false;
    private WebView exercise_photo;




    @SuppressLint("ResourceType")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_exercise, container, false);





        layout = root.findViewById(R.id.lin);
        back = root.findViewById(R.id.back_btn);
        back.setOnClickListener(this);
        information = root.findViewById(R.id.information_about_ex);
        textView = new TextView(getContext());
        diff = root.findViewById(R.id.difficulty);








//create cardView - it's a window for showing information about exercises
        frameLayout = root.findViewById(R.id.frame);
//        cardView.setVisibility(View.INVISIBLE);
//        cardView.setBackgroundColor(Color.YELLOW);
//        cardView.setPreventCornerOverlap(true);
//        cardView.setRadius(50);
//        cardView.setX(40);
//        cardView.setY(80);
//        cardView.setRadius(20F);
//        back.setX(400);
//        back.setY(1350);
//        back.setText("Назад");
//        LinearLayout.LayoutParams p= new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        cardView.addView(back, p);
//        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(1000, 1500);
//
//
//
//
//        main_constraint_layout.addView(cardView, param);



        ItemsOfExercises.add_names_into_array();
        ItemsOfExercises.add_images_into_array();
        ItemsOfExercises.add_description_array();
        addItemsOfExercises(layout);


         //youtube player add to the card view
//        tubePlayerView = root.findViewById(R.id.youtube_player);
//        LinearLayout.LayoutParams tubeParam = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//
//        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
//            @Override
//            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
//                List<String> links = new ArrayList<>();
//                links.add("W4hTJybfU7s");
//                youTubePlayer.loadVideos(links);
//            }
//
//            @Override
//            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
//
//            }
//        };





        return root;

    }





    public void addItemsOfExercises(LinearLayout layout){
        for(int i=0; i<21; i++){
            exercise_photo= new WebView(getContext());
            WebSettings webSettings = exercise_photo.getSettings();
            webSettings.getJavaScriptEnabled();

            exercise_photo.loadUrl(ItemsOfExercises.getPhoto_of_exercise().get(i));
            LinearLayout.LayoutParams margins = new LinearLayout.LayoutParams(250, 250);


            ///////////////////////

            name_exercises = new TextView(getContext());
            name_exercises.setTextColor(Color.WHITE);
            name_exercises.setText(ItemsOfExercises.getName_of_exercise().get(i));
            name_exercises.setTextSize(20);

            ConstraintLayout.LayoutParams text = new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            text.setMargins(450, 80, 50, 30);
            /////////////////

            item = new ConstraintLayout(getContext());
            item.setId(i);
            item.setOnClickListener(this);
            Items items = new Items(item, exercise_photo, margins, name_exercises, text, level_of_difficulty[i]);
            fields.add(items);

            LinearLayout.LayoutParams size = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 250);
            size.topMargin = 2;

            layout.addView(items.getItem(), size);
        }
        Items.insertionSort(fields);


    }

public static void changes_sort(){
    for (int i=0; i<fields.size(); i++){
       // MainActivity.getFields().add(fields.get(i));
        layout.removeView(fields.get(i).getItem());
    }

    for(int i=0; i<fields.size(); i++){

        LinearLayout.LayoutParams size = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 250);
        size.topMargin = 2;
        layout.addView(fields.get(i).getItem(), size);

    }
}



    public static void setKey(boolean key) {

        ExercisesFragment.key = key;
        if(key) {
            changes_sort();
        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case 0:{

                frameLayout.setVisibility(View.VISIBLE);
                information.setText(ItemsOfExercises.getShort_description().get(0));
                diff.setText("НОРМАЛЬНО");

                break;
            }
            case 1:{

                frameLayout.setVisibility(View.VISIBLE);
                information.setText(ItemsOfExercises.getShort_description().get(1));
                diff.setText("ЛЕГКО");
                break;
            }
            case 2:{
                frameLayout.setVisibility(View.VISIBLE);
                information.setText(ItemsOfExercises.getShort_description().get(2));
                diff.setText("ЛЕГКО");
                break;
            }
            case 3:{
                frameLayout.setVisibility(View.VISIBLE);
                information.setText(ItemsOfExercises.getShort_description().get(3));
                diff.setText("ЛЕГКО");
                break;
            }
            case 4:{
                frameLayout.setVisibility(View.VISIBLE);
                information.setText(ItemsOfExercises.getShort_description().get(4));
                diff.setText("ЛЕГКО");
                break;
            }
            case 5:{
                frameLayout.setVisibility(View.VISIBLE);
                information.setText(ItemsOfExercises.getShort_description().get(5));
                diff.setText("ЛЕГКО");
                break;
            }
            case 6:{
                frameLayout.setVisibility(View.VISIBLE);
                information.setText(ItemsOfExercises.getShort_description().get(6));
                diff.setText("НОРМАЛЬНО");
                break;
            }
            case 7:{
                frameLayout.setVisibility(View.VISIBLE);
                information.setText(ItemsOfExercises.getShort_description().get(7));
                diff.setText("СКЛАДНО");
                break;
            }
            case 8:{
                frameLayout.setVisibility(View.VISIBLE);
                information.setText(ItemsOfExercises.getShort_description().get(8));
                diff.setText("СКЛАДНО");
                break;
            }
            case 9:{
                frameLayout.setVisibility(View.VISIBLE);
                information.setText(ItemsOfExercises.getShort_description().get(9));
                diff.setText("СКЛАДНО");
                break;
            }
            case 10:{
                frameLayout.setVisibility(View.VISIBLE);
                information.setText(ItemsOfExercises.getShort_description().get(10));
                diff.setText("ЛЕГКО");
                break;
            }
            case 11:{
                frameLayout.setVisibility(View.VISIBLE);
                information.setText(ItemsOfExercises.getShort_description().get(12));
                diff.setText("ЛЕГКО");
                break;
            }
            case 12:{
                frameLayout.setVisibility(View.VISIBLE);
                information.setText(ItemsOfExercises.getShort_description().get(13));
                diff.setText("НОРМАЛЬНО");
                break;
            }
            case 13:{
                frameLayout.setVisibility(View.VISIBLE);
                information.setText(ItemsOfExercises.getShort_description().get(14));
                diff.setText("НОРМАЛЬНО");
                break;
            }
            case 14:{
                frameLayout.setVisibility(View.VISIBLE);
                information.setText(ItemsOfExercises.getShort_description().get(15));
                diff.setText("СКЛАДНО");
                break;
            }
            case 15:{
                frameLayout.setVisibility(View.VISIBLE);
                information.setText(ItemsOfExercises.getShort_description().get(16));
                diff.setText("НОРМАЛЬНО");
                break;
            }
            case 16:{
                frameLayout.setVisibility(View.VISIBLE);
                information.setText(ItemsOfExercises.getShort_description().get(17));
                diff.setText("ЛЕГКО");
                break;
            }
            case 17:{
                frameLayout.setVisibility(View.VISIBLE);
                information.setText(ItemsOfExercises.getShort_description().get(18));
                diff.setText("НОРМАЛЬНО");
                break;
            }
            case 18:{
                frameLayout.setVisibility(View.VISIBLE);
                information.setText(ItemsOfExercises.getShort_description().get(19));
                diff.setText("СКЛАДНО");
                break;
            }
            case 19:{
                frameLayout.setVisibility(View.VISIBLE);
                information.setText(ItemsOfExercises.getShort_description().get(20));
                diff.setText("СКЛАДНО");
                break;
            }
            case 20:{
                frameLayout.setVisibility(View.VISIBLE);
                information.setText(ItemsOfExercises.getShort_description().get(21));
                diff.setText("НОРМАЛЬНО");
                break;
            }
            case R.id.back_btn:{
                frameLayout.setVisibility(View.INVISIBLE);
                //tubePlayerView.initialize(YoutubeKey.getKey(), onInitializedListener);

                break;
            }

        }
    }

public  ArrayList getFields(){
        return fields;
}

public  LinearLayout getLayout(){
    return layout;
}


}