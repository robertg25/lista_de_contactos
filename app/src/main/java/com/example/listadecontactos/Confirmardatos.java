package com.example.listadecontactos;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Confirmardatos extends AppCompatActivity {

    TextView tvNombre;
    TextView tvFecha;
    TextView tvTel;
    TextView tvEmail;
    TextView tvDescripcion;
    Button btnEditar;
    String nombre;
    String fecha;
    String telefono;
    String email;
    String descripcion;

    Intent firstActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datos_confirmar);

        Bundle parametros = getIntent().getExtras();

        nombre = parametros.getString(getResources().getString(R.string.pNombreC));
        fecha = parametros.getString(getResources().getString(R.string.pFechaN));
        telefono = parametros.getString(getResources().getString(R.string.pTelefono));
        email = parametros.getString(getResources().getString(R.string.pEmail));
        descripcion = parametros.getString(getResources().getString(R.string.pDescripcion));

        tvNombre = findViewById(R.id.tvNombre);
        tvFecha = findViewById(R.id.tvFecha);
        tvTel = findViewById(R.id.tvTel);
        tvEmail = findViewById(R.id.tvEmail);
        tvDescripcion = findViewById(R.id.tvDescripcion);
        btnEditar=findViewById(R.id.btnSiguiente);
        tvNombre.setText(nombre);
        tvFecha.setText(getResources().getString(R.string.fechaN) + " " + fecha);
        tvTel.setText(getResources().getString(R.string.tel) + " " + telefono);
        tvEmail.setText(getResources().getString(R.string.email2) + " " + email);
        tvDescripcion.setText(getResources().getString(R.string.descripcion2) + " " + descripcion);

        firstActivity = new Intent();
    }

    public void editar(View v){
        firstActivity.putExtra(nombre, 1);
        firstActivity.putExtra(fecha, 2);
        firstActivity.putExtra(telefono, 3);
        firstActivity.putExtra(email, 4);
        firstActivity.putExtra(descripcion, 5);
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(Confirmardatos.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}