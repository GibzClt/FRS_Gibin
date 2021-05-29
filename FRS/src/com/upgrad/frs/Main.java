package com.upgrad.frs;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("====================================");
        System.out.println("    Welcome to Upgrad flights !");
        System.out.println("====================================");
        Passenger passenger = new Passenger(01, "Gibin", "8606123456", "qwert@email.com", "tokyo", "texas", "zambia");
        Flight flight_Etihad = new Flight("101", "Etihad", 300);
        System.out.println("What ticket");
        Scanner input = new Scanner(System.in);
        String ticketType = input.nextLine();

        if(ticketType.toLowerCase().equals("regular")){
            Regular regular_Gibin = passenger.bookTicket( "Atlants", "Jamaica", flight_Etihad, "29-05-2021 16:20:05", "31-05-2021 17:25:10",
                    passenger, "14F", 10000, false, false, true);
            System.out.println("Regular ticket : REGISTERED");
            System.out.println(regular_Gibin.displayServices());
            System.out.println(flight_Etihad.getBookedSeats() + " seats booked ");
            System.out.println(flight_Etihad.getCapacity());
        }
        else if (ticketType.toLowerCase().equals("tourist")){
            String[] location = {"Arvi waterfalls", "Kurvi waterfalls", "MArvi waterfalls"};
            Tourist tourist_Gibin = passenger.bookTicket( "Atlants", "Jamaica", flight_Etihad, "29-05-2021 16:20:05", "31-05-2021 17:25:10",
                    passenger, "14F", 10000, "Nayana Hotels", location);
            System.out.println("Tourist ticket : REGISTERED");
            System.out.println(Arrays.toString(tourist_Gibin.getTouristLocation()));
            }

    }
}
