package com.mdleon.animalerte;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Accueil extends AppCompatActivity {
    ////Declaration pour le bouton ajouter Animal
    Button btn_AjouterAnimal;
    //creation d'annonce
    Button btn_CreerAnnonce;
    private ListView mListView;
    AnimalertDatabaseManager animalertDatabaseManager;
    SQLiteDatabase sqLiteDatabase;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_accueil);

        mListView = (ListView) findViewById(R.id.idlistview);
        animalertDatabaseManager=new AnimalertDatabaseManager(this);
        sqLiteDatabase=animalertDatabaseManager.getReadableDatabase();

        //appel de la methode pour afficher les données dans la liste
       populateListView();

       // Annonce annonce=mListView.get(i);

        ////////////Btn Ajouter Animal, Appel de Layout Ajouter Animal
        btn_AjouterAnimal=(Button)findViewById(R.id.idAjouterAnimal);
        btn_AjouterAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Accueil.this,ActivityAjouterAnimal.class);
                startActivity(intent);

            }
        });
        //creation d'annonce
        btn_CreerAnnonce=(Button)findViewById(R.id.idcreerannonce);
        btn_CreerAnnonce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Accueil.this,ActivityAjouterAnnonce.class);
                startActivity(intent);
            }
        });
///on clique sur listview
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String titre = adapterView.getItemAtPosition(i).toString();
                Cursor data = animalertDatabaseManager.getItemID(titre);

            //    Annonce annonce = mListView.get(i);
String itemDescription="";
                String date="";
                String ville="";
                int itemID = -1;
                while(data.moveToNext()){
                    itemID = data.getInt(0);
                    itemDescription=data.getString(2);
                    date=data.getString(3);
                    ville=data.getString(4);
                    }
                if(itemID > -1){

                  Intent detailAnnonceIntent = new Intent(Accueil.this, DetailAnonce.class);
                  detailAnnonceIntent.putExtra("id",itemID);
                    detailAnnonceIntent.putExtra("titre",titre);
                    detailAnnonceIntent.putExtra("Description",itemDescription);
                    detailAnnonceIntent.putExtra("date",date);
                    detailAnnonceIntent.putExtra("ville",ville);
                    startActivity(detailAnnonceIntent);

                }
            }
        });

    }

    private void populateListView() {

        //get the data and append to a list

        Cursor data = animalertDatabaseManager.getData();
        ArrayList<String> listData = new ArrayList<>();
        while (data.moveToNext()) {
            //get the value from the database in column 1
            //then add it to the ArrayList
            listData.add(data.getString(1));
            listData.add(data.getString(2));
            listData.add(data.getString(3));


        }
        //create the list adapter and set the adapter
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        mListView.setAdapter(adapter);

    }

}
