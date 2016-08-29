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


import com.bennu.administrador.simulador20.datos.Contrato.*;

/**
 * Created by administrador on 14/05/16.
 */
public class ProviderSimulacion extends ContentProvider {

    // Comparador de URIs
    public static final UriMatcher uriMatcher;

    // Casos
    public static final int ADD_CASING = 100;
    public static final int ADD_CASING_ID = 101;

    public static final int ADD_TUBING = 200;
    public static final int ADD_TUBING_ID = 201;

    public static final int ADD_PACKER = 300;
    public static final int ADD_PACKER_ID = 301;

    public static final int ADD_FF_UP = 400;
    public static final int ADD_FF_UP_ID = 401;

    public static final int ADD_FF_DOWN = 500;
    public static final int ADD_FF_DOWN_ID = 501;

    public static final int ADD_FF_ROTATION = 600;
    public static final int ADD_FF_ROTATION_ID = 601;

    public static final int ADD_FLUID = 700;
    public static final int ADD_FLUID_ID = 701;


    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(Contrato.AUTORIDAD, "add_casing", ADD_CASING);
        uriMatcher.addURI(Contrato.AUTORIDAD, "add_casing/*", ADD_CASING_ID);
        uriMatcher.addURI(Contrato.AUTORIDAD, "add_tubing", ADD_TUBING);
        uriMatcher.addURI(Contrato.AUTORIDAD, "add_tubing/*", ADD_TUBING_ID);
        uriMatcher.addURI(Contrato.AUTORIDAD, "add_packer", ADD_PACKER);
        uriMatcher.addURI(Contrato.AUTORIDAD, "add_packer/*", ADD_PACKER_ID);
        uriMatcher.addURI(Contrato.AUTORIDAD, "add_ff_up", ADD_FF_UP);
        uriMatcher.addURI(Contrato.AUTORIDAD, "add_ff_up/*", ADD_FF_UP_ID);
        uriMatcher.addURI(Contrato.AUTORIDAD, "add_ff_down", ADD_FF_DOWN);
        uriMatcher.addURI(Contrato.AUTORIDAD, "add_ff_down/*", ADD_FF_DOWN_ID);
        uriMatcher.addURI(Contrato.AUTORIDAD, "add_ff_rotation", ADD_FF_ROTATION);
        uriMatcher.addURI(Contrato.AUTORIDAD, "add_ff_rotaton/*", ADD_FF_ROTATION_ID);
        uriMatcher.addURI(Contrato.AUTORIDAD, "add_fluid", ADD_FLUID);
        uriMatcher.addURI(Contrato.AUTORIDAD, "add_fluid/*", ADD_FLUID_ID);
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
        // string auxiliar para las consultas
        String consulta;

        Cursor c = null;


        switch (match) {
            case ADD_CASING:
                // Consultando todos los registros
                c = bd.query(DataBaseManager.Tablas.ADD_CASING, projection,
                        selection, selectionArgs,
                        null, null, sortOrder);
                c.setNotificationUri(resolver, AddCasing.URI_CONTENIDO);

                break;
            case ADD_CASING_ID:
                // Consultando un solo registro basado en el Id del Uri
                id = AddCasing.obtenerId(uri);
                consulta = AddCasing.ID_ADD_CASING + " = " + id;

                c = bd.query(DataBaseManager.Tablas.ADD_CASING, projection,
                        consulta + (!TextUtils.isEmpty(selection) ?
                                " AND (" + selection + ')' : ""),
                        selectionArgs, null, null, sortOrder);
                c.setNotificationUri(resolver, uri);

                break;
            case ADD_TUBING:
                // Consultando todos los registros
                c = bd.query(DataBaseManager.Tablas.ADD_TUBING, projection,
                        selection, selectionArgs,
                        null, null, sortOrder);
                c.setNotificationUri(resolver, AddTubing.URI_CONTENIDO);
                break;

            case ADD_TUBING_ID:
                // Consultando un solo registro basado en el Id del Uri
                id = AddTubing.obtenerId(uri);
                consulta = AddCasing.ID_ADD_CASING + " = " + id;

                c = bd.query(DataBaseManager.Tablas.ADD_TUBING, projection,
                        consulta + (!TextUtils.isEmpty(selection) ?
                                " AND (" + selection + ')' : ""),
                        selectionArgs, null, null, sortOrder);
                c.setNotificationUri(resolver, uri);
                break;

            case ADD_PACKER:
                // Consultando todos los registros
                c = bd.query(DataBaseManager.Tablas.ADD_PACKER, projection,
                        selection, selectionArgs,
                        null, null, sortOrder);
                c.setNotificationUri(resolver, AddPacker.URI_CONTENIDO);
                break;
            case ADD_PACKER_ID:
                // Consultando un solo registro basado en el Id del Uri
                id = AddPacker.obtenerId(uri);
                consulta = AddCasing.ID_ADD_CASING + " = " + id;

                c = bd.query(DataBaseManager.Tablas.ADD_TUBING, projection,
                        consulta + (!TextUtils.isEmpty(selection) ?
                                " AND (" + selection + ')' : ""),
                        selectionArgs, null, null, sortOrder);
                c.setNotificationUri(resolver, uri);
                break;

            case ADD_FF_UP:
                // Consultando todos los registros
                c = bd.query(DataBaseManager.Tablas.ADD_FF_UP, projection,
                        selection, selectionArgs,
                        null, null, sortOrder);
                c.setNotificationUri(resolver, AddFfUp.URI_CONTENIDO);
                break;
            case ADD_FF_UP_ID:
                // Consultando un solo registro basado en el Id del Uri
                id = AddFfUp.obtenerId(uri);
                consulta = AddFfUp.ID_ADD_FF_UP + " = " + id;

                c = bd.query(DataBaseManager.Tablas.ADD_FF_UP, projection,
                        consulta + (!TextUtils.isEmpty(selection) ?
                                " AND (" + selection + ')' : ""),
                        selectionArgs, null, null, sortOrder);
                c.setNotificationUri(resolver, uri);
                break;

            case ADD_FF_DOWN:
                // Consultando todos los registros
                c = bd.query(DataBaseManager.Tablas.ADD_FF_DOWN, projection,
                        selection, selectionArgs,
                        null, null, sortOrder);
                c.setNotificationUri(resolver, AddFfDown.URI_CONTENIDO);
                break;
            case ADD_FF_DOWN_ID:
                // Consultando un solo registro basado en el Id del Uri
                id = AddFfDown.obtenerId(uri);
                consulta = AddFfDown.ID_ADD_FF_DOWN + " = " + id;

                c = bd.query(DataBaseManager.Tablas.ADD_FF_DOWN, projection,
                        consulta + (!TextUtils.isEmpty(selection) ?
                                " AND (" + selection + ')' : ""),
                        selectionArgs, null, null, sortOrder);
                c.setNotificationUri(resolver, uri);
                break;

            case ADD_FF_ROTATION:
                // Consultando todos los registros
                c = bd.query(DataBaseManager.Tablas.ADD_FF_ROTATION, projection,
                        selection, selectionArgs,
                        null, null, sortOrder);
                c.setNotificationUri(resolver, AddFfRotation.URI_CONTENIDO);
                break;
            case ADD_FF_ROTATION_ID:
                // Consultando un solo registro basado en el Id del Uri
                id = AddFfRotation.obtenerId(uri);
                consulta = AddFfRotation.ID_ADD_FF_ROTATION + " = " + id;

                c = bd.query(DataBaseManager.Tablas.ADD_FF_ROTATION, projection,
                        consulta + (!TextUtils.isEmpty(selection) ?
                                " AND (" + selection + ')' : ""),
                        selectionArgs, null, null, sortOrder);
                c.setNotificationUri(resolver, uri);
                break;

            case ADD_FLUID:
                // Consultando todos los registros
                c = bd.query(DataBaseManager.Tablas.ADD_FLUID, projection,
                        selection, selectionArgs,
                        null, null, sortOrder);
                c.setNotificationUri(resolver, AddFluid.URI_CONTENIDO);
                break;
            case ADD_FLUID_ID:
                // Consultando un solo registro basado en el Id del Uri
                id = AddFluid.obtenerId(uri);
                consulta = AddFluid.ID_ADD_FLUID + " = " + id;

                c = bd.query(DataBaseManager.Tablas.ADD_FLUID, projection,
                        consulta + (!TextUtils.isEmpty(selection) ?
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
            case ADD_PACKER:
                return Contrato.generarMime(DataBaseManager.Tablas.ADD_PACKER);
            case ADD_PACKER_ID:
                return Contrato.generarMimeItem(DataBaseManager.Tablas.ADD_PACKER);
            case ADD_FF_UP:
                return Contrato.generarMime(DataBaseManager.Tablas.ADD_FF_UP);
            case ADD_FF_UP_ID:
                return Contrato.generarMimeItem(DataBaseManager.Tablas.ADD_FF_UP);
            case ADD_FF_DOWN:
                return Contrato.generarMime(DataBaseManager.Tablas.ADD_FF_DOWN);
            case ADD_FF_DOWN_ID:
                return Contrato.generarMimeItem(DataBaseManager.Tablas.ADD_FF_DOWN);
            case ADD_FF_ROTATION:
                return Contrato.generarMime(DataBaseManager.Tablas.ADD_FF_ROTATION);
            case ADD_FF_ROTATION_ID:
                return Contrato.generarMimeItem(DataBaseManager.Tablas.ADD_FF_ROTATION);
            case ADD_FLUID:
                return Contrato.generarMime(DataBaseManager.Tablas.ADD_FLUID);
            case ADD_FLUID_ID:
                return Contrato.generarMimeItem(DataBaseManager.Tablas.ADD_FLUID);
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
                    id = AddCasing.generarId();
                    values.put(ColumnasAddCasing.ID_ADD_CASING, id);
                }

                bd.insertOrThrow(DataBaseManager.Tablas.ADD_CASING, null, values);
                notificarCambio(uri);
                return AddCasing.crearUri(id);

            case ADD_TUBING:
                // Generar Pk
                if (null == values.getAsString(ColumnasAddTubing.ID_ADD_TUBING)) {
                    id = AddTubing.generarId();
                    values.put(ColumnasAddTubing.ID_ADD_TUBING, id);
                }

                bd.insertOrThrow(DataBaseManager.Tablas.ADD_TUBING, null, values);
                notificarCambio(uri);
                return AddTubing.crearUri(id);

            case ADD_PACKER:
                // Generar Pk
                if (null == values.getAsString(ColumnasAddPacker.ID_ADD_PACKER)) {
                    id = AddPacker.generarId();
                    values.put(ColumnasAddPacker.ID_ADD_PACKER, id);
                }

                bd.insertOrThrow(DataBaseManager.Tablas.ADD_PACKER, null, values);
                notificarCambio(uri);
                return AddPacker.crearUri(id);

            case ADD_FF_UP:
                // Generar Pk
                if (null == values.getAsString(ColumnasAddFfUp.ID_ADD_FF_UP)) {
                    id = AddCasing.generarId();
                    values.put(ColumnasAddFfUp.ID_ADD_FF_UP, id);
                }

                bd.insertOrThrow(DataBaseManager.Tablas.ADD_FF_UP, null, values);
                notificarCambio(uri);
                return AddFfUp.crearUri(id);

            case ADD_FF_DOWN:
                // Generar Pk
                if (null == values.getAsString(ColumnasAddFfDown.ID_ADD_FF_DOWN)) {
                    id = AddFfDown.generarId();
                    values.put(ColumnasAddFfDown.ID_ADD_FF_DOWN, id);
                }

                bd.insertOrThrow(DataBaseManager.Tablas.ADD_FF_DOWN, null, values);
                notificarCambio(uri);
                return AddFfDown.crearUri(id);

            case ADD_FF_ROTATION:
                // Generar Pk
                if (null == values.getAsString(ColumnasAddFfRotation.ID_ADD_FF_ROTATION)) {
                    id = AddFfRotation.generarId();
                    values.put(ColumnasAddFfRotation.ID_ADD_FF_ROTATION, id);
                }

                bd.insertOrThrow(DataBaseManager.Tablas.ADD_FF_ROTATION, null, values);
                notificarCambio(uri);
                return AddFfRotation.crearUri(id);

            case ADD_FLUID:
                // Generar Pk
                if (null == values.getAsString(ColumnasAddFluid.ID_ADD_FLUID)) {
                    id = AddFluid.generarId();
                    values.put(ColumnasAddFluid.ID_ADD_FLUID, id);
                }

                bd.insertOrThrow(DataBaseManager.Tablas.ADD_FLUID, null, values);
                notificarCambio(uri);
                return AddFluid.crearUri(id);

            default:
                throw new UnsupportedOperationException("URI no soportada: " + uri);
        }
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {

        SQLiteDatabase bd = baseDatos.getBaseDatos();
        String id = null;
        String consulta = null;

        int resultado = 0;

        switch (uriMatcher.match(uri)) {
            case ADD_CASING:
                resultado = bd.delete(DataBaseManager.Tablas.ADD_CASING, null, null);
                notificarCambio(uri);
                break;
            case ADD_CASING_ID:
                // Consultando un solo registro basado en el Id del Uri
                id = AddCasing.obtenerId(uri);
                consulta = "_id" + " = " + id;
                //
                //resultado = bd.delete(DataBaseManager.Tablas.ADD_CASING, consulta + (!TextUtils.isEmpty(s) ? " AND (" + s + ')' : ""), strings);
                resultado = bd.delete(DataBaseManager.Tablas.ADD_CASING, consulta, null);
                notificarCambio( uri );
                break;
            case ADD_TUBING:
                resultado = bd.delete(DataBaseManager.Tablas.ADD_TUBING, null, null);
                notificarCambio(uri);
                break;
            case ADD_TUBING_ID:
                // Consultando un solo registro basado en el Id del Uri
                id = AddTubing.obtenerId(uri);
                consulta = "_id" + " = " + id;
                resultado = bd.delete(DataBaseManager.Tablas.ADD_TUBING, consulta, null);
                notificarCambio( uri );
                break;
            case ADD_PACKER:
                resultado = bd.delete(DataBaseManager.Tablas.ADD_PACKER, null, null);
                notificarCambio(uri);
                break;
            case ADD_PACKER_ID:
                // Consultando un solo registro basado en el Id del Uri
                id = AddPacker.obtenerId(uri);
                consulta = "_id" + " = " + id;
                resultado = bd.delete(DataBaseManager.Tablas.ADD_PACKER, consulta, null);
                notificarCambio( uri );
                break;
            case ADD_FF_UP:
                resultado = bd.delete(DataBaseManager.Tablas.ADD_FF_UP, null, null);
                notificarCambio(uri);
                break;
            case ADD_FF_UP_ID:
                // Consultando un solo registro basado en el Id del Uri
                id = AddFfUp.obtenerId(uri);
                consulta = "_id" + " = " + id;
                resultado = bd.delete(DataBaseManager.Tablas.ADD_FF_UP, consulta, null);
                notificarCambio( uri );
                break;
            case ADD_FF_DOWN:
                resultado = bd.delete(DataBaseManager.Tablas.ADD_FF_DOWN, null, null);
                notificarCambio(uri);
                break;
            case ADD_FF_DOWN_ID:
                // Consultando un solo registro basado en el Id del Uri
                id = AddFfDown.obtenerId(uri);
                consulta = "_id" + " = " + id;
                resultado = bd.delete(DataBaseManager.Tablas.ADD_FF_DOWN, consulta, null);
                notificarCambio( uri );
                break;
            case ADD_FF_ROTATION:
                resultado = bd.delete(DataBaseManager.Tablas.ADD_FF_ROTATION, null, null);
                notificarCambio(uri);
                break;
            case ADD_FF_ROTATION_ID:
                // Consultando un solo registro basado en el Id del Uri
                id = AddFfRotation.obtenerId(uri);
                consulta = "_id" + " = " + id;
                resultado = bd.delete(DataBaseManager.Tablas.ADD_FF_ROTATION, consulta, null);
                notificarCambio( uri );
                break;
            case ADD_FLUID:
                resultado = bd.delete(DataBaseManager.Tablas.ADD_FLUID, null, null);
                notificarCambio(uri);
                break;
            case ADD_FLUID_ID:
                // Consultando un solo registro basado en el Id del Uri
                id = AddFluid.obtenerId(uri);
                consulta = "_id" + " = " + id;
                resultado = bd.delete(DataBaseManager.Tablas.ADD_FLUID, consulta, null);
                notificarCambio( uri );
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
