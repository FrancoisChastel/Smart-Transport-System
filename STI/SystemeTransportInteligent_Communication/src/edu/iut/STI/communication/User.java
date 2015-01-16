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

/****************************************************
 *  SystemeTransportInteligent_Communication          by  Aloysius             *
 *  04/11/14        21:31                           *
 ****************************************************/

package edu.iut.STI.communication;
/**
 * Created by Aloysius on 04/11/14.
 */

import java.sql.SQLException;

public class User {
    private int idUser;
    private String identification;
    private Position position;
    private boolean abonnePanne;
    private boolean abonneAccident;
    private boolean abonneBouchon;
    private boolean abonneMessagePersonnalise;
    private int numTel;

    public User(int idUser, String identification, Position position, boolean abonnePanne, boolean abonneAccident, boolean abonneBouchon, boolean abonneMessagePersonnalise, int numTel) throws SQLException, ClassNotFoundException {
        this.idUser = idUser;
        this.identification = identification;
        this.position = position;
        this.abonnePanne = abonnePanne;
        this.abonneAccident = abonneAccident;
        this.abonneBouchon = abonneBouchon;
        this.abonneMessagePersonnalise = abonneMessagePersonnalise;
        this.numTel = numTel;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean isAbonnePanne() {
        return abonnePanne;
    }

    public void setAbonnePanne(boolean abonnePanne) throws SQLException {
        this.abonnePanne = abonnePanne;
    }

    public boolean isAbonneAccident() {
        return abonneAccident;
    }

    public void setAbonneAccident(boolean abonneAccident) throws SQLException, ClassNotFoundException {
        this.abonneAccident = abonneAccident;
    }

    public boolean isAbonneBouchon() throws SQLException, ClassNotFoundException {
        return abonneBouchon;
    }

    public void setAbonneBouchon(boolean abonneBouchon) throws SQLException {
        this.abonneBouchon = abonneBouchon;
    }

    public boolean isAbonneMessagePersonnalise() {
        return abonneMessagePersonnalise;
    }

    public void setAbonneMessagePersonnalise(boolean abonneMessagePersonnalise) throws SQLException {
        this.abonneMessagePersonnalise = abonneMessagePersonnalise;
    }

    public int getNumTel() {
        return numTel;
    }

    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }
}
    
