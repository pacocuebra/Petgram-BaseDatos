package com.pacuebra.petgram.presentador;

import android.content.Context;

import com.pacuebra.petgram.Adapter.ContactoAdaptador;
import com.pacuebra.petgram.Fragment.IRecyclerviewFragmentview;
import com.pacuebra.petgram.Fragment.RecyclerView_Fragment;
import com.pacuebra.petgram.Pojo.Perro;
import com.pacuebra.petgram.db.ConstructorContactos;

import java.util.ArrayList;

/**
 * Created by Francisco on 04/07/2016.
 */
public class RecyclerviewFragmentPresenter implements IRecyclerviewFragmentPresenter {

    private IRecyclerviewFragmentview iRecyclerviewFragmentview;
    private Context context;
    private ConstructorContactos constructorContactos;
    private ArrayList<Perro> contactos;

    public RecyclerviewFragmentPresenter(IRecyclerviewFragmentview iRecyclerviewFragmentview, Context context) {
    this.iRecyclerviewFragmentview = iRecyclerviewFragmentview;
        this.context = context;
        obtenerContactosBaseDatos();
    }

    @Override
    public void obtenerContactosBaseDatos() {
        constructorContactos = new ConstructorContactos(context);
        contactos = constructorContactos.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
            iRecyclerviewFragmentview.inicializarAdaptadorRV(iRecyclerviewFragmentview.crearAdaptador(contactos));
            iRecyclerviewFragmentview.generarLinearLayoutVertical();
    }
}
