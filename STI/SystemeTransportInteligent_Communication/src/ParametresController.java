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
import javafx.scene.control.CheckBox;

import java.sql.SQLException;

/**
 * Created by Francois on 30/10/14.
 */
public class ParametresController {

    /**
     * Initialisation des CheckBox *
     */
    @FXML
    protected CheckBox checkBoxAccident;
    @FXML
    protected CheckBox checkBoxBouchon;
    @FXML
    protected CheckBox checkBoxObstacle;
    @FXML
    protected CheckBox checkBoxMessage;


    /**
     * Bouton d'evenement, lorsque l'utilisateur clique dessus cela charge la fenetre ACCUEIL
     *
     * @param event Evenement qui declenche le gestionnaire (retourAccueil).
     */
    @FXML
    void retourAccueil(ActionEvent event) {
        VistaNavigator.loadVista(VistaNavigator.ACCUEIL);
    }

    /**
     * lorsque la checkbox accident est "cliqué" la fonction est appelé
     * si elle est coché alors : on recoit les messages accidents
     * si elle n'est pas coché alors : on ne recoit pas les messages accidents
     *
     * @param event
     */
    @FXML
    void cocheCheckBoxAccident(ActionEvent event) throws SQLException {
        if (checkBoxAccident.isSelected()) {
            Utilisateur.setShowAccidents(true);
        } else if (!checkBoxAccident.isSelected()) {
            Utilisateur.setShowAccidents(false);
        }
    }

    /**
     * lorsque la checkbox bouchon est "cliqué" la fonction est appelé
     * si elle est coché alors : on recoit les messages bouchon
     * si elle n'est pas coché alors : on ne recoit pas les messages bouchon
     *
     * @param event
     */
    @FXML
    void cocheCheckBoxBouchon(ActionEvent event) throws SQLException {
        if (checkBoxBouchon.isSelected()) {
            Utilisateur.setShowBouchon(true);
        } else if (!checkBoxBouchon.isSelected()) {
            Utilisateur.setShowBouchon(false);
        }
    }

    /**
     * lorsque la checkbox obstacle est "cliqué" la fonction est appelé
     * si elle est coché alors : on recoit les messages obstacle
     * si elle n'est pas coché alors : on ne recoit pas les messages obstacle
     *
     * @param event
     */
    @FXML
    void cocheCheckBoxObstacle(ActionEvent event) throws SQLException {
        if (checkBoxObstacle.isSelected()) {
            Utilisateur.setShowPanne(true);
        } else if (!checkBoxObstacle.isSelected()) {
            Utilisateur.setShowPanne(false);
        }
    }

    /**
     * lorsque la checkbox message est "cliqué" la fonction est appelé
     * si elle est coché alors : on recoit les messages des autres usagers
     * si elle n'est pas coché alors : on ne recoit pas les messages des autres usagers
     *
     * @param event
     */
    @FXML
    void cocheCheckBoxMessage(ActionEvent event) throws Throwable {
        if (checkBoxMessage.isSelected()) {
            Utilisateur.setShowMessagePersonnalise(true);
        } else if (!checkBoxMessage.isSelected()) {
            Utilisateur.setShowMessagePersonnalise(false);
        } else {
            throw new Throwable("Erreur systéme");
        }
    }

    /**
     * Méthode appelé lors de l'affichage de la page
     */
    public void initialize() {
        if (Utilisateur.isShowAccidents())
            checkBoxAccident.setSelected(true);

        if (Utilisateur.isShowPanne())
            checkBoxObstacle.setSelected(true);

        if (Utilisateur.isShowBouchons())
            checkBoxBouchon.setSelected(true);

        if (Utilisateur.isShowMessagePersonnalise())
            checkBoxMessage.setSelected(true);
    }

}
