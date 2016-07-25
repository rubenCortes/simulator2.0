package com.bennu.administrador.simulador20.vista;

//import android.annotation.TargetApi;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.LoaderManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bennu.administrador.simulador20.R;
import com.bennu.administrador.simulador20.datos.Contrato;
import com.bennu.administrador.simulador20.modelo.RangoMinimoMaximo;

//import android.database.Cursor;

//import android.view.ViewGroup;

//import android.support.v7.widget.GridLayoutManager;

// clases para cargadores asincronos de datos

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class RangoFragment extends Fragment
        implements LoaderManager.LoaderCallbacks<Cursor>, ItemTouchHelperAdapter {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    private static final String ARG_PADRE = "boton-padre";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private int btnPadre;
    private OnListFragmentInteractionListener mListener;

    private ViewAdapter adaptador;
    private RecyclerView recyclerView;

    private ItemTouchHelper mItemTouchHelper;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RangoFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static RangoFragment newInstance(int columnCount, int botonPadre) {
        RangoFragment fragment = new RangoFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        args.putInt(ARG_PADRE, botonPadre);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
            btnPadre = getArguments().getInt(ARG_PADRE);
        }
        // Notifica que hay un menú disponible
//        setHasOptionsMenu(true);
    }

/*    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch ( item.getItemId() )
        {
            case R.id.action_agregar_fragment:
                Toast.makeText(getActivity(), "Agregar elemento fragmento", Toast.LENGTH_SHORT).show();
                cargarDatos();
                break;
            case R.id.action_borrar_todos_fragment:
                Toast.makeText(getActivity(), "Borrar todos los elementos fragmento", Toast.LENGTH_SHORT).show();
                int resultado = getActivity().getContentResolver().
                        delete( Contrato.AddCasingContrato.URI_CONTENIDO,null,null );
                Toast.makeText( getActivity(), "Registros eliminados: " + resultado, Toast.LENGTH_SHORT ).show();

                break;
        }
        return super.onOptionsItemSelected(item);
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            //recyclerView.setAdapter(new ViewAdapter(DummyContent.ITEMS, mListener));
            adaptador = new ViewAdapter( mListener );
            recyclerView.setAdapter( adaptador );
            cargarDatos();


            DefaultItemAnimator animador = new DefaultItemAnimator();
            animador.setRemoveDuration( 300 );

            recyclerView.setItemAnimator( animador );


            //getSupportLoaderManager().restartLoader(1, null, this);

            ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(this);

            mItemTouchHelper = new ItemTouchHelper(callback);

            mItemTouchHelper.attachToRecyclerView(recyclerView);

            // Iniciar loader
            getLoaderManager().initLoader(0, null, this);

            //adaptador.swapCursor(cursor);
        }
        return view;
    }


    private ContentValues valores(RangoMinimoMaximo rangoMinimoMaximo  )
    {
        ContentValues contenido = new ContentValues();

       // contenido.put(Contrato.ColumnasAddCasing.ID_ADD_CASING, Contrato.AddCasingContrato.generarIdAddCasing());
        contenido.put(Contrato.ColumnasAddCasing.RANGO_MINIMO, rangoMinimoMaximo.getMinimo());
        contenido.put(Contrato.ColumnasAddCasing.RANGO_MAXIMO, rangoMinimoMaximo.getMaximo());

        return contenido;
    }

    private void cargarDatos()
    {
        Long tiempoInicial, tiempoFinal;

        //ContentResolver resolvedor = getActivity().getContentResolver();

        Toast.makeText(getActivity(), "Inicio del proceso", Toast.LENGTH_LONG).show();

        ContentResolver miContent = getActivity().getContentResolver();

        tiempoInicial= System.currentTimeMillis();
        for (int i = 1; i <= 10; i++ ) {

            miContent.insert(Contrato.AddCasingContrato.URI_CONTENIDO, valores( new RangoMinimoMaximo(i, i + 20 ) ) );

//            getActivity().getContentResolver().
//                    insert(Contrato.AddCasingContrato.URI_CONTENIDO, valores( new RangoMinimoMaximo(i, i + 20 ) ) );

        }
        tiempoFinal = System.currentTimeMillis();

        Double duracion = (tiempoFinal.doubleValue()-tiempoInicial.doubleValue())/1000;

        //tvResultado.setText(duracion.toString());

        Toast.makeText(getActivity(),"Duración del proceso: " + duracion, Toast.LENGTH_LONG).show();
    }


    /*
 * onAttach(Context) is not called on pre API 23 versions of Android and onAttach(Activity) is deprecated
 * Use onAttachToContext instead
 */
    @TargetApi(23)
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onAttachToContext(context);
    }

    /*
     * Deprecated on API 23
     * Use onAttachToContext instead
     */
    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            onAttachToContext(activity);
        }
    }

    /*
     * Called when the fragment attaches to the context
     */
    protected void onAttachToContext(Context context) {
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    //**********   Cargador de datos  **************************************

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {

        // Consultar todos los registros
        return new CursorLoader(
                getActivity(),
                Contrato.AddCasingContrato.URI_CONTENIDO,
                null, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        adaptador.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        adaptador.swapCursor(null);
    }



    //***************************** fin de cargador de datos ******************



    // Implementación de métodos de la interface ItemTouchHelperAdapter

    @Override
    public void onItemMove(int fromPosition, int toPosition) {

    }

    @Override
    public void onItemDismiss(int position)
    {
        int id;
        ViewAdapter.ViewHolder vh = (ViewAdapter.ViewHolder) recyclerView.findViewHolderForAdapterPosition(position);
        id = (int) vh.mItem.getIdPrimario();
        Toast.makeText( getActivity(), "Posición eliminada: " + id, Toast.LENGTH_SHORT  ).show();
        ContentResolver contentResolver = getActivity().getContentResolver();
        int resultado = contentResolver.delete( Contrato.AddCasingContrato.crearUriAddCasing(String.valueOf(id)),null,null );
        adaptador.notifyItemRemoved(position);
        Toast.makeText( getActivity(), "Registros eliminads: " + resultado, Toast.LENGTH_SHORT ).show();

    }

    // Fin de implementación de metodos de la interface ItemTouchHelperAdapter



    public  int getBtnPadre()
    {
        return btnPadre;
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        //void onListFragmentInteraction(DummyItem item);
        void onListFragmentInteraction(RangoMinimoMaximo item);
    }


}
