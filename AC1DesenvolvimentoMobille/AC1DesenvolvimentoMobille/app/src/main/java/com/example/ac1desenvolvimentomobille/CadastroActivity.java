package com.example.ac1desenvolvimentomobille;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {

    private EditText editNome, editIdade, editUF, editCidade, editTelefone, editEmail;
    private RadioGroup radioGroupTamanho;
    private CheckBox checkAzul, checkVermelho, checkVerde, checkPreto, checkBranco;
    private Button buttonCadastrar, buttonIrLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        inicializarComponentes();
        configurarBotoes();
    }

    private void inicializarComponentes() {
        editNome = findViewById(R.id.editNome);
        editIdade = findViewById(R.id.editIdade);
        editUF = findViewById(R.id.editUF);
        editCidade = findViewById(R.id.editCidade);
        editTelefone = findViewById(R.id.editTelefone);
        editEmail = findViewById(R.id.editEmail);
        radioGroupTamanho = findViewById(R.id.radioGroupTamanho);
        checkAzul = findViewById(R.id.checkAzul);
        checkVermelho = findViewById(R.id.checkVermelho);
        checkVerde = findViewById(R.id.checkVerde);
        checkPreto = findViewById(R.id.checkPreto);
        checkBranco = findViewById(R.id.checkBranco);
        buttonCadastrar = findViewById(R.id.buttonCadastrar);
        buttonIrLista = findViewById(R.id.buttonIrLista);
    }

    private void configurarBotoes() {
        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarUsuario();
            }
        });

        buttonIrLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirListaUsuarios();
            }
        });
    }

    private void cadastrarUsuario() {
        String nome = editNome.getText().toString();
        String idade = editIdade.getText().toString();
        String uf = editUF.getText().toString();
        String cidade = editCidade.getText().toString();
        String telefone = editTelefone.getText().toString();
        String email = editEmail.getText().toString();

        int selectedId = radioGroupTamanho.getCheckedRadioButtonId();
        RadioButton selectedTamanho = findViewById(selectedId);
        String tamanho = (selectedTamanho != null) ? selectedTamanho.getText().toString() : "Não selecionado";

        String coresSelecionadas = obterCoresSelecionadas();

        String mensagem = "Nome: " + nome + "\nIdade: " + idade + "\nUF: " + uf + "\nCidade: " + cidade +
                "\nTelefone: " + telefone + "\nEmail: " + email + "\nTamanho: " + tamanho +
                "\nCores Preferidas: " + coresSelecionadas;

        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }

    private String obterCoresSelecionadas() {
        StringBuilder coresSelecionadas = new StringBuilder();
        if (checkAzul.isChecked()) coresSelecionadas.append("Azul ");
        if (checkVermelho.isChecked()) coresSelecionadas.append("Vermelho ");
        if (checkVerde.isChecked()) coresSelecionadas.append("Verde ");
        if (checkPreto.isChecked()) coresSelecionadas.append("Preto ");
        if (checkBranco.isChecked()) coresSelecionadas.append("Branco ");
        return coresSelecionadas.toString();
    }

    private void abrirListaUsuarios() {
        Intent intent = new Intent(CadastroActivity.this, ListaUsuariosActivity.class);
        startActivity(intent);
    }
}
