package com.example.examenmoviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class VerPedidoActivity extends AppCompatActivity {

    Button boton_regresar, boton_ver_todo;
    ArrayList<Taco> arrayTacos;
    private TacoArrayAdapter adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_pedido);
        init_components();
    }



    private void init_components(){
        arrayTacos = (ArrayList<Taco>) getIntent().getSerializableExtra("arrayTacos");
        listView = (ListView) findViewById(R.id.listView_lista_tacos_ACT_ver_pedido);
        boton_regresar = (Button) findViewById(R.id.boton_regresar_ACT_ver_pedido);
        boton_regresar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                intent.putExtra("arrayTacos", arrayTacos);
                startActivity(intent);
            }
        });

        boton_ver_todo = (Button) findViewById(R.id.boton_ver_todo_ACT_ver_pedido);
        boton_ver_todo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mostrar_lista_tacos();
            }
        });
    }

    private void mostrar_lista_tacos(){
        adapter = new TacoArrayAdapter(arrayTacos, getApplicationContext());
        listView.setAdapter(adapter);
    }

}