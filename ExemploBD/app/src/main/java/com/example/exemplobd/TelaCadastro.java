package com.example.exemplobd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.exemplobd.dao.ContatoDAO;
import com.example.exemplobd.dao.SQLHelper;
import com.example.exemplobd.pojo.Contato;

public class TelaCadastro extends AppCompatActivity {
    private EditText etNome, etEmail, etTelefone;
    private Button btSalvar;
    private ContatoDAO contatoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        etNome = (EditText) findViewById(R.id.et_nome);
        etEmail = (EditText) findViewById(R.id.et_email);
        etTelefone = (EditText) findViewById(R.id.et_telefone);

        btSalvar = (Button) findViewById(R.id.bt_salvar);
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contato contato = new Contato();

                contatoDAO = new ContatoDAO(getApplicationContext());

                contato.setNome(etNome.getText().toString());
                contato.setEmail(etEmail.getText().toString());
                contato.setTelefone(etTelefone.getText().toString());

                boolean resultado = contatoDAO.salvar(contato);
                String mensagem = resultado ? "Salvo com sucesso :)" : "Não salvo";

                Toast.makeText(TelaCadastro.this, mensagem, Toast.LENGTH_LONG).show();

            }
        });
    }
}
