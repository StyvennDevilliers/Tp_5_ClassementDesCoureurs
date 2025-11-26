package fr.btsciel;

import clavier.In;

public class Ihm {
    public static void main(String[] args) {
        try {
            GestionDesCoureurs laCourse = new GestionDesCoureurs();
        }catch (Exception e){
            System.out.println("Erreur lors de la lecture " + e.getMessage());
        }
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
                """);
        switch (In.readInteger()){
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

                break;
            case 6:

                break;
            case 7:

                break;
            case 8:

                break;
            case 9:

                break;
            case 10:

                break;
            default:
                System.out.println("Erreur de saisie.");
        }
    }
}
