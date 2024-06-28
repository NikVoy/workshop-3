package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Bus;
import com.company.oop.agency.utils.ValidationHelper;

import static com.company.oop.agency.utils.ValidationHelper.validateValueInRange;
import static com.company.oop.agency.utils.ValidationHelper.validateValueInRangeInt;

public class BusImpl extends VehicleBase implements Bus {

    public static final int PASSENGER_MIN_VALUE = 10;
    public static final int PASSENGER_MAX_VALUE = 50;
    public static final String PASSENGER_ERROR_MESSAGE = "Airplane cannot have less than 1 passengers or more than 800 passengers.";

    public BusImpl(int id, int passengerCapacity, double pricePerKilometer) {
        super(id, passengerCapacity, pricePerKilometer);
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.LAND;
    }

    @Override
    public String getAsString() {
        StringBuilder result = new StringBuilder();

        result.append("Bus ----")
                .append(System.lineSeparator())
                .append(super.getAsString())
                .append(System.lineSeparator());

        return result.toString();
    }

    @Override
    protected void validatePassengerCapacity(int passengerCapacity) {
        ValidationHelper.validateValueInRange(
                passengerCapacity,
                PASSENGER_MIN_VALUE,
                PASSENGER_MAX_VALUE,
                PASSENGER_ERROR_MESSAGE);
    }
}
