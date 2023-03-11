package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btn7;

    Spinner spinner;


    double mnt;

    List<String >  items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner =findViewById(R.id.spinner2);
        items=new ArrayList<>();
        items.add("MAD");
        items.add("Euro");
        items.add("Dollar");
        spinner.setAdapter(new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,items));

        btn7 = findViewById(R.id.button3);

        btn7.setOnClickListener(view -> {

            Spinner mySpinner = (Spinner) findViewById(R.id.spinner2);
            String text = mySpinner.getSelectedItem().toString();

            TextView txt = findViewById(R.id.resultat1);
            TextView txt2 = findViewById(R.id.resultat2);

            String montant =  ((EditText)findViewById(R.id.input)).getText().toString();
            mnt=Double.valueOf(montant);
            if(text=="MAD"){
            Double doll =mnt*0.097;
            Double euro =mnt*0.091;
                String formattedValuedoll = String.format("%." + 2 + "f", doll);
                String formattedValueeur = String.format("%." + 2 + "f", euro);
                txt.setText(formattedValuedoll+" Doll");
                txt2.setText(formattedValueeur+" Eur");
            }
            else if(text=="Euro"){
                Double mad =mnt*11.01;
                Double doll =mnt*1.06 ;
                String formattedValuemad = String.format("%." + 2 + "f", mad);
                String formattedValuedoll = String.format("%." + 2 + "f", doll);
                txt.setText(formattedValuedoll+" Doll");
                txt2.setText(formattedValuemad+" Mad");}
            else {
                Double mad =mnt*10.34;
                Double euro =mnt*0.94 ;
                String formattedValuemad = String.format("%." + 2 + "f", mad);
                String formattedValueeur = String.format("%." + 2 + "f", euro);
                txt.setText(formattedValueeur+" Eur");
                txt2.setText(formattedValuemad+" Mad");
                }

            //txt.setText(String.valueOf(montant));
        });





    }
}