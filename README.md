# OOP Workshop - Travel Agency

## Preface

Before you start coding, read this document from top to bottom. It has some valuable information that will make your work easier.

## Description

Implement a journey and ticket tracking system for a famous travel agency called `Sunny Travel`. The application already accepts commands and outputs text for each submitted command. The user can create different models (`Bus, Airplane, Train, Ticket, Journey`) and list them. What you need to do is build the OO classes hierarchy. Make sure to follow the object-oriented programming best practices and conventions discussed during the lectures.

## Architecture

By now you should be aware of how the `Engine` works. It's the same as all previous workshops. The commands use the `AgencyRepositoryImpl` class to create and store all the application information. After a command is executed, it returns a result message to the `EngineImpl` and the engine prints it to the console.

Your focus should be on the **models** package, where you must place the classes you create using the provided interfaces in the **contracts** package.

## Models

> Note: All validation intervals are inclusive (closed).

### **Train**

- `passenger capacity` - a number between `30` and `150`.
 - Exception message: `A train cannot have less than 30 passengers or more than 150 passengers.`
- `price per kilometer` - a number between `0.1` and `2.5` representing currency.
- `Type` - one of `[Land, Air, Sea]`.
- `carts` - a number between `1` and `15`.
 - Exception message: `A train cannot have less than 1 cart or more than 15 carts.`
- Should be convertible to **String** in the format:

```none
Train ----
Passenger capacity: VALUE
Price per kilometer: VALUE
Vehicle type: VALUE
Carts amount: VALUE
```

### **Airplane**

- `passenger capacity` - a number.
- `price per kilometer` - a number.
- `Type` - one of `[Land, Air, Sea]`.
- `has free food` - boolean.
- Should be convertible to **String** in the format:

```none
Airplane ----
Passenger capacity: VALUE
Price per kilometer: VALUE
Vehicle type: VALUE
Has free food: VALUE
```

### **Bus**

- `passenger capacity` - a number between `10` and `50`.
 - Exception message: `A bus cannot have less than 10 passengers or more than 50 passengers.`
- `price per kilometer` - a number.
- `Type` - one of `[Land, Air, Sea]`.
- Should be convertible to **String** in the format:

```none
Bus ----
Passenger capacity: VALUE
Price per kilometer: VALUE
Vehicle type: VALUE
```

### **Journey**

- `start location` - a string with lengths between `5` and `25` symbols.
 - Exception message: `The StartingLocation's length cannot be less than 5 or more than 25 symbols long.`
- `destination` - a string with lengths between `5` and `25` symbols.
 - Exception message: `The Destination's length cannot be less than 5 or more than 25 symbols long.`
- `distance` - a number between `5` and `5000`.
 - Exception message: `The Distance cannot be less than 5 or more than 5000 kilometers.`
- `Vehicle` - the vehicle used for the journey.
- `calculateTravelCosts()` - calculated by multiplying the `distance` by the `Vehicle`'s `price per kilometer`.
- Should be convertible to **String** in the format:

```none
Journey ----
Start location: VALUE
Destination: VALUE
Distance: VALUE
Vehicle type: VALUE
Travel costs: VALUE
```

### **Ticket**

- `Journey` - the journey the ticket is sold for.
- `administrative costs` - a number.
- `calculatePrice()` - calculated by multiplying the `administrative costs` by the `Journey`'s `travel costs`.
- Should be convertible to **String** in the format:

```none
Ticket ----
Destination: VALUE
Price: VALUE
```

### **OPTIONAL Additional validations**

Think carefully how to implement different validation in base and derived classes!

The laws of physics and finances dictate that:

- A vehicle with **less than 1** or **more than 800 passengers** cannot exist!
 - Exception message: `A vehicle with less than 1 passenger or more than 800 passengers cannot exist!`
- A vehicle with a price per kilometer **lower than $0.10** or **higher than $2.50** cannot exist!
 - Exception message: `A vehicle with a price per kilometer lower than $0.10 or higher than $2.50 cannot exist!`

There is no such vehicle in your case but think about these rules more generally. This system could be extended in the future to accommodate more vehicles.

## Repository

The `AgencyRepositoryImpl` class is used to store and retrieve all the information that the application needs. It also contains the `create()` methods of the objects.

The class has a private `nextId` field that stores the following `ID` to be assigned.

Your task is to implement all methods that throw `UnsupportedOperationException`.

## Commands

**All commands are case insensitive, except their parameters!** Each command is represented in the code base as a separate class that the `CommandFactoryImpl` invokes.

You are given a set of commands. They are already implemented:

- **CreateBus** `[passengerCapacity] [pricePerKilometer]` - creates a new `Bus`.
- **CreateTrain** `[passengerCapacity] [pricePerKilometer] [carts]` - creates a new `Train`.
- **CreateAirplane** `[passengerCapacity] [pricePerKilometer] [hasFreeFood]` - creates a new `Airplane`.
- **CreateTicket** `[journeyID] [administrativeCosts]` - creates a new `Ticket`.
- **CreateJourney** `[startLocation] [destination] [distance] [vehicleID]` - creates a new `Journey`.
- **ListJourneys** - lists all stored journeys.
- **ListTickets** - lists all stored tickets.
- **ListVehicles** - lists all stored vehicles.

## Constraints

- You can create new and modify existing **classes, interfaces, enumerations, and packages** in the **models** package.
- You are allowed to modify the `AgencyRepositoryImpl`.
- ***You are NOT allowed to modify any other existing interfaces!***
- ***You are NOT allowed to modify any other existing classes, enumerations, and packages!***

## Unit Tests

- You have been given unit tests to keep track of your progress. Run them by right-clicking the **tests** package and selecting **Run 'All Tests'**.
- If you get stuck, check out the tests' names to guide you on what to do.
 
> Note: Be careful not to change anything in the **tests** folder.

## Step by step guide

1. If you try to build the Skeleton, it won't compile. Do not worry.
2. Navigate to the **models** package. Inspect what classes are there and consider what interfaces they need to implement. Is there an opportunity to introduce an abstract class?
3. After implementing and encapsulating the needed models, head to the `AgencyRepositoryImpl` class. All methods that throw `UnsupportedOperationException` need to be implemented.

### Sample Input

```
createbus 10 0.7
createairplane 230 1 true
createtrain 80 0.44 3
listvehicles
createjourney Sofia Turnovo 300 1
createjourney Sofia Turnovo 33 2
listjourneys
createticket 4 30.2
createticket 4 -1.5
createticket 5 100
listtickets
createticket pesho 100
createairplane 250 1 true
createticket 2 pipi
createairplane alabala 23 16
createjourney Sofia Turnovo 3000 1
createjourney SsdddddddddsdsssssssssSsdddddddddsdsssssssss Turnovo 3000 1
createjourney Sofia SsdddddddddsdsssssssssSsdddddddddsdsssssssss 3000 1
createtrain 80 0.08 3
createtrain 80 2.7 3
listtickets
createtrain 28 0.4 3
createtrain 152 0.4 3
listvehicles
exit
```

### Sample Output

```
Vehicle with ID 1 was created.
Vehicle with ID 2 was created.
Vehicle with ID 3 was created.
Bus ----
Passenger capacity: 10
Price per kilometer: 0.70
Vehicle type: LAND
####################
Airplane ----
Passenger capacity: 230
Price per kilometer: 1.00
Vehicle type: AIR
Has free food: true
####################
Train ----
Passenger capacity: 80
Price per kilometer: 0.44
Vehicle type: LAND
Carts amount: 3
Journey with ID 4 was created.
Journey with ID 5 was created.
Journey ----
Start location: Sofia
Destination: Turnovo
Distance: 300
Vehicle type: LAND
Travel costs: 210.00
####################
Journey ----
Start location: Sofia
Destination: Turnovo
Distance: 33
Vehicle type: AIR
Travel costs: 33.00
Ticket with ID 6 was created.
Value of 'costs' must be a positive number. Actual value: -1.50.
Ticket with ID 8 was created.
Ticket ----
Destination: Turnovo
Price: 6342.00
####################
Ticket ----
Destination: Turnovo
Price: 3300.00
Invalid value for journey id. Should be a number.
Vehicle with ID 9 was created.
Invalid value for cost. Should be a number.
Invalid value for passenger capacity. Should be a number.
Journey with ID 10 was created.
The StartingLocation's length cannot be less than 5 or more than 25 symbols long.
The Destination's length cannot be less than 5 or more than 25 symbols long.
A vehicle with a price per kilometer lower than $0.10 or higher than $2.50 cannot exist!
A vehicle with a price per kilometer lower than $0.10 or higher than $2.50 cannot exist!
Ticket ----
Destination: Turnovo
Price: 6342.00
####################
Ticket ----
Destination: Turnovo
Price: 3300.00
A train cannot have less than 30 passengers or more than 150 passengers.
A train cannot have less than 30 passengers or more than 150 passengers.
Bus ----
Passenger capacity: 10
Price per kilometer: 0.70
Vehicle type: LAND
####################
Airplane ----
Passenger capacity: 230
Price per kilometer: 1.00
Vehicle type: AIR
Has free food: true
####################
Train ----
Passenger capacity: 80
Price per kilometer: 0.44
Vehicle type: LAND
Carts amount: 3
####################
Airplane ----
Passenger capacity: 250
Price per kilometer: 1.00
Vehicle type: AIR
Has free food: true
```
