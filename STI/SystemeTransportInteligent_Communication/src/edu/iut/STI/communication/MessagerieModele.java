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

package edu.iut.STI.communication;

import java.util.ArrayList;

public class MessagerieModele {

    private ArrayList<Message> messages = new ArrayList<>();

    private ArrayList<User> users = new ArrayList<>();
    /*private ArrayList<User> abonnesPanne=new ArrayList<>();
    private ArrayList<User> abonnesAccident=new ArrayList<>();
    private ArrayList<User> abonnesMessagesPersonnalises=new ArrayList<>();
    private ArrayList<User> anonnesBouchon=new ArrayList<>();*/

    public MessagerieModele(ArrayList<User> users, ArrayList<Message> messages) {
        this.users.addAll(users);
        this.messages.addAll(messages);
    }

    public void addMessage(Message message) {
        this.messages.add(message);
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    /*public ArrayList<User> getAbonnesPanne() {
        return abonnesPanne;
    }

    public void setAbonnesPanne(ArrayList<User> abonnesPanne) {
        this.abonnesPanne = abonnesPanne;
    }

    public ArrayList<User> getAbonnesAccident() {
        return abonnesAccident;
    }

    public void setAbonnesAccident(ArrayList<User> abonnesAccident) {
        this.abonnesAccident = abonnesAccident;
    }

    public ArrayList<User> getAbonnesMessagesPersonnalises() {
        return abonnesMessagesPersonnalises;
    }

    public void setAbonnesMessagesPersonnalises(ArrayList<User> abonnesMessagesPersonnalises) {
        this.abonnesMessagesPersonnalises = abonnesMessagesPersonnalises;
    }

    public ArrayList<User> getAnonnesBouchon() {
        return anonnesBouchon;
    }

    public void setAnonnesBouchon(ArrayList<User> anonnesBouchon) {
        this.anonnesBouchon = anonnesBouchon;
    }*/
}
    
