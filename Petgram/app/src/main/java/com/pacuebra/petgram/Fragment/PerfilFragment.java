package com.pacuebra.petgram.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pacuebra.petgram.Adapter.PerroAdaptador;
import com.pacuebra.petgram.Pojo.Pug;
import com.pacuebra.petgram.R;

import java.util.ArrayList;


public class PerfilFragment extends Fragment {
    private RecyclerView listaMyPet;
    ArrayList<Pug> fotos;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        listaMyPet = (RecyclerView) v.findViewById(R.id.rv_mypet);

        GridLayoutManager glm = new GridLayoutManager(getContext(),3);
       listaMyPet.setLayoutManager(glm);
       // LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        //llm.setOrientation(LinearLayoutManager.VERTICAL);

        fotos = new ArrayList<Pug>();
        fotos.add(new Pug(R.drawable.chihuahua,"2",R.drawable.dog_bone_48));
        fotos.add(new Pug(R.drawable.boxer,"5",R.drawable.dog_bone_48));
        fotos.add(new Pug(R.drawable.basset_hound,"10",R.drawable.dog_bone_48));
        fotos.add(new Pug(R.drawable.dalmata,"8",R.drawable.dog_bone_48));
        fotos.add(new Pug(R.drawable.gran_danes,"7",R.drawable.dog_bone_48));
        fotos.add(new Pug(R.drawable.labrador,"6",R.drawable.dog_bone_48));

        inciarAdaptador();

        return v;
    }

    public void inciarAdaptador(){
        PerroAdaptador adaptador = new PerroAdaptador(fotos);
        listaMyPet.setAdapter(adaptador);
    }
}
