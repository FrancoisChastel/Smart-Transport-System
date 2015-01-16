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

public class ServiceAccident {
    private ArrayList<Vehicule> listeAbonnes;
    public ArrayList<Accident> accidents;
    public SystemeCommunication systemeCommunication;

    public ServiceAccident(SystemeCommunication systemeCommunication) {
        this.systemeCommunication = systemeCommunication;
        this.listeAbonnes = new ArrayList<Vehicule>();
        this.accidents = new ArrayList<Accident>();
    }

    public void addAccident(Accident accident) {
        this.accidents.add(accident);
        //@todo gerer la gestion des accidents
        //priseContact(accident.getVehicule().getAutomobilisme().getTel());
        this.getSystemeCommunication().getServiceMessagerie().sendMessageAllVehiculesSecteur(new Message(accident.getVehicule().getPosition(), accident.getVehicule().getIdVehicule(), "", null, 0), accident.getVehicule().getPosition());
        //@todo proposer connexion telephonique voitures proches
    }

    public void priseContact(String numeroTelConducteur) {
        //@todo Gerer la prise de contact
        this.getSystemeCommunication().getServicePriseContact();
    }

    public void addAbonne(Vehicule vehicule) {
        this.listeAbonnes.add(vehicule);
    }

    public void annulerDemandeInfo() {
        //@todo si info acquises, annuler la demande d'info
    }

    public ArrayList<Vehicule> getListeAbonnes() {
        return listeAbonnes;
    }

    public ArrayList<Accident> getAccidents() {
        return accidents;
    }

    public void setListeAbonnes(ArrayList<Vehicule> listeAbonnes) {
        this.listeAbonnes = listeAbonnes;
    }

    public void setAccidents(ArrayList<Accident> accidents) {
        this.accidents = accidents;
    }

    public SystemeCommunication getSystemeCommunication() {
        return systemeCommunication;
    }

    public void setSystemeCommunication(SystemeCommunication systemeCommunication) {
        this.systemeCommunication = systemeCommunication;
    }

    @Override
    public String toString() {
        return "ServiceAccident{" +
                "listeAbonnes=" + listeAbonnes +
                ", accidents=" + accidents +
                ", systemeCommunication=" + systemeCommunication +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiceAccident)) return false;

        ServiceAccident that = (ServiceAccident) o;

        if (!accidents.equals(that.accidents)) return false;
        if (!listeAbonnes.equals(that.listeAbonnes)) return false;
        if (!systemeCommunication.equals(that.systemeCommunication)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = listeAbonnes.hashCode();
        result = 31 * result + accidents.hashCode();
        result = 31 * result + systemeCommunication.hashCode();
        return result;
    }
}