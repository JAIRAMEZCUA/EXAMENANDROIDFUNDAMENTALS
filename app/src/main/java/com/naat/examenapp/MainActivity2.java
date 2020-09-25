package com.naat.examenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.naat.examenapp.Datos.Imagenabs;

public class MainActivity2 extends AppCompatActivity {
    private Imagenabs [] listaImagenes = {
            new Imagenabs() {
                @Override
                public int getImageResource() {
                    return R.drawable.ic_baseline_accessibility_new_24;
                }
            },
            new Imagenabs() {
                @Override
                public int getImageResource() {
                    return R.drawable.ic_baseline_airport_shuttle_24;
                }
            },
            new Imagenabs() {
                @Override
                public int getImageResource() {
                    return R.drawable.ic_baseline_attach_money_24;
                }
            }
    };


    Button btnpersona,btncarro,btndinero;
    ImageButton btn1,btn2,btn3;
    ImageView imageView;
    TextView textView;
    private Typeface tipo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        int orientation = getResources().getConfiguration().orientation;
        if (Configuration.ORIENTATION_LANDSCAPE == orientation) {
            imageView=findViewById(R.id.imageView2);
            textView=findViewById(R.id.textView);
            btn1=findViewById(R.id.imageButton);
            btn2=findViewById(R.id.imageButton2);
            btn3=findViewById(R.id.imageButton3);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    textView.setText(R.string.persona);
                    imageView.setImageResource(listaImagenes[0].getImageResource());
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    textView.setText(R.string.carro);
                    imageView.setImageResource(listaImagenes[1].getImageResource());
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    textView.setText(R.string.dinero);
                    imageView.setImageResource(listaImagenes[2].getImageResource());
                }
            });
        }else{

            imageView=findViewById(R.id.imageView3);
            textView=findViewById(R.id.textView2);
            btnpersona=findViewById(R.id.button);
            btncarro=findViewById(R.id.button2);
            btndinero=findViewById(R.id.button3);

            btnpersona.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    textView.setText(R.string.persona);
                    imageView.setImageResource(listaImagenes[0].getImageResource());
                }
            });
            btncarro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    textView.setText(R.string.carro);
                    imageView.setImageResource(listaImagenes[1].getImageResource());
                }
            });
            btndinero.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    textView.setText(R.string.dinero);
                    imageView.setImageResource(listaImagenes[2].getImageResource());
                }
            });

        }
        String fuente = "Fuentes/nuevo.ttf";
        this.tipo = Typeface.createFromAsset(getAssets(),fuente);
        textView.setTypeface(tipo);
    }
}