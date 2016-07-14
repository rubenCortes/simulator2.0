package com.bennu.administrador.simulador20;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnFragmentInteractionListener  {

    private FragmentManager fragmentManager;
    private Fragment fragmentoPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Preparacion del fragmento principal inicial
        String parametro1 = "";
        String paramentro2 = "";

     //   fragmentoPrincipal = InicialFragment.newInstance(parametro1, paramentro2 );

        fragmentManager = getFragmentManager();
/*        FragmentTransaction transaccion = fragmentManager.beginTransaction();

        transaccion.replace(R.id.fragment_principal, fragmentoPrincipal);

        if (fragmentoPrincipal == null) Toast.makeText(this,"Fragmento nulo",Toast.LENGTH_LONG).show();

        transaccion.commit();*/
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
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
        FragmentTransaction transaccion = fragmentManager.beginTransaction();



        int id = item.getItemId();

        if (id == R.id.nav_proyecto) {
            // Preparacion del fragmento principal inicial
            String parametro1 = "";
            String paramentro2 = "";

            fragmentoPrincipal = InicialFragment.newInstance(parametro1, paramentro2 );

           // FragmentTransaction transaccion = fragmentManager.beginTransaction();
            transaccion.replace(R.id.fragment_principal, fragmentoPrincipal);

            transaccion.commit();
            // Handle the camera action
        } else if (id == R.id.nav_inputs) {
            // Preparacion del fragmento principal inicial
            String parametro1 = "";
            String paramentro2 = "";

            fragmentoPrincipal = InputFragment.newInstance(parametro1, paramentro2 );

          //  FragmentTransaction transaccion = fragmentManager.beginTransaction();
            transaccion.replace(R.id.fragment_principal, fragmentoPrincipal);

            transaccion.commit();
        } else if (id == R.id.nav_outputs) {
            String parametro1 = "";
            String paramentro2 = "";

            fragmentoPrincipal = OutputFragment.newInstance(parametro1, paramentro2 );

      //      FragmentTransaction transaccion = fragmentManager.beginTransaction();
            transaccion.replace(R.id.fragment_principal, fragmentoPrincipal);

            transaccion.commit();

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(String uri) {

    }
}
