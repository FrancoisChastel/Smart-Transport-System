import edu.iut.STI.communication.ControlleurModele;
import edu.iut.STI.communication.Message;
import edu.iut.STI.communication.Position;
import edu.iut.STI.communication.TypeMessage;
import javafx.scene.web.WebEngine;

import java.sql.SQLException;
import java.util.ArrayList;

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


/**
 * Utilisateur permettant de stocker les messages reçus
 *
 * Nous avons utilisé une classe Abstraite car cette possibilité
 * donné par le langage Java.
 *
 * Cette classe n'est pas instancié
 *
 */
public abstract class Utilisateur {

    private static ArrayList<Message> memoireMessages = new ArrayList<>();
    private static boolean showBouchons = false;
    private static boolean showPanne = false;
    private static boolean showAccidents = false;
    private static boolean showMessagePersonnalise = false;
    private static int id;
    private static Position position;
    private static int numTel;
    private static String identification;
    private static ControlleurModele controlleurModele;
    private static WebEngine webEngine;

    public static void updateMemoireMessage(ArrayList<Message> messages) throws SQLException {
        memoireMessages = null;
        memoireMessages = new ArrayList<Message>();

        for (int i = 0; i < messages.size(); i++) {
            memoireMessages.add(messages.get(i));
        }
    }

    public static void updatePosition(Position position1) {
        setPosition(position1);
    }

    public static WebEngine getWebEngine() {
        return webEngine;
    }

    public static void setWebEngine(WebEngine webEngine) {
        Utilisateur.webEngine = webEngine;
    }

    public static ArrayList<Message> getMemoireMessages() {
        return memoireMessages;
    }

    public static void setMemoireMessages(ArrayList<Message> memoireMessages) {
        Utilisateur.memoireMessages = memoireMessages;

    }

    public static void setShowBouchons(boolean showBouchons) {
        Utilisateur.showBouchons = showBouchons;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Utilisateur.id = id;
    }

    public static Position getPosition() {
        return position;
    }

    public static void setPosition(Position position) {
        Utilisateur.position = position;
    }

    public static int getNumTel() {
        return numTel;
    }

    public static void setNumTel(int numTel) {
        Utilisateur.numTel = numTel;
    }

    public static String getIdentification() {
        return identification;
    }

    public static void setIdentification(String identification) {
        Utilisateur.identification = identification;
    }

    public static ControlleurModele getControlleurModele() {
        return controlleurModele;
    }

    public static void setControlleurModele(ControlleurModele controlleurModele) {
        Utilisateur.controlleurModele = controlleurModele;
    }

    public static void setShowBouchon(boolean showBouchons) throws SQLException {
        Utilisateur.showBouchons = showBouchons;
        controlleurModele.setAbonnementBouchon(showBouchons, id);
    }

    public static void setShowPanne(boolean showPanne) throws SQLException {
        Utilisateur.showPanne = showPanne;
        controlleurModele.setAbonnementPanne(showPanne, id);
    }

    public static void setShowAccidents(boolean showAccidents) throws SQLException {
        Utilisateur.showAccidents = showAccidents;
        controlleurModele.setAbonnementAccident(showAccidents, id);
    }

    public static void setShowMessagePersonnalise(boolean showMessagePersonnalise) throws SQLException {
        Utilisateur.showMessagePersonnalise = showMessagePersonnalise;
        controlleurModele.setAbonnementMessagePersonnalises(showMessagePersonnalise, id);
    }

    /**
     * Accesseurs au boolean de filtrage de messages
     * @return
     */
    public static boolean isShowBouchons() {
        return showBouchons;
    }

    public static boolean isShowPanne() {
        return showPanne;
    }

    public static boolean isShowAccidents() {
        return showAccidents;
    }

    public static boolean isShowMessagePersonnalise() {
        return showMessagePersonnalise;
    }


    public static String getMessages(int i) {
        if (i > memoireMessages.size() || i < 0) {

            //Gestion cas invadilites
        }
        return memoireMessages.get(i).getContenu();
    }

    public static double getLattitude(int i) {
        if (i > memoireMessages.size() || i < 0) {
            //Gestion cas invadilites
        }
        return memoireMessages.get(i).getPosition().getLatitude();
    }

    public static double getLongitude(int i) {
        if (i > memoireMessages.size() || i < 0) {
            //Gestion cas invadilites
        }
        return memoireMessages.get(i).getPosition().getLongitude();
    }

    /**
     * Ajoute un message personnalisée via le controlleurModele de la base de données
     * @param unMessage
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void addMessages(String unMessage) throws SQLException, ClassNotFoundException {
        controlleurModele.addMessage(getId(), unMessage, TypeMessage.messagePersonnalise, getPosition().getLongitude(), getPosition().getLatitude());
        updateMemoireMessage(controlleurModele.getMessagerie().getMessages());
    }

    /**
     * Ajoute un message Accident via le controlleurModele de la base de données
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void addAccident() throws SQLException, ClassNotFoundException {
        controlleurModele.addAccident(getId(), getPosition().getLongitude(), getPosition().getLatitude());
        updateMemoireMessage(controlleurModele.getMessagerie().getMessages());
    }

    /**
     * Ajoute un message Panne via le controlleurModele de la base de données
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void addPanne() throws SQLException, ClassNotFoundException {
        controlleurModele.addPanne(getId(), getPosition().getLongitude(), getPosition().getLatitude());
        updateMemoireMessage(controlleurModele.getMessagerie().getMessages());
    }

    /**
     * Ajoute un message Bouchon via le controlleurModele de la base de données
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void addBouchon() throws SQLException, ClassNotFoundException {
        controlleurModele.addBouchon(getId(), getPosition().getLongitude(), getPosition().getLatitude());
        updateMemoireMessage(controlleurModele.getMessagerie().getMessages());
    }
}
