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

package edu.iut.STI.communication;

import java.sql.*;
import java.util.ArrayList;

public class ControlleurModele {
    private static final String DB_URL = "jdbc:mysql://localhost";
    private static final String USER = "root";
    private static final String PASS = "";
    private static Connection conn = null;
    private static Statement stmt = null;
    private static MessagerieModele messagerie;

    public ControlleurModele() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        this.messagerie = new MessagerieModele(getUsers(), getMessages());
    }

    public static void addMessage(int idAuteur, String contenu, TypeMessage typeMessage, double latitude, double longitude) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO sti.Messagerie" +
                "(idAuteur, contenu, typeMessage, latitude, longitude) VALUES" +
                "(" + idAuteur + ",'" + contenu + "','" + typeMessage.toString() + "'," + latitude + "," + longitude + ")";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.executeUpdate(sql);
    }

    public static void addAccident(int idAuteur, double latitude, double longitude) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO sti.Messagerie" +
                "(idAuteur, contenu, typeMessage, latitude, longitude) VALUES" +
                "(" + idAuteur + ",'Accident signalé !','accident'," + latitude + "," + longitude + ")";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.executeUpdate(sql);
    }

    public static void addPanne(int idAuteur, double latitude, double longitude) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO sti.Messagerie" +
                "(idAuteur, contenu, typeMessage, latitude, longitude) VALUES" +
                "(" + idAuteur + ",'Panne signalée !','panne'," + latitude + "," + longitude + ")";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.executeUpdate(sql);
    }

    public static void addBouchon(int idAuteur, double latitude, double longitude) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO sti.Messagerie" +
                "(idAuteur, contenu, typeMessage, latitude, longitude) VALUES" +
                "(" + idAuteur + ",'Bouchon signalé !','bouchon'," + latitude + "," + longitude + ")";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.executeUpdate(sql);
    }

    public int getNbMessagesBdd() throws SQLException {
        int nbMessage = 0;
        String sql = "SELECT COUNT(sti.Messagerie.idMessage) as nb FROM sti.Messagerie";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            nbMessage = rs.getInt("nb");
        }
        return nbMessage;
    }

    public static ArrayList<Message> getMessages() throws SQLException, ClassNotFoundException {
        ArrayList<Message> collection = new ArrayList<Message>();
        stmt = conn.createStatement();
        String sql;
        sql = "SELECT * FROM sti.Messagerie";
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            int idMessage = rs.getInt("idMessage");
            int idAuteur = rs.getInt("idAuteur");
            String contenu = rs.getString("contenu");
            String typeMessage = rs.getString("typeMessage");
            double latitude = rs.getDouble("latitude");
            double longitude = rs.getDouble("longitude");

            Position position = new Position(longitude, latitude);

            collection.add(new Message(idAuteur, null, idMessage, contenu, typeMessage(typeMessage), position));
        }
        //System.err.println("Taille du retour"+collection.size());
        return collection;
    }

    public static ArrayList<User> getUsers() throws SQLException, ClassNotFoundException {
        ArrayList<User> users = new ArrayList<>();
        stmt = conn.createStatement();
        String sql;
        sql = "SELECT * FROM sti.User";
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            int idUser = rs.getInt("idUser");
            double longitude = rs.getDouble("longitude");
            double latitude = rs.getDouble("latitude");
            boolean panneMessage = rs.getBoolean("panneMessage");
            boolean accidentMessage = rs.getBoolean("accidentMessage");
            boolean messagePersonnalise = rs.getBoolean("messagePersonnalise");
            int numTel = rs.getInt("numTel");
            String identification = rs.getString("identification");
            boolean bouchonMessage = rs.getBoolean("bouchonMessage");

            Position position = new Position(longitude, latitude);
            users.add(new User(idUser, identification, position, panneMessage, accidentMessage, bouchonMessage, messagePersonnalise, numTel));
        }
        return users;
    }

    public static String getIdentifiantMessage(int idUser) throws SQLException {
        String result = "";
        stmt = conn.createStatement();
        String sql;
        sql = String.format("SELECT DISTINCT User.identification FROM sti.User, sti.Messagerie WHERE Messagerie.idAuteur=" + idUser + " AND Messagerie.idAuteur=User.idUser");
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            result = rs.getString("identification");
        }
        return result;
    }


    public static boolean isPanneMessage(int idUser) throws SQLException, ClassNotFoundException {
        ArrayList<Message> collection = new ArrayList<Message>();
        stmt = conn.createStatement();
        String sql;
        sql = "SELECT panneMessage FROM sti.User WHERE idUser=" + idUser;
        ResultSet rs = stmt.executeQuery(sql);
        boolean is = false;
        while (rs.next()) {
            is = rs.getBoolean("panneMessage");
        }
        return is;
    }

    public static boolean isAccidentMessage(int idUser) throws SQLException, ClassNotFoundException {
        ArrayList<Message> collection = new ArrayList<Message>();
        stmt = conn.createStatement();
        String sql;
        sql = "SELECT accidentMessage FROM sti.User WHERE idUser=" + idUser;
        ResultSet rs = stmt.executeQuery(sql);
        boolean is = false;
        while (rs.next()) {
            is = rs.getBoolean("panneMessage");
        }
        return is;
    }

    public static boolean isMessagePersonnalise(int idUser) throws SQLException, ClassNotFoundException {
        ArrayList<Message> collection = new ArrayList<Message>();
        stmt = conn.createStatement();
        String sql;
        sql = "SELECT messagePersonnalise FROM sti.User WHERE idUser=" + idUser;
        ResultSet rs = stmt.executeQuery(sql);
        boolean is = false;
        while (rs.next()) {
            is = rs.getBoolean("panneMessage");
        }
        return is;
    }

    public static boolean isBouchonMessage(int idUser) throws SQLException, ClassNotFoundException {
        ArrayList<Message> collection = new ArrayList<Message>();
        stmt = conn.createStatement();
        String sql;
        sql = "SELECT bouchonMessage FROM sti.User WHERE idUser=" + idUser;
        ResultSet rs = stmt.executeQuery(sql);
        boolean is = false;
        while (rs.next()) {
            is = rs.getBoolean("panneMessage");
        }
        return is;
    }

    public static TypeMessage typeMessage(String typeMessage) {
        if (typeMessage.equals("accident")) return TypeMessage.accident;
        if (typeMessage.equals("bouchon")) return TypeMessage.bouchon;
        if (typeMessage.equals("panne")) return TypeMessage.panne;
        if (typeMessage.equals("messagePersonnalise")) return TypeMessage.messagePersonnalise;

        return TypeMessage.inconnu;
    }

    public MessagerieModele getMessagerie() {
        return messagerie;
    }

    public User getUser(int id) throws SQLException, ClassNotFoundException {
        User user = null;
        stmt = conn.createStatement();
        String sql;
        sql = "SELECT * FROM sti.User WHERE idUser=" + id;
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            int idUser = rs.getInt("idUser");
            double longitude = rs.getDouble("longitude");
            double latitude = rs.getDouble("latitude");
            boolean panneMessage = rs.getBoolean("panneMessage");
            boolean accidentMessage = rs.getBoolean("accidentMessage");
            boolean messagePersonnalise = rs.getBoolean("messagePersonnalise");
            int numTel = rs.getInt("numTel");
            String identification = rs.getString("identification");
            boolean bouchonMessage = rs.getBoolean("bouchonMessage");
            user = new User(id, identification, new Position(longitude, latitude), panneMessage, accidentMessage, bouchonMessage, messagePersonnalise, numTel);
        }

        return user;
    }

    public static Position getPosition(int id) throws SQLException, ClassNotFoundException {
        User user = null;
        stmt = conn.createStatement();
        String sql;
        sql = "SELECT * FROM sti.User WHERE idUser=" + id;
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            int idUser = rs.getInt("idUser");
            double longitude = rs.getDouble("longitude");
            double latitude = rs.getDouble("latitude");
            boolean panneMessage = rs.getBoolean("panneMessage");
            boolean accidentMessage = rs.getBoolean("accidentMessage");
            boolean messagePersonnalise = rs.getBoolean("messagePersonnalise");
            int numTel = rs.getInt("numTel");
            String identification = rs.getString("identification");
            boolean bouchonMessage = rs.getBoolean("bouchonMessage");
            user = new User(id, identification, new Position(latitude, longitude), panneMessage, accidentMessage, bouchonMessage, messagePersonnalise, numTel);
        }

        return user.getPosition();
    }

    public static String getIdentification(int id) throws SQLException, ClassNotFoundException {
        User user = null;
        stmt = conn.createStatement();
        String sql;
        sql = "SELECT * FROM sti.User WHERE idUser=" + id;
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            int idUser = rs.getInt("idUser");
            double longitude = rs.getDouble("longitude");
            double latitude = rs.getDouble("latitude");
            boolean panneMessage = rs.getBoolean("panneMessage");
            boolean accidentMessage = rs.getBoolean("accidentMessage");
            boolean messagePersonnalise = rs.getBoolean("messagePersonnalise");
            int numTel = rs.getInt("numTel");
            String identification = rs.getString("identification");
            boolean bouchonMessage = rs.getBoolean("bouchonMessage");
            user = new User(id, identification, new Position(latitude, longitude), panneMessage, accidentMessage, bouchonMessage, messagePersonnalise, numTel);
        }

        return user.getIdentification();
    }

    public void setAbonnementPanne(boolean b, int id) throws SQLException {
        String sql = "UPDATE sti.User SET panneMessage=" + b + " WHERE idUser=" + id;

        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.executeUpdate(sql);
    }

    public void setAbonnementAccident(boolean b, int id) throws SQLException {
        String sql = "UPDATE sti.User SET accidentMessage=" + b + " WHERE idUser=" + id;

        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.executeUpdate(sql);
    }

    public void setAbonnementBouchon(boolean b, int id) throws SQLException {
        String sql = "UPDATE sti.User SET bouchonMessage=" + b + " WHERE idUser=" + id;

        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.executeUpdate(sql);
    }

    public void setAbonnementMessagePersonnalises(boolean b, int id) throws SQLException {
        String sql = "UPDATE sti.User SET messagePersonnalise=" + b + " WHERE idUser=" + id;

        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.executeUpdate(sql);
    }
}
