package com.restrada1.finalproject.itmd411;

import java.sql.*;

@SuppressWarnings("JpaQueryApiInspection")
public class Dao {
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
            String sql = "SELECT * FROM r_estrTickets WHERE TICKET_ID = ?";
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
        PreparedStatement statement = null;
        try{
            String sql = "SELECT * FROM r_estrTickets WHERE TICKET_ID = ?";
            statement = getConnection().prepareStatement(sql);
            statement.setString(1, ticket.getTicketID());
            System.out.println("Executing SQL script...");
            statement.executeQuery();
            // end create table
            // close connection/statement object
            statement.close();
            connect.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    void updateTicket(TicketTemplate ticket){
        PreparedStatement statement = null;
        try{
            String sql = "SELECT * FROM r_estrTickets WHERE TICKET_ID = ?";
            statement = getConnection().prepareStatement(sql);
            statement.setString(1, ticket.getTicketID());
            System.out.println("Executing SQL script...");
            statement.executeQuery();
            // end create table
            // close connection/statement object
            statement.close();
            connect.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    void deleteTicket(TicketTemplate ticket){
        PreparedStatement statement = null;
        try{
            String sql = "SELECT * FROM r_estrTickets WHERE TICKET_ID = ?";
            statement = getConnection().prepareStatement(sql);
            statement.setString(1, ticket.getTicketID());
            System.out.println("Executing SQL script...");
            statement.executeQuery();
            // end create table
            // close connection/statement object
            statement.close();
            connect.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    void createTicketsTable(){
        String sql = "CREATE TABLE IF NOT EXISTS r_estrTickets (\n" +
                "ticket_id INT AUTO_INCREMENT,\n" +
                "customer_name VARCHAR(50) NOT NULL,\n" +
                "date_time DATE,\n" +
                "status VARCHAR(1) NOT NULL,\n" +
                "priority INT(1) NOT NULL,\n" +
                "description VARCHAR(255),\n" +
                "PRIMARY KEY (ticket_id)\n" +
                ")";
                PreparedStatement statement = null;
        try{
            statement = getConnection().prepareStatement(sql);
            System.out.println("Executing SQL script...");
            statement.executeQuery();
            statement.close();
            connect.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
//    private String ticketID;
//    private String customerName;
//    private String dateTime;
//    private String description;
//    private String isResolved;
//    private String priority;