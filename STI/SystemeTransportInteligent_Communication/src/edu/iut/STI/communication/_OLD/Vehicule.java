/*
 * Copyright © 2015, François Chastel and Timothy Keynes
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * The Software is provided “as is”, without warranty of any kind, express or implied, including but not limited to the warranties of merchantability, fitness for a particular purpose and noninfringement. In no event shall the authors or copyright holders X be liable for any claim, damages or other liability, whether in an action of contract, tort or otherwise, arising from, out of or in connection with the software or the use or other dealings in the Software.
 *
 * Except as contained in this notice, the name of the <copyright holders> shall not be used in advertising or otherwise to promote the sale, use or other dealings in this Software without prior written authorization from the François Chastel and Timothy Keynes.
 */

package edu.iut.STI.communication._OLD;

import java.util.ArrayList;

public class Vehicule {
    private boolean chocImportant;
    private boolean boutonAlerte;
    private boolean enPanne;
    private boolean enAccident;
    private boolean aLarret;
    private boolean problemeDetecte;
    private boolean autoroute;
    private ArrayList<Message> listeMessages;
    private Systeme systeme;

    private Abonnement abonnement;
    private ModeleVehicule modeleVehicule;
    private Position position;
    private int idVehicule;

    public Vehicule(int idVehicule, ModeleVehicule modeleVehicule, Systeme systeme) {
        this.idVehicule = idVehicule;
        this.modeleVehicule = modeleVehicule;
        this.systeme = systeme;

        this.autoroute = false;
        this.abonnement = new Abonnement();
        this.chocImportant = false;
        this.boutonAlerte = false;
        this.enPanne = false;
        this.enAccident = false;
        this.aLarret = true;
        this.problemeDetecte = false;
        this.listeMessages = new ArrayList<Message>();
    }

    public void supprimerMessageLocalise() {
        //@todo Supprimer messages localisés
    }

    public void supprimerMessage(Message message) {
        this.listeMessages.remove(message);
    }

    public void supprimerMessage(int position) {
        this.listeMessages.remove(position);
    }

    public void addMessage(Message message) {
        this.listeMessages.add(message);
    }

    public void sendMessageAllVehicules(Message message) {
        this.systeme.getSystemeCommunication().sendMessageAllVehicules(message);
    }

    public void sendMessageVehicule(Vehicule vehicule, Message message) {
        this.systeme.getSystemeCommunication().sendMessageVehicule(vehicule, message);
    }

    public void sendMessageListeVehicule(Message message, ArrayList<Vehicule> vehicules) {
        this.systeme.getSystemeCommunication().sendMessageListeVehicule(message, vehicules);
    }

    public void readMessages() {
        if (listeMessages.size() == 1) {
            System.out.println(listeMessages.get(0).toString());
        } else {
            for (int i = 0; i < listeMessages.size(); i++) {
                System.out.println(listeMessages.get(i).toString());
            }
        }

    }

    public void signalerPanne() {
        //if (this.aLarret && this.problemeDetecte){
        this.enPanne = true;
        this.getSysteme().getSystemeCommunication().getServicePanne().addPanne(new Panne(this, this.position));
        //}
    }

    public void modifierAbonnement() {
        //@todo gerer liste abonnement
    }

    public void signalerAccident() {
        if (this.chocImportant || this.boutonAlerte) {
            this.enAccident = true;
            this.getSysteme().getSystemeCommunication().getServiceAccident().addAccident(new Accident(this, "Accident"));
        }
    }

    public void signalerVehiculeAutreEnPanne() {
        //@todo avertir systeme central
    }

    public boolean isChocImportant() {
        return chocImportant;
    }

    public boolean isBoutonAlerte() {
        return boutonAlerte;
    }

    public boolean isEnPanne() {
        return enPanne;
    }

    public boolean isaLarret() {
        return aLarret;
    }

    public boolean isProblemeDetecte() {
        return problemeDetecte;
    }

    public ArrayList<Message> getListeMessages() {
        return listeMessages;
    }

    public Systeme getSysteme() {
        return systeme;
    }

    public Abonnement getAbonnement() {
        return abonnement;
    }

    public ModeleVehicule getModeleVehicule() {
        return modeleVehicule;
    }

    public Position getPosition() {
        return position;
    }

    public boolean isAutoroute() {
        return autoroute;
    }

    public int getIdVehicule() {
        return idVehicule;
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "chocImportant=" + chocImportant +
                ", boutonAlerte=" + boutonAlerte +
                ", enPanne=" + enPanne +
                ", enAccident=" + enAccident +
                ", aLarret=" + aLarret +
                ", problemeDetecte=" + problemeDetecte +
                ", autoroute=" + autoroute +
                ", modeleVehicule=" + modeleVehicule +
                ", position=" + position +
                ", automobilisme=" + idVehicule +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicule)) return false;

        Vehicule vehicule = (Vehicule) o;

        if (aLarret != vehicule.aLarret) return false;
        if (autoroute != vehicule.autoroute) return false;
        if (boutonAlerte != vehicule.boutonAlerte) return false;
        if (chocImportant != vehicule.chocImportant) return false;
        if (enAccident != vehicule.enAccident) return false;
        if (enPanne != vehicule.enPanne) return false;
        if (problemeDetecte != vehicule.problemeDetecte) return false;
        if (!abonnement.equals(vehicule.abonnement)) return false;
        if (!listeMessages.equals(vehicule.listeMessages)) return false;
        if (!modeleVehicule.equals(vehicule.modeleVehicule)) return false;
        if (!position.equals(vehicule.position)) return false;
        if (!systeme.equals(vehicule.systeme)) return false;

        return true;
    }

}