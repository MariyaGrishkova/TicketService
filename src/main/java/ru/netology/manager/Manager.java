package ru.netology.manager;

import lombok.AllArgsConstructor;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepo;

import java.util.Arrays;

@AllArgsConstructor
public class Manager {
    private TicketRepo list;

    public Ticket[] findAll(String from, String to) {
        Ticket[] newList = new Ticket[0];
        for (Ticket ticket : list.getAll()) {
            if (ticket.getArrivalAirport().equals(to) && ticket.getDepartureAirport().equals(from)) {
                Ticket[] tmp = new Ticket[newList.length + 1];
                System.arraycopy(newList, 0, tmp, 0, newList.length);
                tmp[tmp.length - 1] = ticket;
                newList = tmp;
            }
        }
        Arrays.sort(newList);
        return newList;
    }
}