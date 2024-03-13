package org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.utiles;

public class PseudoExistantExeption extends AjoutJoueurException{

    @Override
    public String getMessage() {
        return "Le pseudo existe déjà";
    }
}
