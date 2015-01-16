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

import edu.iut.STI.communication.ControlleurModele;
import edu.iut.STI.communication.TypeMessage;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.sql.SQLException;

/**
 * Created by Francois on 23/10/14.
 */
public class messagesController {

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
    public ListView<String> listeMessages;

    /**
     * Initialise le controller
     * Ensuite on ajoute des elements à cette liste
     */

    /**
     * Initialise le controller (lancé au chargement de messages.fxml)
     * <p>
     * une boucle affiche les messages présent dans la messagerie en
     * fonction des filtres messsages de l'utilisateur
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void initialize() throws SQLException, ClassNotFoundException {
        Utilisateur.updateMemoireMessage(ControlleurModele.getMessages());
        ObservableList<String> messages = listeMessages.getItems();
        for (int i = Utilisateur.getMemoireMessages().size() - 1; i >= 0; i--)//Lecture des messages je decrementes pour avoir les messages dans lordre
        {
            if (Utilisateur.isShowAccidents() && Utilisateur.getMemoireMessages().get(i).getTypeMessage() == TypeMessage.accident) {
                messages.add(Utilisateur.getMemoireMessages().get(i).getContenu() + " à " + i + " km");
            } else if (Utilisateur.isShowBouchons() && Utilisateur.getMemoireMessages().get(i).getTypeMessage() == TypeMessage.bouchon) {
                messages.add(Utilisateur.getMemoireMessages().get(i).getContenu() + " à " + i + " km");

            } else if (Utilisateur.isShowPanne() && Utilisateur.getMemoireMessages().get(i).getTypeMessage() == TypeMessage.panne) {
                messages.add(Utilisateur.getMemoireMessages().get(i).getContenu() + " à " + i + " km");
            } else if (Utilisateur.isShowMessagePersonnalise() && Utilisateur.getMemoireMessages().get(i).getTypeMessage() == TypeMessage.messagePersonnalise) {
                messages.add(Utilisateur.getMemoireMessages().get(i).getContenu() + " par " + Utilisateur.getMemoireMessages().get(i).getIdentification());
            }
        }
    }

    /**
     * Ajouter un message a la liste de message, ne gere pas les messages autres
     * que ceux de la liste, un autre message de type envoye par utilisateur ne contenant
     *
     * @param unMessage   bouchon, panne ...
     * @param uneDistance la distance du message par rapport a la voiture
     */
    public void ajouterMessageOnScreen(String unMessage, int uneDistance) {
        //Messages.add(unMessage + " à " +uneDistance+ " kilométres");
    }

    public void afficherMessage() {

    }


}
