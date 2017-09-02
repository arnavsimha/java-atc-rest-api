package atcapi.model.request;


import atcapi.model.AircraftSize;
import atcapi.model.AircraftType;

public class AqmEnqueueRequest extends AqmRequest{

    private AircraftType type;
    private AircraftSize size;

    public AqmEnqueueRequest(AircraftType type, AircraftSize size){
        this.type = type;
        this.size = size;
    }

    public AircraftSize getSize() {
        return size;
    }

    public AircraftType getType() {
        return type;
    }
}
