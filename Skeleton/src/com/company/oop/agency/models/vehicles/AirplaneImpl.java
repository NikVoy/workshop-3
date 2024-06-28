package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Airplane;

import static com.company.oop.agency.utils.ValidationHelper.validateValueInRange;
import static com.company.oop.agency.utils.ValidationHelper.validateValueInRangeInt;

public class AirplaneImpl extends VehicleBase implements Airplane {

    private final boolean hasFreeFood;

    public AirplaneImpl(int id, int passengerCapacity, double pricePerKilometer, boolean hasFreeFood) {
        super(id, passengerCapacity, pricePerKilometer);
        this.hasFreeFood = hasFreeFood;
    }

    @Override
    public boolean hasFreeFood() {
        return hasFreeFood;
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.AIR;
    }


    @Override
    public String getAsString() {
        StringBuilder result = new StringBuilder();

        result.append("Airplane ----")
                .append(System.lineSeparator())
                .append(super.getAsString())
                .append(System.lineSeparator())
                .append(String.format("Has free food: %s", this.hasFreeFood))
                .append(System.lineSeparator());

        return result.toString();
    }
}