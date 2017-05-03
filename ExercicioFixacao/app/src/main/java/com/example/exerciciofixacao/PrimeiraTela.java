package com.example.exerciciofixacao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Button;

import java.util.ArrayList;

public class PrimeiraTela extends AppCompatActivity {
    private EditText etNome;
    private RadioGroup rgSexo;
    private RadioButton rbSexo;
    private CheckBox cbMusica, cbFilme;
    private Button btCadastrar, btEnviar;
    private ArrayList<Usuario> usuarios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primeira_tela);

        etNome = (EditText) findViewById(R.id.et_nome);
        rgSexo = (RadioGroup) findViewById(R.id.rg_sexo);
        cbMusica = (CheckBox) findViewById(R.id.cb_musica);
        cbFilme = (CheckBox) findViewById(R.id.cb_filme);
        btCadastrar = (Button) findViewById(R.id.bt_cadastrar);
        btEnviar = (Button) findViewById(R.id.bt_enviar);
        usuarios = new ArrayList<>();

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = etNome.getText().toString();

                int rbSexoId = rgSexo.getCheckedRadioButtonId();
                rbSexo = (RadioButton) rgSexo.findViewById(rbSexoId);
                String sexo = rbSexo.getText().toString();

                ArrayList<String> interesses = new ArrayList<>();

                if(cbMusica.isChecked()){
                    interesses.add("Música");
                }
                if(cbFilme.isChecked()){
                    interesses.add("Filme");
                }

                usuarios.add(new Usuario(nome, sexo, interesses));
            }

        });

        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent proximaTela = new Intent(PrimeiraTela.this, SegundaTela.class);
                proximaTela.putExtra("usuarios", usuarios);

                startActivity(proximaTela);
            }
        });
    }
}
