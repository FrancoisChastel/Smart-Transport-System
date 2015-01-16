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

public class ServiceMessagerie {
    private ArrayList<Vehicule> vehicules;

    public ServiceMessagerie(ArrayList<Vehicule> vehicules) {
        this.vehicules = vehicules;
    }

    public void sendMessageVehicule(Vehicule vehicule, Message message) {
        vehicule.addMessage(message);
    }

    public void sendMessageListeVehicule(Message message, ArrayList<Vehicule> vehicules) {
        //@todo gerer les exceptions -> Pas de vehicule, 1 vehicule...
        for (int i = 0; i < vehicules.size(); i++) {
            vehicules.get(i).addMessage(message);
        }
    }

    public void sendMessageAllVehicules(Message message) {
        //@todo gerer les exceptions -> Pas de vehicule, 1 vehicule...
        if (vehicules.size() == 0) {
        } else
            for (int i = 0; i < this.vehicules.size(); i++) {
                this.vehicules.get(i).addMessage(message);
            }
    }

    public void sendMessageAllVehiculesSecteur(Message message, Position position) {
        //@todo gerer les exceptions -> Pas de vehicule, 1 vehicule...
        //@todo Gerer la secteur
        for (int i = 0; i < this.vehicules.size(); i++) {
            this.vehicules.get(i).addMessage(message);
        }
    }

    public void sendMessageServiceExterne(Message message, ServiceExterne serviceExterne) {
        serviceExterne.addMessage(message);
    }

    @Override
    public String toString() {
        return "ServiceMessagerie{" +
                "vehicules=" + vehicules +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiceMessagerie)) return false;

        ServiceMessagerie that = (ServiceMessagerie) o;

        if (vehicules != null ? !vehicules.equals(that.vehicules) : that.vehicules != null) return false;

        return true;
    }
}