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

public class Panne {
    private Vehicule vehicule;
    private Position position;
    private boolean vehiculeInconnu;

    public Panne(Vehicule vehicule, Position position) {
        this.vehicule = vehicule;
        this.position = position;
        this.vehiculeInconnu = false;
    }

    public Panne(Position position) {
        this.vehiculeInconnu = true;
        this.position = position;
        this.vehicule = null;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean isVehiculeInconnu() {
        return vehiculeInconnu;
    }

    public void setVehiculeInconnu(boolean vehiculeInconnu) {
        this.vehiculeInconnu = vehiculeInconnu;
    }

    @Override
    public String toString() {
        return "Panne{" +
                "vehicule=" + vehicule +
                ", position=" + position +
                ", vehiculeInconnu=" + vehiculeInconnu +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Panne)) return false;

        Panne panne = (Panne) o;

        if (vehiculeInconnu != panne.vehiculeInconnu) return false;
        if (!position.equals(panne.position)) return false;
        if (!vehicule.equals(panne.vehicule)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = vehicule.hashCode();
        result = 31 * result + position.hashCode();
        result = 31 * result + (vehiculeInconnu ? 1 : 0);
        return result;
    }
}