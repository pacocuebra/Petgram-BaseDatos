package com.pacuebra.petgram.db;

import android.content.ContentValues;
import android.content.Context;

import com.pacuebra.petgram.Pojo.Perro;
import com.pacuebra.petgram.R;

import java.util.ArrayList;

/**
 * Created by Francisco on 04/07/2016.
 */

//NOTA :   SE LE PUEDE LLAMAR TAMBIEN INTERACTOR
public class ConstructorContactos {

    private static final int LIKE = 1;
    private Context context;
    public ConstructorContactos(Context context){
        this.context = context;
    }

    public ArrayList<Perro> obtenerDatos(){

      /*  ArrayList<Perro> contactos= new ArrayList<>();

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
        contactos.add(new Perro(R.drawable.r_pug2, "Pug",R.drawable.favorites_50, R.drawable.dog_bone_48, 21));
        return contactos;*/

        BaseDatos db = new BaseDatos(context);
        insertarMuchosContactos(db);
        return db.ObtenerTodosLosContactos();
    }

    public void insertarMuchosContactos(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ContastantesBaseDatos.Table_Contacts_Nombre, "Basset Hound");
        contentValues.put(ContastantesBaseDatos.Table_Contacts_Foto, R.drawable.basset_hound);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ContastantesBaseDatos.Table_Contacts_Nombre, "Boxer");
        contentValues.put(ContastantesBaseDatos.Table_Contacts_Foto, R.drawable.boxer);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ContastantesBaseDatos.Table_Contacts_Nombre, "Bulldog");
        contentValues.put(ContastantesBaseDatos.Table_Contacts_Foto, R.drawable.bulldog);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ContastantesBaseDatos.Table_Contacts_Nombre, "Chihuahua");
        contentValues.put(ContastantesBaseDatos.Table_Contacts_Foto, R.drawable.chihuahua);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ContastantesBaseDatos.Table_Contacts_Nombre, "Dalmata");
        contentValues.put(ContastantesBaseDatos.Table_Contacts_Foto, R.drawable.dalmata);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ContastantesBaseDatos.Table_Contacts_Nombre, "Gran Danes");
        contentValues.put(ContastantesBaseDatos.Table_Contacts_Foto, R.drawable.gran_danes);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ContastantesBaseDatos.Table_Contacts_Nombre, "Husky Siberiano");
        contentValues.put(ContastantesBaseDatos.Table_Contacts_Foto, R.drawable.husky_siberiano);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ContastantesBaseDatos.Table_Contacts_Nombre, "Labrador");
        contentValues.put(ContastantesBaseDatos.Table_Contacts_Foto, R.drawable.labrador);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ContastantesBaseDatos.Table_Contacts_Nombre, "Lakeland Terrier");
        contentValues.put(ContastantesBaseDatos.Table_Contacts_Foto, R.drawable.lakeland_terrier);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ContastantesBaseDatos.Table_Contacts_Nombre, "Pastor Aleman");
        contentValues.put(ContastantesBaseDatos.Table_Contacts_Foto, R.drawable.pastor_aleman);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ContastantesBaseDatos.Table_Contacts_Nombre, "Pitbull");
        contentValues.put(ContastantesBaseDatos.Table_Contacts_Foto, R.drawable.pitbull);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ContastantesBaseDatos.Table_Contacts_Nombre, "Pomerania");
        contentValues.put(ContastantesBaseDatos.Table_Contacts_Foto, R.drawable.pomerania);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ContastantesBaseDatos.Table_Contacts_Nombre, "Pug");
        contentValues.put(ContastantesBaseDatos.Table_Contacts_Foto, R.drawable.r_pug2);
        db.insertarContacto(contentValues);
    }

    public void darLikeContacto (Perro contacto){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ContastantesBaseDatos.Table_Likes_Contact_Id_Contacto, contacto.getId());
        contentValues.put(ContastantesBaseDatos.Table_Likes_Contact_Numero_Likes, LIKE);
        db.insertarLikeContacto(contentValues);

    }

    public int obtenerLikesContacto (Perro contacto){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesContacto(contacto);
    }
}
