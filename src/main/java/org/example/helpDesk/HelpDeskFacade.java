package org.example.helpDesk;

import org.example.models.SupportTicket;

public interface HelpDeskFacade {
    void addNewSupportTicket(SupportTicket supportTicket);
    SupportTicket getNextSupportTicket();
    /**
     * @return amount of tickets that are not processed
     */
    int getNumberOfTickets();

}
