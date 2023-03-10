package com.example.examenpractico;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

public class ComponentesIU extends ConnectedObject {
    TextView informacion;
    CheckBox checkBox;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_componentes_iu);
        informacion = findViewById(R.id.informacion);
        checkBox = findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> buscar ());
        String[] nombres = {"Rendon","Mejia","Castrillon","Murillas"};
        Spinner Snombres = (Spinner) findViewById(R.id.spinner);
        Snombres.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, nombres));
        Snombres.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                TextView textView = (TextView)selectedItemView;
                result = textView.getText().toString();
                buscar();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }
    public  void buscar(){
        String plan = "3743";
        String nombre = "";
        switch (result) {
            case "Rendon":
                nombre = "Juan David Rendon Lopez - 2013128";
                break;
            case "Mejia":
                nombre = "Jose David Mejia Rojas - 2013127";
                break;
            case "Castrillon":
                nombre = "Danier Castrillon Garcia - 1668067";
                break;
            case "Murillas":
                nombre = "German David Murillas - 2067549";
                plan = "3743";
                break;
        }
        String adicional = "";
        if(checkBox.isChecked()){
            adicional = "\nPlan: "+plan+"\nUniversidad del Valle";
        }
        String text = nombre + adicional;
        informacion.setText(text);

    }
}