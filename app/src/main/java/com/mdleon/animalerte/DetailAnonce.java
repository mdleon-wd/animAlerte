package com.mdleon.animalerte;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailAnonce extends AppCompatActivity {

    private TextView txt_titre;
    private TextView txt_description;
    private TextView txt_date;
    private TextView txt_ville;

    private String selectedTitle;
    private String selectedDescription;
    private String selectedVille;
    private String selectedDate;
    private int selectedID;
    int id;

    AnimalertDatabaseManager animalertDatabaseManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_detail_annonce);

        animalertDatabaseManager=new AnimalertDatabaseManager(this);

        txt_titre = (TextView) findViewById(R.id.idTextViewTitreAnnonce);
        txt_ville = (TextView) findViewById(R.id.idTextViewVille);
        txt_date = (TextView) findViewById(R.id.idTextViewDateCreation);
        txt_description = (TextView) findViewById(R.id.idTextViewDescriptionAnimal);

        //get the intent extra from the ListDataActivity
        Intent receivedIntent = getIntent();

        id = receivedIntent.getIntExtra("id",-1);
        //Annonce a=animalertDatabaseManager.getOneAnnonce(id);


        txt_titre.setText(selectedTitle);
        txt_ville.setText(selectedVille);
        txt_date.setText(selectedDate);
        txt_description.setText(selectedDescription);
    }
}
