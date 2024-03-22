package org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.service.impls;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.entites.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.service.interfaces.IServicesJoueur;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.utiles.*;

import java.util.List;
import java.util.regex.Pattern;

public class ServiceJoueurImpl implements IServicesJoueur {
    @Override
    public JoueurDTO creerJoueur(String prenom, String pseudo, int anneeDeNaissance, Langue langue, List<String> centreInteret) throws AjoutJoueurException {
        if (prenom.length() >= 15 || !prenom.isEmpty() || estSansCaracteresSpeciauxEtSansChiffre(prenom)) {
            throw new PrenomIncorrectExeption();
        }
        if (pseudo.length() >= 20 || pseudo.length() <= 3) {
            throw new PseudoTailleIncorrectExeption();
        }
        if (anneeDeNaissance < 1907 || anneeDeNaissance > 2020) {
            throw new AnneeIncorrectExeption();
        }
        if (centreInteret.size() > 3) {
            throw new CentreInteretIncorrectExeption();
        }

        Langue.valueOf(langue.name());
        
        return new JoueurDTO(prenom, pseudo, anneeDeNaissance, langue, centreInteret);

    }

    public static boolean estSansCaracteresSpeciauxEtSansChiffre (String chaine) {
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        return pattern.matcher(chaine).matches();
    }
}
