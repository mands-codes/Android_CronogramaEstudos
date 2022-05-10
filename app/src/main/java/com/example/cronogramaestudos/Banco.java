package com.example.cronogramaestudos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Banco extends SQLiteOpenHelper {

    private static final int VERSAO = 1;
    private static final String NOME = "AgendaEscolar";

    public Banco(Context context){
        super(context, NOME, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( "CREATE TABLE IF NOT EXISTS agenda ( " +
                " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , " +
                " materia TEXT NOT NULL," +
                "tarefa TEXT NOT NULL, " +
                " finalizado TEXT NOT NULL)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
