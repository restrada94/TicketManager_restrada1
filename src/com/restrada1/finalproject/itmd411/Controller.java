package com.restrada1.finalproject.itmd411;

public interface Controller {

    //Create Ticket (elements.. getText)
        //map text into a new object
        //pass this object into createTicket in Dao
        //return a status string to map to a label maybe? if SQL is successful

    //Retrieve Ticket (Ticket ID, Nodes to append text into)
        //pass the string into Dao and receive a results set
        //put the results from SQL into the Nodes

    //Update Ticket (Ticket ID, Nodes to retrieve values from)
        //use the retrieve method above to map the elements
        //then take in the elements and rewrite per the ID

    //Delete ticket(Ticket ID, Nodes to clear text from)
        //retrieve ticket using above Retrieve ticket method
        //use SQL in dao to delete by the ID

    //Retrieve all tickets(Whatever UI needs to have the RS appended into it)
        //run SQL query to retrieve all tickets
        //put the RS into the UI element

    //Status tracker
        //implement a message to SQL queries to display status

    default void currentStatusMessage(String message){
        TicketManagerGUI.statusMessage = message;
    }
}
