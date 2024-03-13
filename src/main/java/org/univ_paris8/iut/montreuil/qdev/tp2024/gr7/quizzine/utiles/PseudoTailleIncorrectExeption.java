package org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.utiles;

public class PseudoTailleIncorrectExeption extends AjoutJoueurException{

    @Override
    public String getMessage() {
        return "La taille du pseudo est incorrecte";
    }
}
