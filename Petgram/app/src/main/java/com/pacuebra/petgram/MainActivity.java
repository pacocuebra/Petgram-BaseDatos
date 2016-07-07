package com.pacuebra.petgram;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;


import com.pacuebra.petgram.Adapter.ContactoAdaptador;
import com.pacuebra.petgram.Adapter.PageAdapter;
import com.pacuebra.petgram.Fragment.PerfilFragment;
import com.pacuebra.petgram.Fragment.RecyclerView_Fragment;
import com.pacuebra.petgram.Menu.Acerca;
import com.pacuebra.petgram.Menu.Favoritos;
import com.pacuebra.petgram.Menu.contacto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar     = (Toolbar)     findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(toolbar == null){
            setSupportActionBar(toolbar);
        }
        tabLayout = (TabLayout)  findViewById(R.id.tabLayout);
        viewPager   = (ViewPager)   findViewById(R.id.viewPager);

        setUpViewPager();
    }


    private ArrayList<Fragment> agregarFragment(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerView_Fragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }
    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragment()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_contacts);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_dog1);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

         MenuInflater menuInflater = getMenuInflater();
         //menuInflater.inflate(R.menu.favoritos, menu);
         menuInflater.inflate(R.menu.menu_opciones, menu);
        return true;
        //return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
         /*   case R.id.action_favorite:
                Intent intent2 = new Intent(this,Favoritos.class);
                for (int c = 0; c< ContactoAdaptador.seleccion.size(); c++){
                    intent2.putExtra("Imagen"+c,ContactoAdaptador.seleccion.get(c).getFoto());//Imagen
                    intent2.putExtra("Nombre"+c,ContactoAdaptador.seleccion.get(c).getNombre());//Nombre
                    //intent2.putExtra("Estrella"+c,ContactoAdaptador.seleccion.get(c).getBthueso());//Estrella
                    intent2.putExtra("Like"+c,ContactoAdaptador.seleccion.get(c).getBtlike());//Like
                    intent2.putExtra("Votos"+c,ContactoAdaptador.seleccion.get(c).getLikes());
                }
                //return true;
                startActivity(intent2);
                Toast.makeText(getApplicationContext(),"Favoritos",Toast.LENGTH_SHORT).show();
                break;  */
            case R.id.mcontacto:
                Intent intent3 = new Intent(this,contacto.class);
                startActivity(intent3);
                Toast.makeText(getApplicationContext(),"Contacto",Toast.LENGTH_SHORT).show();
                break;
            case R.id.macerca:
                Intent intent4 = new Intent(this,Acerca.class);
                startActivity(intent4);
                Toast.makeText(getApplicationContext(),"Acerca de",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

