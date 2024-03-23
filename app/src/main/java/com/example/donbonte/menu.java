package com.example.donbonte;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.donbonte.R;

import java.util.Locale;

public class menu extends AppCompatActivity {

    SharedPreferences menulang;
    Button buttonaller;
    Button buttonsettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_menu);
        menulang = this.getSharedPreferences("langua", Context.MODE_PRIVATE);
        String menulang2 = menulang.getString("langua", null);
        buttonaller = findViewById(R.id.button2);
        buttonsettings = findViewById(R.id.button3);
        if (menulang2==null){
            menulang2="English";
        }
        if (menulang2.matches("Français")){
            buttonaller.setText("Aller");
            buttonsettings.setText("Paramètres");
        }else if (menulang2.matches("English")){
            buttonaller.setText("Start");
            buttonsettings.setText("Settings");
        }
        else if (menulang2.matches("Türkçe")){
            buttonaller.setText("Başla");
            buttonsettings.setText("Ayarlar");
        }else if (menulang2 == null){
            buttonaller.setText("Start");
            buttonsettings.setText("Settings");
        }
        else{
            buttonaller.setText("Start");
            buttonsettings.setText("Settings");
        }
    }

    public void aller(View view){
        menulang = this.getSharedPreferences("langua", Context.MODE_PRIVATE);
        String menulang2 = menulang.getString("langua", null);
        if (menulang2==null){
            menulang2="English";
        }
        if (menulang2.matches("Français")){
            setLocal(menu.this, "fr");
            finish();
            startActivity(getIntent());
        }else if (menulang2.matches("English")){
            setLocal(menu.this, "en");
            finish();
            startActivity(getIntent());
        }
        else if (menulang2.matches("Türkçe")){
            setLocal(menu.this, "tr");
            finish();
            startActivity(getIntent());
        }else if (menulang2 == null){
            setLocal(menu.this, "en");
            finish();
            startActivity(getIntent());
        }
        else{
            setLocal(menu.this, "en");
            finish();
            startActivity(getIntent());
        }
        Intent gomain = new Intent(menu.this, MainActivity.class);
        startActivity(gomain);
    }

    public void parametres(View view){
        menulang = this.getSharedPreferences("langua", Context.MODE_PRIVATE);
        String menulang2 = menulang.getString("langua", null);
        if (menulang2==null){
            menulang2="English";
        }
        if (menulang2.matches("Français")){
            setLocal(menu.this, "fr");
            finish();
            startActivity(getIntent());
        }else if (menulang2.matches("English")){
            setLocal(menu.this, "en");
            finish();
            startActivity(getIntent());
        }
        else if (menulang2.matches("Türkçe")){
            setLocal(menu.this, "tr");
            finish();
            startActivity(getIntent());
        }else if (menulang2 == null){
            setLocal(menu.this, "en");
            finish();
            startActivity(getIntent());
        }else{
            setLocal(menu.this, "en");
            finish();
            startActivity(getIntent());
        }
        Intent gosettings = new Intent(menu.this, settings.class);
        startActivity(gosettings);
    }

    public void setLocal(Activity activity, String langCode){
        Locale locale = new Locale(langCode);
        locale.setDefault(locale);
        Resources resources = activity.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.setLocale(locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }

}