package com.javiernunez.contactos;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (getIntent().getExtras()!=null) {
            Bundle parametros = getIntent().getExtras();
            String nombre = parametros.getString(getResources().getString(R.string.pnom));
            String telefono = parametros.getString(getResources().getString(R.string.ptel));
            String descripcion = parametros.getString(getResources().getString(R.string.pdesc));
            String email = parametros.getString(getResources().getString(R.string.pmail));
            String fechaDia = parametros.getString(getResources().getString(R.string.pfecDia));
            String fechaMes = parametros.getString(getResources().getString(R.string.pfecMes));
            String fechaAnyo = parametros.getString(getResources().getString(R.string.pfecAnyo));

            TextInputEditText tvNombre = (TextInputEditText) findViewById(R.id.inputNombre);
            TextInputEditText tvEmail = (TextInputEditText) findViewById(R.id.inputEmail);
            TextInputEditText tvTelefono = (TextInputEditText) findViewById(R.id.inputTelefono);
            TextInputEditText tvDescripcion = (TextInputEditText) findViewById(R.id.inputDescrip);
            DatePicker dpFecha = (DatePicker) findViewById(R.id.inputFecha);

            tvNombre.setText(nombre);
            tvEmail.setText(email);
            tvTelefono.setText(telefono);
            tvDescripcion.setText(descripcion);
            dpFecha.updateDate(Integer.valueOf(fechaAnyo),Integer.valueOf(fechaMes)-1,Integer.valueOf(fechaDia));
        }


    }

    /*final Button bt_siguiente = (Button) findViewById(R.id.btSiguiente);
    bt_siguiente.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, ConfirmarContacto.class);
            startActivity(intent);
        }
    });*/

    public void goVerContacto(View v) {
        TextView nombre = (TextView) findViewById(R.id.inputNombre);
        TextView email = (TextView) findViewById(R.id.inputEmail);
        TextView telefono = (TextView) findViewById(R.id.inputTelefono);
        TextView descripcion = (TextView) findViewById(R.id.inputDescrip);
        DatePicker fecha = (DatePicker) findViewById(R.id.inputFecha);
        int dia = fecha.getDayOfMonth();
        int mes = fecha.getMonth() + 1;
        int anyo = fecha.getYear();
        //String fechaTxt = String.valueOf(dia) + '/' + String.valueOf(mes) + '/' + String.valueOf(anyo);

        /*
        Toast.makeText(getBaseContext(), fechaTxt, Toast.LENGTH_SHORT).show();
        Toast.makeText(getBaseContext(),nombre.getText(),Toast.LENGTH_SHORT).show();
        */

        Intent intent = new Intent(MainActivity.this, ConfirmarContacto.class);
        intent.putExtra(getResources().getString(R.string.pnom), nombre.getText().toString());
        intent.putExtra(getResources().getString(R.string.ptel), telefono.getText().toString());
        intent.putExtra(getResources().getString(R.string.pmail), email.getText().toString());
        intent.putExtra(getResources().getString(R.string.pfecDia), String.valueOf(dia));
        intent.putExtra(getResources().getString(R.string.pfecMes), String.valueOf(mes));
        intent.putExtra(getResources().getString(R.string.pfecAnyo), String.valueOf(anyo));
        intent.putExtra(getResources().getString(R.string.pdesc), descripcion.getText().toString());
        startActivity(intent);

    }



}

