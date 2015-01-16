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

import java.sql.SQLException;

/**
 * Thread de rafraichisement de la base de données
 */
public class Refresh implements Runnable {
    private ControlleurModele controlleurModele;
    private boolean run = true;
    //private WebEngine webEngine;

    public Refresh(ControlleurModele controlleurModele) {
        this.controlleurModele = controlleurModele;
        //this.webEngine=webEngine;
    }


    /**
     * Méthode lancé au lancement du Thread
     *
     * Il permet de mettre à jour la base de données tous les 5 secondes
     */
    public void run() {
        System.out.println("Run lancé");
        while (run) {
            try {
                Thread.sleep(5000);

                System.err.println("Refresh de la bdd");
                Utilisateur.updateMemoireMessage(controlleurModele.getMessages());
                Utilisateur.updatePosition(controlleurModele.getPosition(Utilisateur.getId()));

                //AccueilController.refreshMarkers();
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

    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }
}
    
