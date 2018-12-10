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

    //done
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
    //done
    TicketTemplate retrieveTicket(String ticketID){
        ResultSet rs = null;
        PreparedStatement statement = null;
        TicketTemplate ticket = null;

        try{
            String sql = "SELECT * FROM r_estrTickets WHERE TICKET_ID = ?";
            statement = getConnection().prepareStatement(sql);
            statement.setString(1, ticketID);
            System.out.println("Executing SQL script...");
            rs = statement.executeQuery();

            ticket = new Ticket(String.valueOf(rs.getString(1)), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5), rs.getString(6));
            //    private String ticketID;
//    private String customerName;
//    private String dateTime;
//    private String description;
//    private String isResolved;
//    private String priority;
//        "ticket_id INT AUTO_INCREMENT,\n" +
//                "customer_name VARCHAR(50) NOT NULL,\n" +
//                "date_time DATE,\n" +
//                "is_resolved VARCHAR(1) NOT NULL,\n" +
//                "priority TINYINT(1) NOT NULL,\n" +
//                "description VARCHAR(255),\n" +
            statement.close();
            connect.close();
        } catch (SQLException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return ticket;
    }

    void createTicket(TicketTemplate ticket){
       PreparedStatement statement = null;
        try{
            String sql = "INSERT INTO r_estrTickets " +
                    "SET customer_name = ?, date_time = ?, is_resolved = ?, priority = ?, description = ?";
            statement = getConnection().prepareStatement(sql);
            statement.setString(1, ticket.getCustomerName());
            statement.setString(2, ticket.getDateTime());
            statement.setString(3, ticket.getIsResolved());
            statement.setString(4, ticket.getPriority());
            statement.setString(5, ticket.getDescription());
            System.out.println("Executing SQL script...");
            statement.executeQuery();
            statement.close();
            connect.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    //Done
    void updateTicket(TicketTemplate ticket){
        PreparedStatement statement = null;
        try{
            String sql = "UPDATE r_estrTickets " +
                    "SET customer_name = ?, date_time = ?, is_resolved = ?, priority = ?, description = ?" +
                    "WHERE ticket_id = ?";
            statement = getConnection().prepareStatement(sql);
            statement.setString(1, ticket.getCustomerName());
            statement.setString(2, ticket.getDateTime());
            statement.setString(3, ticket.getIsResolved());
            statement.setString(4, ticket.getPriority());
            statement.setString(5, ticket.getDescription());
            statement.setString(6, ticket.getTicketID());
            System.out.println("Executing SQL script...");
            statement.executeQuery();
            statement.close();
            connect.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    void deleteTicket(TicketTemplate ticket){
        PreparedStatement statement = null;
        try{
            String sql = "DELETE * FROM r_estrTickets WHERE TICKET_ID = ?";
            statement = getConnection().prepareStatement(sql);
            statement.setString(1, ticket.getTicketID());
            System.out.println("Deleted record: " + ticket.toString());
            statement.executeQuery();
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
                "date_time VARCHAR(50),\n" +
                "is_resolved VARCHAR(1) NOT NULL,\n" +
                "priority TINYINT(1) NOT NULL,\n" +
                "description VARCHAR(255),\n" +
                "PRIMARY KEY (ticket_id)\n" +
                ")";
                PreparedStatement statement = null;
        try{
            statement = getConnection().prepareStatement(sql);
            statement.executeQuery();
            System.out.println("Table created");
            statement.close();
            connect.close();
        } catch (SQLException e){
            System.out.println("Table might already exist." + e);
        }
    }
}
