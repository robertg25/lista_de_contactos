package com.example.listadecontactos;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView tvFecha;
    EditText txtNombre;
    EditText txtTelefono;
    EditText txtEmail;
    EditText txtDescripcion;
    Button btnSiguiente;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSiguiente =(Button) findViewById(R.id.btnSiguiente);
        txtNombre =(EditText)findViewById(R.id.txtNombre);
        txtTelefono = (EditText)findViewById(R.id.txtTelefono);
        txtEmail = (EditText)findViewById(R.id.txtEmail);
        txtDescripcion = (EditText)findViewById(R.id.txtDescripcion);
        tvFecha = findViewById(R.id.tvFecha);

        tvFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month += 1;

                String date = day + "/" + month + "/" + year;
                tvFecha.setText(date);
            }
        };

    }

    public void siguiente(View v) {
        Intent intent = new Intent(MainActivity.this, Confirmardatos.class);
        intent.putExtra(getResources().getString(R.string.pNombreC), txtNombre.getText().toString());
        intent.putExtra(getResources().getString(R.string.pFechaN), tvFecha.getText().toString());
        intent.putExtra(getResources().getString(R.string.pTelefono), txtTelefono.getText().toString());
        intent.putExtra(getResources().getString(R.string.pEmail), txtEmail.getText().toString());
        intent.putExtra(getResources().getString(R.string.pDescripcion), txtDescripcion.getText().toString());
        startActivityForResult(intent, 1);
    }
}