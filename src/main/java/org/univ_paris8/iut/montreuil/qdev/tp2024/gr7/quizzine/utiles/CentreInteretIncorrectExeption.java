package org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.utiles;

public class CentreInteretIncorrectExeption extends AjoutJoueurException{

    @Override
    public String getMessage() {
        return "Les centres d'intérêt sont incorrecte";
    }
}
