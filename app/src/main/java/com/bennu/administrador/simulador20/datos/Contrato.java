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

    // [URIS]
    // Autoridad del Content Provider
    public final static String AUTORIDAD = "com.bennu.administrador.simulador20.provider";

    // Uri base
    public static final Uri URI_BASE = Uri.parse("content://" + AUTORIDAD);

    private static final String RUTA_ADD_CASSING = "add_casing";
    private static final String RUTA_ADD_TUBING = "add_tubing";

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



    public static class AddCasingContrato
    {
        public static final Uri URI_CONTENIDO = URI_BASE.buildUpon().appendPath(RUTA_ADD_CASSING).build();

        public static Uri crearUriAddCasing(String id) {
            return URI_CONTENIDO.buildUpon().appendPath(id).build();
        }

        public static String generarIdAddCasing()
        {
            return UUID.randomUUID().toString();
        }

        public static String obtenerIdAddCasing(Uri uri) {
            return uri.getLastPathSegment();
        }
    }

    public static class AddTubingContrato
    {
        public static final Uri URI_CONTENIDO = URI_BASE.buildUpon().appendPath(RUTA_ADD_TUBING).build();

        public static Uri crearUriAddTubing(String id) {
            return URI_CONTENIDO.buildUpon().appendPath(id).build();
        }

        public static String generarIdAddTubing()
        {
            return UUID.randomUUID().toString();
        }

        public static String obtenerIdAddTubing(Uri uri) {
            return uri.getLastPathSegment();
        }
    }

}
