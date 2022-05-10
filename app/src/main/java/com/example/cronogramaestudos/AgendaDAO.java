package com.example.cronogramaestudos;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class AgendaDAO {

    public static void inserir(Context context, Agenda agenda){
        Banco conn = new Banco(context);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("materia", agenda.getMateria() );
        valores.put("tarefa", agenda.getTarefa() );
         valores.put("finalizado", agenda.getFinalizado() );

        db.insert("agenda", null, valores);

        db.close();
    }

    public static void editar(Context context, Agenda agenda){
        Banco conn = new Banco(context);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("materia", agenda.getMateria() );
        valores.put("tarefa", agenda.getTarefa() );
        valores.put("finalizado", agenda.getFinalizado() );

        db.update("agenda", valores, " id = " + agenda.getId(), null);

        db.close();
    }

    public static void excluir(Context context, int idAgenda){
        Banco conn = new Banco(context);
        SQLiteDatabase db = conn.getWritableDatabase();

        db.delete("agenda", " id = " + idAgenda, null);

        db.close();
    }

    public static List<Agenda> getAgendamentos(Context context){
        Banco conn = new Banco(context);
        SQLiteDatabase db = conn.getReadableDatabase();

        Cursor cursor = db.rawQuery(
                " SELECT a.id, a.materia, a.tarefa, a.finalizado" +
                        " FROM agenda a  ",
                null );

        List<Agenda> agenda = new ArrayList<>();

        if( cursor.getCount() > 0 ){
            cursor.moveToFirst();

            do{

                Agenda a  = new Agenda();
                a.setId( cursor.getInt(0));
                a.setMateria( cursor.getString(1));
                a.setTarefa( cursor.getString(2));
                a.setFinalizado( cursor.getString(3));
                agenda.add( a );
            }while (cursor.moveToNext());
        }
        return agenda;
    }


}
