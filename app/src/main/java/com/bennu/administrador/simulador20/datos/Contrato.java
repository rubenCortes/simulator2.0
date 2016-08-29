package com.bennu.administrador.simulador20.datos;

import android.net.Uri;

import java.util.UUID;

/**
 * Created by Rubén on 7/5/2016.
 */
public class Contrato
{
    public interface ColumnasAddCasing
    {
        String ID_ADD_CASING = "id_add_casing";
        String RANGO_MINIMO = "rango_minimo";
        String RANGO_MAXIMO = "rango_maximo";
        String ID = "id";
        String OD = "od";
        String DRIFT = "drift";
        String BURST = "burst";
    }

    public interface ColumnasAddTubing
    {
        String ID_ADD_TUBING = "id_add_tubing";
        String RANGO_MINIMO = "rango_minimo";
        String RANGO_MAXIMO = "rango_maximo";
        String ID = "id";
        String OD = "od";
        String UNIT_WEIGHT = "unit_weight";
        String DRIFT = "drift";
        String TENSION = "tension";
        String COMPRESSION = "compression";
        String BURST = "busrt";
        String COLLAPSE = "collapse";
        String TORQUE_LIMIT = "torque_limit";
        String THERMAL_EXP = "thermal_exp";
    }

    public interface ColumnasAddPacker
    {
        String ID_ADD_PACKER = "id_add_packer";
        String RANGO_MINIMO = "rango_minimo";
        String RANGO_MAXIMO = "rango_maximo";
        String ID = "id";
        String OD = "od";
        String BURST = "burst";
        String COLLAPSE = "collapse";
        String TENSION = "tension";
        String COMPRESSION = "compression";
        String HOLDOWN = "holdown";
        String INITIAL_SLACK_OFF = "initial_slack_off";
        String INITIAL_TENSION = "initial_tension";
    }

    public interface ColumnasAddFfUp
    {
        String ID_ADD_FF_UP = "id_add_ff_up";
        String RANGO_MINIMO = "rango_minimo";
        String RANGO_MAXIMO = "rango_maximo";
        String CH = "ch";
        String OH = "oh";
    }

    public interface ColumnasAddFfDown
    {
        String ID_ADD_FF_DOWN = "id_add_ff_down";
        String RANGO_MINIMO = "rango_minimo";
        String RANGO_MAXIMO = "rango_maximo";
        String CH = "ch";
        String OH = "oh";
    }

    public interface ColumnasAddFfRotation
    {
        String ID_ADD_FF_ROTATION = "id_add_ff_rotation";
        String RANGO_MINIMO = "rango_minimo";
        String RANGO_MAXIMO = "rango_maximo";
        String CH = "ch";
        String OH = "oh";
    }

    public interface ColumnasAddFluid
    {
        String ID_ADD_FLUID = "id_add_fluid";
        String RANGO_MINIMO = "rango_minimo";
        String RANGO_MAXIMO = "rango_maximo";
        String INITIAL_INTERNAL_FLUID_DENSITY = "initial_internal_fluid_density";
        String INITIAL_EXTERNAL_FLUID_DENSITY = "initial_external_fluid_density";
        String FINAL_INTERNAL_FLUID_DENSITY = "final_internal_fluid_density";
        String FINAL_EXTERNAL_FLUID_DENSITY = "final_external_fluid_density";
    }


    // [URIS]
    // Autoridad del Content Provider
    public final static String AUTORIDAD = "com.bennu.administrador.simulador20.provider";

    // Uri base
    public static final Uri URI_BASE = Uri.parse("content://" + AUTORIDAD);

    private static final String RUTA_ADD_CASSING = "add_casing";
    private static final String RUTA_ADD_TUBING = "add_tubing";
    private static final String RUTA_ADD_PACKER = "add_packer";
    private static final String RUTA_ADD_FF_UP = "add_ff_up";
    private static final String RUTA_ADD_FF_DOWN = "add_ff_down";
    private static final String RUTA_ADD_FF_ROTATION = "add_ff_rotation";
    private static final String RUTA_ADD_FLUID = "add_fluid";


    // [/URIS]

    // [TIPOS_MIME]
    public static final String BASE_CONTENIDOS = "simulador20.";

    public static final String TIPO_CONTENIDO = "vnd.android.cursor.dir/vnd." + BASE_CONTENIDOS;

    public static final String TIPO_CONTENIDO_ITEM = "vnd.android.cursor.item/vnd." + BASE_CONTENIDOS;


    public static String generarMime(String id) {
        if (id != null) {
            return TIPO_CONTENIDO + id;
        } else {
            return null;
        }
    }

    public static String generarMimeItem(String id) {
        if (id != null) {
            return TIPO_CONTENIDO_ITEM + id;
        } else {
            return null;
        }
    }
    // [/TIPOS_MIME]



    public static class AddCasing implements ColumnasAddCasing
    {
        public static final Uri URI_CONTENIDO = URI_BASE.buildUpon().appendPath(RUTA_ADD_CASSING).build();

        public static Uri crearUri(String id) {
            return URI_CONTENIDO.buildUpon().appendPath(id).build();
        }

        public static String generarId()
        {
            return UUID.randomUUID().toString();
        }

        public static String obtenerId(Uri uri) {
            return uri.getLastPathSegment();
        }
    }

    public static class AddTubing implements ColumnasAddTubing
    {
        public static final Uri URI_CONTENIDO = URI_BASE.buildUpon().appendPath(RUTA_ADD_TUBING).build();

        public static Uri crearUri(String id) {
            return URI_CONTENIDO.buildUpon().appendPath(id).build();
        }

        public static String generarId()
        {
            return UUID.randomUUID().toString();
        }

        public static String obtenerId(Uri uri) {
            return uri.getLastPathSegment();
        }
    }

    public static class AddPacker implements ColumnasAddPacker
    {
        public static final Uri URI_CONTENIDO = URI_BASE.buildUpon().appendPath(RUTA_ADD_PACKER).build();

        public static Uri crearUri(String id) {
            return URI_CONTENIDO.buildUpon().appendPath(id).build();
        }

        public static String generarId()
        {
            return UUID.randomUUID().toString();
        }

        public static String obtenerId(Uri uri) {
            return uri.getLastPathSegment();
        }
    }

    public static class AddFfUp implements ColumnasAddFfUp
    {
        public static final Uri URI_CONTENIDO = URI_BASE.buildUpon().appendPath(RUTA_ADD_FF_UP).build();

        public static Uri crearUri(String id) {
            return URI_CONTENIDO.buildUpon().appendPath(id).build();
        }

        public static String generarId()
        {
            return UUID.randomUUID().toString();
        }

        public static String obtenerId(Uri uri) {
            return uri.getLastPathSegment();
        }
    }

    public static class AddFfDown implements ColumnasAddFfDown
    {
        public static final Uri URI_CONTENIDO = URI_BASE.buildUpon().appendPath(RUTA_ADD_FF_DOWN).build();

        public static Uri crearUri(String id) {
            return URI_CONTENIDO.buildUpon().appendPath(id).build();
        }

        public static String generarId()
        {
            return UUID.randomUUID().toString();
        }

        public static String obtenerId(Uri uri) {
            return uri.getLastPathSegment();
        }
    }

    public static class AddFfRotation implements ColumnasAddFfRotation
    {
        public static final Uri URI_CONTENIDO = URI_BASE.buildUpon().appendPath(RUTA_ADD_FF_ROTATION).build();

        public static Uri crearUri(String id) {
            return URI_CONTENIDO.buildUpon().appendPath(id).build();
        }

        public static String generarId()
        {
            return UUID.randomUUID().toString();
        }

        public static String obtenerId(Uri uri) {
            return uri.getLastPathSegment();
        }
    }

    public static class AddFluid implements ColumnasAddFluid
    {
        public static final Uri URI_CONTENIDO = URI_BASE.buildUpon().appendPath(RUTA_ADD_FLUID).build();

        public static Uri crearUri(String id) {
            return URI_CONTENIDO.buildUpon().appendPath(id).build();
        }

        public static String generarId()
        {
            return UUID.randomUUID().toString();
        }

        public static String obtenerId(Uri uri) {
            return uri.getLastPathSegment();
        }
    }
}
