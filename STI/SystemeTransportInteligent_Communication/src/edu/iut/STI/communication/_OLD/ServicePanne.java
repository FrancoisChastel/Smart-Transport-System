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

public class ServicePanne {
    private ArrayList<Vehicule> listeAbonnes;
    private SystemeCommunication systemeCommunication;
    public ArrayList<Panne> pannes;

    public ServicePanne(SystemeCommunication systemeCommunication) {
        this.systemeCommunication = systemeCommunication;
        this.listeAbonnes = new ArrayList<Vehicule>();
        this.pannes = new ArrayList<Panne>();
    }

    public void addPanne(Panne panne) {
        Message message = new Message(panne.getPosition(), panne.getVehicule().getIdVehicule(), "Panne sur le véhicule", null, 0);
        this.pannes.add(panne);
        this.systemeCommunication.contactServiceDepannage(message);

        /*if (message.getId().isAutoroute()){
            this.systemeCommunication.contactServiceDepannage(message);
            this.systemeCommunication.contactServiceVoirie(message);
        }*/
    }

    public void addAbonne(Vehicule vehicule) {
        this.listeAbonnes.add(vehicule);
    }

    public ArrayList<Vehicule> getListeAbonnes() {
        return listeAbonnes;
    }

    public ArrayList<Panne> getPannes() {
        return pannes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServicePanne)) return false;

        ServicePanne that = (ServicePanne) o;

        if (!listeAbonnes.equals(that.listeAbonnes)) return false;
        if (!pannes.equals(that.pannes)) return false;
        if (!systemeCommunication.equals(that.systemeCommunication)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = listeAbonnes.hashCode();
        result = 31 * result + systemeCommunication.hashCode();
        result = 31 * result + pannes.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ServicePanne{" +
                "listeAbonnes=" + listeAbonnes +
                ", systemeCommunication=" + systemeCommunication +
                ", pannes=" + pannes +
                '}';
    }
}