package com.upgrad.frs;

public class Flight {

    private boolean flightAvailable;
    private int capacity;
    private String flightNumber;
    private String airline;
    private int bookedSeats;

    Flight (String flightNumber, String airline, int capacity){
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.capacity = capacity;
        flightAvailable = this.capacity  > 0;
    }

    Flight(Flight flight){
        this.flightNumber = flight.flightNumber;
        this.airline = flight.airline;
        this.capacity = flight.capacity;
        this.flightAvailable = this.capacity > 0;
    }

    // to get the status of the availability of the flight
    public boolean isFlightAvailable(){
        if(!(getCapacity() > 0)) {
            flightAvailable = false;
        }
        return flightAvailable;
    }

    // to set the status of the availability of the flight
    public void setFlightAvailable(boolean flightAvailable) {
        this.flightAvailable = flightAvailable;
    }

    // to get the capacity of the flight
    public int getCapacity(){
        return capacity;
    }

    // to set the capacity of the flight
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // to get the flight number
    public String getFlightNumber() {
        return flightNumber;
    }

    // to set the flight number of the flight
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    // to get the airline of the flight
    public String getAirline() {
        return airline;
    }

    // to set the airline of the flight
    public void setAirline(String airline) {
        this.airline = airline;
    }

    // to get the number of booked seats in the flight
    public int getBookedSeats() {
        return bookedSeats;
    }

    // to set the number of booked seats of the flight
    public void setBookedSeats(int bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    // to update the seats of the flight
    public void updateSeat(int i){
        bookedSeats+=i;
        capacity-=i;
    }

    //to get the flight details
    public String getFlightDetails(){
        return String.format("%-5s %-12s | %-5s",getFlightNumber(), getAirline(), getCapacity());
    }
}
