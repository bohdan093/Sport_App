package com.example.kursach.ui.trains_mode;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.kursach.R;
import com.example.kursach.objectsClasses.ItemsOfExercises;

import java.util.Random;

public class TrainsModeFragment extends Fragment implements View.OnClickListener {

    private Button start;
    private ConstraintLayout main_layout;
    private ProgressBar bar;
    private TextView ready;
    private int changing_time = 20;
    private TextView time;
    private TextView name_of_exercise;
    private boolean sw = false;
    private int []time_arr = {20, 30, 40};
    private Random random = new Random();
    private WebView webView;
    private CountDownTimer timer;
    private int cycle =0;
    private CardView cardView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_trains_mode, container, false);

        start = root.findViewById(R.id.start);
        main_layout = root.findViewById(R.id.main_layout);
        start.setOnClickListener(this);
        bar = root.findViewById(R.id.bar);
        ready = root.findViewById(R.id.ready);
        time = root.findViewById(R.id.time);
        name_of_exercise = root.findViewById(R.id.name_of_exercise);


        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start:{
                main_layout.removeView(start);
                ready.setVisibility(View.INVISIBLE);
                cardView = new CardView(getContext());
                cardView.setRadius(20F);

                cardView.setX(70);
                cardView.setY(40);
                webView = new WebView(getContext());
                WebSettings webSettings = webView.getSettings();
                webSettings.getJavaScriptEnabled();
                webView.loadUrl("file:android_asset/gif_"+String.valueOf(cycle+1)+".gif");

                ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(920, 840);
                ConstraintLayout.LayoutParams l = new ConstraintLayout.LayoutParams(920, 820);
                //layoutParams.setMargins(100, 100, 100, 100);
                cardView.addView(webView, layoutParams);
                main_layout.addView(cardView, l);

                bar.setVisibility(View.VISIBLE);
                time.setVisibility(View.VISIBLE);
                name_of_exercise.setVisibility(View.VISIBLE);

                //додавання назв вправ і гівок у масив
                ItemsOfExercises.add_names_into_array();
                ItemsOfExercises.add_images_into_array();

                    action();



                break;
            }
        }



    }



    public void action() {

             timer = new CountDownTimer(changing_time * 1000, 1000) {
                @Override
                public void onTick(long m) {


                         if(sw==false) {
                             bar.setMax(changing_time);
                             // bar.setVisibility(View.VISIBLE);
                             //time.setVisibility(View.VISIBLE);
                             //  name_of_exercise.setVisibility(View.VISIBLE);
                             name_of_exercise.setText(ItemsOfExercises.getName_of_exercise().get(cycle));
                             bar.setProgress((int) m / 1000);
                             time.setText(String.valueOf((int) m / 1000));

                         }else{
                             bar.setMax(changing_time);
                             name_of_exercise.setText("ВІДПОЧИНОК"+'\n'+"НАСТУПНА ВПРАВА");

                             bar.setProgress((int) m / 1000);
                             time.setText(String.valueOf((int) m / 1000));

                         }




                }

                @Override
                public void onFinish() {
                    if(cycle<2) {
                        if (sw == false) {
                            cycle++;
                            changing_time = 10;
                            sw = true;
                            main_layout.setBackgroundColor(Color.GREEN);
                            webView.loadUrl("file:android_asset/gif_"+String.valueOf(cycle+1)+".gif");
                            action();
                        } else {
                            changing_time = 20;
                            sw = false;
                            main_layout.setBackgroundResource(R.color.back);
                            webView.loadUrl("file:android_asset/gif_"+String.valueOf(cycle+1)+".gif");
                            action();

                        }

                    }else {
                        bar.setVisibility(View.INVISIBLE);
                        cardView.setVisibility(View.INVISIBLE);
                        time.setVisibility(View.INVISIBLE);
                        name_of_exercise.setVisibility(View.INVISIBLE);
                        ready.setVisibility(View.VISIBLE);
                        ready.setText("Вітаю із закінченням тренування ");
                        cycle=0;
                    }




                }

            };
             timer.start();

    }
























}







