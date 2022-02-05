package com.mdleon.animalerte;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;

public class ActivityAjouterAnnonce extends AppCompatActivity {

    AnimalertDatabaseManager animalertDatabaseManager;


    EditText ville ,descriptionAnnonce,utilisateur,titre;
    RadioGroup rgType;
    Button btn_enregistrerAnnonce;
    Button btn_retour;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_creer_annonce);

        animalertDatabaseManager=new AnimalertDatabaseManager(this);
        titre=findViewById(R.id.idEditTextTitreAnnonce);
        descriptionAnnonce=findViewById(R.id.idTextInputDescription);
        ville=findViewById(R.id.idEditTextVille);
        rgType=findViewById(R.id.idTypeAnnonce);
        utilisateur=findViewById(R.id.idEditUtilisateur);

        btn_enregistrerAnnonce = (Button) findViewById(R.id.idEnregtrerAnnonce);
        btn_retour= (Button) findViewById(R.id.idretour);



        //Type
        RadioButton radioType = (RadioButton) findViewById(rgType.getCheckedRadioButtonId());
        String type=radioType.getText().toString();

        ///////////////Ajouter Annonce
        btn_enregistrerAnnonce.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            public String ajouterDate(){
                LocalDate date= LocalDate.now();
                String Date = date.toString(); // convert date to string
                return  Date;
            }
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                String  date = ajouterDate();
                animalertDatabaseManager.insert_data_annonce(titre.getText().toString(), descriptionAnnonce.getText().toString(), date, ville.getText().toString(), utilisateur.getText().toString(), type);

                Toast.makeText(ActivityAjouterAnnonce.this, "enregistrement bien effectué", Toast.LENGTH_SHORT).show();
                titre.setText("");
                descriptionAnnonce.setText("");
                ville.setText("");
                utilisateur.setText("");
            }

        });

        btn_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ActivityAjouterAnnonce.this,Accueil.class);
                startActivity(intent);
            }
        });
    }
}

