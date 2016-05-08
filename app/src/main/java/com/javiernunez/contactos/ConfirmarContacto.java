package com.javiernunez.contactos;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConfirmarContacto extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_contacto);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString(getResources().getString(R.string.pnom));
        String telefono = parametros.getString(getResources().getString(R.string.ptel));
        String descripcion = parametros.getString(getResources().getString(R.string.pdesc));
        String email = parametros.getString(getResources().getString(R.string.pmail));
        String fechaDia = parametros.getString(getResources().getString(R.string.pfecDia));
        String fechaMes = parametros.getString(getResources().getString(R.string.pfecMes));
        String fechaAnyo = parametros.getString(getResources().getString(R.string.pfecAnyo));
        /*Toast.makeText(getBaseContext(), "nuevo: " + nombre, Toast.LENGTH_SHORT).show();*/

        TextView tvNombre = (TextView) findViewById(R.id.txtNombre);
        TextView tvTelefono = (TextView) findViewById(R.id.txtTelefono);
        TextView tvEmail = (TextView) findViewById(R.id.txtEmail);
        TextView tvDescripcion = (TextView) findViewById(R.id.txtDescripcion);
        TextView tvFechaDia = (TextView) findViewById(R.id.txtFechaDia);
        TextView tvFechaMes = (TextView) findViewById(R.id.txtFechaMes);
        TextView tvFechaAnyo = (TextView) findViewById(R.id.txtFechaAnyo);

        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvDescripcion.setText(descripcion);
        tvEmail.setText(email);
        tvFechaDia.setText(fechaDia);
        tvFechaMes.setText(fechaMes);
        tvFechaAnyo.setText(fechaAnyo);


    }

    public void goEditarContacto(View v) {
        TextView tv_nombre = (TextView) findViewById(R.id.txtNombre);
        TextView tv_email = (TextView) findViewById(R.id.txtEmail);
        TextView tv_telefono = (TextView) findViewById(R.id.txtTelefono);
        TextView tv_descripcion = (TextView) findViewById(R.id.txtDescripcion);
        TextView tv_fecDia = (TextView) findViewById(R.id.txtFechaDia);
        TextView tv_fecMes = (TextView) findViewById(R.id.txtFechaMes);
        TextView tv_fecAnyo = (TextView) findViewById(R.id.txtFechaAnyo);


        Intent intent = new Intent(ConfirmarContacto.this, MainActivity.class);
        intent.putExtra(getResources().getString(R.string.pnom), tv_nombre.getText().toString());
        intent.putExtra(getResources().getString(R.string.ptel), tv_telefono.getText().toString());
        intent.putExtra(getResources().getString(R.string.pmail), tv_email.getText().toString());
        intent.putExtra(getResources().getString(R.string.pfecDia), tv_fecDia.getText().toString());
        intent.putExtra(getResources().getString(R.string.pfecMes), tv_fecMes.getText().toString());
        intent.putExtra(getResources().getString(R.string.pfecAnyo), tv_fecAnyo.getText().toString());
        intent.putExtra(getResources().getString(R.string.pdesc), tv_descripcion.getText().toString());
        startActivity(intent);


        //Toast.makeText(getBaseContext(), fechaTxt, Toast.LENGTH_SHORT).show();
        //Toast.makeText(getBaseContext(),nombre.getText(),Toast.LENGTH_SHORT).show();

    }

}
