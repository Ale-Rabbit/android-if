package com.example.exemplobd.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.exemplobd.pojo.Contato;

import java.util.ArrayList;

public class ContatoDAO {
    private SQLiteDatabase db;
    private static final String NOME_TABELA = "contato";
    private static final String COLUNA_ID = "id";
    private static final String COLUNA_NOME = "nome";
    private static final String COLUNA_EMAIL = "email";
    private static final String COLUNA_TELEFONE = "telefone";
    public static final String CREATE_TABLE = "CREATE TABLE "+NOME_TABELA+" ("+COLUNA_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE, "+COLUNA_NOME+" TEXT NOT NULL, "+COLUNA_EMAIL+" TEXT UNIQUE, "+COLUNA_TELEFONE+" TEXT NOT NULL UNIQUE)";

    public ContatoDAO(Context ctx){
        db = SQLHelper.getInstance(ctx).getWritableDatabase();
    }

    public boolean salvar(Contato contato){
        Long id = this.db.insert(NOME_TABELA, null, this.contatoToContentValues(contato));

        return id != -1;
    }

    public void editar(Contato contato){
        String where = "WHERE "+COLUNA_ID+"=?";
        String[] whereArgs = {String.valueOf(contato.getId())};
        this.db.update(NOME_TABELA, this.contatoToContentValues(contato), where, whereArgs);
    }

    public void excluir(int id){
        String where = "WHERE "+COLUNA_ID+"=?";
        String[] whereArgs = {String.valueOf(id)};
        this.db.delete(NOME_TABELA, where, whereArgs);
    }

    public ArrayList<Contato> listar(){
        ArrayList<Contato> listaContato = new ArrayList<>();
        String sqlListar = "SELECT * FROM "+NOME_TABELA;

        Cursor cursor = this.db.rawQuery(sqlListar, null);

        int indiceId = cursor.getColumnIndex(COLUNA_ID);
        int indiceNome = cursor.getColumnIndex(COLUNA_NOME);
        int indiceEmail = cursor.getColumnIndex(COLUNA_EMAIL);
        int indiceTelefone = cursor.getColumnIndex(COLUNA_TELEFONE);

        while(cursor.moveToNext()){
            Contato contato = new Contato();
            contato.setId(cursor.getInt(indiceId));
            contato.setNome(cursor.getString(indiceNome));
            contato.setEmail(cursor.getString(indiceEmail));
            contato.setTelefone(cursor.getString(indiceTelefone));

            listaContato.add(contato);
        }

        return listaContato;

    }

    private ContentValues contatoToContentValues(Contato contato){
        ContentValues cv = new ContentValues();
        cv.put(COLUNA_NOME, contato.getNome());
        cv.put(COLUNA_EMAIL, contato.getEmail());
        cv.put(COLUNA_TELEFONE, contato.getTelefone());

        return cv;
    }

}
