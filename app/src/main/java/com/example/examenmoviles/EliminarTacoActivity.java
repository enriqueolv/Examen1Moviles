package com.example.examenmoviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class EliminarTacoActivity extends AppCompatActivity {

    ArrayList<Taco> arrayTacos;
    Button          boton_regresar;
    Button          boton_eliminar;
    EditText        editTextNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_taco);
        init_components();
        init_botones();
    }


    private void init_botones(){
        boton_regresar = (Button) findViewById(R.id.boton_regresar_ACT_eliminar_taco);
        boton_regresar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                intent.putExtra("arrayTacos", arrayTacos);
                startActivityForResult(intent, 0);
            }
        });


        boton_eliminar = (Button)   findViewById(R.id.boton_eliminar_ACT_eliminar_taco);
        boton_eliminar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int num_taco = Integer.parseInt(editTextNumber.getText().toString());
                int ultimo_num_taco = arrayTacos.size();
                if(num_taco >= 1 && num_taco <= ultimo_num_taco){
                    //Se puede eliminar porque esta en la lista
                    arrayTacos.remove(num_taco - 1);
                    Context context = getApplicationContext();
                    CharSequence text = "Taco eliminado";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }else{
                    Context context = getApplicationContext();
                    CharSequence text = "Ese número de taco no existe";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

            }
        });

    }


    private void init_components(){
        arrayTacos = (ArrayList<Taco>) getIntent().getSerializableExtra("arrayTacos");
        editTextNumber = (EditText) findViewById(R.id.editTextNumber_num_taco_ACT_eliminar_taco);
    }
}