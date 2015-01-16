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

public class Message {
    private int nbMots;
    private Position position;
    private int idAutomobiliste;
    private String text;
    private String typeMessage;
    private int id;

    public Message(int nbMots, Position position, int idAutomobiliste, String text, String typeMessage, int id) {
        this.nbMots = nbMots;
        this.position = position;
        this.idAutomobiliste = idAutomobiliste;
        this.text = text;
        this.typeMessage = typeMessage;
        this.id = id;
    }

    public Message(Position position, int idAutomobiliste, String text, String typeMessage, int id) {
        this.nbMots = nbMots;
        this.position = position;
        this.idAutomobiliste = idAutomobiliste;
        this.text = text;
        this.typeMessage = typeMessage;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Message{" +
                "nbMots=" + nbMots +
                ", position=" + position +
                ", vehicule=" + idAutomobiliste +
                ", text='" + text + '\'' +
                ", typeMessage=" + typeMessage +
                ", id=" + id +
                '}';
    }

    public void supprimerMessage() {
        this.nbMots = 0;
        this.position = null;
        this.idAutomobiliste = 0;
        this.text = "";
        this.typeMessage = null;
        this.id = 0;
    }

    public int getNbMots() {
        return nbMots;
    }

    public void setNbMots(int nbMots) {
        this.nbMots = nbMots;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTypeMessage() {
        return typeMessage;
    }

    public void setTypeMessage(String typeMessage) {
        this.typeMessage = typeMessage;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}