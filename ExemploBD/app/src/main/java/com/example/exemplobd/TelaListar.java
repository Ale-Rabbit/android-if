package com.example.exemplobd;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.exemplobd.dao.ContatoDAO;
import com.example.exemplobd.pojo.Contato;

import java.util.ArrayList;

public class TelaListar extends ListActivity {
    private ContatoDAO contatoDAO;
    private ArrayList<Contato> listaContato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contatoDAO = new ContatoDAO(this);
        listaContato = contatoDAO.listar();
        ArrayAdapter<Contato> adapter = new ArrayAdapter<Contato>(this, android.R.layout.simple_list_item_1, listaContato);
        setListAdapter(adapter);
    };

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        Bundle bundle = new Bundle();

        Contato contato = (Contato) this.getListAdapter().getItem(position);

        bundle.putInt("id", contato);

    }

}
