package atcapi;

import atcapi.model.Aircraft;
import atcapi.model.request.AqmBootRequest;
import atcapi.model.request.AqmDequeueRequest;
import atcapi.model.request.AqmEnqueueRequest;
import atcapi.model.request.AqmRequest;
import atcapi.model.response.AqmDequeueResponse;
import atcapi.model.response.AqmResponse;

import java.util.PriorityQueue;

public class AircraftQueueManager {

    private PriorityQueue<Aircraft> aircraftQueue;
    private boolean systemBooted = false;

    public AircraftQueueManager(){
        aircraftQueue = new PriorityQueue<>(new AircraftComparator());
    }

    public AqmResponse aqmRequestProcess(AqmRequest request){

        if(request instanceof AqmBootRequest){

            if(this.bootAircraftQueue()){
                return new AqmResponse("System booted succesfully!");
            } else {
                return new AqmResponse("System boot failed!");
            }

        } else if(!this.systemBooted){
            //system not booted, and its not a boot request
            return new AqmResponse("System not booted up, please boot system and retry!");
        } else if(request instanceof AqmEnqueueRequest) {
            this.enqueueAircraft(
                    new Aircraft(((AqmEnqueueRequest) request).getType(), ((AqmEnqueueRequest) request).getSize()));
            return new AqmResponse("Aircraft enqueued successfully!");
        } else if(request instanceof AqmDequeueRequest){
            return new AqmDequeueResponse("Aircraft dequeued successfully!", this.dequeAircraft());
        }

        return new AqmResponse("Request type not recognized!");

    }

    private boolean bootAircraftQueue(){

        //if system isnt booted, boot and return true
        if(!this.systemBooted){
            return (this.systemBooted = true);
        } else {
            return false;
        }

    }

    private boolean enqueueAircraft(Aircraft ac){
        return aircraftQueue.offer(ac);
    }

    private Aircraft dequeAircraft(){
        //add error checking
        return aircraftQueue.poll();
    }

    public int size(){
        return aircraftQueue.size();
    }

    public AqmResponse getStatus(){
        return new AqmResponse("System booted? " + systemBooted + " current queue size is " + size());
    }
}
