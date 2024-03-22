package org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.entites.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.service.*;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.service.impls.ServiceJoueurImpl;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.service.interfaces.IServicesJoueur;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.utiles.*;

import java.util.ArrayList;
import java.util.List;

class ServicesJoueurTest {

//    IServicesJoueur servicesJoueur = new ServicesJoueursMockAjoutOK();
    IServicesJoueur servicesJoueur = ServiceJoueurImpl.getInstance();
    List<String> listeCentreInteret = new ArrayList<>();

    @Test
    public void testAddJoueur() throws AjoutJoueurException {
//        servicesJoueur = new ServicesJoueursMockAjoutOK();
        listeCentreInteret.add("footballe");

        JoueurDTO joueurAttendu = new JoueurDTO("emre","emrebondys",2015, "francais", listeCentreInteret);

        //tout correct
        JoueurDTO joueurResultat = servicesJoueur.creerJoueur("emre","emrebondys",2015,"francais", listeCentreInteret);
        Assertions.assertEquals(joueurAttendu,joueurResultat);
    }
    @Test
    public void testJoueurPrenomCarectereSpecial(){
        //prenom avec caractère spécial
        listeCentreInteret.add("footballe");
//        servicesJoueur = new ServiceJoueurPrenonIncorrectMock();
        Assertions.assertThrows(PrenomIncorrectExeption.class, () -> {
            servicesJoueur.creerJoueur("emre5", "emrebondy1", 2015, "francais", listeCentreInteret);
        });
    }
    @Test
    public void testJoueurPrenomVide(){
        //prenom vide
        listeCentreInteret.add("footballe");
//        servicesJoueur = new ServiceJoueurPrenonIncorrectMock();
        Assertions.assertThrows(PrenomIncorrectExeption.class, () -> {
            servicesJoueur.creerJoueur("", "emrebondy2", 2015, "francais", listeCentreInteret);
        });
    }
    @Test
    public void testJoueurPrenomTailleSuperieur14(){
        //taille prenom supérieur ou égale à 15
        listeCentreInteret.add("footballe");
//        servicesJoueur = new ServiceJoueurPrenonIncorrectMock();
        Assertions.assertThrows(PrenomIncorrectExeption.class, () -> {
            servicesJoueur.creerJoueur("emreemreemreemreemre", "emrebondy3", 2015, "francais", listeCentreInteret);
        });
    }
    @Test
    public void testJoueurPseudoTailleIncorrect(){
        //taille pseudo superieur à 19
        listeCentreInteret.add("footballe");
//        servicesJoueur = new ServiceJoueurPseudoTailleIncorrectMock();
        Assertions.assertThrows(PseudoTailleIncorrectExeption.class, () -> {
            servicesJoueur.creerJoueur("emrebondy", "emrebondyemrebondyab", 2015, "francais", listeCentreInteret);
        });
    }
    @Test
    public void testJoueurPseudoVide(){
        //pseudo vide
        listeCentreInteret.add("footballe");
//        servicesJoueur = new ServiceJoueurPseudoTailleIncorrectMock();
        Assertions.assertThrows(PseudoTailleIncorrectExeption.class, () -> {
            servicesJoueur.creerJoueur("emre", "", 2015, "francais", listeCentreInteret);
        });
    }
    @Test
    public void testJoueurPseudoTropPetit(){
        //pseudo trop petit
        listeCentreInteret.add("footballe");
//        servicesJoueur = new ServiceJoueurPseudoTailleIncorrectMock();
        Assertions.assertThrows(PseudoTailleIncorrectExeption.class, () -> {
            servicesJoueur.creerJoueur("emre", "abc", 2015, "francais", listeCentreInteret);
        });
    }
    @Test
    public void testJoueurCentreInteretIncorrect(){
        List<String> test2 = new ArrayList<>();
        test2.add("footballe");
        test2.add("basket");
        test2.add("tennis");
        test2.add("baseball");
//        servicesJoueur = new ServiceJoueurCentreInteretIncorrectMock();
        Assertions.assertThrows(CentreInteretIncorrectExeption.class, () -> {
            servicesJoueur.creerJoueur("emrebondy", "emrebondy4", 2015, "francais", test2);
        });
    }
    @Test
    public void testJoueurAnneeTropPetite(){
        //date de naissance superieur à 2020
        listeCentreInteret.add("footballe");
//        servicesJoueur = new ServiceJoueurAnneeIncorrectMock();
        Assertions.assertThrows(AnneeIncorrectExeption.class, () -> {
            servicesJoueur.creerJoueur("emre", "emrebondyr", 1906, "francais", listeCentreInteret);
        });
    }
    @Test
    public void testJoueurAnneeTropGrande(){
        //date de naissance incorect2
        listeCentreInteret.add("footballe");
//        servicesJoueur = new ServiceJoueurAnneeIncorrectMock();
        Assertions.assertThrows(AnneeIncorrectExeption.class, () -> {
            servicesJoueur.creerJoueur("emre", "emrebondy6", 2022,"francais", listeCentreInteret);
        });
    }
    @Test
    public void testJoueurPseudoUnique() throws AjoutJoueurException {
        //pseudo deja existant
        listeCentreInteret.add("footballe");
//        servicesJoueur = new ServiceJoueurPseudoExistantMock();
        servicesJoueur.creerJoueur("emre","emreBondy",2004,"francais", listeCentreInteret);
        Assertions.assertThrows(PseudoExistantExeption.class, () -> {
            servicesJoueur.creerJoueur("bilel","emreBondy",2004,"francais", listeCentreInteret);
        });
    }
    @Test
    public void testJoueurLangue() throws AjoutJoueurException {
        //verifie que la langue soit correcte
        listeCentreInteret.add("footballe");
//        servicesJoueur = new ServiceJoueurPseudoExistantMock();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            servicesJoueur.creerJoueur("bilel","emreBondy",2004,"free", listeCentreInteret);
        });
    }

}