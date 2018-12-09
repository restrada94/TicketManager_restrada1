package com.restrada1.finalproject.itmd411;

import java.sql.*;

public class DAO {
    /**
     * Author: restrada1
     * Class: Ticket.java
     * Description:
     * The TicketTemplate defines the high level behavior by defining abstract method signatures.
     *
     * To statically store Ticket objects, a static hashMap, TicketMap, will contain both the key and the value <String, TicketTemplate>.
     */

    static Connection connect = null;

    {
    CsvReader csvReader = new CsvReader();
    }

    public static Connection getConnection() {
        // Setup the connection with the DB
        try {
            connect = DriverManager
                    .getConnection("jdbc:mysql://www.papademas.net:3307/tickets?autoReconnect=true&useSSL=false"
                            + "&user=fp411&password=411");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connect;
    }

    ResultSet retrieveTicket(TicketTemplate ticket){

        ResultSet rs = null;
        PreparedStatement statement = null;

        try{
            String sql = "SELECT TICKET_ID FROM RE_TICKET_TABLE WHERE TICKET_ID IN('?')";
            statement = getConnection().prepareStatement(sql);
            statement.setString(1, ticket.getTicketID());
            System.out.println("Executing SQL script...");
            rs = statement.executeQuery();
            // end create table
            // close connection/statement object
            statement.close();
            connect.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }

    void createTicket(TicketTemplate ticket){

    }

    void updateTicket(TicketTemplate ticket){

    }

    void deleteTicket(TicketTemplate ticket){

    }

}
