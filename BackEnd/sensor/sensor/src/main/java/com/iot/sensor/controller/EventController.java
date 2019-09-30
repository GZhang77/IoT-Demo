package com.iot.sensor.controller;

import com.iot.sensor.payload.Event;
import com.iot.sensor.payload.Events;
import com.iot.sensor.payload.Result;
import com.iot.sensor.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/event")
public class EventController {

    @Autowired
    private EventService eventService;


    @PostMapping("")
    public Result save(@RequestBody Event event) {
        eventService.save(event);
        return new Result(true);
    }

    @GetMapping("/{userId}/{name}")
    public Events getEvent(@PathVariable Long userId, @PathVariable String name) {
        return eventService.get(userId, name);

    }


}
