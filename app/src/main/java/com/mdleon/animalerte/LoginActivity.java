package com.mdleon.animalerte;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText utilisateur, password;
    Button buttonFB, buttonEnregistrer, buttonConnection;
    AnimalertDatabaseManager animalertDatabaseManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_connection);

        utilisateur = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        buttonFB = findViewById(R.id.buttonFB);
        buttonConnection = findViewById(R.id.buttonConnection);
        buttonEnregistrer = findViewById(R.id.idInscriptionUser);

        animalertDatabaseManager = new AnimalertDatabaseManager(this);

        buttonConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = utilisateur.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("") || (pass.equals(""))) {
                    Toast.makeText(LoginActivity.this, "Veuillez remplir tout les champs", Toast.LENGTH_LONG).show();
                } else {
                    Boolean check = animalertDatabaseManager.checkPassword(user, pass);

                    if (check) {
                        Toast.makeText(LoginActivity.this, "Connection reussi", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    } else {
                        //Toast.makeText(LoginActivity.this, "Mauvais mot de passe", Toast.LENGTH_LONG).show();
                        Toast.makeText(LoginActivity.this, "Erreur de connection", Toast.LENGTH_LONG).show();// remove after testing
                    }
                }
            }
        });
        buttonEnregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}