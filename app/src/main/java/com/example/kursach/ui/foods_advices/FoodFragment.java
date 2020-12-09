package com.example.kursach.ui.foods_advices;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.kursach.R;

import java.util.ArrayList;

public class FoodFragment extends Fragment implements View.OnClickListener {


    private Button link;
    private View root;
    private ConstraintLayout main_food_layout;
    private ConstraintLayout item;
    private ConstraintLayout item_1;
    private ConstraintLayout item_2;
    private ConstraintLayout item_3;
    private ConstraintLayout item_4;
    private ConstraintLayout item_5;
    private ConstraintLayout item_6;
    private ConstraintLayout item_7;
    private ConstraintLayout item_8;
    private ConstraintLayout item_9;
    private ScrollView scrollView;




    private Button button;



    //fields from information layout
    private ScrollView information_scroll;
    private ImageView information_image;
    private TextView ingredients_title;
    private TextView ingredients;
    private TextView value_calories;
    private TextView method_of_cooking_title;
    private TextView method_of_cooking;
    private ImageView back;
    private static LinearLayout view;
    private LinearLayout layout;
    private static final int ID_BACK = 12;
    private CardView card;
    private static ArrayList<Food_obj> obj = new ArrayList<>();
    private int[] calories = new int[]{119, 104, 56, 78, 44, 324, 152, 47, 101, 84};
    private static boolean flag = false;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_food_advices, container, false);
        main_food_layout = root.findViewById(R.id.main_food_layout);

        creating();
        scrollView = root.findViewById(R.id.scroll);
        layout = root.findViewById(R.id.lin);
        view = root.findViewById(R.id.view);
        information_scroll = root.findViewById(R.id.information_scroll);

        add_view();


        return root;
    }


    public static void setFlag(boolean flag) {
        FoodFragment.flag = flag;
        Food_obj.selectionSort(obj);
        changing();
    }

    public static void changing(){
        for (int i=0; i< obj.size(); i++){
            view.removeView(obj.get(i).getItem());
        }
        for (int i=0; i< obj.size(); i++){
            view.addView(obj.get(i).getItem());
        }
    }

    public void creating(){
for(int i=0; i<10; i++){
    switch (i){
        case 0:{
            item = root.findViewById(R.id.item);
            break;
        }
        case 1:{
            item = root.findViewById(R.id.item_1);
            break;
        }
        case 2:{
            item = root.findViewById(R.id.item_2);
            break;
        }
        case 3:{
            item= root.findViewById(R.id.item_3);
            break;
        }
        case 4:{
            item = root.findViewById(R.id.item_4);
            break;
        }
        case 5:{
            item = root.findViewById(R.id.item_5);
            break;
        }
        case 6:{
            item = root.findViewById(R.id.item_6);
            break;
        }
        case 7:{
            item = root.findViewById(R.id.item_7);
            break;
        }
        case 8:{
            item = root.findViewById(R.id.item_8);
            break;
        }
        case 9:{
            item = root.findViewById(R.id.item_9);
            break;
        }
    }
    item.setOnClickListener(this);
    Food_obj food = new Food_obj(item, calories[i]);
    obj.add(food);
}
    }





    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item: {

            scrollView.setVisibility(View.INVISIBLE);
            information_scroll.setVisibility(View.VISIBLE);
            information_about_dish(R.string.ingredient_1, R.string.method_1, R.drawable.cereal);

                break;
            }
            case R.id.item_1: {

                scrollView.setVisibility(View.INVISIBLE);
                information_scroll.setVisibility(View.VISIBLE);
                information_about_dish(R.string.ingredient_2, R.string.method_2, R.drawable.dish);

                break;
            }
            case R.id.item_2: {

                scrollView.setVisibility(View.INVISIBLE);
                information_scroll.setVisibility(View.VISIBLE);
                information_about_dish(R.string.ingredient_3, R.string.method_3, R.drawable.dish3);

                break;
            }
            case R.id.item_3: {

                scrollView.setVisibility(View.INVISIBLE);
                information_scroll.setVisibility(View.VISIBLE);
                information_about_dish(R.string.ingredient_4, R.string.method_4, R.drawable.dish_4);

                break;
            }
            case R.id.item_4: {

                scrollView.setVisibility(View.INVISIBLE);
                information_scroll.setVisibility(View.VISIBLE);
                information_about_dish(R.string.ingredient_5, R.string.method_5, R.drawable.dish_5);

                break;
            }
            case R.id.item_5: {

                scrollView.setVisibility(View.INVISIBLE);
                information_scroll.setVisibility(View.VISIBLE);
                information_about_dish(R.string.ingredient_6, R.string.method_6, R.drawable.dish_6);

                break;
            }
            case R.id.item_6: {

                scrollView.setVisibility(View.INVISIBLE);
                information_scroll.setVisibility(View.VISIBLE);
                information_about_dish(R.string.ingredient_7, R.string.method_7, R.drawable.dish_7);

                break;
            }
            case R.id.item_7: {

                scrollView.setVisibility(View.INVISIBLE);
                information_scroll.setVisibility(View.VISIBLE);
                information_about_dish(R.string.ingredient_8, R.string.method_8, R.drawable.dish_8);

                break;
            }
            case R.id.item_8: {

                scrollView.setVisibility(View.INVISIBLE);
                information_scroll.setVisibility(View.VISIBLE);
                information_about_dish(R.string.ingredient_9, R.string.method_9, R.drawable.dish_9);

                break;
            }
            case R.id.item_9: {

                scrollView.setVisibility(View.INVISIBLE);
                information_scroll.setVisibility(View.VISIBLE);
                information_about_dish(R.string.ingredient_10, R.string.method_10, R.drawable.dish_10);

                break;
            }
            case ID_BACK:{
                information_scroll.setVisibility(View.INVISIBLE);
                scrollView.setVisibility(View.VISIBLE);
                break;
            }
        }


    }

public void information_about_dish(int ingredient, int method, int image){
    information_image.setImageResource(image);
        ingredients_title.setText(R.string.ingredient_title);
        ingredients.setText(ingredient);
        method_of_cooking_title.setText(R.string.method_title);
        method_of_cooking.setText(method);
}


public void add_view(){
        //картинка страви
    information_image = new ImageView(getContext());
    information_image.setScaleType(ImageView.ScaleType.CENTER_CROP);
    card  = new CardView(getContext());
    card.setRadius(30F);
//параметри ширини і висоти
    LinearLayout.LayoutParams image = new LinearLayout.LayoutParams(900, 700);
    //положкння відносно головного View
    image.gravity = Gravity.CENTER;
    image.setMargins(0, 10, 0, 0);
//параметри ширини і висоти
    LinearLayout.LayoutParams carD = new LinearLayout.LayoutParams(900, 700);
    carD.gravity = Gravity.CENTER;
    carD.setMargins(0, 10, 0, 0);

    ingredients_title = new TextView(getContext());
    ingredients_title.setTextSize(25);
//параметри ширини і висоти
    LinearLayout.LayoutParams ingredient_t = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    ingredient_t.setMargins(3, 0, 3, 0);

    ingredients = new TextView(getContext());
    ingredients.setTextSize(20);

    method_of_cooking_title = new TextView(getContext());
    method_of_cooking_title.setTextSize(25);

    method_of_cooking = new TextView(getContext());
    method_of_cooking.setTextSize(20);

    back = new ImageView(getContext());
    back.setId(ID_BACK);
    back.setOnClickListener(this);
    back.setImageResource(R.drawable.ic_baseline_arrow_back_24);
    LinearLayout.LayoutParams b = new LinearLayout.LayoutParams(200, 200);
    b.gravity =Gravity.CENTER|Gravity.BOTTOM;
    b.setMargins(0, 0, 0, 20);


    card.addView(information_image, image);
    layout.addView(card, carD);
    layout.addView(ingredients_title, ingredient_t);
    layout.addView(ingredients, ingredient_t);
    layout.addView(method_of_cooking_title, ingredient_t);
    layout.addView(method_of_cooking, ingredient_t);
    layout.addView(back, b);
}



































}