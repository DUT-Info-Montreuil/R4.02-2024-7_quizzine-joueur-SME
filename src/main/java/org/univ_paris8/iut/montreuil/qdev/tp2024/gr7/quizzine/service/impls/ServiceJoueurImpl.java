package org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.service.impls;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.entites.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.service.interfaces.IServicesJoueur;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.utiles.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ServiceJoueurImpl implements IServicesJoueur {

    private static ServiceJoueurImpl serviceJoueur;
    private List<JoueurDTO> joueurDTOList;

    private ServiceJoueurImpl () {
        joueurDTOList = new ArrayList<>();
    }

    public static ServiceJoueurImpl getInstance() {
        if (serviceJoueur == null) {
            return serviceJoueur = new ServiceJoueurImpl();
        }
        else {
            return serviceJoueur;
        }
    }
    @Override
    public JoueurDTO creerJoueur(String prenom, String pseudo, int anneeDeNaissance, String langue, List<String> centreInteret) throws AjoutJoueurException {
        verifiePrenom(prenom);
        verifiePseudo(pseudo);
        verifieAnneDeNaissance(anneeDeNaissance);
        verifieCentreInteret(centreInteret);
        Langue.valueOf(langue);
        
        JoueurDTO joueurDTO = new JoueurDTO(prenom, pseudo, anneeDeNaissance, langue, centreInteret);
        joueurDTOList.add(joueurDTO);

        return joueurDTO;

    }
    public void verifiePrenom(String prenom) throws PrenomIncorrectExeption{
        if (prenom.length() >= 15 || prenom.isEmpty() || !estSansCaracteresSpeciauxEtSansChiffre(prenom)) {
            throw new PrenomIncorrectExeption();
        }
    }
    public boolean estSansCaracteresSpeciauxEtSansChiffre (String chaine) {
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        return pattern.matcher(chaine).matches();
    }

    public void verifiePseudo(String pseudo) throws PseudoTailleIncorrectExeption, PseudoExistantExeption{
        if (pseudo.length() >= 20 || pseudo.length() <= 3) {
            throw new PseudoTailleIncorrectExeption();
        }
        for (JoueurDTO joueurDTO : joueurDTOList) {
            if (joueurDTO.getPseudo().equals(pseudo)) {
                throw new PseudoExistantExeption();
            }
        }
    }

    public void verifieAnneDeNaissance(int anneeDeNaissance) throws AnneeIncorrectExeption {
        if (anneeDeNaissance < 1907 || anneeDeNaissance > 2020) {
            throw new AnneeIncorrectExeption();
        }
    }

    public void verifieCentreInteret( List<String> centreInteret) throws CentreInteretIncorrectExeption {
        if (centreInteret.size() > 3) {
            throw new CentreInteretIncorrectExeption();
        }
    }
}
