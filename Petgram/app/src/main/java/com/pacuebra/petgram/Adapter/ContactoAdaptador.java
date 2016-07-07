package com.pacuebra.petgram.Adapter;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.pacuebra.petgram.Pojo.Perro;
import com.pacuebra.petgram.R;
import com.pacuebra.petgram.db.ConstructorContactos;

import java.util.ArrayList;

import static android.app.ProgressDialog.show;

/**
 * Created by Francisco on 14/06/2016.
 */

public class ContactoAdaptador extends  RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder> {

    ArrayList<Perro> contactos;
    public static ArrayList<Perro> seleccion = new ArrayList<Perro>();
    private Context context;

    public ContactoAdaptador(ArrayList<Perro> contactos, Context context){
            this.contactos = contactos;
        this.context = context;
    }
    @Override //Inflara el layout y lo pasara al viewholder para que el obtenga los views

    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacto_perro, parent, false);
        ContactoViewHolder holder = new ContactoViewHolder(v);
        return holder;
    }
//asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(final ContactoViewHolder contactoViewHolder,/*final*/ int position) {
       final Perro contacto = contactos.get(position);
        contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvnombre.setText(contacto.getNombre());
        //contactoViewHolder.bthueso.setImageResource(contacto.getBthueso());
        //contactoViewHolder.btlike.setImageResource(contacto.getBtlike());
        contactoViewHolder.tvLikes.setText(String.valueOf(contacto.getLikes()) + " Likes");

        /*contactoViewHolder.bthueso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Me ah gustado "+contacto.getNombre(),Snackbar.LENGTH_SHORT).show();

                seleccion.add(new Perro(contacto.getFoto(),contacto.getNombre(),contacto.getBthueso(),contacto.getBtlike(),contacto.getLikes()));
            }
        });*/

        contactoViewHolder.btlike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Diste Like a:  "+contacto.getNombre(),Snackbar.LENGTH_SHORT).show();

                ConstructorContactos constructorContactos = new ConstructorContactos(context);
                constructorContactos.darLikeContacto(contacto);
                contactoViewHolder.tvLikes.setText(String.valueOf(constructorContactos.obtenerLikesContacto(contacto)) + " Likes");

                    }
        });
    }

    @Override
    public int getItemCount() {  //Cantidad de elementos que contiene la lista de contactos
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder /*implements View.OnClickListener*/ {

        private ImageView imgFoto;
        private TextView tvnombre;
        //private ImageButton bthueso;
        private ImageButton btlike;
        private TextView tvLikes;

        public ContactoViewHolder(final View itemView) {
            super(itemView);

            imgFoto  = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvnombre = (TextView)  itemView.findViewById(R.id.tvnombre);
           // bthueso = (ImageButton) itemView.findViewById(R.id.bthueso);
            btlike = (ImageButton) itemView.findViewById(R.id.btlike);
            tvLikes= (TextView) itemView.findViewById(R.id.votos);
        }

    }
}
