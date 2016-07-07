package com.pacuebra.petgram.db;

/**
 * Created by Francisco on 04/07/2016.
 */
public final class ContastantesBaseDatos {
    public static final String DataBase_Name = "contactos";
    public static final int DataBase_Version = 1;

    public static final String Table_Contacts                       = "contacto";
    public static final String Table_Contacts_Id                    = "id";
    public static final String Table_Contacts_Nombre                = "nombre";
    public static final String Table_Contacts_Foto                  = "foto";
    public static final String Table_Likes_Contact                  = "contacto_likes";
    public static final String Table_Likes_Contact_Id               = "id";
    public static final String Table_Likes_Contact_Id_Contacto      = "id_contacto";
    public static final String Table_Likes_Contact_Numero_Likes     = "numero_likes";
}
