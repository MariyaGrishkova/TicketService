package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String arrivalAirport;
    private String departureAirport;
    private int travelTime;

    @Override
    public int compareTo(Ticket o) {
        return price - o.getPrice();
    }
}
