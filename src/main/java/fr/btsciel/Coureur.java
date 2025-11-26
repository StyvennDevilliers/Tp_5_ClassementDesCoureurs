package fr.btsciel;

import java.text.SimpleDateFormat;
import java.time.LocalTime;

public class Coureur extends Personne{
    private  LocalTime temps;
    private  Categorie categorie;

    public LocalTime getTemps() {
        return temps;
    }

    public  void setTemps(LocalTime temps) {
        this.temps = temps;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public  void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Coureur(Genre genre,String nom ,String prenom ,Categorie categorie,LocalTime temps ) {
        setGenre(genre);
        setNom(nom);
        setPrenom(prenom);
        setTemps(temps);
        setCategorie(categorie);
    }
}
