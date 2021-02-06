package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.Manager;
import ru.netology.repository.TicketRepo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ManagerTest {
    Ticket[] list = {new Ticket(1, 1500, "VVO", "SVO", 540),
            new Ticket(2, 1000, "GOR", "LED", 120),
            new Ticket(3, 850, "GOR", "LED", 125),
            new Ticket(4, 500, "GOR", "LED", 140),
            new Ticket(5, 1250, "DME", "LED", 60)};
    TicketRepo repo = new TicketRepo(list);
    Manager man = new Manager(repo);

    @Test
    void shouldFindAll() {
        Ticket[] expected = {new Ticket(2, 1000, "GOR", "LED", 120),
                new Ticket(3, 850, "GOR", "LED", 125),
                new Ticket(4, 500, "GOR", "LED", 140)};
        Ticket[] actual = man.findAll("UUD", "LED");
        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldFindSingleTicket() {
        Ticket[] expected = {new Ticket(1, 1500, "VVO", "SVO", 540)};
        Ticket[] actual = man.findAll("VVO", "SVO");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindSingleTicket() {
        Ticket[] actual = man.findAll("LED", "NJC");
        Ticket[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldCheckSortingByPrice() {
        Ticket[] actual = man.findAll("LED", "UUD");
        Ticket prevTicket = null;
        for (Ticket ticket : actual) {
            if (prevTicket != null) {
                assertTrue(prevTicket.getPrice() < ticket.getPrice());
            }
            prevTicket = ticket;
        }
    }
}
