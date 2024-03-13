package org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.utiles;

public class AjoutJoueurException extends Exception{
    @Override
    public String getMessage() {
        return "Une Exeption à était lever lors de l'ajout du joueur";
    }
}
