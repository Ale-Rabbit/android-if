package com.example.exemplobd.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLHelper extends SQLiteOpenHelper{
    private static final String NOME_BANCO = "bd_contatos";
    private static final int VERSAO = 1;
    private static SQLHelper instance;

    private SQLHelper(Context ctx) {
        super(ctx, NOME_BANCO, null, VERSAO);
    }

    public static SQLHelper getInstance(Context ctx){

        if(instance == null){
            instance = new SQLHelper(ctx);
        }

        return instance;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ContatoDAO.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
