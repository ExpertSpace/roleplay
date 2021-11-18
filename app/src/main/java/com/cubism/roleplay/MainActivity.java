package com.cubism.roleplay;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Button generation;
    EditText personName;
    Spinner setting;
    EditText location;

    public static String name;
    public static String sett;
    public static String locat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        generation = findViewById(R.id.generation);
        personName = findViewById(R.id.textPersonName);
        setting = findViewById(R.id.spinner);
        location = findViewById(R.id.location);

        sett = setting.getSelectedItem().toString();
    }

    public void generation(View view) {
        if(String.valueOf(personName.getText()).length() == 0 || setting.getSelectedItem().toString().equals("ВЫБОР СЕТТИНГА") || String.valueOf(location.getText()).length() == 0){
            personName.setError("Вы не написали имя,локацию или не выбрали сеттинг");
        }
        else {
            sett = setting.getSelectedItem().toString();
            name = String.valueOf(personName.getText());
            locat = String.valueOf(location.getText());
            Intent intent = new Intent(this, FinalActivity.class);
            startActivity(intent);
        }

    }

}