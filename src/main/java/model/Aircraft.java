package model;

public class Aircraft {

    private AircraftType type;
    private AircraftSize size;

    public Aircraft(AircraftType type, AircraftSize size){
        this.type = type;
        this.size = size;
    }

    public AircraftType getType() {
        return type;
    }

    public AircraftSize getSize() {
        return size;
    }

    public String toString(){
        return "Type: " + this.getType() + ", Size: " + this.getSize();
    }
}
