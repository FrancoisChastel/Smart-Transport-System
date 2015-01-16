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

public class ServiceExterne {
    private ArrayList<Message> listeMessage;
    private String telService;
    private String nomService;
    private ServiceMessagerie serviceMessagerie;

    public ServiceExterne(String telService, String nomService, ServiceMessagerie serviceMessagerie) {
        this.listeMessage = new ArrayList<Message>();
        this.telService = telService;
        this.nomService = nomService;
        this.serviceMessagerie = serviceMessagerie;
    }

    public void addMessage(Message message) {
        this.listeMessage.add(message);
    }

    @Override
    public String toString() {
        return "ServiceExterne{" +
                "listeMessage=" + listeMessage +
                ", telService='" + telService + '\'' +
                ", nomService='" + nomService + '\'' +
                ", serviceMessagerie=" + serviceMessagerie +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiceExterne)) return false;

        ServiceExterne that = (ServiceExterne) o;

        if (!listeMessage.equals(that.listeMessage)) return false;
        if (!nomService.equals(that.nomService)) return false;
        if (!serviceMessagerie.equals(that.serviceMessagerie)) return false;
        if (!telService.equals(that.telService)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = listeMessage.hashCode();
        result = 31 * result + telService.hashCode();
        result = 31 * result + nomService.hashCode();
        result = 31 * result + serviceMessagerie.hashCode();
        return result;
    }
}
