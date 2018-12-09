package com.restrada1.finalproject.itmd411;

import java.util.*;

/**
 * Author: restrada1
 * Class: Ticket.java
 * Description:
 * The Ticket class is the core object upon which records will be based on. It implements the TicketTemplate so that the behavior can be updated from the
 * interface, and also allows for polymorphic properties with other classes which may implement the TicketTemplate, among other benefits.
 *
 * The class features fields which capture essential ticketing information,
 * such as the auto-generated ticketID, customerName, dateTime, description, isResolved, and the priority. The ticket overrides the Equals, and Hash Code, allowing for easier manipulation and for enhanced flexibility. The class implements essential encapsulation by hiding fields, and exposing
 * getters and setters as needed. Additionally, the toString() method is overriden to allow for easy printing/viewing.
 *
 * The constructor maps the parameters to the instance variables so that new objects can be created easily without needing to 'set' the values.
 */

public class Ticket implements TicketTemplate {
    private String ticketID;
    private String customerName;
    private String dateTime;
    private String description;
    private String isResolved;
    private String priority;

    public Ticket(String ticketID, String customerName, String dateTime, String description, String isResolved, String priority) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.dateTime = dateTime;
        this.description = description;
        this.isResolved = isResolved;
        this.priority = priority;
    }

    @Override
    public String getTicketID() {
        return ticketID;
    }

    @Override
    public void setTicketID(String ticketID){
        this.ticketID = ticketID;
    }

    @Override
    public String getCustomerName() {
        return customerName;
    }

    @Override
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String getDateTime() {
        return dateTime;
    }

    @Override
    public void setDateTime(String date) {
        dateTime = date;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getIsResolved() {
        return isResolved;
    }

    @Override
    public void setIsResolved(String isResolved) {
        this.isResolved = isResolved;
    }

    @Override
    public String getPriority() {
        return priority;
    }

    @Override
    public void setPriority(String priority){
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketID='" + ticketID + '\'' +
                ", customerName='" + customerName + '\'' +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", isResolved='" + isResolved + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(ticketID, ticket.ticketID) &&
                Objects.equals(customerName, ticket.customerName) &&
                Objects.equals(dateTime, ticket.dateTime) &&
                Objects.equals(description, ticket.description) &&
                Objects.equals(isResolved, ticket.isResolved) &&
                Objects.equals(priority, ticket.priority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketID, customerName, dateTime, description, isResolved, priority);
    }
}
