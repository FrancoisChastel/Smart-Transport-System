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
import edu.iut.STI.communication.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

/** This is a Java document for Education project
 *	Systeme de Transport Intelligent
 *	By Francois Chastel , Alexandre Jalat-Million, Timothy Keynes et Kevin Schieb
 *	Student of University, Nice, France - Students in computer science
 **/


public class Main extends Application {

    /**
     * Définie une page principal ayant pour référence main.fxml
     * se situera à l'intérieur les différents écran affichées
     * il sert de "zone de chargement" des écrans ou de "parents"
     *
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Systéme de Transport Intelligent - Démonstration V1.0");

        stage.setScene(
                createScene(
                        loadMainPane()
                )
        );

        stage.show();
    }

    /**
     * Charge le fichier main fxml.
     * Charge le navigateur de page VistaNagigator.
     * Charge le premier écran dans la zone fxml parent.
     *
     * @return la page chargé.
     * @throws IOException if the pane could not be loaded.
     */
    private Pane loadMainPane() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        Pane mainPane = (Pane) loader.load(
                getClass().getResourceAsStream(
                        VistaNavigator.MAIN
                )
        );

        MainController mainController = loader.getController();

        VistaNavigator.setMainController(mainController);
        VistaNavigator.loadVista(VistaNavigator.ACCUEIL);

        return mainPane;
    }

    /**
     * Créer l'application principal d'affichage.
     * Charge le CSS pour tous les écrans.
     *
     * @param mainPane l'application principal.
     * @return the created scene.
     */
    private Scene createScene(Pane mainPane) {
        Scene scene = new Scene(
                mainPane
        );

        scene.getStylesheets().setAll(
                getClass().getResource("style.css").toExternalForm()
        );

        return scene;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        /**
         * T_Unitaire : Création des messages avec leurs coordonnées et leurs contenues
         */
        /*Message message=new Message(45,null,445,"Accident signalé", TypeMessage.accident,new Position(37545454,4555445));
        Message message2=new Message(45,null,445,"Bouchon signalé", TypeMessage.bouchon,new Position(37545454,4555445));
        Message message3=new Message(45,null,445,"Panne signalé", TypeMessage.panne,new Position(37545454,4555445));
        Message message4=new Message(45,null,445,"Accident signalé A", TypeMessage.accident,new Position(37545454,4555445));
        Message message5=new Message(45,null,445,"Accident signalé B", TypeMessage.accident,new Position(37545454,4555445));
        Message message6=new Message(45,null,445,"Accident signalé C", TypeMessage.accident,new Position(37545454,4555445));*/
        /**
         * T_Unitaire : Création de la messagerie réceptionnant les messages et les stockant dans la mémoire
         */
        /*Utilisateur.addMessages(message);
        Utilisateur.addMessages(message2);
        Utilisateur.addMessages(message3);
        Utilisateur.addMessages(message4);
        Utilisateur.addMessages(message5);
        Utilisateur.addMessages(message6);*/

        //Choix de la connection avec quel compte ! 1 pour tim / 2 pour francois
        int idUser = 1;

        ControlleurModele controlleurModele = new ControlleurModele();
        User user = controlleurModele.getUser(idUser);
        Utilisateur.setControlleurModele(controlleurModele);
        Utilisateur.setShowPanne(user.isAbonnePanne());
        Utilisateur.setShowAccidents(user.isAbonnePanne());
        Utilisateur.setShowBouchon(user.isAbonneBouchon());
        Utilisateur.setShowMessagePersonnalise(user.isAbonneMessagePersonnalise());
        Utilisateur.setId(user.getIdUser());
        Utilisateur.setIdentification(user.getIdentification());
        Utilisateur.setNumTel(user.getNumTel());
        Utilisateur.setPosition(user.getPosition());

        //Utilisateur.addMessages(new Message(1,null,300,"test",TypeMessage.accident,new Position(43.415005,7.161078)));
        Utilisateur.updateMemoireMessage(controlleurModele.getMessages());
        //System.err.println(Utilisateur.getMemoireMessages().size());

        //AccueilController vista1Controller=new AccueilController();

        /*Refresh refresh=new Refresh(controlleurModele);
        Thread MonThread = new Thread(refresh);  //creation du thread
        MonThread.start (); //Lancement du thread*/
        launch(args);
    }
}
