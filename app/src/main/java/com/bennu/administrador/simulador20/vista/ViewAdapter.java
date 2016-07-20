package com.bennu.administrador.simulador20.vista;

import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bennu.administrador.simulador20.R;
import com.bennu.administrador.simulador20.datos.Contrato;
import com.bennu.administrador.simulador20.modelo.RangoMinimoMaximo;
import com.bennu.administrador.simulador20.vista.RangoFragment.OnListFragmentInteractionListener;
//import bennucybercafe.com.ve.simulador4.fragmento.dummy.DummyContent.DummyItem;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder>  {

  //  private final List<DummyItem> mValues;
    private Cursor mValues;
    private final OnListFragmentInteractionListener mListener;



    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView minimo;
        public final TextView maximo;
        public RangoMinimoMaximo mItem;
        //public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            minimo = (TextView) view.findViewById(R.id.id);
            maximo = (TextView) view.findViewById(R.id.content);

        }

        @Override
        public String toString() {
            return super.toString();
        }
    }


    public ViewAdapter(OnListFragmentInteractionListener listener ) {
        mListener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        String minimo, maximo, id;

        mValues.moveToPosition(position);
        //holder.mItem = mValues.moveToPosition(position);

        minimo = mValues.getString( mValues.getColumnIndex(Contrato.ColumnasAddCasing.RANGO_MINIMO) );
        maximo = mValues.getString( mValues.getColumnIndex(Contrato.ColumnasAddCasing.RANGO_MAXIMO) );
        id = mValues.getString(mValues.getColumnIndex("_id"));

        holder.mItem = new RangoMinimoMaximo(Double.valueOf(minimo), Double.valueOf( maximo), Integer.valueOf(id) );


        holder.minimo.setText(minimo);
        holder.maximo.setText(maximo);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mValues != null)
            return mValues.getCount();
        return 0;
    }

    public void swapCursor(Cursor nuevoCursor) {
        if (nuevoCursor != null) {
            mValues = nuevoCursor;
            notifyDataSetChanged();
        }
    }



}
