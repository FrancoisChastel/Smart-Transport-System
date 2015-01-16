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

package edu.iut.STI.communication._OLD;

import java.util.ArrayList;

public class SystemeCommunication {
    private ServiceMessagerie serviceMessagerie;
    private ServiceContactSysteme serviceContactSysteme;
    private ServicePanne servicePanne;
    private ServiceAccident serviceAccident;
    private ArrayList<Vehicule> vehicules;

    private ServiceSecours serviceSecours;
    private ServiceDepanage serviceDepanage;
    private ServiceVoirie serviceVoirie;
    private ServicePriseContact servicePriseContact;

    public SystemeCommunication(ArrayList<Vehicule> vehicules) {
        this.vehicules = vehicules;

        this.serviceMessagerie = new ServiceMessagerie(vehicules);

        this.serviceContactSysteme = new ServiceContactSysteme(serviceMessagerie);
        this.servicePanne = new ServicePanne(this);
        this.serviceAccident = new ServiceAccident(this);

        this.serviceSecours = new ServiceSecours("", "", serviceMessagerie);
        this.serviceDepanage = new ServiceDepanage("", "", serviceMessagerie);
        this.serviceVoirie = new ServiceVoirie("", "", serviceMessagerie);
        this.servicePriseContact = new ServicePriseContact("", "", serviceMessagerie);
    }

    public void sendMessageAllVehicules(Message message) {
        this.serviceMessagerie.sendMessageAllVehicules(message);
    }

    public void sendMessageVehicule(Vehicule vehicule, Message message) {
        this.serviceMessagerie.sendMessageVehicule(vehicule, message);
    }

    public void sendMessageListeVehicule(Message message, ArrayList<Vehicule> vehicules) {
        this.serviceMessagerie.sendMessageListeVehicule(message, vehicules);
    }

    public void contactServiceDepannage(Message message) {
        this.serviceMessagerie.sendMessageServiceExterne(message, serviceDepanage);
    }

    public void contactServiceVoirie(Message message) {
        this.serviceMessagerie.sendMessageServiceExterne(message, serviceVoirie);
    }


    public ServiceMessagerie getServiceMessagerie() {
        return serviceMessagerie;
    }

    public void setServiceMessagerie(ServiceMessagerie serviceMessagerie) {
        this.serviceMessagerie = serviceMessagerie;
    }

    public ServiceContactSysteme getServiceContactSysteme() {
        return serviceContactSysteme;
    }

    public void setServiceContactSysteme(ServiceContactSysteme serviceContactSysteme) {
        this.serviceContactSysteme = serviceContactSysteme;
    }

    public ServicePanne getServicePanne() {
        return servicePanne;
    }

    public void setServicePanne(ServicePanne servicePanne) {
        this.servicePanne = servicePanne;
    }

    public ServiceAccident getServiceAccident() {
        return serviceAccident;
    }

    public void setServiceAccident(ServiceAccident serviceAccident) {
        this.serviceAccident = serviceAccident;
    }

    public ArrayList<Vehicule> getVehicules() {
        return vehicules;
    }

    public void setVehicules(ArrayList<Vehicule> vehicules) {
        this.vehicules = vehicules;
    }

    public ServiceSecours getServiceSecours() {
        return serviceSecours;
    }

    public void setServiceSecours(ServiceSecours serviceSecours) {
        this.serviceSecours = serviceSecours;
    }

    public ServiceDepanage getServiceDepanage() {
        return serviceDepanage;
    }

    public void setServiceDepanage(ServiceDepanage serviceDepanage) {
        this.serviceDepanage = serviceDepanage;
    }

    public ServiceVoirie getServiceVoirie() {
        return serviceVoirie;
    }

    public void setServiceVoirie(ServiceVoirie serviceVoirie) {
        this.serviceVoirie = serviceVoirie;
    }

    public ServicePriseContact getServicePriseContact() {
        return servicePriseContact;
    }

    public void setServicePriseContact(ServicePriseContact servicePriseContact) {
        this.servicePriseContact = servicePriseContact;
    }

    @Override
    public String toString() {
        return "SystemeCommunication{" +
                "serviceMessagerie=" + serviceMessagerie +
                ", serviceContactSysteme=" + serviceContactSysteme +
                ", servicePanne=" + servicePanne +
                ", serviceAccident=" + serviceAccident +
                ", vehicules=" + vehicules +
                ", serviceSecours=" + serviceSecours +
                ", serviceDepanage=" + serviceDepanage +
                ", serviceVoirie=" + serviceVoirie +
                ", servicePriseContact=" + servicePriseContact +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SystemeCommunication)) return false;

        SystemeCommunication that = (SystemeCommunication) o;

        if (!serviceAccident.equals(that.serviceAccident)) return false;
        if (!serviceContactSysteme.equals(that.serviceContactSysteme)) return false;
        if (!serviceDepanage.equals(that.serviceDepanage)) return false;
        if (!serviceMessagerie.equals(that.serviceMessagerie)) return false;
        if (!servicePanne.equals(that.servicePanne)) return false;
        if (!servicePriseContact.equals(that.servicePriseContact)) return false;
        if (!serviceSecours.equals(that.serviceSecours)) return false;
        if (!serviceVoirie.equals(that.serviceVoirie)) return false;
        if (!vehicules.equals(that.vehicules)) return false;

        return true;
    }

}