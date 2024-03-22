package org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.service;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.entites.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.service.interfaces.IServicesJoueur;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.utiles.AjoutJoueurException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.utiles.Langue;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.utiles.PseudoTailleIncorrectExeption;

import java.util.List;

public class ServiceJoueurPseudoTailleIncorrectMock implements IServicesJoueur {
    @Override
    public JoueurDTO creerJoueur(String prenom, String pseudo, int anneeDeNaissance, Langue langue, List<String> centreInteret) throws AjoutJoueurException {
        throw new PseudoTailleIncorrectExeption();
    }
}
