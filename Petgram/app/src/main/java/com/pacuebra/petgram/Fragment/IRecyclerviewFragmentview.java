package com.pacuebra.petgram.Fragment;

import com.pacuebra.petgram.Adapter.ContactoAdaptador;
import com.pacuebra.petgram.Pojo.Perro;

import java.util.ArrayList;

/**
 * Created by Francisco on 04/07/2016.
 */
public interface IRecyclerviewFragmentview {

    public void generarLinearLayoutVertical();
    public ContactoAdaptador crearAdaptador(ArrayList<Perro> contactos);
    public void inicializarAdaptadorRV(ContactoAdaptador adaptador);
}
