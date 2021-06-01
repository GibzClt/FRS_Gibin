package com.upgrad.frs;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public abstract class Ticket {

    String pnr;
    String destination;
    String departure;
    Flight flight;
    String departDateTime;
    String arriveDateTime;
    Passenger passenger;
    String seatNumber;
    float price;
    boolean cancelled;

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

    public String getPnr() {
        return pnr;
    }


    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getDepartDateTime() {
        return departDateTime;
    }

    public void setDepartDateTime(String departDateTime) {
        this.departDateTime = departDateTime;
    }

    public String getArriveDateTime() {
        return arriveDateTime;
    }

    public void setArriveDateTime(String arriveDateTime) {
        this.arriveDateTime = arriveDateTime;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void cancelTicket(String pnr, Flight flight ) {
        if(this.pnr.equals(pnr)){
            this.cancelled = true;
            flight.updateSeat(-1);
            System.out.println("Ticket successfully cancelled ");
        }
        else{
            System.out.println("Wrong ticket details ! ");
        }
    }

    abstract void checkStatus();

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
        }
        catch (ParseException e){
            System.out.println("Wrong date format !!! ");
        }
        return null;
    }
}
