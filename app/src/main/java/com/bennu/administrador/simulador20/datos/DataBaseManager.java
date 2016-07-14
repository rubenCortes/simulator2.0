package com.bennu.administrador.simulador20.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import bennucybercafe.com.ve.simulador4.modelo.RangoMinimoMaximo;


//import bennucybercafe.com.ve.simulador.datos.Contrato;

/**
 * Created by Rubén on 25/11/2015.
 */
public class DataBaseManager  {


    interface Tablas
    {
        String ADD_CASING = "add_casing";
        String ADD_TUBING = "add_tubing";
    }



    private DbHelper helper;
    private SQLiteDatabase db;

    public DataBaseManager(Context context )
    {
        helper = new DbHelper( context );
        db = helper.getWritableDatabase();
    }

    public static String generarTablaAddCasing()
    {
        StringBuilder cadena;

        cadena = new StringBuilder();
        cadena.append( "create table " + Tablas.ADD_CASING + " (" );
        cadena.append( BaseColumns._ID + " integer primary key autoincrement,");
        cadena.append( Contrato.ColumnasAddCasing.ID_ADD_CASING + " text unique not null," );
        cadena.append( Contrato.ColumnasAddCasing.RANGO_MINIMO + " real not null," );
        cadena.append( Contrato.ColumnasAddCasing.RANGO_MAXIMO + " real not null," );
        cadena.append( Contrato.ColumnasAddCasing.ID + " real not null default 0," );
        cadena.append( Contrato.ColumnasAddCasing.OD + " real not null default 0," );
        cadena.append( Contrato.ColumnasAddCasing.DRIFT + " real not null default 0," );
        cadena.append( Contrato.ColumnasAddCasing.BURST + " real not null default 0" );
        cadena.append( " );" );

        return cadena.toString();
    }

    public static String generarTablaAddTubing()
    {
        StringBuilder cadena;

        cadena = new StringBuilder();
        cadena.append( "create table " + Tablas.ADD_TUBING + " (" );
        cadena.append( BaseColumns._ID + " integer primary key autoincrement,");
        cadena.append( Contrato.ColumnasAddTubing.ID_ADD_TUBING + " text unique not null,"  );
        cadena.append( Contrato.ColumnasAddTubing.RANGO_MINIMO + " real not null," );
        cadena.append( Contrato.ColumnasAddTubing.RANGO_MAXIMO + " real not null," );
        cadena.append( Contrato.ColumnasAddTubing.ID + " real not null default 0," );
        cadena.append( Contrato.ColumnasAddTubing.OD + " real not null default 0," );
        cadena.append( Contrato.ColumnasAddTubing.UNIT_WEIGHT + " real not null default 0," );
        cadena.append( Contrato.ColumnasAddTubing.DRIFT + " real not null default 0," );
        cadena.append( Contrato.ColumnasAddTubing.TENSION + " real not null default 0," );
        cadena.append( Contrato.ColumnasAddTubing.COMPRESSION + " real not null default 0," );
        cadena.append( Contrato.ColumnasAddTubing.BURST + " real not null default 0," );
        cadena.append( Contrato.ColumnasAddTubing.COLLAPSE + " real not null default 0," );
        cadena.append( Contrato.ColumnasAddTubing.TORQUE_LIMIT + " real not null default 0," );
        cadena.append( Contrato.ColumnasAddTubing.THERMAL_EXP + " real not null default 0" );
        cadena.append( " );" );

        return cadena.toString();
    }

    private ContentValues valores(RangoMinimoMaximo datos  )
    {
        ContentValues contenido = new ContentValues();

        contenido.put(Contrato.ColumnasAddCasing.ID_ADD_CASING, Contrato.AddCasingContrato.generarIdAddCasing());
        contenido.put(Contrato.ColumnasAddCasing.RANGO_MINIMO, datos.getMinimo());
        contenido.put(Contrato.ColumnasAddCasing.RANGO_MAXIMO, datos.getMaximo());

        return contenido;
    }

    public void insertar( double min, double max )
    {
        double minimo;
        double maximo;

        minimo = min;
        maximo = max;

        RangoMinimoMaximo miRango = new RangoMinimoMaximo( minimo, maximo );
        db.insert(Tablas.ADD_CASING, null, valores( miRango ));
    }

    public boolean estaAbierta()
    {
        return db.isOpen();
    }

    public void borrarRango()
    {
        String sentencia = "delete from " +  Tablas.ADD_CASING + ";";
        db.execSQL(sentencia);
    }

    public Cursor rangoCursor()
    {
        return db.rawQuery("select * from " + Tablas.ADD_CASING + ";", null);
    }

    public SQLiteDatabase getBaseDatos()
    {
        return db;
    }

}
