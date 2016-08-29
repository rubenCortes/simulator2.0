package com.bennu.administrador.simulador20.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.bennu.administrador.simulador20.modelo.RangoMinimoMaximo;

//import bennucybercafe.com.ve.simulador.datos.Contrato;

/**
 * Created by Rubén on 25/11/2015.
 */
public class DataBaseManager  {


    interface Tablas
    {
        String ADD_CASING = "add_casing";
        String ADD_TUBING = "add_tubing";
        String ADD_PACKER = "add_packer";
        String ADD_FF_UP = "add_ff_up";
        String ADD_FF_DOWN = "add_ff_down";
        String ADD_FF_ROTATION = "add_ff_rotation";
        String ADD_FLUID = "add_fluid";
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
        cadena.append( Contrato.AddCasing.ID_ADD_CASING + " text unique not null," );
        cadena.append( Contrato.AddCasing.RANGO_MINIMO + " real not null," );
        cadena.append( Contrato.AddCasing.RANGO_MAXIMO + " real not null," );
        cadena.append( Contrato.AddCasing.ID + " real not null default 0," );
        cadena.append( Contrato.AddCasing.OD + " real not null default 0," );
        cadena.append( Contrato.AddCasing.DRIFT + " real not null default 0," );
        cadena.append( Contrato.AddCasing.BURST + " real not null default 0" );
        cadena.append( " );" );

        return cadena.toString();
    }

    public static String generarTablaAddTubing()
    {
        StringBuilder cadena;

        cadena = new StringBuilder();
        cadena.append( "create table " + Tablas.ADD_TUBING + " (" );
        cadena.append( BaseColumns._ID + " integer primary key autoincrement,");
        cadena.append( Contrato.AddTubing.ID_ADD_TUBING + " text unique not null,"  );
        cadena.append( Contrato.AddTubing.RANGO_MINIMO + " real not null," );
        cadena.append( Contrato.AddTubing.RANGO_MAXIMO + " real not null," );
        cadena.append( Contrato.AddTubing.ID + " real not null default 0," );
        cadena.append( Contrato.AddTubing.OD + " real not null default 0," );
        cadena.append( Contrato.AddTubing.UNIT_WEIGHT + " real not null default 0," );
        cadena.append( Contrato.AddTubing.DRIFT + " real not null default 0," );
        cadena.append( Contrato.AddTubing.TENSION + " real not null default 0," );
        cadena.append( Contrato.AddTubing.COMPRESSION + " real not null default 0," );
        cadena.append( Contrato.AddTubing.BURST + " real not null default 0," );
        cadena.append( Contrato.AddTubing.COLLAPSE + " real not null default 0," );
        cadena.append( Contrato.AddTubing.TORQUE_LIMIT + " real not null default 0," );
        cadena.append( Contrato.AddTubing.THERMAL_EXP + " real not null default 0" );
        cadena.append( " );" );

        return cadena.toString();
    }

    public static String generarTablaAddPacker()
    {
        StringBuilder cadena;

        cadena = new StringBuilder();
        cadena.append( "create table " + Tablas.ADD_PACKER + " (" );
        cadena.append( BaseColumns._ID + " integer primary key autoincrement,");
        cadena.append( Contrato.AddPacker.ID_ADD_PACKER + " text unique not null,"  );
        cadena.append( Contrato.AddPacker.RANGO_MINIMO + " real not null," );
        cadena.append( Contrato.AddPacker.RANGO_MAXIMO + " real not null," );
        cadena.append( Contrato.AddPacker.ID + " real not null default 0," );
        cadena.append( Contrato.AddPacker.OD + " real not null default 0," );
        cadena.append( Contrato.AddPacker.BURST + " real not null default 0," );
        cadena.append( Contrato.AddPacker.COLLAPSE + " real not null default 0," );
        cadena.append( Contrato.AddPacker.TENSION + " real not null default 0," );
        cadena.append( Contrato.AddPacker.COMPRESSION + " real not null default 0," );
        cadena.append( Contrato.AddPacker.HOLDOWN + " real not null default 0," );
        cadena.append( Contrato.AddPacker.INITIAL_SLACK_OFF + " real not null default 0," );
        cadena.append( Contrato.AddPacker.INITIAL_TENSION + " real not null default 0" );
        cadena.append( " );" );

        return cadena.toString();
    }

    public static String generarTablaAddFfUp()
    {
        StringBuilder cadena;

        cadena = new StringBuilder();
        cadena.append( "create table " + Tablas.ADD_FF_UP + " (" );
        cadena.append( BaseColumns._ID + " integer primary key autoincrement,");
        cadena.append( Contrato.AddFfUp.ID_ADD_FF_UP + " text unique not null,"  );
        cadena.append( Contrato.AddFfUp.RANGO_MINIMO + " real not null," );
        cadena.append( Contrato.AddFfUp.RANGO_MAXIMO + " real not null," );
        cadena.append( Contrato.AddFfUp.CH + " real not null default 0," );
        cadena.append( Contrato.AddFfUp.OH + " real not null default 0" );
        cadena.append( " );" );

        return cadena.toString();
    }

    public static String generarTablaAddFfDown()
    {
        StringBuilder cadena;

        cadena = new StringBuilder();
        cadena.append( "create table " + Tablas.ADD_FF_DOWN + " (" );
        cadena.append( BaseColumns._ID + " integer primary key autoincrement,");
        cadena.append( Contrato.AddFfDown.ID_ADD_FF_DOWN + " text unique not null,"  );
        cadena.append( Contrato.AddFfDown.RANGO_MINIMO + " real not null," );
        cadena.append( Contrato.AddFfDown.RANGO_MAXIMO + " real not null," );
        cadena.append( Contrato.AddFfDown.CH + " real not null default 0," );
        cadena.append( Contrato.AddFfDown.OH + " real not null default 0" );
        cadena.append( " );" );

        return cadena.toString();
    }

    public static String generarTablaAddFfRotation()
    {
        StringBuilder cadena;

        cadena = new StringBuilder();
        cadena.append( "create table " + Tablas.ADD_FF_ROTATION + " (" );
        cadena.append( BaseColumns._ID + " integer primary key autoincrement,");
        cadena.append( Contrato.AddFfRotation.ID_ADD_FF_ROTATION + " text unique not null,"  );
        cadena.append( Contrato.AddFfRotation.RANGO_MINIMO + " real not null," );
        cadena.append( Contrato.AddFfRotation.RANGO_MAXIMO + " real not null," );
        cadena.append( Contrato.AddFfRotation.CH + " real not null default 0," );
        cadena.append( Contrato.AddFfRotation.OH + " real not null default 0" );
        cadena.append( " );" );

        return cadena.toString();
    }

    public static String generarTablaAddFluid()
    {
        StringBuilder cadena;

        cadena = new StringBuilder();
        cadena.append( "create table " + Tablas.ADD_FLUID + " (" );
        cadena.append( BaseColumns._ID + " integer primary key autoincrement,");
        cadena.append( Contrato.AddFluid.ID_ADD_FLUID + " text unique not null,"  );
        cadena.append( Contrato.AddFluid.RANGO_MINIMO + " real not null," );
        cadena.append( Contrato.AddFluid.RANGO_MAXIMO + " real not null," );
        cadena.append( Contrato.AddFluid.INITIAL_INTERNAL_FLUID_DENSITY + " real not null default 0," );
        cadena.append( Contrato.AddFluid.INITIAL_EXTERNAL_FLUID_DENSITY + " real not null default 0," );
        cadena.append( Contrato.AddFluid.FINAL_INTERNAL_FLUID_DENSITY + " real not null default 0," );
        cadena.append( Contrato.AddFluid.FINAL_EXTERNAL_FLUID_DENSITY + " real not null default 0" );
        cadena.append( " );" );

        return cadena.toString();
    }

    private ContentValues valores(RangoMinimoMaximo datos  )
    {
        ContentValues contenido = new ContentValues();

        contenido.put(Contrato.ColumnasAddCasing.ID_ADD_CASING, Contrato.AddCasing.generarId());
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
