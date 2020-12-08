package com.a.mt1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button restartButton;
    private ImageView view1, view2, view3, view4, view5, view6, view7, view8;
    private ImageView view9, view10, view11, view12, view13, view14, view15, view16;
    private List<ImageView> views = new ArrayList<>();
    private List<Drawable> images = new ArrayList<>();
    private ImageView button1;
    private ImageView button2;
    private int counter = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        restartButton.setOnClickListener(v -> {
            for (ImageView view : views) {
                init();
                view.setVisibility(View.VISIBLE);
                view.setImageResource(R.color.design_default_color_primary);
            }
        });

        for (ImageView view : views) {
            view.setOnClickListener(v -> {
                if (button1 == null & button1 != view) {
                    view.setImageDrawable(images.get(views.indexOf(view)));
                    Log.d("X", "first");
                    button1 = view;
                } else if (button1 != view) {
                    view.setImageDrawable(images.get(views.indexOf(view)));
                    Log.d("X", "second");
                    button2 = view;
                    checkCoincidence();
                }
            });
        }
    }

    private void checkCoincidence() {
        Log.d("X", "check");
        setImageViewsClickable(false);
        new Handler().postDelayed(() -> {
            if (button1.getDrawable().getConstantState().equals(button2.getDrawable().getConstantState())) {
                button1.setVisibility(View.INVISIBLE);
                button2.setVisibility(View.INVISIBLE);
                --counter;
                Log.d("X", "good");
                if (counter == 0) {
                    Toast.makeText(this, "Win", Toast.LENGTH_LONG).show();
                }
            } else {
                button1.setImageResource(R.color.design_default_color_primary);
                button2.setImageResource(R.color.design_default_color_primary);
                button1 = null;
                button2 = null;
                Log.d("X", "not good");
            }
            setImageViewsClickable(true);
        }, 1000);

    }

    private void setImageViewsClickable(boolean isClickable) {
        for (ImageView view : views) {
            view.setClickable(isClickable);
        }
    }

    private void init() {
        restartButton = findViewById(R.id.startButton);
        view1 = findViewById(R.id.imageView1);
        view2 = findViewById(R.id.imageView2);
        view3 = findViewById(R.id.imageView3);
        view4 = findViewById(R.id.imageView4);
        view5 = findViewById(R.id.imageView5);
        view6 = findViewById(R.id.imageView6);
        view7 = findViewById(R.id.imageView7);
        view8 = findViewById(R.id.imageView8);
        view9 = findViewById(R.id.imageView9);
        view10 = findViewById(R.id.imageView10);
        view11 = findViewById(R.id.imageView11);
        view12 = findViewById(R.id.imageView12);
        view13 = findViewById(R.id.imageView13);
        view14 = findViewById(R.id.imageView14);
        view15 = findViewById(R.id.imageView15);
        view16 = findViewById(R.id.imageView16);
        views = new ArrayList<>(Arrays.asList(view1, view2, view3, view4, view5, view6, view7, view8, view9,
                view10, view11, view12, view13, view14, view15, view16));
        for (ImageView view : views) {
            view.setImageResource(R.color.design_default_color_primary);
        }
        images = new ArrayList<>(Arrays.asList(getDrawable(R.drawable.ic_avocado), getDrawable(R.drawable.ic_avocado),
                getDrawable(R.drawable.ic_bananas), getDrawable(R.drawable.ic_bananas), getDrawable(R.drawable.ic_blueberry),
                getDrawable(R.drawable.ic_blueberry), getDrawable(R.drawable.ic_grapes), getDrawable(R.drawable.ic_grapes),
                getDrawable(R.drawable.ic_mango), getDrawable(R.drawable.ic_mango), getDrawable(R.drawable.ic_pineapple),
                getDrawable(R.drawable.ic_pineapple), getDrawable(R.drawable.ic_strawberry), getDrawable(R.drawable.ic_strawberry),
                getDrawable(R.drawable.ic_watermelon), getDrawable(R.drawable.ic_watermelon)));
        Collections.shuffle(images);
    }
}