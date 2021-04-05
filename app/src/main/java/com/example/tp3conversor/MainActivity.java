package com.example.tp3conversor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel vm;
    private EditText etEuros, etDolar, etResultado;
    private Button btnConvertir;
    private RadioGroup radioGroup;
    private RadioButton rbEuro, rbDolar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        inicializar();

        vm.getResultadoMutable().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                etResultado.setText(s);
            }
        });
    }
    private void inicializar() {
        btnConvertir= findViewById(R.id.btnConvertir);
        etDolar= findViewById(R.id.etDolar);
        etEuros= findViewById(R.id.etEuros);
        etResultado= findViewById(R.id.etResultado);
        radioGroup= findViewById(R.id.radioGrup);
        rbDolar= findViewById(R.id.rbDolar);
        rbEuro= findViewById(R.id.rbEuro);

        btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbDolar.isChecked())
                    vm.convertiraEuro(etDolar.getText().toString());
                if (rbEuro.isChecked())
                    vm.convertiraDolar(etEuros.getText().toString());

            }
        });

        rbDolar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDolar.setEnabled(false);
                etEuros.setEnabled(true);
            }
        });

        rbEuro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etEuros.setEnabled(false);
                etDolar.setEnabled(true);
            }
        });
    }
}