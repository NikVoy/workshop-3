package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Airplane;

import static com.company.oop.agency.utils.ValidationHelper.validateValueInRange;
import static com.company.oop.agency.utils.ValidationHelper.validateValueInRangeInt;

public class AirplaneImpl extends BaseVehicle implements Airplane {

    public static final int PASSENGER_MIN_VALUE = 1;
    public static final int PASSENGER_MAX_VALUE = 800;
    public static final double PRICE_MIN_VALUE = 0.1;
    public static final double PRICE_MAX_VALUE = 2.5;
    public static final String AIRPLANE_CANNOT_HAVE_LESS_THAN_1_PASSENGERS_OR_MORE_THAN_800_PASSENGERS = "Airplane cannot have less than 1 passengers or more than 800 passengers.";
    public static final String CURRENCY_MUST_BE_A_NUMBER_BETWEEN_0_1_AND_2_5 = "Currency must be a number between 0.1 and 2.5";

    private final boolean hasFreeFood;
    private int passengerCapacity;
    private double pricePerKilometer;
    private final VehicleType vehicleType;

    public AirplaneImpl(int id, int passengerCapacity, double pricePerKilometer, boolean hasFreeFood) {
        super(id);
        setPassengerCapacity(passengerCapacity);
        setPricePerKilometer(pricePerKilometer);
        this.hasFreeFood = hasFreeFood;
        this.vehicleType = VehicleType.AIR;
    }

    @Override
    public boolean hasFreeFood() {
        return hasFreeFood;
    }

    @Override
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public double getPricePerKilometer() {
        return pricePerKilometer;
    }

    private void setPassengerCapacity(int passengerCapacity) {
        validateValueInRangeInt(passengerCapacity, PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE,
                AIRPLANE_CANNOT_HAVE_LESS_THAN_1_PASSENGERS_OR_MORE_THAN_800_PASSENGERS);

        this.passengerCapacity = passengerCapacity;
    }

    private void setPricePerKilometer(double pricePerKilometer) {
        validateValueInRange(pricePerKilometer, PRICE_MIN_VALUE, PRICE_MAX_VALUE,
                String.format("A vehicle with a price per kilometer lower than $%.2f or higher than $%.2f cannot exist!",
                        PRICE_MIN_VALUE,PRICE_MAX_VALUE));

        this.pricePerKilometer = pricePerKilometer;
    }

    @Override
    public String getAsString() {
        StringBuilder result = new StringBuilder();

        result.append("Airplane ----")
                .append(System.lineSeparator())
                .append(String.format("Passenger capacity: %d", this.passengerCapacity))
                .append(System.lineSeparator())
                .append(String.format("Price per kilometer: %.2f", this.pricePerKilometer))
                .append(System.lineSeparator())
                .append(String.format("Vehicle type: %s", this.vehicleType))
                .append(System.lineSeparator())
                .append(String.format("Has free food: %s", this.hasFreeFood))
                .append(System.lineSeparator());

        return result.toString();
    }
}