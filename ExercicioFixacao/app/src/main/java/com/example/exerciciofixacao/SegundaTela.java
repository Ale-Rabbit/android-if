package com.example.exerciciofixacao;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class SegundaTela extends ListActivity {
    private ListView lvUsuarios;
    private ArrayAdapter adapter;
    private ArrayList<Usuario> usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);

        lvUsuarios = (ListView) findViewById(android.R.id.list);

        Intent intent = getIntent();
        usuarios = (ArrayList<Usuario>) intent.getExtras().get("usuarios");

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, usuarios);
        lvUsuarios.setAdapter(adapter);

        lvUsuarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent proximaTela = new Intent(SegundaTela.this, TerceiraTela.class);

                proximaTela.putExtra("usuario", usuarios.get(position));

                startActivity(proximaTela);

            }
        });
    }
}
