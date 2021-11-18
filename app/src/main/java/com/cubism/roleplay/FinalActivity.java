package com.cubism.roleplay;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class FinalActivity extends AppCompatActivity {

    TextView genText;
    RelativeLayout design;


    Random random = new Random();
    int rand = 1+random.nextInt(4);
    int rand2 = 6+random.nextInt(4);
    int rand3= 11+random.nextInt(4);

    static String local;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint({"SetTextI18n", "UseCompatLoadingForDrawables", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_final);



        RPText.main();

        genText = findViewById(R.id.textView);
        design = findViewById(R.id.des);

        switch (MainActivity.sett){
            case "Фэнтэзи":
                design.setBackground(getDrawable(R.drawable.bg_fts));
                genText.setTextColor(getColor(R.color.wh));
                local =RPText.places.get(rand2) + " - " + RPText.about.get(rand2);
                genText.setTextSize(20);
                break;
            case "Реальная жизнь":
                design.setBackground(getDrawable(R.drawable.bg_rl));
                local =RPText.places.get(rand) + " - " + RPText.about.get(rand);
                genText.setTextSize(20);
                break;
            case "Фантастика":
                design.setBackground(getDrawable(R.drawable.bg_cp));
                local =RPText.places.get(rand3) + " - " + RPText.about.get(rand3);
                genText.setTextSize(20);
                break;

        }
        genText.setText(
                RPText.greeting.get(rand)+MainActivity.name+"! Вы находитесь на локации "
                        + MainActivity.locat+", " +MainActivity.locat+" - "+RPText.aboutLoc.get(1+ random.nextInt(2)) + "\n"
                        + "Поблизости с вами находиться " + RPText.names.get(1+random.nextInt(6))
                        + ". Он " + RPText.characters.get(1 +random.nextInt(4))
                        + ", " + RPText.characters.get(5 +random.nextInt(3))
                        + ", " + RPText.characters.get(9 +random.nextInt(3)) +
                        "также" + RPText.characters.get(12 + random.nextInt(3)) +" внешности" + "\n"
                        + "Также позади вас есть локация " + local + " С таким человеком как - "+ RPText.names.get(1 + random.nextInt(6))
                        + ". Он " + RPText.characters.get(1 +random.nextInt(4)) + ", " + RPText.characters.get(5 +random.nextInt(3))
                        + ", " + RPText.characters.get(9 +random.nextInt(3)) +
                        " также " + RPText.characters.get(12 + random.nextInt(3)) +" внешности" + "."
        );
    }
}
