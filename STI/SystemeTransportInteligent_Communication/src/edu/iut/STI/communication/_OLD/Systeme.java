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

public class Systeme {
    public SystemeCommunication systemeCommunication;
    public ArrayList<Vehicule> vehicules;

    public Systeme() {
        vehicules = new ArrayList<Vehicule>();
        systemeCommunication = new SystemeCommunication(vehicules);
    }

    public Vehicule addVehicule(Automobilisme automobilisme, ModeleVehicule modeleVehicule) {
        Vehicule vehicule = new Vehicule(automobilisme.getId(), modeleVehicule, this);
        this.vehicules.add(vehicule);
        return vehicule;
    }

    public SystemeCommunication getSystemeCommunication() {
        return systemeCommunication;
    }

    @Override
    public String toString() {
        return "Systeme{" +
                "systemeCommunication=" + systemeCommunication +
                ", vehicules=" + vehicules +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Systeme)) return false;

        Systeme systeme = (Systeme) o;

        if (!systemeCommunication.equals(systeme.systemeCommunication)) return false;
        if (!vehicules.equals(systeme.vehicules)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = systemeCommunication.hashCode();
        result = 31 * result + vehicules.hashCode();
        return result;
    }
}