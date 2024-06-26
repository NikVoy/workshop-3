package com.company.oop.agency.models;

import com.company.oop.agency.exceptions.InvalidUserInputException;
import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.contracts.Ticket;

public class TicketImpl implements Ticket {
    public static final String ADMINISTRATIVE_COSTS_CANNOT_BE_NEGATIVE_VALUE = "Administrative costs cannot be negative value";
    private int id;
    private Journey journey;
    private double administrativeCosts;

    public TicketImpl(int id, Journey journey, double costs) {
        this.id = id;
        this.journey = journey;
        setAdministrativeCosts(costs);
    }

    @Override
    public Journey getJourney() {
        return journey;
    }

    @Override
    public double calculatePrice() {
        return journey.calculateTravelCosts() * administrativeCosts;
    }

    @Override
    public double getAdministrativeCosts() {
        return administrativeCosts;
    }

    @Override
    public int getId() {
        return id;
    }

    private void setAdministrativeCosts(double administrativeCosts) {
        if (administrativeCosts < 0) {
            throw new InvalidUserInputException(String.format("Value of 'costs' must be a positive number. Actual value: %.2f.", administrativeCosts));
        }

        this.administrativeCosts = administrativeCosts;
    }

    @Override
    public String getAsString() {
        StringBuilder result = new StringBuilder();

        result.append("Ticket ----")
                .append(System.lineSeparator())
                .append(String.format("Destination: %s", journey.getDestination()))
                .append(System.lineSeparator())
                .append(String.format("Price: %.2f", calculatePrice()))
                .append(System.lineSeparator());

        return result.toString();
    }
}
