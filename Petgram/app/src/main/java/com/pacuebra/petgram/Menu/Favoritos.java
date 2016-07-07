package com.pacuebra.petgram.Menu;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.pacuebra.petgram.R;
/*
public class Favoritos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}*/
import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;

import com.pacuebra.petgram.Adapter.ContactoAdaptador;
        import com.pacuebra.petgram.Pojo.Perro;

        import java.util.ArrayList;

public class Favoritos extends AppCompatActivity {

    Toolbar bar;
    RecyclerView recyclerView;
    ArrayList<Perro> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_favorito);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) // Habilitar up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView)findViewById(R.id.rvFavoritos);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);


        Bundle bundle = getIntent().getExtras();
        ArrayList<Perro> count = new ArrayList<Perro>();

        for (int c=0;c<5;c++){
            //initListaFab(new Perro(Adapter.seleccion.get(c).getImagen(),Adapter.seleccion.get(c).getHuesoB(),Adapter.seleccion.get(c).getHuesoA(),Adapter.seleccion.get(c).getNombre(),Adapter.seleccion.get(c).getLike()));
            count.add(new Perro(bundle.getInt("Imagen" + c),
                    bundle.getString("Nombre"+c),
                    /*bundle.getInt("Estrella" + c),*/
                    bundle.getInt("Like"+c),
                    bundle.getInt("Votos"+c)));
        }
        initListaFab(count);
        initAdapter();

    }

    public void initAdapter(){
        ContactoAdaptador adapter = new ContactoAdaptador(contactos, this);
        recyclerView.setAdapter(adapter);
    }

    public void initListaFab(ArrayList<Perro> mascota){
        contactos = new ArrayList<Perro>();
        for(int c=0;c<mascota.size();c++){
            contactos.add(mascota.get(c));
        }
        //contactos.add(new Mascota(R.drawable.girl4, R.drawable.corazones, R.drawable.estrella, "Scarlet", 0));
    }

}
