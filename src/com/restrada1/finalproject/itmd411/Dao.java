package com.restrada1.finalproject.itmd411;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("JpaQueryApiInspection")
public class Dao implements Controller{
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

    TicketTemplate retrieveTicket(String ticketID) throws SQLException {
        ResultSet rs = null;
        PreparedStatement statement = null;
        TicketTemplate ticket = null;

        try{
            String sql = "SELECT * FROM r_estrTickets WHERE TICKET_ID = ?";
            statement = getConnection().prepareStatement(sql);
            statement.setString(1, ticketID);
            rs = statement.executeQuery();

            ticket = new Ticket(String.valueOf(rs.getString(1)), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5), rs.getString(6));
            setStatusMessage("Data Retrieved Successfully.");
        } catch (SQLException e){
            setStatusMessage("An SQL Exception Ocurred.");
            e.printStackTrace();
        } catch (Exception e){
            setStatusMessage("An Exception Ocurred.");
            e.printStackTrace();
        } finally {
            statement.close();
            connect.close();
        }
        return ticket;
    }

    void createTicket(TicketTemplate ticket) throws SQLException {
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
            statement.executeQuery();
            setStatusMessage("Ticket Created Successfully.");
        } catch (SQLException e){
            setStatusMessage("An SQL Exception Ocurred.");
            e.printStackTrace();
        } catch (Exception e){
            setStatusMessage("An Exception Ocurred.");
            e.printStackTrace();
        } finally {
            statement.close();
            connect.close();
        }

    }

    void updateTicket(TicketTemplate ticket) throws SQLException {
        PreparedStatement statement = null;
        try {
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
            statement.executeQuery();
            setStatusMessage("Ticket Updated Successfully.");
        } catch (SQLException e){
            setStatusMessage("An SQL Exception Ocurred.");
            e.printStackTrace();
        } catch (Exception e){
            setStatusMessage("An Exception Ocurred.");
            e.printStackTrace();
        } finally {
            statement.close();
            connect.close();
        }
    }

    void deleteTicket(TicketTemplate ticket) throws SQLException {
        PreparedStatement statement = null;
        try {
            String sql = "DELETE * FROM r_estrTickets WHERE TICKET_ID = ?";
            statement = getConnection().prepareStatement(sql);
            statement.setString(1, ticket.getTicketID());
            statement.executeQuery();
            setStatusMessage("Ticket" +ticket.getTicketID()+ "Deleted Successfully.");
        } catch (SQLException e){
            setStatusMessage("An SQL Exception Ocurred.");
            e.printStackTrace();
        } catch (Exception e){
            setStatusMessage("An Exception Ocurred.");
            e.printStackTrace();
        } finally {
            statement.close();
            connect.close();
        }
    }

    List<TicketTemplate> retrieveAllTickets() throws SQLException {
        ResultSet rs = null;
        PreparedStatement statement = null;
        TicketTemplate ticket = null;
        List<TicketTemplate> ticketList = new ArrayList<>();

        try{
            String sql = "SELECT * FROM r_estrTickets";
            statement = getConnection().prepareStatement(sql);
            rs = statement.executeQuery();

            while(rs.next()) {
                ticketList.add(new Ticket(String.valueOf(rs.getString(1)), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6)));
            }
            setStatusMessage("Data Retrieved Successfully.");
        } catch (SQLException e){
            setStatusMessage("An SQL Exception Ocurred.");
            e.printStackTrace();
        } catch (Exception e){
            setStatusMessage("An Exception Ocurred.");
            e.printStackTrace();
        } finally {
            statement.close();
            connect.close();
        }
        return ticketList;
    }

    void createTicketsTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS r_estrTickets (\n" +
                "ticket_id INT AUTO_INCREMENT,\n" +
                "customer_name VARCHAR(50) NOT NULL,\n" +
                "date_time VARCHAR(25),\n" +
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
        } catch (SQLException e){
            setStatusMessage("An SQL Exception Ocurred.");
            e.printStackTrace();
        } catch (Exception e){
            setStatusMessage("An Exception Ocurred.");
            e.printStackTrace();
        } finally {
            statement.close();
            connect.close();
        }
    }
}
