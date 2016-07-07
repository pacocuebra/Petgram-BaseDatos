package com.pacuebra.petgram.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.pacuebra.petgram.Pojo.Perro;

import java.util.ArrayList;

/**
 * Created by Francisco on 04/07/2016.
 */
public class BaseDatos extends SQLiteOpenHelper {
    private Context context;

    public BaseDatos(Context context) {
        super(context, ContastantesBaseDatos.DataBase_Name, null, ContastantesBaseDatos.DataBase_Version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaContacto = "Create Table " + ContastantesBaseDatos.Table_Contacts + "(" +
                    ContastantesBaseDatos.Table_Contacts_Id     + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    ContastantesBaseDatos.Table_Contacts_Nombre + " TEXT, " +
                    ContastantesBaseDatos.Table_Contacts_Foto   + " INTEGER" +
                ")";

        String queryCrearTablaLikes = "Create Table " + ContastantesBaseDatos.Table_Likes_Contact + "(" +
                    ContastantesBaseDatos.Table_Likes_Contact_Id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    ContastantesBaseDatos.Table_Likes_Contact_Id_Contacto +  " INTEGER, " +
                    ContastantesBaseDatos.Table_Likes_Contact_Numero_Likes + " INTEGER, " +
                    "FOREIGN KEY (" + ContastantesBaseDatos.Table_Likes_Contact_Id_Contacto + ") " +
                    "REFERENCES " + ContastantesBaseDatos.Table_Contacts + " (" + ContastantesBaseDatos.Table_Contacts_Id + ") " +
                ")";

        db.execSQL(queryCrearTablaContacto);
        db.execSQL(queryCrearTablaLikes);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL("DROP TABLE IF EXIST " + ContastantesBaseDatos.Table_Contacts);
            db.execSQL("DROP TABLE IF EXIST " + ContastantesBaseDatos.Table_Likes_Contact);
        onCreate(db);
    }

    public ArrayList<Perro> ObtenerTodosLosContactos(){
        ArrayList<Perro> contactos = new ArrayList<>();

        String query = "SELECT * FROM " + ContastantesBaseDatos.Table_Contacts;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        while(registros.moveToNext()){
            Perro contactoActual = new Perro();
            contactoActual.setId(registros.getInt(0));
            contactoActual.setNombre(registros.getString(1));
            contactoActual.setFoto(registros.getInt(2));

            String queryLikes = "SELECT COUNT ("+ContastantesBaseDatos.Table_Likes_Contact_Numero_Likes+") as likes " +
                                " FROM " + ContastantesBaseDatos.Table_Likes_Contact +
                                " WHERE " + ContastantesBaseDatos.Table_Likes_Contact_Id_Contacto + "=" + contactoActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if(registrosLikes.moveToNext()){
                contactoActual.setLikes(registrosLikes.getInt(0));
            }else{
                contactoActual.setLikes(0);
            }


            contactos.add(contactoActual);
        }

        db.close();
        return contactos;
    }


    public void insertarContacto (ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ContastantesBaseDatos.Table_Contacts,null, contentValues);
        db.close();
    }

    public void insertarLikeContacto(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ContastantesBaseDatos.Table_Likes_Contact, null, contentValues);
        db.close();
    }

    public int obtenerLikesContacto(Perro contacto){
        int likes = 0;
        String query = "SELECT COUNT(" + ContastantesBaseDatos.Table_Likes_Contact_Numero_Likes + ")" +
                " FROM " + ContastantesBaseDatos.Table_Likes_Contact +
                " WHERE " + ContastantesBaseDatos.Table_Likes_Contact_Id_Contacto + "=" + contacto.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if(registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();
        return likes;
    }

}
