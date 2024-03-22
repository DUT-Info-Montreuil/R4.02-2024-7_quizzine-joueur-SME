package org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.entites.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.service.*;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.service.impls.ServiceJoueurImpl;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.service.interfaces.IServicesJoueur;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.utiles.*;

import java.util.ArrayList;
import java.util.List;

class ServicesJoueurTest {
    IServicesJoueur servicesJoueur;
    List<String> test = new ArrayList<>();

    @Test
    public void testAddJoueur() throws AjoutJoueurException {
//        servicesJoueur = new ServicesJoueursMockAjoutOK();
        servicesJoueur = ServiceJoueurImpl.getInstance();
        test.add("footballe");

        JoueurDTO joueurAttendu = new JoueurDTO("emre","emrebondy",2015, "francais",test);

        //tout correct
        JoueurDTO joueurResultat = servicesJoueur.creerJoueur("emre","emrebondy",2015,"francais",test);
        Assertions.assertEquals(joueurAttendu,joueurResultat);
    }
    @Test
    public void testJoueurPrenomCarectereSpecial(){
        //prenom avec caractère spécial
        test.add("footballe");
//        servicesJoueur = new ServiceJoueurPrenonIncorrectMock();
        Assertions.assertThrows(PrenomIncorrectExeption.class, () -> {
            servicesJoueur.creerJoueur("emre5", "emrebondy", 2015, "francais", test);
        });
    }
    @Test
    public void testJoueurPrenomVide(){
        //prenom vide
        test.add("footballe");
//        servicesJoueur = new ServiceJoueurPrenonIncorrectMock();
        Assertions.assertThrows(PrenomIncorrectExeption.class, () -> {
            servicesJoueur.creerJoueur("", "emrebondy", 2015, "francais", test);
        });
    }
    @Test
    public void testJoueurPrenomTailleSuperieur14(){
        //taille prenom supérieur ou égale à 15
        test.add("footballe");
//        servicesJoueur = new ServiceJoueurPrenonIncorrectMock();
        Assertions.assertThrows(PrenomIncorrectExeption.class, () -> {
            servicesJoueur.creerJoueur("emreemreemreemreemre", "emrebondy", 2015, "francais", test);
        });
    }
    @Test
    public void testJoueurPseudoTailleIncorrect(){
        //taille pseudo superieur à 19
        test.add("footballe");
//        servicesJoueur = new ServiceJoueurPseudoTailleIncorrectMock();
        Assertions.assertThrows(PseudoTailleIncorrectExeption.class, () -> {
            servicesJoueur.creerJoueur("emrebondy", "emrebondyemrebondyab", 2015, "francais", test);
        });
    }
    @Test
    public void testJoueurPseudoVide(){
        //pseudo vide
        test.add("footballe");
//        servicesJoueur = new ServiceJoueurPseudoTailleIncorrectMock();
        Assertions.assertThrows(PseudoTailleIncorrectExeption.class, () -> {
            servicesJoueur.creerJoueur("emre", "", 2015, "francais", test);
        });
    }
    @Test
    public void testJoueurPseudoTropPetit(){
        //pseudo trop petit
        test.add("footballe");
//        servicesJoueur = new ServiceJoueurPseudoTailleIncorrectMock();
        Assertions.assertThrows(PseudoTailleIncorrectExeption.class, () -> {
            servicesJoueur.creerJoueur("emre", "abc", 2015, "francais", test);
        });
    }
    @Test
    public void testJoueurCentreInteretINcorrect(){
        List<String> test2 = new ArrayList<>();
        test2.add("footballe");
        test2.add("basket");
        test2.add("tennis");
        test2.add("baseball");
//        servicesJoueur = new ServiceJoueurCentreInteretIncorrectMock();
        Assertions.assertThrows(CentreInteretIncorrectExeption.class, () -> {
            servicesJoueur.creerJoueur("emrebondy", "emrebondyemrebondyab", 2015, "francais", test2);
        });
    }
    @Test
    public void testJoueurAnneeTropGrand(){
        //date de naissance superieur à 2020
        test.add("footballe");
//        servicesJoueur = new ServiceJoueurAnneeIncorrectMock();
        Assertions.assertThrows(AnneeIncorrectExeption.class, () -> {
            servicesJoueur.creerJoueur("emre", "emrebondy", 1906, "francais", test);
        });
    }
    @Test
    public void testJoueurAnneeTropPetit(){
        //date de naissance incorect2
        test.add("footballe");
//        servicesJoueur = new ServiceJoueurAnneeIncorrectMock();
        Assertions.assertThrows(AnneeIncorrectExeption.class, () -> {
            servicesJoueur.creerJoueur("emre", "emrebondy", 2022,"francais", test);
        });
    }
    @Test
    public void testJoueurPseudoUnique() throws AjoutJoueurException {
        //pseudo deja existant
        test.add("footballe");
//        servicesJoueur = new ServiceJoueurPseudoExistantMock();
        servicesJoueur.creerJoueur("emre","emreBondy",2004,"francais",test);
        servicesJoueur.creerJoueur("bilel","emreBondy",2004,"francais",test);
    }

}