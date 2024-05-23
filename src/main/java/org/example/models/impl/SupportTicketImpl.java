package org.example.models.impl;

import org.example.models.Priority;
import org.example.models.RequestType;
import org.example.models.SupportTicket;

public class SupportTicketImpl implements SupportTicket {


    private final RequestType requestType;
    private final int sequentialNumber;
    private static int ticketsCreated;

    {
        sequentialNumber = ++ticketsCreated;
    }

    public SupportTicketImpl(RequestType requestType) {
        this.requestType = requestType;
    }

    @Override
    public Priority getPriority() {
        if(requestType == null) {
            return null;
        }
        return requestType.getPriority();
    }

    @Override
    public int getSequentialNumber() {
        return sequentialNumber;
    }

    @Override
    public RequestType getRequestType() {
        return requestType;
    }
}
