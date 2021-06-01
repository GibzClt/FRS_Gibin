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


    public void setFlightAvailable(boolean flightAvailable) {
        this.flightAvailable = flightAvailable;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public void setBookedSeats(int bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public boolean isFlightAvailable(){
        if(!(capacity > 0)) {
            flightAvailable = false;
        }
        return flightAvailable;
    }

    public int getCapacity(){
        return capacity;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getAirline() {
        return airline;
    }

    void updateSeat(int i){
        bookedSeats+=i;
        capacity-=i;
    }
    String getFlightDetails(){
        return getFlightNumber() + "  " + getAirline() + "  | Capacity : " + getCapacity();
    }

}
