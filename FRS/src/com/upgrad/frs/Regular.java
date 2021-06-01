package com.upgrad.frs;

public class Regular extends Ticket {
    private boolean specialService;

    Regular(String pnr, String destination, String departure, Flight flight, String departDateTime,
            String arriveDateTime, Passenger passenger, String seatNumber, float price, boolean specialService) {
        super(pnr, destination, departure, flight, departDateTime, arriveDateTime, passenger, seatNumber, price);
        this.specialService = specialService;
        this.cancelled = false;
        flight.updateSeat(1);
    }

    Regular(Regular regular){
        super(regular.pnr, regular.destination, regular.departure, regular.flight, regular.departDateTime, regular.arriveDateTime, regular.passenger, regular.seatNumber, regular.price);
        this.specialService = regular.specialService;
        this.cancelled = false;
        flight.updateSeat(1);
    }

    // to get the status of special services
    public boolean isSpecialService() {
        return specialService;
    }

    // to set the status of special services
    public void setSpecialService(boolean specialService) {
        this.specialService = specialService;
    }

    // to display the ticket status
    @Override
    void checkStatus(){
        if(! isCancelled()){
            System.out.println("Regular ticket "+ getPnr() + " confirmed ");
        } else{
            System.out.println("Regular ticket "+ getPnr() + " cancelled ");
        }
    }

    // to display special services
    String displayServices(){
        if(specialService){
            return "food, water and snacks ";
        }
        return "No special services availed ";
    }
}
