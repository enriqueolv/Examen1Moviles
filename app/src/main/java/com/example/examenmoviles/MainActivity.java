package com.example.examenmoviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    Button boton_agregar_taco;
    Button boton_ver_pedido;
    Button boton_eliminar_taco;
    Button boton_actualizar_taco;
    private ArrayList<Taco> arrayTacos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init_botones();

        if (getIntent().getSerializableExtra("arrayTacos") != null){
            arrayTacos = (ArrayList<Taco>) getIntent().getSerializableExtra("arrayTacos");
        }else{
            arrayTacos = new ArrayList<>();
        }
    }


    private void init_botones(){
        boton_agregar_taco = (Button) findViewById(R.id.button_ir_act_agregar_taco);
        boton_agregar_taco.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), AgregarTacoActivity.class);
                intent.putExtra("arrayTacos", arrayTacos);
                startActivity(intent);
            }
        });



        boton_ver_pedido = (Button) findViewById(R.id.button_ir_act_ver_pedido);
        boton_ver_pedido.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), VerPedidoActivity.class);
                intent.putExtra("arrayTacos", arrayTacos);
                startActivity(intent);
            }
        });



        boton_eliminar_taco = (Button) findViewById(R.id.button_ir_act_eliminar_taco);
        boton_eliminar_taco.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), EliminarTacoActivity.class);
                intent.putExtra("arrayTacos", arrayTacos);
                startActivity(intent);
            }
        });



        boton_actualizar_taco = (Button) findViewById(R.id.button_ir_act_actualizar_taco);
        boton_actualizar_taco.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), ActualizarTacoActivity.class);
                intent.putExtra("arrayTacos", arrayTacos);
                startActivity(intent);
            }
        });
    }
}