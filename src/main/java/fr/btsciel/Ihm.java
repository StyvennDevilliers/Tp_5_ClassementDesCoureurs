package fr.btsciel;

import clavier.In;

import java.io.IOException;

public class Ihm {
    public static void main(String[] args) {
        boolean boucle = true;
        try {
            new GestionDesCoureurs();
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture " + e.getMessage());
        }
        while(boucle) {
            try {
                System.out.println("""
                        1   Afficher par ordre alphabétique de leur nom croissant
                        2   Afficher par ordre alphabétique de leur nom décroissant
                        3   Afficher par ordre alphabétique de leur prénom croissant
                        4   Afficher par ordre alphabétique de leur prénom décroissant
                        5   Afficher par ordre de classement croissant
                        6   Afficher par ordre de classement décroissant
                        7   Ajouter un coureur
                        8   Supprimer un coureur
                        9   Modifier un coureur
                        10  Sauvegarder la liste des coureurs
                        11  Fin programme
                        """);
                switch (In.readInteger()) {
                    case 1:
                        GestionDesCoureurs.sortNomCroissant();
                        break;
                    case 2:
                        GestionDesCoureurs.sortNomDecroissant();
                        break;
                    case 3:
                        GestionDesCoureurs.sortPrenomCroissant();
                        break;
                    case 4:
                        GestionDesCoureurs.sortPrenomDecroissant();
                        break;
                    case 5:
                        GestionDesCoureurs.sortClassementCroissant();
                        break;
                    case 6:
                        GestionDesCoureurs.sortClassementDecroissant();
                        break;
                    case 7:
                        GestionDesCoureurs.addCoureur();
                        break;
                    case 8:
                        GestionDesCoureurs.deleteCoureur();
                        break;
                    case 9:
                        GestionDesCoureurs.editCoureur();
                        break;
                    case 10:
                        GestionDesCoureurs.saveCoureur();
                        break;
                    case 11:
                        boucle = false;
                        break;
                    default:
                        System.out.println("Erreur de saisie.");
                }
            } catch (Exception e) {
                System.out.println("Erreur lors de la lecture " + e.getMessage());
            }
        }
    }
}
