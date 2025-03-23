package com.example.ac1desenvolvimentomobille;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CalculadoraActivity extends AppCompatActivity {

    private EditText editTextNumero1;
    private EditText editTextNumero2;
    private TextView textViewResultado;
    private Button buttonSoma, buttonSubtracao, buttonMultiplicacao, buttonDivisao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activy_calculadora);

        // Inicializando os componentes
        editTextNumero1 = findViewById(R.id.editTextNumero1);
        editTextNumero2 = findViewById(R.id.editTextNumero2);
        textViewResultado = findViewById(R.id.textViewResultado);

        buttonSoma = findViewById(R.id.buttonSoma);
        buttonSubtracao = findViewById(R.id.buttonSubtracao);
        buttonMultiplicacao = findViewById(R.id.buttonMultiplicacao);
        buttonDivisao = findViewById(R.id.buttonDivisao);

        // Configurando os cliques dos botões
        buttonSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarOperacao('+');
            }
        });

        buttonSubtracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarOperacao('-');
            }
        });

        buttonMultiplicacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarOperacao('*');
            }
        });

        buttonDivisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarOperacao('/');
            }
        });
    }

    private void realizarOperacao(char operacao) {
        String numero1String = editTextNumero1.getText().toString();
        String numero2String = editTextNumero2.getText().toString();

        // Verifica se os campos não estão vazios
        if (numero1String.isEmpty() || numero2String.isEmpty()) {
            Toast.makeText(CalculadoraActivity.this, "Por favor, insira ambos os números.", Toast.LENGTH_SHORT).show();
            return;
        }

        double numero1 = Double.parseDouble(numero1String);
        double numero2 = Double.parseDouble(numero2String);
        double resultado = 0;

        switch (operacao) {
            case '+':
                resultado = numero1 + numero2;
                break;
            case '-':
                resultado = numero1 - numero2;
                break;
            case '*':
                resultado = numero1 * numero2;
                break;
            case '/':
                if (numero2 == 0) {
                    Toast.makeText(CalculadoraActivity.this, "Divisão por zero não permitida!", Toast.LENGTH_SHORT).show();
                    return;
                }
                resultado = numero1 / numero2;
                break;
        }

        textViewResultado.setText("Resultado: " + resultado);
    }
}
