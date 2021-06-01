package com.upgrad.frs;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public abstract class Ticket {

    protected String pnr;
    protected String destination;
    protected String departure;
    protected Flight flight;
    protected String departDateTime;
    protected String arriveDateTime;
    protected Passenger passenger;
    protected String seatNumber;
    protected float price;
    protected boolean cancelled;

    Ticket(String pnr, String destination, String departure, Flight flight, String departDateTime,
               String arriveDateTime, Passenger passenger, String seatNumber, float price){
        this.pnr = pnr;
        this.destination = destination;
        this.departure = departure;
        this.flight = flight;
        this.departDateTime = departDateTime;
        this.arriveDateTime = arriveDateTime;
        this.passenger = passenger;
        this. seatNumber = seatNumber;
        this.price = price;
        cancelled = false;
    }

    // to get the PNR
    public String getPnr() {
        return pnr;
    }

    // to get the destination
    public String getDestination() {
        return destination;
    }

    // to set the destination
    public void setDestination(String destination) {
        this.destination = destination;
    }

    // to get the departure
    public String getDeparture() {
        return departure;
    }

    // to set the departure
    public void setDeparture(String departure) {
        this.departure = departure;
    }

    // to get the flight
    public Flight getFlight() {
        return flight;
    }

    // to set the flight
    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    // to get the date and time of departure
    public String getDepartDateTime() {
        return departDateTime;
    }

    // to set the date and time of departure
    public void setDepartDateTime(String departDateTime) {
        this.departDateTime = departDateTime;
    }

    // to get the date and time of arrival
    public String getArriveDateTime() {
        return arriveDateTime;
    }

    // to set the date and time of arrival
    public void setArriveDateTime(String arriveDateTime) {
        this.arriveDateTime = arriveDateTime;
    }

    // to get the passenger
    public Passenger getPassenger() {
        return passenger;
    }

    // to set the passenger
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    // to get the seat number
    public String getSeatNumber() {
        return seatNumber;
    }

    // to set the seat number
    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    // to get the ticket price
    public float getPrice() {
        return price;
    }

    // to set the ticket price
    public void setPrice(float price) {
        this.price = price;
    }

    // to check whether the ticket is cancelled
    public boolean isCancelled() {
        return cancelled;
    }

    // to cancel the ticket
    public void cancelTicket(String pnr, Flight flight ) {
        if (this.pnr.equals(pnr)){
            this.cancelled = true;
            flight.updateSeat(-1);
            System.out.println("Ticket successfully cancelled ");
        } else {
            System.out.println("Wrong ticket details !!! ");
        }
    }

    // to print the ticket status
    abstract void checkStatus();

    // to get the journey duration
    public String getDuration(String departDateTime, String arriveDateTime) {
        SimpleDateFormat duration = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        try{
            Date start = duration.parse(departDateTime);
            Date end = duration.parse(arriveDateTime);

            long difference = end.getTime() - start.getTime();
            long differenceInSeconds = TimeUnit.MILLISECONDS.toSeconds(difference) % 60;
            long differenceInMinutes = TimeUnit.MILLISECONDS.toMinutes(difference) % 60;
            long differenceInHours = TimeUnit.MILLISECONDS.toHours(difference) % 24;
            long differenceInDays = TimeUnit.MILLISECONDS.toDays(difference) % 365;

            return differenceInDays + " days, "+ differenceInHours + " hours, " + differenceInMinutes + " minutes, ";
        } catch (ParseException e){
            System.out.println("Wrong date format !!! ");
        }
        return null;
    }
}
