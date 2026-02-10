package repository;

import exception.NoTicketFoundException;
import models.Ticket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TicketRepository {
    private HashMap<Integer, Ticket> tickets;
    private static int id_counter = 1;

    public TicketRepository() {
        this.tickets = new HashMap<>();
    }

    public Ticket getTicketById(int id) {
        if(tickets.containsKey(id)){
            return tickets.get(id);
        }
        throw new NoTicketFoundException("No ticket found with id: " + id);
    }

    public Ticket saveTicket(Ticket ticket){
        if (!tickets.containsKey(ticket.getId())) {
            ticket.setId(id_counter++);
        }
        tickets.put(ticket.getId(), ticket);
        return ticket;
    }

    public void delete(int ticketId) {
        tickets.remove(ticketId);
    }

    public List<Ticket> getAllTickets() {
        return new ArrayList<>(tickets.values());
    }
}
