package com.example.examenmoviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class ActualizarTacoActivity extends AppCompatActivity {

    Taco            taco_actual;
    ArrayList<Taco> arrayTacos;
    Button          boton_regresar, boton_buscar, boton_modificar;
    EditText        editText_num_taco, editText_carne;
    RadioButton     radioButton_salsa_pica, radioButton_salsa_NO_pica;
    CheckBox        checkBox_limon, checkBox_cilantro, checkBox_cebolla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_taco);
        arrayTacos = (ArrayList<Taco>) getIntent().getSerializableExtra("arrayTacos");
        init_botones();
        init_components();
        boton_modificar.setEnabled(false);
    }


    private void init_botones() {
        boton_regresar = (Button) findViewById(R.id.boton_regresar_ACT_actualizar_taco);
        boton_regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                intent.putExtra("arrayTacos", arrayTacos);
                startActivity(intent);
            }
        });


        boton_buscar = (Button) findViewById(R.id.boton_buscar_ACT_actualizar_taco);
        boton_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num_taco = Integer.parseInt(editText_num_taco.getText().toString());
                int ultimo_num_taco = arrayTacos.size();

                if(num_taco >=1 && num_taco <= ultimo_num_taco){
                    //El taco existe en la lista
                    //Obtener el taco de la lista
                    taco_actual = arrayTacos.get(num_taco-1);
                    //Cargar los capos con el taco solicitado
                    cargar_taco_a_vista();

                    //Habilitar las vistas
                    enable_taco_fields();
                    boton_modificar.setEnabled(true);
                    editText_num_taco.setEnabled(false);
                }else{
                    Context context = getApplicationContext();
                    CharSequence text = "Ese número de taco no existe";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }


            }
        });

        boton_modificar = (Button) findViewById(R.id.boton_modificar_ACT_actualizar_taco);
        boton_modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num_taco = Integer.parseInt(editText_num_taco.getText().toString());
                cargar_taco_desde_vista();
                arrayTacos.set(num_taco - 1, taco_actual);
                disable_taco_fields();
                editText_num_taco.setEnabled(true);

                boton_modificar.setEnabled(false);
                Context context = getApplicationContext();
                CharSequence text = "Taco actualizado";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
    }

    private void init_components(){

        editText_num_taco         = (EditText)    findViewById(R.id.editTextNumber_num_taco_ACT_actualizar_taco);
        editText_carne            = (EditText)    findViewById(R.id.editText_tipo_de_carne_ACT_actualizar_taco);
        radioButton_salsa_pica    = (RadioButton) findViewById(R.id.radioButton_salsa_pica_ACT_actualizar_taco);
        radioButton_salsa_NO_pica = (RadioButton) findViewById(R.id.radioButton_salsa_no_pica_ACT_actualizar_taco);
        checkBox_limon            = (CheckBox)    findViewById(R.id.checkBox_limon_ACT_actualizar_taco);
        checkBox_cilantro         = (CheckBox)    findViewById(R.id.checkBox_cilantro_ACT_actualizar_taco);
        checkBox_cebolla          = (CheckBox)    findViewById(R.id.checkBox_cebolla_ACT_actualizar_taco);

        disable_taco_fields();
    }

    private void disable_taco_fields(){
        editText_carne.setEnabled(false);
        radioButton_salsa_pica.setEnabled(false);
        radioButton_salsa_NO_pica.setEnabled(false);
        checkBox_limon.setEnabled(false);
        checkBox_cilantro.setEnabled(false);
        checkBox_cebolla.setEnabled(false);
    }

    private void enable_taco_fields(){
        editText_carne.setEnabled(true);
        radioButton_salsa_pica.setEnabled(true);
        radioButton_salsa_NO_pica.setEnabled(true);
        checkBox_limon.setEnabled(true);
        checkBox_cilantro.setEnabled(true);
        checkBox_cebolla.setEnabled(true);
    }

    private void cargar_taco_a_vista(){
        editText_carne.setText(taco_actual.getCarne());
        if(taco_actual.getTipo_salsa() == 0){
            radioButton_salsa_pica.setChecked(true);
            radioButton_salsa_NO_pica.setChecked(false);
        }else if (taco_actual.getTipo_salsa() == 1){
            radioButton_salsa_pica.setChecked(false);
            radioButton_salsa_NO_pica.setChecked(true);
        }else{
            radioButton_salsa_pica.setChecked(true);
            radioButton_salsa_NO_pica.setChecked(false);
        }

        if(taco_actual.getLimon()==true){
            checkBox_limon.setChecked(true);
        }else{
            checkBox_limon.setChecked(false);
        }

        if(taco_actual.getCilantro()==true){
            checkBox_cilantro.setChecked(true);
        }else{
            checkBox_cilantro.setChecked(false);
        }

        if(taco_actual.getCebolla()==true){
            checkBox_cebolla.setChecked(true);
        }else{
            checkBox_cebolla.setChecked(false);
        }
    }

    private void cargar_taco_desde_vista(){
        taco_actual.setCarne(editText_carne.getText().toString());
        taco_actual.setTipo_salsa(0);
        if(radioButton_salsa_pica.isChecked()){
            taco_actual.setTipo_salsa(0);
        }
        if(radioButton_salsa_NO_pica.isChecked()){
            taco_actual.setTipo_salsa(1);
        }

        if(checkBox_limon.isChecked()){
            taco_actual.setLimon(true);
        }else{
            taco_actual.setLimon(false);
        }

        if(checkBox_cilantro.isChecked()){
            taco_actual.setCilantro(true);
        }else{
            taco_actual.setCilantro(false);
        }

        if(checkBox_cebolla.isChecked()){
            taco_actual.setCebolla(true);
        }else{
            taco_actual.setCebolla(false);
        }
    }
}