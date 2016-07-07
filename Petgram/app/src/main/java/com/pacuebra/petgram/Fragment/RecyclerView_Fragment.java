package com.pacuebra.petgram.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pacuebra.petgram.Adapter.ContactoAdaptador;
import com.pacuebra.petgram.Pojo.Perro;
import com.pacuebra.petgram.R;
import com.pacuebra.petgram.presentador.IRecyclerviewFragmentPresenter;
import com.pacuebra.petgram.presentador.RecyclerviewFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by Francisco on 25/06/2016.
 */
public class RecyclerView_Fragment extends Fragment implements IRecyclerviewFragmentview {
   private RecyclerView listaPerros;
    private IRecyclerviewFragmentPresenter presenter;
  private ArrayList<Perro> contactos;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        listaPerros = (RecyclerView) v.findViewById(R.id.rvPerros);
        presenter = new RecyclerviewFragmentPresenter(this, getContext());
    //    incializarDatos();
        return v;
    }

/*
    public void incializarDatos(){
        contactos = new ArrayList<Perro>();

        contactos.add(new Perro(R.drawable.basset_hound, "Basset Hound",R.drawable.favorites_50,R.drawable.dog_bone_48,4));
        contactos.add(new Perro(R.drawable.boxer, "Boxer",R.drawable.favorites_50,R.drawable.dog_bone_48, 5));
        contactos.add(new Perro(R.drawable.bulldog, "Bulldog",R.drawable.favorites_50,R.drawable.dog_bone_48, 3));
        contactos.add(new Perro(R.drawable.chihuahua, "Chihuahua",R.drawable.favorites_50,R.drawable.dog_bone_48, 12));
        contactos.add(new Perro(R.drawable.dalmata, "Dalmata",R.drawable.favorites_50,R.drawable.dog_bone_48, 15));
        contactos.add(new Perro(R.drawable.gran_danes, "Gran Danes",R.drawable.favorites_50,R.drawable.dog_bone_48, 2));
        contactos.add(new Perro(R.drawable.husky_siberiano, "Husky Siberiano",R.drawable.favorites_50,R.drawable.dog_bone_48, 3));
        contactos.add(new Perro(R.drawable.labrador, "Labrador",R.drawable.favorites_50,R.drawable.dog_bone_48, 10));
        contactos.add(new Perro(R.drawable.lakeland_terrier, "Lakeland Terrier",R.drawable.favorites_50,R.drawable.dog_bone_48, 4));
        contactos.add(new Perro(R.drawable.pastor_aleman, "Pastor Aleman",R.drawable.favorites_50,R.drawable.dog_bone_48, 11));
        contactos.add(new Perro(R.drawable.pitbull, "Pitbull",R.drawable.favorites_50,R.drawable.dog_bone_48, 12));
        contactos.add(new Perro(R.drawable.pomerania, "Pomerania",R.drawable.favorites_50,R.drawable.dog_bone_48, 9));
        contactos.add(new Perro(R.drawable.r_pug2, "Pug",R.drawable.favorites_50,R.drawable.dog_bone_48, 21));
    }
    */


    @Override
    public void generarLinearLayoutVertical() {

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaPerros.setLayoutManager(llm);
    }

    @Override
    public ContactoAdaptador crearAdaptador(ArrayList<Perro> contactos) {
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, getContext());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(ContactoAdaptador adaptador) {
        listaPerros.setAdapter(adaptador);
    }
}
