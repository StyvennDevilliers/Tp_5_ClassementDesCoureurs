package fr.btsciel;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;

public class GestionDesCoureurs {
    private static ArrayList<Coureur> coureurs = new ArrayList<>();
    private final Path path = Paths.get("course.txt");
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static void sortPrenomDecroissant() {
        coureurs.sort(Comparator.comparing(Coureur::getPrenom).reversed());
        coureurs.forEach(coureur -> {
            System.out.printf("%-10s  %-10s\t%-10s\t\t\t%-10s\t%-10s\n",coureur.getGenre(),coureur.getNom(),coureur.getPrenom(),coureur.getCategorie(),dtf.format(coureur.getTemps()));
        });
    }

    public static void sortPrenomCroissant() {
        coureurs.sort(Comparator.comparing(Coureur::getPrenom));
        coureurs.forEach(coureur -> {
            System.out.printf("%-10s  %-10s\t%-10s\t\t\t%-10s\t%-10s\n",coureur.getGenre(),coureur.getNom(),coureur.getPrenom(),coureur.getCategorie(),dtf.format(coureur.getTemps()));
        });
    }


    public ArrayList<Coureur> getCoureurs() {
        return coureurs;
    }

    public void setCoureurs(ArrayList<Coureur> coureurs) {
        this.coureurs = coureurs;
    }

    private void lectureFichier() throws IOException {
        BufferedReader br = Files.newBufferedReader(path);
        while(br.ready()){
            String ligne = br.readLine();
            ajouterListe(ligne);
        }
    }

    private void ajouterListe(String ligne) {
        if(ligne != null){
            String[] monTableau = ligne.split(",");
            if(monTableau.length == 5){
                Coureur coureur = new Coureur(Genre.valueOf(monTableau[0].trim()),monTableau[1],monTableau[2],Categorie.valueOf(monTableau[3].trim()),LocalTime.ofSecondOfDay(Integer.parseInt(monTableau[4].trim())));
                coureurs.add(coureur);
            }
        }
    }



    public GestionDesCoureurs() throws IOException {
        lectureFichier();
    }

    public static void sortNomCroissant(){
        coureurs.sort(Comparator.comparing(Coureur::getNom));
        coureurs.forEach(coureur -> {
            System.out.printf("%-10s  %-10s\t%-10s\t\t\t%-10s\t%-10s\n",coureur.getGenre(),coureur.getNom(),coureur.getPrenom(),coureur.getCategorie(),coureur.getTemps());
        });
    }

    public static void sortNomDecroissant() {
        coureurs.sort(Comparator.comparing(Coureur::getNom).reversed());
        coureurs.forEach(coureur -> {
            System.out.printf("%-10s  %-10s\t%-10s\t\t\t%-10s\t%-10s\n",coureur.getGenre(),coureur.getNom(),coureur.getPrenom(),coureur.getCategorie(),dtf.format(coureur.getTemps()));
        });
    }


}
