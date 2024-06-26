package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Vehicle;

public abstract class BaseVehicle implements Vehicle {

    private final int id;

    public BaseVehicle(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    public abstract String getAsString();
}
