package com.example.ac1desenvolvimentomobille;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNome;
    private EditText editTextIdade;
    private TextView textViewResultado;
    private Button buttonVerificarIdade;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializando os componentes
        editTextNome = findViewById(R.id.editTextNome);
        editTextIdade = findViewById(R.id.editTextIdade);
        textViewResultado = findViewById(R.id.textViewResultado);
        buttonVerificarIdade = findViewById(R.id.buttonVerificarIdade);

        // Inicializando o botão de navegação
        Button buttonAbrirCalculadora = findViewById(R.id.buttonAbrirCalculadora);

        // Configurando o clique do botão para abrir a calculadora
        buttonAbrirCalculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navega para a CalculadoraActivity
                Intent intent = new Intent(MainActivity.this, CalculadoraActivity.class);
                startActivity(intent);
            }
        });


        // Botão cadastro
        Button buttonAbrirCadastro = findViewById(R.id.buttonAbrirCadastro);
        buttonAbrirCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir a tela de Cadastro
                Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });

        //Botão Check Box
        Button buttonIrParaNomeCheckBox = findViewById(R.id.buttonIrParaNomeCheckBox);
        buttonIrParaNomeCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NomeCheckBoxActivity.class);
                startActivity(intent);
            }
        });

        Button buttonAbrirPreferencias = findViewById(R.id.buttonAbrirPreferencias);
        buttonAbrirPreferencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PreferenciasActivity.class);
                startActivity(intent);
            }
        });


        // Configurando o clique do botão
        buttonVerificarIdade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString();
                String idadeString = editTextIdade.getText().toString();

                // Verifica se os campos não estão vazios
                if (nome.isEmpty() || idadeString.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Converte a idade para um número inteiro
                int idade = Integer.parseInt(idadeString);

                // Verifica se é maior de idade
                if (idade >= 18) {
                    textViewResultado.setText(nome + ", você é maior de idade.");
                } else {
                    textViewResultado.setText(nome + ", você não é maior de idade.");
                }
            }
        });
    }
}
