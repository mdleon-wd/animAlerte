package com.mdleon.animalerte;

public class Animal {

    private int Id;
    private String nomAnimal;
    private String description;
    private String categorie;

    public Animal(String nomAnimal, String description, String categorie) {
        this.nomAnimal = nomAnimal;
        this.description = description;
        this.categorie = categorie;
    }

    public Animal(int id, String nomAnimal, String description, String categorie) {
        Id = id;
        this.nomAnimal = nomAnimal;
        this.description = description;
        this.categorie = categorie;
    }

    public int getId() {
        return Id;
    }

    public String getNomAnimal() {
        return nomAnimal;
    }

    public String getDescription() {
        return description;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setNomAnimal(String nomAnimal) {
        this.nomAnimal = nomAnimal;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "Id=" + Id +
                ", nomAnimal='" + nomAnimal + '\'' +
                ", description='" + description + '\'' +
                ", categorie='" + categorie + '\'' +
                '}';
    }
}
