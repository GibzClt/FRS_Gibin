package com.upgrad.frs;

public class Regular extends Ticket {
    private boolean food;
    private boolean water;
    private boolean snack;

    Regular(int pnr, String destination, String departure, Flight flight, String departDateTime,
            String arriveDateTime, Passenger passenger, String seatNumber, float price, boolean food, boolean water, boolean snack) {
        super(pnr, destination, departure, flight, departDateTime, arriveDateTime, passenger, seatNumber, price);
        this.food = food;
        this.water = water;
        this.snack = snack;
        flight.updateSeat();
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isSnack() {
        return snack;
    }

    public void setSnack(boolean snack) {
        this.snack = snack;
    }

    String displayServices(){
        String a = "", b = "", c = "";
        if(food){
            a = "food ";
        }
        if(water){
            b = ("water ");
        }
        if(snack){
            c = ("snack ");
        }
        return a + b + c ;
    }
}
