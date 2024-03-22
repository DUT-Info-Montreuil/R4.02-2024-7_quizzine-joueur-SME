package org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.entites.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.service.ServicesJoueursMockAjoutOK;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.service.impls.ServiceJoueurImpl;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.service.interfaces.IServicesJoueur;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.utiles.*;

import java.util.ArrayList;
import java.util.List;

class ServicesJoueurTest {

    IServicesJoueur servicesJoueur;
    @Test
    public void testAddJoueur() throws AjoutJoueurException {
        servicesJoueur = new ServiceJoueurImpl();
//        servicesJoueur = new ServicesJoueursMockAjoutOK();

        List<String> test = new ArrayList<>();
        test.add("footballe");
        JoueurDTO joueurAttendu = new JoueurDTO("emre","emrebondy",2015, Langue.francais,test);
//
//        //tout correct
//        public void testAddJoueurCorrect(){
//
//        }
        JoueurDTO joueurResultat = servicesJoueur.creerJoueur("emre","emrebondy",2015,Langue.francais,test);
        Assertions.assertEquals(joueurAttendu,joueurResultat);

        //prenom avec caractère spécial
        //JoueurDTO joueurResultat2 = servicesJoueur.creerJoueur("emre5","emrebondy",2020,Langue.francais,test);
        //Assertions.assertNotEquals(joueurAttendu, joueurResultat2);
        Assertions.assertThrows(PrenomIncorrectExeption.class, () -> {
            servicesJoueur.creerJoueur("emre5", "emrebondy", 2015, Langue.francais, test);
        });

//        //date de naissance incorect
//        JoueurDTO joueurResultat3 = servicesJoueur.creerJoueur("emre","emrebondy",1906,Langue.francais,test);
//        Assertions.assertNotEquals(joueurAttendu, joueurResultat3);
        Assertions.assertThrows(AnneeIncorrectExeption.class, () -> {
            servicesJoueur.creerJoueur("emre", "emrebondy", 1906, Langue.francais, test);
        });

//
//        //date de naissance incorect2
//        JoueurDTO joueurResultat4 = servicesJoueur.creerJoueur("emre","emrebondy",2022,Langue.francais,test);
//        Assertions.assertNotEquals(joueurAttendu, joueurResultat4);
        Assertions.assertThrows(AnneeIncorrectExeption.class, () -> {
            servicesJoueur.creerJoueur("emre", "emrebondy", 2022,Langue.francais, test);
        });
//
//        //prenom vide
//        JoueurDTO joueurResultat5 = servicesJoueur.creerJoueur("","emrebondy",2020,Langue.francais,test);
//        Assertions.assertNotEquals(joueurAttendu, joueurResultat5);
        Assertions.assertThrows(PrenomIncorrectExeption.class, () -> {
            servicesJoueur.creerJoueur("", "emrebondy", 2015, Langue.francais, test);
        });
//
//        //pseudo vide
//        JoueurDTO joueurResultat6 = servicesJoueur.creerJoueur("emre","",2020,Langue.francais,test);
//        Assertions.assertNotEquals(joueurAttendu, joueurResultat6);
        Assertions.assertThrows(PseudoTailleIncorrectExeption.class, () -> {
            servicesJoueur.creerJoueur("emre", "", 2015, Langue.francais, test);
        });
//
//        //pseudo trop petit
//        JoueurDTO joueurResultat9 = servicesJoueur.creerJoueur("emre","abc",2020,Langue.francais,test);
//        Assertions.assertNotEquals(joueurAttendu, joueurResultat9);
        Assertions.assertThrows(PseudoTailleIncorrectExeption.class, () -> {
            servicesJoueur.creerJoueur("emre", "abc", 2015, Langue.francais, test);
        });
//
//
//        JoueurDTO joueurAttendu2 = new JoueurDTO("emreemreemreem","emrebondyemrebondya",2020, Langue.francais,test);
//
//        //taille prenom supérieur ou égale à 15
//        JoueurDTO joueurResultat7 = servicesJoueur.creerJoueur("emreemreemreemreemre","emrebondy",2020, Langue.francais,test);
//        Assertions.assertNotEquals(joueurAttendu2, joueurResultat7);
        Assertions.assertThrows(PrenomIncorrectExeption.class, () -> {
            servicesJoueur.creerJoueur("emreemreemreemreemre", "emrebondy", 2015, Langue.francais, test);
        });
//
//
//        //taille pseudo supérieur ou égale à 20
//        JoueurDTO joueurResultat8 = servicesJoueur.creerJoueur("emreemreemreem","emrebondyemrebondyab",2020, Langue.francais,test);
//        Assertions.assertNotEquals(joueurAttendu2, joueurResultat8);
        Assertions.assertThrows(PseudoTailleIncorrectExeption.class, () -> {
            servicesJoueur.creerJoueur("emrebondy", "emrebondyemrebondyab", 2015, Langue.francais, test);
        });

        List<String> test2 = new ArrayList<>();
        test2.add("footballe");
        test2.add("basket");
        test2.add("tennis");
        test2.add("baseball");
        Assertions.assertThrows(CentreInteretIncorrectExeption.class, () -> {
            servicesJoueur.creerJoueur("emrebondy", "emrebondyemrebondyab", 2015, Langue.francais, test2);
        });

    }


}