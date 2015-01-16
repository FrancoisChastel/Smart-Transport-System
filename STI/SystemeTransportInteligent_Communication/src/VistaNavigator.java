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

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;

/**
 * Classe Utilitaire pour controler la navigation entre les fenetres.
 * <p>
 * Toutes les methodes sont static pour faciliter
 * l'acces de ces methodes dans toute l'applications.
 */
public class VistaNavigator {

    /**
     * Constantes pour l'affichage des FXML geres par le navigateur
     */
    public static final String MAIN = "main.fxml";
    public static final String ACCUEIL = "accueil.fxml";
    public static final String VISTA_2 = "sos.fxml";
    public static final String MESSAGES = "messages.fxml";
    public static final String SIGNALEMENT = "signalement.fxml";
    public static final String PARAMETRES = "parametres.fxml";

    /**
     * Controller MainController.
     */
    private static MainController mainController;

    /**
     * Instancie le MainController pour l'utilisation dans des taches de navigation.
     *
     * @param mainController
     */
    public static void setMainController(MainController mainController) {
        VistaNavigator.mainController = mainController;
    }

    /**
     * Charge le vista spécifié par le fichier de FXML dans le
     * VistaHolder volet de l'application principale disposition.
     *
     * Les fenetres auparavant chargée ne sont pour le meme fichier FXML ne sont pas mit en cache (optimisation)
     * Le FXML est chargé de nouveau et une nouvelle hiérarchie de noeud des fenetres est généré
     * Chaque fois que cette méthode est appelée.
     *
     * @param fxml le fichier FXML qui doit etre chargé.
     */
    public static void loadVista(String fxml) {
        try {
            mainController.setVista(
                    (Node) FXMLLoader.load(
                            VistaNavigator.class.getResource(
                                    fxml
                            )
                    )
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}