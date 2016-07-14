package com.bennu.administrador.simulador20.datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Rubén on 25/11/2015.
 */
public class DbHelper extends SQLiteOpenHelper
{

    private static final String DB_NAME = "datos.sqlite";
    private static final int DB_SCHEMA_VERSION = 1;


    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_SCHEMA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

        db.execSQL( DataBaseManager.generarTablaAddCasing() );
        db.execSQL( DataBaseManager.generarTablaAddTubing() );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DataBaseManager.Tablas.ADD_CASING);
        db.execSQL("DROP TABLE IF EXISTS " + DataBaseManager.Tablas.ADD_TUBING);

    }
}
