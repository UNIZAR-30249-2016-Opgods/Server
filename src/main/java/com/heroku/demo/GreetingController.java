package com.heroku.demo;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello OP chetao , %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/greetings/{name}", method = RequestMethod.GET)
    public Greeting greeting(@PathVariable("name") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}
