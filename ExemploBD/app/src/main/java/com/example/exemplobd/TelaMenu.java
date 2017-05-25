package com.example.exemplobd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaMenu extends AppCompatActivity {
    private Button btCadastrar, btEditar, btExcluir, btListar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCadastrar = (Button) findViewById(R.id.bt_cadastrar);
        btEditar = (Button) findViewById(R.id.bt_editar);
        btExcluir = (Button) findViewById(R.id.bt_excluir);
        btListar = (Button) findViewById(R.id.bt_listar);

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent proximaTela = new Intent(TelaMenu.this, TelaCadastro.class);
                startActivity(proximaTela);
            }
        });

        btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent proximaTela = new Intent(TelaMenu.this, )
            }
        });
    }
}
