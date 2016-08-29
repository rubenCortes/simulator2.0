package com.bennu.administrador.simulador20.vista;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.bennu.administrador.simulador20.R;
import com.bennu.administrador.simulador20.modelo.RangoMinimoMaximo;
import com.bennu.administrador.simulador20.vista.RangoFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnFragmentInteractionListener, RangoFragment.OnListFragmentInteractionListener, View.OnClickListener {

    private FragmentManager fragmentManager;
    private Fragment fragmentoPrincipal;
    private Toolbar miToolbar;
    private ActionBar miBarra;
    private FloatingActionButton fab;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;

    private int nivelNavegacion = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mostrarToolbar();
        miBarra = getSupportActionBar();

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.hide();
        fab.setOnClickListener( this );

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, miToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);

        toggle.setToolbarNavigationClickListener(this);

        //toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragmentManager = getFragmentManager();

        String parametro1 = "";
        String paramentro2 = "";

        fragmentoPrincipal = InicialFragment.newInstance(parametro1, paramentro2 );

        cambiarFragment(fragmentoPrincipal, false);


    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            nivelNavegacion--;
            if ( nivelNavegacion == 1 )
            {
                toggle.setDrawerIndicatorEnabled(true);
                miBarra.setDisplayHomeAsUpEnabled(false);
                toggle.syncState();
            }
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

       // Toolbar miToolbar = (Toolbar) findViewById( R.id.toolbar );

        int id = item.getItemId();

        if (id == R.id.nav_proyecto) {


        } else if (id == R.id.nav_inputs) {

            miToolbar.setTitle(R.string.titulo_inputs);

            toggle.setDrawerIndicatorEnabled(false); //REVISAR


            // Preparacion del fragmento principal inicial
            String parametro1 = "";
            String paramentro2 = "";

            fragmentoPrincipal = InputFragment.newInstance(parametro1, paramentro2 );

            cambiarFragment(fragmentoPrincipal, true);



        } else if (id == R.id.nav_outputs) {
            String parametro1 = "";
            String paramentro2 = "";

            fragmentoPrincipal = OutputFragment.newInstance(parametro1, paramentro2 );
            cambiarFragment(fragmentoPrincipal, true);

            miToolbar.setTitle(R.string.titulo_outputs);
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //gestionas bien las ramas
    @Override
    public void onFragmentInteraction(int idBoton) {
        switch (idBoton)
        {
            case R.id.btn_casing:

                // Establece el título de la Toolbar

                setTitleToolbar(R.string.btn_casing, miToolbar);

                // Carga el fragmento
                Toast.makeText(this,"Boton btn_casing",Toast.LENGTH_SHORT).show();
                fragmentoPrincipal = RangoFragment.newInstance(1, R.id.btn_casing);
                cambiarFragment(fragmentoPrincipal, true);

                fab.show();
                break;
            case R.id.btn_tubing:
                Toast.makeText(this,"Boton btn_tubing",Toast.LENGTH_SHORT).show();
                fragmentoPrincipal = RangoFragment.newInstance(1, R.id.btn_tubing);
                cambiarFragment(fragmentoPrincipal,true);
                break;
            case R.id.btn_packer:
                Toast.makeText(this,"Boton btn_packer",Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_ff_up:
                Toast.makeText(this,"Boton btn_ff_up",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_ff_down:
                Toast.makeText(this,"Boton btn_ff_down",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_ff_rotation:
                Toast.makeText(this,"Boton btn_ff_rotation",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_fluid:
                Toast.makeText(this,"Boton btn_fluid",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_temperature:
                Toast.makeText(this,"Boton btn_temperature",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_pressure:
                Toast.makeText(this,"Boton btn_pressure",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_internal_friction:
                Toast.makeText(this,"Boton btn_internal_friction",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_load:
                Toast.makeText(this,"Boton btn_load",Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this,"Opción no existente",Toast.LENGTH_SHORT).show();
                break;
        }

    }

    @Override
    public void onListFragmentInteraction(RangoMinimoMaximo item)
    {

        // Proceso para editar registros registros

        Toast.makeText(this,"Elemento presionado",Toast.LENGTH_SHORT).show();


        fragmentoPrincipal = AddCasingFragment.newInstance("","");

        cambiarFragment(fragmentoPrincipal, true);


        fab.setImageResource(R.drawable.ic_create_white_48dp);

    }

    private void setTitleToolbar( int boton, Toolbar toolbar )
    {
        String tituloActual = toolbar.getTitle().toString();
        String nombreBoton = getText(boton).toString();
        String nuevoTitulo = tituloActual + " " + nombreBoton;

        toolbar.setTitle(nuevoTitulo);
    }


    // Evento de comportamiento de boton flotante
    @Override
    public void onClick(View view) {
        int id = view.getId();

        //int btnPadre = ((RangoFragment) fragmentoPrincipal).getBtnPadre();

        switch (id) {

            case R.id.fab:
                Toast.makeText(this, "Botón flotante presionado", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "Botón de volver presionado", Toast.LENGTH_SHORT).show();
                onBackPressed();
                break;
        }

    }

    public void cambiarFragment( Fragment fragmento, boolean flecha )
    {
        FragmentTransaction transaccion = fragmentManager.beginTransaction();

        transaccion.replace(R.id.fragment_principal, fragmento );

        transaccion.addToBackStack(null);

        miBarra.setDisplayHomeAsUpEnabled(flecha);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(flecha);

        toggle.setDrawerIndicatorEnabled( ! flecha );
        miBarra.setDisplayHomeAsUpEnabled( flecha );

        toggle.syncState();

        transaccion.commit();

        nivelNavegacion++;
    }


    private void mostrarToolbar()
    {
        miToolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar(miToolbar);
    }


}
