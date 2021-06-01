package com.upgrad.frs;

public class Passenger {

    private String id;
    private Contact contact;
    Address address;
    Ticket ticket;
    private boolean registered;

        // Declaring contact class
        private static class Contact {

        private String name;
        private String phone;
        private String email;

        Contact(String name, String phone, String email){
            this.name = name;
            this.phone = phone;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

        // Declaring address class
        private static class Address {

        String street;
        String city;
        String state;

        Address(String street, String city, String state){
            this.street = street;
            this.city = city;
            this.state = state;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
    }

    Passenger(){

    }

    Passenger( String id, String name, String phone, String email, String street, String city, String state){
        this.id = id;
        this.contact = new Contact(name, phone, email);
        this.address = new Address(street, city, state);
        registered = true;
    }

    Passenger (Passenger passenger){
        this.id = passenger.id;
        this.contact = passenger.contact;
        this.address = passenger.address;
    }

    // to check if the passenger is registered
    boolean isRegistered(){
            return registered;
    }

    // to get the contact details
    String getContactDetails(Contact contact){
        return "Name : " + contact.getName() + "\nMobile number : " + contact.getPhone() + "\nEmail Id : " + contact.getEmail();
    }

    // to get the address details
    String getAddressDetails(Address address){
        return "Street : " + address.getStreet() + "\nCity : " + address.getCity() + "\nState : " + address.getState();
    }

    // to book a regular ticket
    Regular bookTicket(String pnr, String destination, String departure, Flight flight, String departDateTime, String arriveDateTime,
                       Passenger passenger, String seatNumber, float price, boolean specialService) {
            if(flight.isFlightAvailable()){
                return new Regular(pnr,destination, departure, flight, departDateTime, arriveDateTime, passenger,
                        seatNumber, price, specialService );
            } else {
                System.out.println("Sorry, all the seats in this flight are booked. Please check another flight.");
                return null;
            }
    }

    // to book a tourist ticket
    Tourist bookTicket(String pnr, String destination, String departure, Flight flight, String departDateTime, String arriveDateTime,
                       Passenger passenger, String seatNumber, float price, String hotelAddress, String[] touristLocation) {
        if(flight.getCapacity() > 0){
            return new Tourist(pnr,destination, departure, flight, departDateTime, arriveDateTime, passenger,
                    seatNumber, price, hotelAddress, touristLocation);
        } else {
            System.out.println("Sorry, all the seats in this flight are booked. Please check another flight.");
            return null;
        }
    }
}
