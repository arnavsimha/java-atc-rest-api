package atcapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class AqmController {

    private final AtomicLong counter = new AtomicLong();


    @RequestMapping("/healthz")
    public String healthz() {
        return counter.incrementAndGet() + " What are you a doctor?";
    }

}
