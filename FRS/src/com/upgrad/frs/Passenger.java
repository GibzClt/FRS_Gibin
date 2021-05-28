package com.upgrad.frs;

public class Passenger {

    private int id;
    private Contact contact;
    Address address;
    Ticket ticket;
    private boolean registered;

        class Contact {

        private String name;
        private String phone;
        private String email;

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

        class Address {

        String street;
        String city;
        String state;

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


    Passenger( int id, Contact contact, Address address ){
        this.id = id;
        this.contact = contact;
        this.address = address;
        registered = true;
    }

    boolean isRegistered(){
            return registered;
    }

}
