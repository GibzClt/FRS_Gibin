package com.upgrad.frs;

import java.util.Arrays;
import java.util.Random;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        // Welcome message
        System.out.println("====================================");
        System.out.println("    Welcome to UpGrad flights !");
        System.out.println("====================================");
        System.out.println("      Flight ko karo lift");

        // Passenger No.1
        Random number = new Random();
        String id = String.valueOf(number.nextInt(1000));
        Passenger passenger = new Passenger(id, "Gibin", "8606851482", "gibinninan5@gmail.com", "TK road", "Pullad", "Kerala");
        System.out.println("\nGibin (" + id +") " + "has been successfully registered with UpGrad flights !");

        // Instantiating flight objects
        Flight flight_Etihad = new Flight("101", "Etihad", 200);
        Flight flight_Indigo = new Flight("203", "Indigo", 180);
        Flight flight_Emirates = new Flight("123", "Emirates", 230);
        Flight flight_Vistara = new Flight("220", "Vistara", 195);
        Flight flight_AirIndia = new Flight("250", "Air India", 200);
        Flight flight_FlyDubai = new Flight("321", "Fly Dubai", 230);

        // User has to choose the departure and arrival locations
        System.out.print("From : ");
        String departure = input.next();
        System.out.print("To : ");
        String destination = input.next();

        // Displaying flight details
        System.out.println("\nChoose a flight : ");
        System.out.println("1 : " + flight_Etihad.getFlightDetails());
        System.out.println("2 : " + flight_Indigo.getFlightDetails());
        System.out.println("3 : " + flight_Emirates.getFlightDetails());
        System.out.println("4 : " + flight_Vistara.getFlightDetails());
        System.out.println("5 : " + flight_AirIndia.getFlightDetails());
        System.out.println("6 : " + flight_FlyDubai.getFlightDetails());

        // User has to choose the type of ticket
        System.out.print("\nRegular ticket or a Tourist ticket : ");
        String ticketType = input.next();

        // When the user chooses a regular ticket
        if (ticketType.equalsIgnoreCase("regular")){
            String pnr = "ET" +  String.valueOf(number.nextInt(10000));                // Generating a PNR number
            Regular regular_Gibin = passenger.bookTicket(pnr, destination, departure, flight_Etihad, "29-05-2021 16:20:05",
                    "30-05-2021 17:25:10", passenger, "14F", 10000, true);
            regular_Gibin.checkStatus();                                                      // To check the ticket status
            System.out.println(regular_Gibin.displayServices());                              // Display the status of special services
            System.out.println(flight_Etihad.getBookedSeats() + " seat booked ");             // Total number of booked seats in the respective flight
            System.out.println("Duration of journey : " +  regular_Gibin.getDuration(regular_Gibin.getDepartDateTime(), regular_Gibin.getArriveDateTime())); //Duratioon of the journey
            System.out.println("Remaining flight capacity : " + flight_Etihad.getCapacity()); // Remaining flight capacity
            printTicketDetails(regular_Gibin);                                                // Prints the PNR number
        }

        // When the user chooses a tourist ticket
        else if (ticketType.equalsIgnoreCase("tourist")){
            String pnr = "ET" +  String.valueOf(number.nextInt(10000));               // Generating a PNR number
            String[] location = {"Aruvi waterfalls", "Olive waterfalls", "RJ park"};        // Tourist locations
            Tourist tourist_Gibin = passenger.bookTicket(pnr,  destination, departure, flight_Etihad, "29-05-2021 16:20:00",
                    "30-05-2021 17:25:00", passenger, "14F", 10000, "Sheraton Hotel", location);
            tourist_Gibin.checkStatus();                                                    // To check the ticket status
            System.out.println(tourist_Gibin.getTouristLocation());        // Displaying the tourist locations
            System.out.println(flight_Etihad.getBookedSeats() + " seat booked ");           // Total number of booked seats in the respective flight
            System.out.println("Duration of journey : " +  tourist_Gibin.getDuration(tourist_Gibin.getDepartDateTime(), tourist_Gibin.getArriveDateTime())); //Duratioon of the journey
            System.out.println("Remaining flight capacity : " + flight_Etihad.getCapacity()); // Remaining flight capacity
            printTicketDetails(tourist_Gibin);                                                // Prints the PNR number
        }


        // Passenger No.2
        System.out.println("---------------------------\n");
        String pnr = "ET" +  String.valueOf(number.nextInt(10000));                     // Generating a PNR number
        Passenger passenger_2 = new Passenger("02", "Joshua", "7037123456", "lala@email.com", "ibm", "gandhinagar", "goa");
        Regular regular_Joshua = passenger.bookTicket(pnr, "Bangalore", "Goa", flight_Etihad, "29-05-2021 16:20:00", "31-05-2021 17:25:00",
                passenger_2, "13B", 10000, true);
        regular_Joshua.checkStatus();                                                         // To check the ticket status
        System.out.println(regular_Joshua.displayServices());                                 // To check the ticket status
        System.out.println(flight_Etihad.getBookedSeats() + " seat booked ");                 // Total number of booked seats in the respective flight
        System.out.println("Duration of journey : " +  regular_Joshua.getDuration(regular_Joshua.getDepartDateTime(), regular_Joshua.getArriveDateTime()));  //Duratioon of the journey
        System.out.println("Remaining flight capacity : " + flight_Etihad.getCapacity());     // Remaining flight capacity
        printTicketDetails(regular_Joshua);                                                   // Prints the PNR number


        // Passenger No.3
        System.out.println("---------------------------\n");
        pnr = "ET" +  String.valueOf(number.nextInt(10000));                        // Generating a PNR number
        Passenger passenger_3 = new Passenger("03", "Ashish", "4747553456", "tholath@email.com", "dollar", "kr puram", "bangalore");
        Regular regular_Ashish = passenger.bookTicket(pnr, "Bangalore", "Goa", flight_Etihad, "29-05-2021 16:20:00", "01-06-2021 18:25:00",
                passenger_3, "13B", 10000, false);
        regular_Ashish.checkStatus();                                                     // To check the ticket status
        System.out.println(regular_Ashish.displayServices());                             // To check the ticket status
        System.out.println(flight_Etihad.getBookedSeats() + " seat booked ");             // Total number of booked seats in the respective flight
        System.out.println("Duration of journey : " +  regular_Ashish.getDuration(regular_Ashish.getDepartDateTime(), regular_Ashish.getArriveDateTime())); //Duratioon of the journey
        System.out.println("Remaining flight capacity : " + flight_Etihad.getCapacity()); // Remaining flight capacity
        printTicketDetails(regular_Ashish);                                               // Prints the PNR number


        // Passenger No.4
        System.out.println("---------------------------\n");
        pnr = "IN" +  String.valueOf(number.nextInt(10000));               // Generating a PNR number
        Passenger passenger_4 = new Passenger("04", "Ezra", "8032892615", "ezra@email.com", "Somandepalli", "Anantapur", "Andhra Pradesh");
        String[] location = {"Taj Mahal", "Red fort", "Qutub Minar"};        // Tourist locations
        Tourist tourist_Ezra = passenger.bookTicket(pnr,  destination, departure, flight_Indigo, "01-06-2021 10:32:00",
                "01-06-2021 17:25:00", passenger, "11A", 12000, "Sardarji Hotel", location);
        tourist_Ezra.checkStatus();                                                    // To check the ticket status
        System.out.println(tourist_Ezra.getTouristLocation());        // Displaying the tourist locations
        tourist_Ezra.addLocation("India Gate");                                        // Adding one more location
        System.out.println(tourist_Ezra.getTouristLocation());        // Displaying the updated tourist locations
        System.out.println(flight_Indigo.getBookedSeats() + " seat booked ");           // Total number of booked seats in the respective flight
        System.out.println("Duration of journey : " +  tourist_Ezra.getDuration(tourist_Ezra.getDepartDateTime(), tourist_Ezra.getArriveDateTime())); //Duratioon of the journey
        System.out.println("Remaining flight capacity : " + flight_Indigo.getCapacity()); // Remaining flight capacity
        printTicketDetails(tourist_Ezra);                                                // Prints the PNR number


        System.out.println("---------------------------\n");
        // Secured ticket cancellation. Ticket will be cancelled only if the passenger enters the correct PNR number.
        // Wrong PNR number given for demo
        regular_Joshua.cancelTicket("111", flight_Etihad);                              // Checks with the PNR number. Cancels the ticket if the PNR number matches
        System.out.println("Remaining flight capacity : " + flight_Etihad.getCapacity());   // Remaining flight capacity
        System.out.println("\n---------------------------\n");

    }

    // Function to print ticket details
    public static void printTicketDetails(Ticket ticket){
        System.out.println(ticket.getPnr() + "  ---->  " + ticket.flight.getFlightNumber() + " " + ticket.flight.getAirline());
    }
}
