package com.practiceApp.practiceApp.restData;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

        private static final String template = "Hello %s!";
        private final AtomicLong counter = new AtomicLong();

        @GetMapping("/hello")
        public Greeting hello(@RequestParam(value = "name", defaultValue = "World") String name) {
                return new Greeting(counter.incrementAndGet(), String.format(template, name));
        }

        @PostMapping("/helloPost")
        public String helloPost() {
                return "{\"result\":\"this is the post endpoint\"}";
        }
}
