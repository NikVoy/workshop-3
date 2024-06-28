package com.company.oop.agency.models;

import com.company.oop.agency.exceptions.InvalidUserInputException;
import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.contracts.Ticket;

public class TicketImpl implements Ticket {
    public static final String COSTS_POSITIVE_MESSAGE = "Value of 'costs' must be a positive number. Actual value: %.2f.";

    private int id;
    private Journey journey;
    private double administrativeCosts;

    public TicketImpl(int id, Journey journey, double costs) {
        this.id = id;
        this.journey = journey;
        setAdministrativeCosts(costs);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Journey getJourney() {
        return journey;
    }

    @Override
    public double getAdministrativeCosts() {
        return administrativeCosts;
    }

    private void setAdministrativeCosts(double administrativeCosts) {
        if (administrativeCosts < 0) {
            throw new InvalidUserInputException(String.format(COSTS_POSITIVE_MESSAGE, administrativeCosts));
        }

        this.administrativeCosts = administrativeCosts;
    }

    @Override
    public double calculatePrice() {
        return journey.calculateTravelCosts() * administrativeCosts;
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
