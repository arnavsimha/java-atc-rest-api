package atcapi.controller;

import atcapi.AircraftQueueManager;
import atcapi.model.AircraftSize;
import atcapi.model.AircraftType;
import atcapi.model.request.AqmBootRequest;
import atcapi.model.request.AqmEnqueueRequest;
import atcapi.model.response.AqmResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/aqm")
public class AqmController {

    private final AtomicLong counter = new AtomicLong();
    private final AircraftQueueManager queueManager = new AircraftQueueManager();

    @RequestMapping("/healthz")
    public String healthz() {
        return counter.incrementAndGet() + " What are you a doctor?";
    }

    @RequestMapping(value = "/statusz", method = RequestMethod.GET)
    public AqmResponse getAqmStatus(){
        return queueManager.getStatus();
    }

    @RequestMapping(value = "/boot")
    public AqmResponse bootAqm(){
        return queueManager.aqmRequestProcess(new AqmBootRequest());
    }

    @RequestMapping(value = "/enqueue/type/{type}/size/{size}", method = RequestMethod.POST)
    public AqmResponse enqueueAircraft(@PathVariable AircraftType type, @PathVariable AircraftSize size){
        return queueManager.aqmRequestProcess(
                new AqmEnqueueRequest(type, size)
        );
    }

}
