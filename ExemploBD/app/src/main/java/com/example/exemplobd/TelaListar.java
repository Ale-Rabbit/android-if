package com.example.exemplobd;


import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.exemplobd.dao.ContatoDAO;
import com.example.exemplobd.pojo.Contato;

import java.util.ArrayList;

public class TelaListar extends ListActivity{
    private ContatoDAO contatoDAO;
    private ArrayList<Contato> listaContato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contatoDAO = new ContatoDAO(this);
        listaContato = contatoDAO.listar();
        ArrayAdapter<Contato> adapter = new ArrayAdapter<Contato>(this, android.R.layout.simple_list_item_1, listaContato);
        setListAdapter(adapter);
    }

}
