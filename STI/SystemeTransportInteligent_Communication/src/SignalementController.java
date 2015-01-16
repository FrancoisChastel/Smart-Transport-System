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

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.SQLException;

/**
 * Created by Francois on 30/10/14.
 */
public class SignalementController {

    /**
     * Champs de text
     */
    @FXML
    private TextField contenuMessage;

    /**
     * Bouton d'evenement, lorsque l'utilisateur clique dessus cela charge la fenetre ACCUEIL
     *
     * @param event Evenement qui declenche le gestionnaire (retourAccueil).
     */
    @FXML
    void retourAccueil(ActionEvent event) {
        VistaNavigator.loadVista(VistaNavigator.ACCUEIL);
    }

    @FXML
    void signalerPanne(ActionEvent event) throws SQLException, ClassNotFoundException {
        Utilisateur.addPanne();
        VistaNavigator.loadVista(VistaNavigator.ACCUEIL);
    }

    @FXML
    void signalerBouchon(ActionEvent event) throws SQLException, ClassNotFoundException {
        Utilisateur.addBouchon();
        VistaNavigator.loadVista(VistaNavigator.ACCUEIL);
    }

    @FXML
    void signalerAccident(ActionEvent event) throws SQLException, ClassNotFoundException {
        Utilisateur.addAccident();
        VistaNavigator.loadVista(VistaNavigator.ACCUEIL);
    }

    /**
     * Lorsque l'on clique sur le bouton envoyerMessage
     * on récupére le contenu du champs Text contenuMessage
     * on ajoute ce message dans la messagerie
     * puis on charge la page d'accueil
     *
     * @param event
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @FXML
    void envoyerMessage(ActionEvent event) throws SQLException, ClassNotFoundException {
        Utilisateur.addMessages(contenuMessage.getText());
        VistaNavigator.loadVista(VistaNavigator.ACCUEIL);
    }
}
