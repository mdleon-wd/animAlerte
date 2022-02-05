package com.mdleon.animalerte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ////Declaration pour le bouton ajouter user
    Button btn_AjouterUser;
    Button btn_connection, buttonFB, buttonEnregistrer;
    EditText utilisateur, password;
    AnimalertDatabaseManager animalertDatabaseManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_connection);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ////////////Btn Ajouter user, Appel de Layout Ajouter User
        btn_AjouterUser=(Button)findViewById(R.id.idInscriptionUser);

        btn_AjouterUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,AddUser.class);
                startActivity(intent);

            }
        });

        ///Bouton connection
        utilisateur = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        buttonFB = findViewById(R.id.buttonFB);
        btn_connection = findViewById(R.id.buttonConnection);
        buttonEnregistrer = findViewById(R.id.idInscriptionUser);
        btn_connection=(Button)findViewById(R.id.buttonConnection);

        btn_connection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = utilisateur.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("") || (pass.equals(""))) {
                    Toast.makeText(MainActivity.this, "Veuillez remplir tout les champs", Toast.LENGTH_LONG).show();
                } else {
                    // Boolean check = animalertDatabaseManager.checkPassword(user,pass);
                    Boolean check =true;

                    if (check) {
                        Toast.makeText(MainActivity.this, "Connection réussi", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), Accueil.class);
                        startActivity(intent);
                    } else {
                        //Toast.makeText(LoginActivity.this, "Mauvais mot de passe", Toast.LENGTH_LONG).show();
                        Toast.makeText(MainActivity.this, "Erreur de connection", Toast.LENGTH_LONG).show();// remove after testing
                    }
                }
            }


        });

    }
}