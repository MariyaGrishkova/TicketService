package ru.netology.repository;

import ru.netology.domain.Ticket;

import java.util.NoSuchElementException;

public class TicketRepo {
    Ticket[] list;

    public TicketRepo(Ticket[] list) {
        this.list = list;
    }

    public Ticket[] getAll() {
        return list;
    }

    void save(Ticket ticket) {
        int length = list.length + 1;
        Ticket[] addedTicket = new Ticket[length];
        for (int i = 0; i < list.length; i++) {
            addedTicket[i] = list[i];
        }
        int lastIndex = addedTicket.length - 1;
        addedTicket[lastIndex] = ticket;
        list = addedTicket;
    }

    Ticket findById (int id) {
        for (Ticket item : list) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }


    void removeById(int id) {
        Ticket ticketById = findById(id);
        if (ticketById == null) {
            throw new NoSuchElementException();
        } else {

            int length = list.length - 1;
            Ticket[] newArray = new Ticket[length];
            int count = 0;
            for (Ticket ticket : list) {
                if (ticket != ticketById) {
                    newArray[count++] = ticket;
                }
            }
        }
    }
}
