package com.example.ac1desenvolvimentomobille;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class NomeCheckBoxActivity extends AppCompatActivity {

    private EditText editNome;
    private Button buttonGerarCheckBoxes;
    private LinearLayout layoutCheckBoxes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nome_checkbox);

        editNome = findViewById(R.id.editNome);
        buttonGerarCheckBoxes = findViewById(R.id.buttonGerarCheckBoxes);
        layoutCheckBoxes = findViewById(R.id.layoutCheckBoxes);

        buttonGerarCheckBoxes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gerarCheckBoxes();
            }
        });
    }

    private void gerarCheckBoxes() {
        layoutCheckBoxes.removeAllViews(); // Limpa os CheckBoxes anteriores

        String nome = editNome.getText().toString().trim();
        if (nome.isEmpty()) {
            return; // Se estiver vazio, não faz nada
        }

        for (char letra : nome.toCharArray()) {
            CheckBox checkBox = new CheckBox(this);
            checkBox.setText(String.valueOf(letra)); // Define o texto do CheckBox como a letra
            layoutCheckBoxes.addView(checkBox); // Adiciona o CheckBox ao layout
        }
    }
}

