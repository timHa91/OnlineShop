package org.example.helpDesk.impl;

import org.example.models.SupportTicket;
import org.example.helpDesk.HelpDeskFacade;
import org.example.utils.comparators.CustomSupportTicketsComparator;

import java.util.PriorityQueue;
import java.util.Queue;

public class HelpDeskFacadeImpl implements HelpDeskFacade {

    public static HelpDeskFacade instance;
    private final Queue<SupportTicket> supportTickets;

    {
        supportTickets = new PriorityQueue<>(new CustomSupportTicketsComparator());
    }

    public static HelpDeskFacade getInstance() {
        if (instance == null) {
            instance = new HelpDeskFacadeImpl();
        }
        return instance;
    }

    @Override
    public void addNewSupportTicket(SupportTicket supportTicket) {
        if(supportTicket == null) {
            throw new IllegalArgumentException("Support Ticket can't be null");
        }
        boolean added = supportTickets.offer(supportTicket);
        if (!added) {
            throw new IllegalStateException("Unable to add support ticket to the queue");
        }
    }

    @Override
    public SupportTicket getNextSupportTicket() {
        return supportTickets.poll();
    }

    @Override
    public int getNumberOfTickets() {
        return supportTickets.size();
    }
}
