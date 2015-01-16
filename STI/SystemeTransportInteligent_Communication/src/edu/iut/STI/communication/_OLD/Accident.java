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

public class Accident {
    private String informationsAcquises;
    private boolean dossierComplet;
    private boolean accidentFini;
    private boolean accidentConducteurInconnu;
    private Vehicule vehicule;

    public Accident(Vehicule vehicule, String informationsAcquises) {
        this.informationsAcquises = informationsAcquises;
        this.dossierComplet = false;
        this.accidentFini = false;
        this.accidentConducteurInconnu = false;
        this.vehicule = vehicule;
    }

    public Accident(String informationsAcquises, Position position) {
        this.informationsAcquises = informationsAcquises;
        this.dossierComplet = false;
        this.accidentFini = false;
        this.accidentConducteurInconnu = true;
    }

    public String getInformationsAcquises() {
        return informationsAcquises;
    }

    public void setInformationsAcquises(String informationsAcquises) {
        this.informationsAcquises = informationsAcquises;
    }

    public boolean isDossierComplet() {
        return dossierComplet;
    }

    public void setDossierComplet(boolean dossierComplet) {
        this.dossierComplet = dossierComplet;
    }

    public boolean isAccidentFini() {
        return accidentFini;
    }

    public void setAccidentFini(boolean accidentFini) {
        this.accidentFini = accidentFini;
    }

    public boolean isAccidentConducteurInconnu() {
        return accidentConducteurInconnu;
    }

    public void setAccidentConducteurInconnu(boolean accidentConducteurInconnu) {
        this.accidentConducteurInconnu = accidentConducteurInconnu;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    @Override
    public String toString() {
        return "Accident{" +
                "informationsAcquises='" + informationsAcquises + '\'' +
                ", dossierComplet=" + dossierComplet +
                ", accidentFini=" + accidentFini +
                ", accidentConducteurInconnu=" + accidentConducteurInconnu +
                ", vehicule=" + vehicule +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Accident)) return false;

        Accident accident = (Accident) o;

        if (accidentConducteurInconnu != accident.accidentConducteurInconnu) return false;
        if (accidentFini != accident.accidentFini) return false;
        if (dossierComplet != accident.dossierComplet) return false;
        if (!informationsAcquises.equals(accident.informationsAcquises)) return false;
        if (!vehicule.equals(accident.vehicule)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = informationsAcquises.hashCode();
        result = 31 * result + (dossierComplet ? 1 : 0);
        result = 31 * result + (accidentFini ? 1 : 0);
        result = 31 * result + (accidentConducteurInconnu ? 1 : 0);
        result = 31 * result + vehicule.hashCode();
        return result;
    }
}