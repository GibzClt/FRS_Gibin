package com.upgrad.frs;

import java.util.*;

public class Tourist extends Ticket{

    private String hotelAddress;
    private String[] touristLocation;

    Tourist(String pnr, String destination, String departure, Flight flight, String departDateTime,
            String arriveDateTime, Passenger passenger, String seatNumber, float price, String hotelAddress, String[] touristLocation) {
        super(pnr, destination, departure, flight, departDateTime, arriveDateTime, passenger, seatNumber, price);
        this.hotelAddress = hotelAddress;
        this.touristLocation = touristLocation;
        this.cancelled = false;
        flight.updateSeat(1);
    }

    Tourist(Tourist tourist){
        super(tourist.pnr, tourist.destination, tourist.departure, tourist.flight, tourist.departDateTime, tourist.arriveDateTime, tourist.passenger, tourist.seatNumber, tourist.price);
        this.hotelAddress = tourist.hotelAddress;
        this.touristLocation = tourist.touristLocation;
        this.cancelled = false;
        flight.updateSeat(1);
    }

    // to get the hotel address
    public String getHotelAddress() {
        return hotelAddress;
    }

    // to set the hotel address
    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    // to get the tourist location
    public String getTouristLocation() {
        return Arrays.toString(touristLocation);
    }

    // to set the tourist location
    public void setTouristLocation(String[] touristLocation) {
        this.touristLocation = touristLocation;
    }

    // to  display the ticket status
    @Override
    void checkStatus(){
        if(! isCancelled()){
            System.out.println("Tourist ticket "+ this.getPnr() + " confirmed ");
        } else{
            System.out.println("Tourist ticket "+ this.getPnr() + " cancelled ");
        }
    }

    // to remove a tourist location
    void removeLocation(String location){
        int originalNumber = this.touristLocation.length;
        if(originalNumber > 1)
        {
            String[] newLocation = new String[originalNumber - 1];
            int pos = 0;
            for (int i = 0; pos < originalNumber - 1; i++, pos++) {
                if (this.touristLocation[i].equals(location)) {
                    pos--;
                    continue;
                }
                newLocation[pos] = this.touristLocation[i];
            }
            this.touristLocation = newLocation;
        } else{
            System.out.println("You have to select at least one location \n");
        }
    }

    // to add a tourist location
    void addLocation(String location){
        int originalNumber = this.touristLocation.length;
        if ( originalNumber < 5) {
            String[] newLocation = new String[originalNumber + 1];
            for (int i = 0; i < originalNumber; i++) {
                newLocation[i] = touristLocation[i];
            }
            newLocation[originalNumber] = location;
            this.touristLocation = newLocation;
        } else {
            System.out.println("Sorry!, You have reached the maximum number of locations. ");
        }
    }
}
