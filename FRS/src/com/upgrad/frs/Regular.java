package com.upgrad.frs;

public class Regular extends Ticket {
    private boolean specialService;

    Regular(String pnr, String destination, String departure, Flight flight, String departDateTime,
            String arriveDateTime, Passenger passenger, String seatNumber, float price, boolean specialServie) {
        super(pnr, destination, departure, flight, departDateTime, arriveDateTime, passenger, seatNumber, price);
        this.specialService = specialServie;
        this.cancelled = false;
        flight.updateSeat(1);
    }

    public boolean isSpecialService() {
        return specialService;
    }

    public void setSpecialService(boolean specialService) {
        this.specialService = specialService;
    }

    void checkStatus(){
        if(! isCancelled()){
            System.out.println("Regular ticket "+ getPnr() + " confirmed ");
        }
        else{
            System.out.println("Regular ticket "+ getPnr() + " cancelled ");
        }
    }

    String displayServices(){
        if(specialService){
            return "food, water and snacks ";
        }
        return "No special services availed ";
    }
}
