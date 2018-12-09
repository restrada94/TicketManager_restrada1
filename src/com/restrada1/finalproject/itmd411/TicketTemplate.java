package com.restrada1.finalproject.itmd411;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: restrada1
 * Class: Ticket.java
 * Description:
 * The TicketTemplate defines the high level behavior by defining abstract method signatures.
 *
 * To statically store Ticket objects, a static hashMap, TicketMap, will contain both the key and the value <String, TicketTemplate>.
 */

public interface TicketTemplate {

    static Map<String, TicketTemplate> TicketMap = new HashMap<>();

    String getTicketID();

    void setTicketID(String ticketID);

    String getCustomerName();

    void setCustomerName(String customerName);

    String getDateTime();

    void setDateTime(String date);

    String getDescription();

    void setDescription(String description);

    String getIsResolved();

    void setIsResolved(String isResolved);

    String getPriority();

    void setPriority(String priority);

    @Override
    String toString();

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();
}
