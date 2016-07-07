package com.pacuebra.petgram.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pacuebra.petgram.Pojo.Pug;
import com.pacuebra.petgram.R;

import java.util.ArrayList;

/**
 * Created by Francisco on 26/06/2016.
 */
public class PerroAdaptador extends RecyclerView.Adapter<PerroAdaptador.PerroViewHolder>{


public PerroAdaptador(ArrayList<Pug> fotos){
this.fotos = fotos;
}

    ArrayList<Pug> fotos;

    @Override
    public PerroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacto_pug, parent,false);
       return new PerroViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PerroViewHolder PerroViewHolder, int position) {
        Pug perro = fotos.get(position);
        PerroViewHolder.imgFoto.setImageResource(perro.getFoto());
        PerroViewHolder.calif.setText(perro.getCalif());
        PerroViewHolder.hueso.setImageResource(perro.getHueso());
    }

    @Override
    public int getItemCount() {
        return fotos.size();
    }

    public static class PerroViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView calif;
        private ImageView hueso;

        public PerroViewHolder(View itemView) {
            super(itemView);
            imgFoto  = (ImageView) itemView.findViewById(R.id.imgPug);
            calif = (TextView)  itemView.findViewById(R.id.votos2);
            hueso = (ImageView) itemView.findViewById(R.id.btlike2);
        }
    }

}