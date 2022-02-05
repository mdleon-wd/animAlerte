package com.mdleon.animalerte;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddUser extends AppCompatActivity {
    ///declaration pour ajouter User
    AnimalertDatabaseManager animalertDatabaseManager;
    EditText nomuser, nom, prenom, courriel, password, telephone;
    Button btn_enregistrer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_inscription_user);

        ///Pour l'ajout User
        animalertDatabaseManager=new AnimalertDatabaseManager(this);

        btn_enregistrer = (Button) findViewById(R.id.enregistre);
        nomuser = (EditText) findViewById(R.id.nomUtilisateur);
        nom = (EditText) findViewById(R.id.nom);
        prenom = (EditText) findViewById(R.id.prenom);
        courriel = (EditText) findViewById(R.id.courriel);
        password = (EditText) findViewById(R.id.motDePasse);
        telephone = (EditText) findViewById(R.id.telephone);


        ///////////////Ajouter User
        btn_enregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               animalertDatabaseManager.insert_data_user(nomuser.getText().toString(),nom.getText().toString(),prenom.getText().toString(),courriel.getText().toString(),password.getText().toString(),telephone.getText().toString());


                    Toast.makeText(AddUser.this, "enregistrement bien effectué", Toast.LENGTH_SHORT).show();
                nomuser.setText("");
                nom.setText("");
                prenom.setText("");
                courriel.setText("");
                password.setText("");
                telephone.setText("");
            }

        });

    }
}
