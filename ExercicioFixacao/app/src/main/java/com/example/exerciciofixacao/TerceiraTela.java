package com.example.exerciciofixacao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class TerceiraTela extends AppCompatActivity {
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceira_tela);

        usuario = (Usuario) getIntent().getExtras().get("usuario");

    }
    @Override
    protected void onStart(){
        Toast.makeText(this, usuario.getNome()+","+usuario.getSexo()+","+usuario.getInteresses().get(0), Toast.LENGTH_LONG).show();

        super.onStart();
    }
}
