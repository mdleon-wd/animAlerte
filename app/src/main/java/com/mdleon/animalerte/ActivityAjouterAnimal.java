package com.mdleon.animalerte;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityAjouterAnimal extends AppCompatActivity {
    ///declaration pour ajouter Animal
    AnimalertDatabaseManager animalertDatabaseManager;
    EditText nomAnimal, description;
    RadioGroup rgCategorie;
    Button btn_enregistrerAnimal;
    Button btn_retour;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_inscription_animal);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        animalertDatabaseManager=new AnimalertDatabaseManager(this);

        btn_enregistrerAnimal = (Button) findViewById(R.id.idEnregistreranimal);
        nomAnimal = (EditText) findViewById(R.id.animalName);
        description = (EditText) findViewById(R.id.descriptionAnimal);
        rgCategorie=findViewById(R.id.radioGroupCategorie);
        btn_retour= (Button) findViewById(R.id.idretour);

        //Categorie choisi
        RadioButton radioCategorie = (RadioButton) findViewById(rgCategorie.getCheckedRadioButtonId());
        String categorie=radioCategorie.getText().toString();

        ///////////////Ajouter Animal
        btn_enregistrerAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 animalertDatabaseManager.insert_data_animal(nomAnimal.getText().toString(),description.getText().toString(),categorie);

                    Toast.makeText(ActivityAjouterAnimal.this, "enregistrement bien effectué", Toast.LENGTH_SHORT).show();
                nomAnimal.setText("");
                description.setText("");
            }

        });

        btn_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ActivityAjouterAnimal.this,Accueil.class);
                startActivity(intent);
            }
        });
    }
}
