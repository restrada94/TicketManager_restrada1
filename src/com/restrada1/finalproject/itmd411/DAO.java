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
    PreparedStatement statement = null;

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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connect;
    }

    ResultSet runQuery(String sql){

        ResultSet rs = null;
        try{
            statement = getConnection().prepareStatement(sql);
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
    void createNewTicketTable(){

    }

    void createNewCustomerTable(){

    }
    void create(Ticket ticket){

    }


    void read(String ticketID){
        String sql = "Select * from ticket_table where ticket like '%?%'";
        ResultSet rs = runQuery(sql);

    }

    void update(String ticketID){

    }

    void delete(String ticketID){

    }

}
