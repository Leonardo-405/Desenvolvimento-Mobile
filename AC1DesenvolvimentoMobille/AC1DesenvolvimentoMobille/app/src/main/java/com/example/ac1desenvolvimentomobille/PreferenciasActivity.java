package com.example.ac1desenvolvimentomobille;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PreferenciasActivity extends AppCompatActivity {

    private CheckBox checkNotificacoes, checkModoEscuro, checkLembrarLogin;
    private Button buttonSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencias);

        // Inicializa os componentes
        checkNotificacoes = findViewById(R.id.checkNotificacoes);
        checkModoEscuro = findViewById(R.id.checkModoEscuro);
        checkLembrarLogin = findViewById(R.id.checkLembrarLogin);
        buttonSalvar = findViewById(R.id.buttonSalvar);

        // Configura o clique do botão
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarPreferencias();
            }
        });
    }

    private void salvarPreferencias() {
        StringBuilder preferencias = new StringBuilder();

        if (checkNotificacoes.isChecked()) preferencias.append("Receber notificações\n");
        if (checkModoEscuro.isChecked()) preferencias.append("Modo escuro\n");
        if (checkLembrarLogin.isChecked()) preferencias.append("Lembrar login\n");

        if (preferencias.length() == 0) {
            Toast.makeText(this, "Nenhuma preferência foi escolhida", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Preferências salvas:\n" + preferencias, Toast.LENGTH_LONG).show();
        }
    }
}
