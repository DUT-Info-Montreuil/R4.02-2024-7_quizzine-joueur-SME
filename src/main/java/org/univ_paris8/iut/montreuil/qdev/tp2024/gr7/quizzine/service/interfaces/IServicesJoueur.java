package org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.service.interfaces;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.entites.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.utiles.AjoutJoueurException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.utiles.Langue;

import java.util.List;

public interface IServicesJoueur {

    public JoueurDTO creerJoueur(String prenom, String pseudo, int anneeDeNaissance, String langue, List<String> centreInteret) throws AjoutJoueurException;
}
