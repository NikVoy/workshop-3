package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Train;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;

import static com.company.oop.agency.utils.ValidationHelper.validateValueInRangeInt;
import static com.company.oop.agency.utils.ValidationHelper.validateValueInRange;

public class TrainImpl extends BaseVehicle implements Train {

    public static final int PASSENGER_MIN_VALUE = 30;
    public static final int PASSENGER_MAX_VALUE = 150;
    public static final int CARTS_MIN_VALUE = 1;
    public static final int CARTS_MAX_VALUE = 15;
    public static final double PRICE_MIN_VALUE = 0.1;
    public static final double PRICE_MAX_VALUE = 2.5;
    public static final String A_TRAIN_CANNOT_HAVE_LESS_THAN_30_PASSENGERS_OR_MORE_THAN_150_PASSENGERS = "A train cannot have less than 30 passengers or more than 150 passengers.";
    public static final String CURRENCY_MUST_BE_A_NUMBER_BETWEEN_0_1_AND_2_5 = "Currency must be a number between 0.1 and 2.5";
    public static final String A_TRAIN_CANNOT_HAVE_LESS_THAN_1_CART_OR_MORE_THAN_15_CARTS = "A train cannot have less than 1 cart or more than 15 carts.";

    private int carts;
    private int passengerCapacity;
    private double pricePerKilometer;
    private final VehicleType vehicleType;

    public TrainImpl(int id, int passengerCapacity, double pricePerKilometer, int carts) {
        super(id);
        setPassengerCapacity(passengerCapacity);
        setPricePerKilometer(pricePerKilometer);
        setCarts(carts);
        this.vehicleType = VehicleType.LAND;
    }

    @Override
    public int getCarts() {
        return carts;
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
                A_TRAIN_CANNOT_HAVE_LESS_THAN_30_PASSENGERS_OR_MORE_THAN_150_PASSENGERS);

        this.passengerCapacity = passengerCapacity;
    }

    private void setPricePerKilometer(double pricePerKilometer) {
        validateValueInRange(pricePerKilometer, PRICE_MIN_VALUE, PRICE_MAX_VALUE,
                String.format("A vehicle with a price per kilometer lower than $%.2f or higher than $%.2f cannot exist!",
                        PRICE_MIN_VALUE,PRICE_MAX_VALUE));

        this.pricePerKilometer = pricePerKilometer;
    }

    private void setCarts(int carts) {
        validateValueInRangeInt(carts, CARTS_MIN_VALUE, CARTS_MAX_VALUE,
                A_TRAIN_CANNOT_HAVE_LESS_THAN_1_CART_OR_MORE_THAN_15_CARTS);

        this.carts = carts;
    }

    @Override
    public String getAsString() {
        StringBuilder result = new StringBuilder();

        result.append("Train ----")
                .append(System.lineSeparator())
                .append(String.format("Passenger capacity: %d", this.passengerCapacity))
                .append(System.lineSeparator())
                .append(String.format("Price per kilometer: %.2f", this.pricePerKilometer))
                .append(System.lineSeparator())
                .append(String.format("Vehicle type: %s", this.vehicleType))
                .append(System.lineSeparator())
                .append(String.format("Carts amount: %d", this.carts))
                .append(System.lineSeparator());

        return result.toString();
    }
}