package model.response;


import model.Aircraft;

public class AqmDequeueResponse extends AqmResponse {

    private Aircraft aircraft;

    public AqmDequeueResponse( String status, Aircraft aircraft){
        super(status);
        this.aircraft = aircraft;
    }

    public String toString(){
        return super.toString() + "\n" + this.aircraft.toString();
    }
}