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

/****************************************************
 *  SystemeTransportInteligent_Communication          by  Aloysius             *
 *  15/10/2014        16:53                           *
 ****************************************************/

package edu.iut.STI.communication.Tests;
/**
 * Created by Aloysius on 15/10/2014.
 */

import edu.iut.STI.communication._OLD.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UsersStoriesTestUnits {
    Systeme systeme = new Systeme();
    Automobilisme tim = new Automobilisme("Tim", "Keynes", "06", 1);
    ModeleVehicule porsche = new ModeleVehicule("", "", 1);

    Vehicule vehicule = systeme.addVehicule(tim, porsche);
    Message message1 = new Message(3, new Position(4114, 4141, "", false), vehicule.getIdVehicule(), "Test", null, 12);

    @Test
    public void testReceptionMessage() throws Exception {
        vehicule.addMessage(new Message(3, new Position(4114, 4114, "", false), vehicule.getIdVehicule(), "Test", null, 12));
        vehicule.addMessage(new Message(3, new Position(4114, 4114, "", false), vehicule.getIdVehicule(), "Test", null, 12));
        assertEquals(vehicule.getListeMessages().toString(), "[Message{nbMots=3, position=Position{longitude='', latitude='', positionVoie='', autoroute=false}, vehicule=Vehicule{chocImportant=false, boutonAlerte=false, enPanne=false, enAccident=false, aLarret=true, problemeDetecte=false, autoroute=false, modeleVehicule=ModeleVehicule{nom='', modele='', id=1}, position=null, automobilisme=Automobilisme{nom='Tim', prenom='Keynes', tel='06', id=1}}, text='Test', typeMessage=null, id=12}, Message{nbMots=3, position=Position{longitude='', latitude='', positionVoie='', autoroute=false}, vehicule=Vehicule{chocImportant=false, boutonAlerte=false, enPanne=false, enAccident=false, aLarret=true, problemeDetecte=false, autoroute=false, modeleVehicule=ModeleVehicule{nom='', modele='', id=1}, position=null, automobilisme=Automobilisme{nom='Tim', prenom='Keynes', tel='06', id=1}}, text='Test', typeMessage=null, id=12}]");
    }

    @Test
    public void testEnvoiMessage() throws Exception {
        vehicule.addMessage(new Message(3, new Position(4114, 4114, "", false), vehicule.getIdVehicule(), "Test", null, 12));
        vehicule.addMessage(new Message(3, new Position(4114, 4114, "", false), vehicule.getIdVehicule(), "Test", null, 12));
        assertEquals(vehicule.getListeMessages().toString(), "[Message{nbMots=3, position=Position{longitude='', latitude='', positionVoie='', autoroute=false}, vehicule=Vehicule{chocImportant=false, boutonAlerte=false, enPanne=false, enAccident=false, aLarret=true, problemeDetecte=false, autoroute=false, modeleVehicule=ModeleVehicule{nom='', modele='', id=1}, position=null, automobilisme=Automobilisme{nom='Tim', prenom='Keynes', tel='06', id=1}}, text='Test', typeMessage=null, id=12}, Message{nbMots=3, position=Position{longitude='', latitude='', positionVoie='', autoroute=false}, vehicule=Vehicule{chocImportant=false, boutonAlerte=false, enPanne=false, enAccident=false, aLarret=true, problemeDetecte=false, autoroute=false, modeleVehicule=ModeleVehicule{nom='', modele='', id=1}, position=null, automobilisme=Automobilisme{nom='Tim', prenom='Keynes', tel='06', id=1}}, text='Test', typeMessage=null, id=12}]");
    }

    @Test
    public void testSignalementPanne() throws Exception {
        vehicule.signalerPanne();
        assertEquals(systeme.getSystemeCommunication().getServicePanne().getPannes().toString(), "[Panne{vehicule=Vehicule{chocImportant=false, boutonAlerte=false, enPanne=true, enAccident=false, aLarret=true, problemeDetecte=false, autoroute=false, modeleVehicule=ModeleVehicule{nom='', modele='', id=1}, position=null, automobilisme=Automobilisme{nom='Tim', prenom='Keynes', tel='06', id=1}}, position=null, vehiculeInconnu=false}]");
    }

    @Test
    public void testVehiculeAbonne() throws Exception {
        systeme.getSystemeCommunication().sendMessageAllVehicules(message1);
        assertEquals(vehicule.getListeMessages(), vehicule.getListeMessages());
    }

    @Test
    public void testVehiculePanne() throws Exception {
        vehicule.signalerPanne();
        assertEquals(systeme.getSystemeCommunication().getServicePanne().getPannes().toString(), "[Panne{vehicule=Vehicule{chocImportant=false, boutonAlerte=false, enPanne=true, enAccident=false, aLarret=true, problemeDetecte=false, autoroute=false, modeleVehicule=ModeleVehicule{nom='', modele='', id=1}, position=null, automobilisme=Automobilisme{nom='Tim', prenom='Keynes', tel='06', id=1}}, position=null, vehiculeInconnu=false}]");
    }

    @Test
    public void testVehiculeAccidente() throws Exception {
        vehicule.signalerPanne();
        assertEquals(systeme.getSystemeCommunication().getServicePanne().getPannes().toString(), "[Panne{vehicule=Vehicule{chocImportant=false, boutonAlerte=false, enPanne=true, enAccident=false, aLarret=true, problemeDetecte=false, autoroute=false, modeleVehicule=ModeleVehicule{nom='', modele='', id=1}, position=null, automobilisme=Automobilisme{nom='Tim', prenom='Keynes', tel='06', id=1}}, position=null, vehiculeInconnu=false}]");
    }

    @Test
    public void testProximiteAccident() throws Exception {
        //Non implémenté !
    }
}

