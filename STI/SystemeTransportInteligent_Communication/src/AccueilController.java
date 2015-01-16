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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javax.script.ScriptException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

/**
 * Controller de la Vista1
 */
public class AccueilController {
    /**
     * Bouton d'evenement, lorsque l'utilisateur clique dessus cela charge la fenetre VISTA_2
     *
     * @param event Evenement qui declenche le gestionnaire (nextPane).
     */
    @FXML
    void nextPane(ActionEvent event) throws SQLException, ClassNotFoundException {
        refreshMarkers();
        /*Platform.runLater(new Runnable() {
            @Override
            public void run() {
                    try {
                        Thread.sleep(5000);
                        System.err.println("-----------------");
                        System.err.println("Refresh de la bdd");
                        Utilisateur.updateMemoireMessage(Utilisateur.getControlleurModele().getMessages());
                        Utilisateur.updatePosition(Utilisateur.getControlleurModele().getPosition(Utilisateur.getId()));
                        System.err.println("-----------------");
                        System.err.println("Marqueurs rafraichis");
                        refreshMarkers();
                        System.err.println("-----------------");
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
        });*/
        //VistaNavigator.loadVista(VistaNavigator.VISTA_2);
        //refreshMarkers();
        /*Refresh refresh=new Refresh(new ControlleurModele(), webEngine);
        Thread MonThread = new Thread(refresh);  //creation du thread
        MonThread.start(); //Lancement du thread*/

        /*new Thread(new Runnable() {
            @Override public void run() {
                while (true) {
                    try {
                        Thread.sleep(5000);

                        System.err.println("-----------------");

                        System.err.println("Refresh des markeurs");
                        refreshMarkers();

                        System.err.println("-----------------");
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();*/

        /*Task task = new Task<Void>() {
            @Override public void run() {
                final int max = 1000000;
                while (true) {
                    try {
                        Thread.sleep(5000);

                        System.err.println("-----------------");

                        System.err.println("Refresh des markeurs");
                        refreshMarkers();

                        System.err.println("-----------------");
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            protected Void call() throws Exception {
                return null;
            }
        };


        new Thread(task).start();*/
    }

    /**
     * Ecouteur sur les boutons de l'interface
     * <p>
     * En fonction du bouton sur lequel on clique, on change
     * la page affiché à l'écran en appelant VistaNavigator
     *
     * @param event
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @FXML
    void displayMessages(ActionEvent event) throws SQLException, ClassNotFoundException {
        VistaNavigator.loadVista(VistaNavigator.MESSAGES);
    }

    @FXML
    void displaySignalement(ActionEvent event) {
        VistaNavigator.loadVista(VistaNavigator.SIGNALEMENT);
    }

    @FXML
    void displayParametres(ActionEvent event) {
        VistaNavigator.loadVista(VistaNavigator.PARAMETRES);
    }


    /**
     * Attribution de la WebView
     */
    @FXML
    WebView webView;
    private static WebEngine webEngine;


    public WebEngine getWebEngine() {
        return webEngine;
    }

    /**
     * Initialise le controller avec un WebEngine generant une page web permettant d'afficher "googleMaps.html"
     * docs pour la gestion JavaScript et JavaFX a travers WebEngine https://blogs.oracle.com/javafx/entry/communicating_between_javascript_and_javafx
     */
    public void initialize() throws IOException, ScriptException, NoSuchMethodException, InterruptedException, SQLException, ClassNotFoundException {
        webEngine = webView.getEngine();
        final URL urlGoogleMaps = getClass().getResource("googleMaps.html");
        webEngine.load(urlGoogleMaps.toExternalForm());
        webEngine.setJavaScriptEnabled(true);
    }

    /**
     * Rafrachit les markers GoogleMaps
     * Ils sont affichés en fonction des paramétres
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void refreshMarkers() throws SQLException, ClassNotFoundException {
        webEngine.executeScript("deleteMarkers() ");
        Utilisateur.updatePosition(ControlleurModele.getPosition(Utilisateur.getId()));

        Utilisateur.updateMemoireMessage(ControlleurModele.getMessages());

        /** Lecture des messages je décrementes pour avoir les messages dans l'ordre des postes **/
        for (int i = Utilisateur.getMemoireMessages().size() - 1; i >= 0; i--)
        {
            if (Utilisateur.getMemoireMessages().get(i).getTypeMessage().equals(TypeMessage.accident) && Utilisateur.isShowAccidents())
                ajouterMarker(Utilisateur.getMemoireMessages().get(i).getPosition().getLatitude(), Utilisateur.getMemoireMessages().get(i).getPosition().getLongitude(), Utilisateur.getMemoireMessages().get(i).getContenu(), Utilisateur.getMemoireMessages().get(i).getTypeMessage());

            else if (Utilisateur.getMemoireMessages().get(i).getTypeMessage().equals(TypeMessage.bouchon) && Utilisateur.isShowBouchons())
                ajouterMarker(Utilisateur.getMemoireMessages().get(i).getPosition().getLatitude(), Utilisateur.getMemoireMessages().get(i).getPosition().getLongitude(), Utilisateur.getMemoireMessages().get(i).getContenu(), Utilisateur.getMemoireMessages().get(i).getTypeMessage());

            else if (Utilisateur.getMemoireMessages().get(i).getTypeMessage().equals(TypeMessage.panne) && Utilisateur.isShowPanne())
                ajouterMarker(Utilisateur.getMemoireMessages().get(i).getPosition().getLatitude(), Utilisateur.getMemoireMessages().get(i).getPosition().getLongitude(), Utilisateur.getMemoireMessages().get(i).getContenu(), Utilisateur.getMemoireMessages().get(i).getTypeMessage());
        }
        ajouterMarker(Utilisateur.getPosition().getLatitude(), Utilisateur.getPosition().getLongitude(), "position voiture", TypeMessage.voiture);
    }

    /**
     * Ajoute un Marker à la carte GoogleMaps
     *
     * @param uneLattiude
     * @param uneLongitude
     * @param unContenu
     * @param unType
     */
    public void ajouterMarker(double uneLattiude, double uneLongitude, String unContenu, TypeMessage unType) {
        System.err.println("--------------");
        System.err.println(uneLattiude);
        System.err.println(uneLongitude);
        System.err.println(unType.toString());
        System.err.println("YES");
        System.err.println("--------------");
        webEngine.executeScript(" constructeurMarker( " + uneLattiude + " , " + uneLongitude + " , '" + unContenu + "' , '" + unType.toString() + "') ");
    }
}
