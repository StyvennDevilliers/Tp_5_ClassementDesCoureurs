package fr.btsciel;

import clavier.In;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;

public class GestionDesCoureurs {
    private static final ArrayList<Coureur> coureurs = new ArrayList<>();
    private static final Path path = Paths.get("course.txt");
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static void sortNomCroissant(){
        coureurs.sort(Comparator.comparing(Coureur::getNom));
        coureurs.forEach(coureur -> {
            System.out.printf("%-10s  %-10s\t%-10s\t\t\t%-10s\t%-10s\n",coureur.getGenre(),coureur.getNom(),coureur.getPrenom(),coureur.getCategorie(),dtf.format(coureur.getTemps()));
        });
    }

    public static void sortNomDecroissant() {
        coureurs.sort(Comparator.comparing(Coureur::getNom).reversed());
        coureurs.forEach(coureur -> {
            System.out.printf("%-10s  %-10s\t%-10s\t\t\t%-10s\t%-10s\n",coureur.getGenre(),coureur.getNom(),coureur.getPrenom(),coureur.getCategorie(),dtf.format(coureur.getTemps()));
        });
    }

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

    public static void sortClassementCroissant() {
        coureurs.sort(Comparator.comparing(Coureur::getCategorie));
        coureurs.forEach(coureur -> {
            System.out.printf("%-10s  %-10s\t%-10s\t\t\t%-10s\t%-10s\n",coureur.getGenre(),coureur.getNom(),coureur.getPrenom(),coureur.getCategorie(),dtf.format(coureur.getTemps()));
        });
    }

    public static void sortClassementDecroissant() {
        coureurs.sort(Comparator.comparing(Coureur::getCategorie).reversed());
        coureurs.forEach(coureur -> {
            System.out.printf("%-10s  %-10s\t%-10s\t\t\t%-10s\t%-10s\n",coureur.getGenre(),coureur.getNom(),coureur.getPrenom(),coureur.getCategorie(),dtf.format(coureur.getTemps()));
        });
    }

    public static void addCoureur() {
        System.out.println("De quel genre est le joueur ?");
        String genre = In.readString().toUpperCase();
        System.out.println("Quel est le nom du joueur ?");
        String nom = In.readString().toUpperCase();
        System.out.println("Quel est le prenom du joueur ?");
        String prenom = In.readString().trim();
        prenom = prenom.substring(0, 1).toUpperCase() + prenom.substring(1).toLowerCase();
        System.out.println("Quel est le classement du joueur ?");
        String classement = In.readString().trim();
        classement = classement.substring(0, 1).toUpperCase() + classement.substring(1);
        System.out.println("Quel est le temps du joueur ? (en secondes)");
        String temps = In.readString();
        Coureur coureur = new Coureur(Genre.valueOf(genre.trim()),nom.trim(),prenom.trim(),Categorie.valueOf(classement),LocalTime.ofSecondOfDay(Integer.parseInt(temps.trim())));
        coureurs.add(coureur);
    }

    public static void deleteCoureur() {
        System.out.println("Quel est le numéro/ligne du joueur que vous voulez suprimer ?");
        int numero = In.readInteger();
        coureurs.remove(numero-1);
    }

    public static void editCoureur() {
        System.out.println("Quel est le numéro/ligne du joueur que vous voulez modifier ?");
        int numero = In.readInteger();
        Coureur coureur = coureurs.get(numero-1);
        System.out.println("""
                    Que voulez vous modifier ?
                1   Genre
                2   Nom
                3   Prenom
                4   Classement
                5   Temps
                """);
        int modification = In.readInteger();
        switch (modification) {
            case 1:
                System.out.println("Quel est le genre du coureur ?");
                String genre = In.readString().trim().toUpperCase();
                coureur = new Coureur(Genre.valueOf(genre), coureur.getNom(), coureur.getPrenom(), coureur.getCategorie(), coureur.getTemps());
                break;
            case 2:
                System.out.println("Quel est le nom du coureur ?");
                String nom = In.readString().trim().toUpperCase();
                coureur = new Coureur(coureur.getGenre(), nom , coureur.getPrenom(), coureur.getCategorie(), coureur.getTemps());
                break;
            case 3:
                System.out.println("Quel est le prenom du coureur ?");
                String prenom = In.readString().trim().toUpperCase();
                coureur = new Coureur(coureur.getGenre(), coureur.getNom() , prenom, coureur.getCategorie(), coureur.getTemps());
                break;
            case 4:
                System.out.println("Quel est le categorie du coureur ?");
                String categorie = In.readString().trim().toUpperCase();
                coureur = new Coureur(coureur.getGenre(), coureur.getNom() , coureur.getPrenom(), Categorie.valueOf(categorie), coureur.getTemps());
                break;

            case 5:
                System.out.println("Quel est le temps du coureur ? (en secondes)");
                String temps = In.readString().trim();
                coureur = new Coureur(coureur.getGenre(), coureur.getNom() , coureur.getPrenom(), coureur.getCategorie(), LocalTime.ofSecondOfDay(Integer.parseInt(temps)));
                break;
            default:
                coureur = coureurs.get(numero-1);
        }
        coureurs.set(numero-1,coureur);
    }

    public static void saveCoureur() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("courseFinal.txt"));
        for (Coureur coureur : coureurs) {
            writer.write(coureur.getGenre() + ", " + coureur.getNom() + ", " + coureur.getPrenom() + ", " + coureur.getCategorie() + ", " + dtf.format(coureur.getTemps()));
            writer.newLine();
        }
        writer.close();
    }

    public static void calculDiffTemps() {
        System.out.println("Quelle est la ligne du premier coureur ?");
        int index1 = In.readInteger();
        System.out.println("Quelle est la ligne du deuxieme coureur ?");
        int index2 = In.readInteger();
        if (index1-1 < index2-1) {
            LocalTime t1 = coureurs.get(index1-1).getTemps();
            LocalTime t2 = coureurs.get(index2-1).getTemps();
            int ecart = t1.getSecond() - t2.getSecond();
            System.out.println("L'ecart entre les deux coureurs est de : " + dtf.format(LocalTime.ofSecondOfDay(ecart)));

        }else if (index2-1 < index1-1) {
            LocalTime t1 = coureurs.get(index2-1).getTemps();
            LocalTime t2 = coureurs.get(index1-1).getTemps();
            int ecart = t1.getSecond() - t2.getSecond();
            System.out.println("L'ecart entre les deux coureurs est de : -" + dtf.format(LocalTime.ofSecondOfDay(ecart)));

        }else {
            System.out.println("Ce sont les memes coureurs il n'y a donc pas d'ecart.");
        }

    }


    private void ajouterListe(String ligne) {
        if(ligne != null){
            String[] monTableau = ligne.split(",");
            if(monTableau.length == 5){
                Coureur coureur = new Coureur(Genre.valueOf(monTableau[0].trim()),monTableau[1].trim(),monTableau[2].trim(),Categorie.valueOf(monTableau[3].trim()),LocalTime.ofSecondOfDay(Integer.parseInt(monTableau[4].trim())));
                coureurs.add(coureur);
            }
        }
    }

    private void lectureFichier() throws IOException {
        BufferedReader br = Files.newBufferedReader(path);
        while(br.ready()){
            String ligne = br.readLine();
            ajouterListe(ligne);
        }
        br.close();
    }

    public GestionDesCoureurs() throws IOException {
        lectureFichier();
    }

}
