package com.example.exemplobd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.exemplobd.dao.SQLHelper;
import com.example.exemplobd.pojo.Contato;

public class CadastrarActivity extends AppCompatActivity {
    private EditText etNome, etEmail, etTelefone;
    private Button btSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        SQLHelper helper = SQLHelper.getInstance();

        etNome = (EditText) findViewById(R.id.et_nome);
        etEmail = (EditText) findViewById(R.id.et_email);
        etTelefone = (EditText) findViewById(R.id.et_telefone);
        btSalvar = (Button) findViewById(R.id.bt_salvar);

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = etNome.getText().toString();
                String email = etEmail.getText().toString();
                String telefone = etTelefone.getText().toString();

                Contato contato = new Contato(nome, email, telefone);

            }
        });
    }
}
