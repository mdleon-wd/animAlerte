package com.mdleon.animalerte;

import java.io.Serializable;

public class Annonce implements Serializable{
    private int Id;
    private String titreAnnonce;
    private String descriptionAnimal;
    private String dateCreation;
    private String ville;
    private String typeAnnonce;
    private String utilasateur;


    public Annonce() {
    }

    public Annonce(int id, String titreAnnonce, String descriptionAnimal, String dateCreation, String ville, String typeAnnonce, String utilasateur) {
        Id=id;
        this.titreAnnonce = titreAnnonce;
        this.descriptionAnimal = descriptionAnimal;
        this.dateCreation = dateCreation;
        this.ville = ville;
        this.typeAnnonce = typeAnnonce;
        this.utilasateur = utilasateur;
    }
    public Annonce(String titreAnnonce, String descriptionAnimal, String dateCreation, String ville, String typeAnnonce, String utilasateur) {

        this.titreAnnonce = titreAnnonce;
        this.descriptionAnimal = descriptionAnimal;
        this.dateCreation = dateCreation;
        this.ville = ville;
        this.typeAnnonce = typeAnnonce;
        this.utilasateur = utilasateur;
    }

    public String getTitreAnnonce() {
        return titreAnnonce;
    }

    public String getTypeAnnonce() {
        return typeAnnonce;
    }

    public String getUtilasateur() {
        return utilasateur;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setUtilasateur(String utilasateur) {
        this.utilasateur = utilasateur;
    }

    public void setTypeAnnonce(String typeAnnonce) {
        this.typeAnnonce = typeAnnonce;
    }

    public void setTitreAnnonce(String titreAnnonce) {
        this.titreAnnonce = titreAnnonce;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getDescriptionAnimal() {
        return descriptionAnimal;
    }

    public void setDescriptionAnimal(String descriptionAnimal) {
        this.descriptionAnimal = descriptionAnimal;
    }

    @Override
    public String toString() {
        return "Annonce{" +
                "Id=" + Id +
                ", titreAnnonce='" + titreAnnonce + '\'' +
                ", descriptionAnimal='" + descriptionAnimal + '\'' +
                ", dateCreation='" + dateCreation + '\'' +
                ", ville='" + ville + '\'' +
                ", typeAnnonce='" + typeAnnonce + '\'' +
                ", utilasateur='" + utilasateur + '\'' +
                '}';
    }
}