package com.naat.examenapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import static com.naat.examenapp.MainActivity2.TEXT_REQUEST;
import static com.naat.examenapp.MainActivity2.listaImagenes;

public class MainActivity extends AppCompatActivity {

    Button button,btnsalir;
    ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.btnpasar);
        btnsalir=findViewById(R.id.btnsalir);
        im=findViewById(R.id.imageView);
        if(savedInstanceState !=null){

        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
        btnsalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                alerta.setMessage(R.string.pregunta)
                        .setCancelable(false)
                        .setPositiveButton(R.string.SI, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }

                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog titulo = alerta.create();
                titulo.setTitle(R.string.salir);
                titulo.show();

            }
        });

        Toast toast1 = Toast.makeText(getApplicationContext(),R.string.Bienvenido, Toast.LENGTH_SHORT);
        toast1.setGravity(Gravity.CENTER,0,0);
        toast1.show();

    }
    public  void cargar(){
        SharedPreferences sharedPreferences= getSharedPreferences("llaveimagen",MODE_PRIVATE);
        int index=sharedPreferences.getInt("imagen",0);
        im.setImageResource(listaImagenes[index].getImageResource());
        Toast toast1 = Toast.makeText(getApplicationContext(),index, Toast.LENGTH_SHORT);
        toast1.setGravity(Gravity.CENTER,0,0);
        toast1.show();
    }
    /*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == TEXT_REQUEST){
            if(resultCode==RESULT_OK) {
                reply = Integer.parseInt(data.getStringExtra("llaveimagen"));
                im.setImageResource(listaImagenes[reply].getImageResource());

            }
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
       // outState.putString("llaveimagen");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        im.setImageResource(listaImagenes[reply].getImageResource());
    }

    public void primer(){
        Intent intent= new Intent(MainActivity.this,MainActivity2.class);
        intent.putExtra("llaveimagen",reply);
        //REQUEST ES PARA VER LOS PERMISOS
        //SOLICITANDO CON UN REQUEST Y ESPERO UNA RESPUESTA
        startActivityForResult(intent,TEXT_REQUEST);
    }

     */
}