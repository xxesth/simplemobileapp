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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.donbonte.R;

import java.util.Locale;

public class settings extends AppCompatActivity {
    Spinner spinner;
    SharedPreferences langua;
    public static final String[] languages = {"Select Language","English","Français", "Türkçe"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_settings);
        spinner = findViewById(R.id.spinner);
        langua = this.getSharedPreferences("langua", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = langua.edit();
        editor.commit();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, languages);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedLang = parent.getItemAtPosition(position).toString();
                if (selectedLang.equals("Français")){
                    editor.putString("langua", selectedLang);
                    editor.commit();
                    setLocal(settings.this, "fr");
                    finish();
                    startActivity(getIntent());
                }else if (selectedLang.equals("English")){
                    editor.putString("langua", selectedLang);
                    editor.commit();
                    setLocal(settings.this, "en");
                    finish();
                    startActivity(getIntent());
                }
                else if (selectedLang.equals("Türkçe")){
                    editor.putString("langua", selectedLang);
                    editor.commit();
                    setLocal(settings.this, "tr");
                    finish();
                    startActivity(getIntent());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    public void setLocal(Activity activity, String langCode){
        Locale locale = new Locale(langCode);
        locale.setDefault(locale);
        Resources resources = activity.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.setLocale(locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }
    public void gomenu(View view){
        Intent gomenu = new Intent(settings.this, menu.class);
        startActivity(gomenu);
    }
}