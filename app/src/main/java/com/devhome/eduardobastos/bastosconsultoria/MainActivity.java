package com.devhome.eduardobastos.bastosconsultoria;

import android.content.Intent;
import android.os.Bundle;

import com.devhome.eduardobastos.bastosconsultoria.clientes.ClientesFragment;
import com.devhome.eduardobastos.bastosconsultoria.contato.ContatoFragment;
import com.devhome.eduardobastos.bastosconsultoria.formacao.FormacaoFragment;
import com.devhome.eduardobastos.bastosconsultoria.principal.PrincipalFragment;
import com.devhome.eduardobastos.bastosconsultoria.servicos.ServicosFragment;
import com.devhome.eduardobastos.bastosconsultoria.sobre.SobreFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mDrawerToogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarEmail();
            }
            });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerToogle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,
                R.string.open, R.string.close);


        mDrawerLayout.addDrawerListener(mDrawerToogle);
        mDrawerToogle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        PrincipalFragment fragment = new PrincipalFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment, "Home");
        fragmentTransaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id = menuItem.getItemId();

        if (id == R.id.principal) {

            PrincipalFragment fragment = new PrincipalFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame_layout, fragment, "principal");
            fragmentTransaction.commit();

        } else if (id == R.id.servicos) {

            ServicosFragment fragment = new ServicosFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame_layout, fragment, "servicos");
            fragmentTransaction.commit();

        } else if (id == R.id.formacao) {

            FormacaoFragment fragment = new FormacaoFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame_layout, fragment, "formacao");
            fragmentTransaction.commit();

        } else if (id == R.id.clientes) {

            ClientesFragment fragment = new ClientesFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame_layout, fragment, "clientes");
            fragmentTransaction.commit();

        } else if (id == R.id.contato) {

            enviarEmail();

            /*ContatoFragment fragment = new ContatoFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame_layout, fragment, "contato");
            fragmentTransaction.commit();*/

        } else if (id == R.id.sobre) {

            startActivity(new Intent(this, SobreActivity.class));

            /*SobreFragment fragment = new SobreFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame_layout, fragment, "sobre");
            fragmentTransaction.commit();*/

        }

        mDrawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {

            super.onBackPressed();

        }

    }
    public void enviarEmail(){

        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{"eduardobastos87@outlook.com"});//endereço de envio
        email.putExtra(Intent.EXTRA_SUBJECT, "Contato pelo App");//assunto do email
        email.putExtra(Intent.EXTRA_TEXT,"Mensagem automática");//corpo do email

        //configurar apps para email

        email.setType("message/rfc822");//abrir apps de envio de emails
        //email.setType("application/pdf");
        //email.setType("image/png");

        startActivity(Intent.createChooser(email, "Escolha o aplicativo de email"));//msg de seleção do app

    }
}