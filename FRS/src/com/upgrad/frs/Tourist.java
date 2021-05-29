package com.upgrad.frs;

import java.util.*
;
public class Tourist extends Ticket{

    String hotelAddress;
    String[] touristLocation;

    Tourist(int pnr, String destination, String departure, Flight flight, String departDateTime,
            String arriveDateTime, Passenger passenger, String seatNumber, float price, String hotelAddress, String[] touristLocation) {
        super(pnr, destination, departure, flight, departDateTime, arriveDateTime, passenger, seatNumber, price);
        this.hotelAddress = hotelAddress;
        this.touristLocation = touristLocation;
        flight.updateSeat();

    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String[] getTouristLocation() {
        return touristLocation;
    }

    public void setTouristLocation(String[] touristLocation) {
        this.touristLocation = touristLocation;
    }

    void removeLocation(String location){
        int originalNumber = this.touristLocation.length;
        String[] newLocation = new String[originalNumber - 1];
        int pos = 0;
        for (int i = 0; pos < originalNumber - 1; i++,pos++){
            if( this.touristLocation[i].equals(location)){
                pos--;
                continue;
            }
            newLocation[pos] = this.touristLocation[i];
        }
        this.touristLocation = newLocation;
    }
    void addLocation(String location){
        int originalNumber = this.touristLocation.length;
        if ( originalNumber < 5) {
            String[] newLocation = new String[originalNumber + 1];
            for (int i = 0; i < originalNumber; i++) {
                newLocation[i] = touristLocation[i];
            }
            newLocation[originalNumber] = location;
            this.touristLocation = newLocation;
        }
        else {
            System.out.println("Sorry!, You have reached the maximum number of locations. ");
        }
    }

}
