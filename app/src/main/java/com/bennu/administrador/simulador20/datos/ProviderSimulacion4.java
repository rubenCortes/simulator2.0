package com.bennu.administrador.simulador20.datos;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import bennucybercafe.com.ve.simulador4.datos.Contrato.*;

/**
 * Created by administrador on 14/05/16.
 */
public class ProviderSimulacion4 extends ContentProvider {

    // Comparador de URIs
    public static final UriMatcher uriMatcher;

    // Casos
    public static final int ADD_CASING = 100;
    public static final int ADD_CASING_ID = 101;

    public static final int ADD_TUBING = 200;
    public static final int ADD_TUBING_ID = 201;


    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(Contrato.AUTORIDAD, "add_casing", ADD_CASING);
        uriMatcher.addURI(Contrato.AUTORIDAD, "add_casing/*", ADD_CASING_ID);
        uriMatcher.addURI(Contrato.AUTORIDAD, "add_tubing", ADD_TUBING);
        uriMatcher.addURI(Contrato.AUTORIDAD, "add_tubing/*", ADD_TUBING_ID);

    }

    private DataBaseManager baseDatos;
    private ContentResolver resolver;


    @Override
    public boolean onCreate() {
        baseDatos = new DataBaseManager(getContext());
        resolver = getContext().getContentResolver();
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        // Obtener base de datos

        SQLiteDatabase bd = baseDatos.getBaseDatos();

        // Comparar Uri
        int match = uriMatcher.match(uri);

        // string auxiliar para los ids
        String id;

        Cursor c;


        switch (match) {
            case ADD_CASING:
                // Consultando todos los registros
                c = bd.query(DataBaseManager.Tablas.ADD_CASING, projection,
                        selection, selectionArgs,
                        null, null, sortOrder);
                c.setNotificationUri(resolver, Contrato.AddCasingContrato.URI_CONTENIDO);

                break;
            case ADD_CASING_ID:
                // Consultando un solo registro basado en el Id del Uri
                String idAddCasing = Contrato.AddCasingContrato.obtenerIdAddCasing(uri);
                String consultaCasing = Contrato.ColumnasAddCasing.ID_ADD_CASING + " = " + idAddCasing;

                c = bd.query(DataBaseManager.Tablas.ADD_CASING, projection,
                        consultaCasing + (!TextUtils.isEmpty(selection) ?
                                " AND (" + selection + ')' : ""),
                        selectionArgs, null, null, sortOrder);
                c.setNotificationUri(resolver, uri);

                break;
            case ADD_TUBING:
                // Consultando todos los registros
                c = bd.query(DataBaseManager.Tablas.ADD_TUBING, projection,
                        selection, selectionArgs,
                        null, null, sortOrder);
                c.setNotificationUri(resolver, Contrato.AddTubingContrato.URI_CONTENIDO);
                break;

            case ADD_TUBING_ID:
                // Consultando un solo registro basado en el Id del Uri
                String idAddTubing = Contrato.AddTubingContrato.obtenerIdAddTubing(uri);
                String consultaTubing = Contrato.ColumnasAddCasing.ID_ADD_CASING + " = " + idAddTubing;

                c = bd.query(DataBaseManager.Tablas.ADD_TUBING, projection,
                        consultaTubing + (!TextUtils.isEmpty(selection) ?
                                " AND (" + selection + ')' : ""),
                        selectionArgs, null, null, sortOrder);
                c.setNotificationUri(resolver, uri);
                break;


            default:
                throw new UnsupportedOperationException("URI no soportada: " + uri);
        }

        return c;
    }


    @Nullable
    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)) {
            case ADD_CASING:
                return Contrato.generarMime(DataBaseManager.Tablas.ADD_CASING);
            case ADD_CASING_ID:
                return Contrato.generarMimeItem(DataBaseManager.Tablas.ADD_CASING);
            case ADD_TUBING:
                return Contrato.generarMime(DataBaseManager.Tablas.ADD_TUBING);
            case ADD_TUBING_ID:
                return Contrato.generarMimeItem(DataBaseManager.Tablas.ADD_TUBING);
            default:
                throw new UnsupportedOperationException("Uri desconocida =>" + uri);
        }
    }


    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {

        //Log.d(TAG, "Inserción en " + uri + "( " + values.toString() + " )\n");

        SQLiteDatabase bd = baseDatos.getBaseDatos();
        String id = null;

        switch (uriMatcher.match(uri)) {
            case ADD_CASING:
                // Generar Pk
                if (null == values.getAsString(ColumnasAddCasing.ID_ADD_CASING)) {
                    id = AddCasingContrato.generarIdAddCasing();
                    values.put(ColumnasAddCasing.ID_ADD_CASING, id);
                }

                bd.insertOrThrow(DataBaseManager.Tablas.ADD_CASING, null, values);
                notificarCambio(uri);
                return AddCasingContrato.crearUriAddCasing(id);

            case ADD_TUBING:
                // Generar Pk
                if (null == values.getAsString(ColumnasAddTubing.ID_ADD_TUBING)) {
                    id = AddCasingContrato.generarIdAddCasing();
                    values.put(ColumnasAddTubing.ID_ADD_TUBING, id);
                }

                bd.insertOrThrow(DataBaseManager.Tablas.ADD_CASING, null, values);
                notificarCambio(uri);
                return AddTubingContrato.crearUriAddTubing(id);



            default:
                throw new UnsupportedOperationException("URI no soportada: " + uri);
        }

    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {

        SQLiteDatabase bd = baseDatos.getBaseDatos();
        String id = null;

        int resultado = 0;

        switch (uriMatcher.match(uri)) {
            case ADD_CASING:
                resultado = bd.delete(DataBaseManager.Tablas.ADD_CASING, null, null);

                notificarCambio(uri);
                break;


            case ADD_CASING_ID:
                // Consultando un solo registro basado en el Id del Uri
                String idAddCasing = Contrato.AddCasingContrato.obtenerIdAddCasing(uri);
                String consultaCasing = "_id" + " = " + idAddCasing;

                resultado = bd.delete(DataBaseManager.Tablas.ADD_CASING,
                        consultaCasing + (!TextUtils.isEmpty(s) ? " AND (" + s + ')' : ""), strings);

                notificarCambio( uri );


                break;
            case ADD_TUBING:
                resultado = bd.delete(DataBaseManager.Tablas.ADD_TUBING, null, null);

                notificarCambio(uri);
                break;
            default:
                throw new UnsupportedOperationException("URI no soportada: " + uri);
        }

        return resultado;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }

    private void notificarCambio(Uri uri) {
        resolver.notifyChange(uri, null);
    }


}
