package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Bus;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;

import static com.company.oop.agency.utils.ValidationHelper.validateValueInRange;
import static com.company.oop.agency.utils.ValidationHelper.validateValueInRangeInt;

public class BusImpl extends BaseVehicle implements Bus {

    public static final int PASSENGER_MIN_VALUE = 10;
    public static final int PASSENGER_MAX_VALUE = 50;
    public static final double PRICE_MIN_VALUE = 0.1;
    public static final double PRICE_MAX_VALUE = 2.5;

    public static final String AIRPLANE_CANNOT_HAVE_LESS_THAN_10_PASSENGERS_OR_MORE_THAN_50_PASSENGERS = "Airplane cannot have less than 1 passengers or more than 800 passengers.";
    public static final String CURRENCY_MUST_BE_A_NUMBER_BETWEEN_0_1_AND_2_5 = "Currency must be a number between 0.1 and 2.5";

    private int passengerCapacity;
    private double pricePerKilometer;
    private final VehicleType vehicleType;

    public BusImpl(int id, int passengerCapacity, double pricePerKilometer) {
        super(id);
        setPassengerCapacity(passengerCapacity);
        setPricePerKilometer(pricePerKilometer);
        this.vehicleType = VehicleType.LAND;
    }

    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public double getPricePerKilometer() {
        return pricePerKilometer;
    }

    @Override
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    private void setPassengerCapacity(int passengerCapacity) {
        validateValueInRangeInt(passengerCapacity, PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE,
                AIRPLANE_CANNOT_HAVE_LESS_THAN_10_PASSENGERS_OR_MORE_THAN_50_PASSENGERS);

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

        result.append("Bus ----")
                .append(System.lineSeparator())
                .append(String.format("Passenger capacity: %d", this.passengerCapacity))
                .append(System.lineSeparator())
                .append(String.format("Price per kilometer: %.2f", this.pricePerKilometer))
                .append(System.lineSeparator())
                .append(String.format("Vehicle type: %s", this.vehicleType))
                .append(System.lineSeparator());

        return result.toString();
    }


}
