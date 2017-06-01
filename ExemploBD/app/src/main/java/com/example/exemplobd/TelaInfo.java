package com.example.exemplobd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.exemplobd.dao.ContatoDAO;

public class TelaInfo extends Activity {
    private TextView tvNome, tvEmail, tvTelefone;
    private Button btExcluir, btEditar;
    private ContatoDAO contatoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        tvNome = (TextView) findViewById(R.id.tv_nome);
        tvEmail = (TextView) findViewById(R.id.tv_email);
        tvTelefone = (TextView) findViewById(R.id.tv_telefone);
        btExcluir = (Button) findViewById(R.id.bt_excluir);
        btEditar = (Button) findViewById(R.id.bt_editar);

        contatoDAO = new ContatoDAO(this);

        btExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contatoDAO.excluir();
            }
        });

        btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itTelaEditar = new Intent(TelaInfo.this, TelaEditar.class);

            }
        });

    }
}
