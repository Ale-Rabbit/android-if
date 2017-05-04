package com.example.exemplobd.dao;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLHelper extends SQLiteOpenHelper{
    private static final String NOME_BANCO = "bd_contatos";
    private static final int VERSAO = 1;
    private static SQLHelper instance;

    private SQLHelper() {

    }

    public static SQLHelper getInstance(){

        if(instance == null){
            instance = new SQLHelper();
        }

        return instance;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
