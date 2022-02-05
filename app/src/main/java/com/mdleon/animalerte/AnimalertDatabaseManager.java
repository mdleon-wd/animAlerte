package com.mdleon.animalerte;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AnimalertDatabaseManager extends SQLiteOpenHelper {

    //Database and Table
    private static final String DATABASE_NAME ="Animalert1.db";
    private static final String TABLE_User="User";
    private static final String TABLE_Animal="Animal";
    private static final String TABLE_Annonce="Annonce";


    public AnimalertDatabaseManager(Context context) {
        super(context, DATABASE_NAME,null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create tables
        String table1="CREATE TABLE "+TABLE_User+"(nomUser TEXT PRIMARY KEY, nom TEXT, prenom TEXT, courriel TEXT, password TEXT, telephone TEXT)";
        String table2="CREATE TABLE "+TABLE_Animal+"(Id INTEGER PRIMARY KEY AUTOINCREMENT, nomAnimal TEXT, description TEXT, categorie TEXT)";
        String table3="CREATE TABLE "+TABLE_Annonce+"(Id INTEGER PRIMARY KEY AUTOINCREMENT, Titre TEXT,  DescriptionAnnonce TEXT, Date TEXT, Ville TEXT, Utilisateur TEXT, Type TEXT)";
        db.execSQL(table1);
        db.execSQL(table2);
        db.execSQL(table3);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_User);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_Animal);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_Annonce);
        onCreate(db);
    }
    //Ajout User
    public long insert_data_user(String nomuser, String nom, String prenom, String courriel, String password, String telephone) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nomuser", nomuser);
        values.put("nom", nom);
        values.put("prenom", prenom);
        values.put("courriel", courriel);
        values.put("password", password);
        values.put("telephone", telephone);
        return  db.insert(TABLE_User, null, values);

    }


    //Ajout Animal
    public long insert_data_animal(String nomAnimal, String description, String categorie) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues valuesAnimal = new ContentValues();
        valuesAnimal.put("nomAnimal", nomAnimal);
        valuesAnimal.put("description", description);
        valuesAnimal.put("categorie", categorie);

        return db.insert(TABLE_Animal, null, valuesAnimal);

    }

    //Ajouter Annonce
    public long insert_data_annonce(String txtTitre, String txtDescriptionAnnonce, String txtDate, String txtVille, String txtUtilisateur, String type){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues valuesAnnonce = new ContentValues();
        valuesAnnonce.put("Titre",txtTitre);
        valuesAnnonce.put("DescriptionAnnonce", txtDescriptionAnnonce);
        valuesAnnonce.put("Date", txtVille);
        valuesAnnonce.put("Date", txtDate);
        valuesAnnonce.put("Utilisateur", txtUtilisateur);
        valuesAnnonce.put("Type", type);


        return db.insert(TABLE_Annonce, null, valuesAnnonce);

    }

    public Boolean checkPassword(String nomUser, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        //Cursor cursor = db.rawQuery("SELECT * FROM TABLE_User WHERE nomUser= ? and password=? ", new String[]{nomUser, password});
        Cursor cursor = db.rawQuery("SELECT * FROM TABLE_User WHERE nomUser='usersafae' and password='1234' ", new String[]{nomUser, password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    /// VERIFICATION DE L'UTILISATEUR DANS LA BD
    public Boolean checkUtilisateur(String nomUser) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM TABLE_User WHERE nomUser =?", new String[]{nomUser});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }
    ///recuperer la liste des annonces

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        //String query = "SELECT * FROM " + TABLE_Annonce;
        String query = "SELECT * FROM "+ TABLE_Annonce;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

  /*  public Cursor getItemID(String titre){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + "Titre" + "Description"+ "Ville"+ "Date"+" FROM " + TABLE_Annonce +
                " WHERE " + "Titre" + " = '" + titre + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }*/
  public Cursor getItemID(String titre){
      SQLiteDatabase db = this.getWritableDatabase();
      String query = "SELECT " + "Id" + " FROM " + TABLE_Annonce +
              " WHERE " + "Titre" + " = '" + titre + "'";
      Cursor data = db.rawQuery(query, null);
      return data;
  }

 /* public Annonce getOneAnnonce(String id){
      SQLiteDatabase db = this.getWritableDatabase();
      Cursor c= db.query("TABLE_Annonce", new String[]{"id","Titre","DescriptionAnnonce","Date","Ville","Utilisateur","type"},
              "id=?",new String[]{String.valueOf(id), null, null, null});
      String query = "SELECT " + "titre" + " FROM " + TABLE_Annonce +
              " WHERE " + "Titre" + " = '" + titre + "'";

      Cursor c = db.rawQuery(query, null);
      c.moveToFirst();
      Annonce a=new Annonce((c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4));
      return a;
  }*/

}
