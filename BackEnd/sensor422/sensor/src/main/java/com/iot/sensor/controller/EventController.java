package com.iot.sensor.controller;

import com.iot.sensor.Constant.EventType;
import com.iot.sensor.model.*;
import com.iot.sensor.payload.EventTO;
import com.iot.sensor.payload.HistoryTO;
import com.iot.sensor.payload.Result;
import com.iot.sensor.security.CurrentUser;
import com.iot.sensor.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private BusService busService;

    @Autowired
    private DriverService driverService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private UserService userService;


    @PostMapping("/save")
    public Result save(@RequestBody EventTO eventTO) {

        Bus bus = busService.getByPlate(eventTO.getBusPlate());
        if(bus == null) {
            return new Result(false, "Bus not found");
        }

        if(eventTO.getEventType() == EventType.GET_ON) {
            if(bus.getOccupiedSeatNumber() >= bus.getSeatNumber())
                return new Result(false, "Not enough seats");
        } else {
            if(bus.getOccupiedSeatNumber() <= 0)
                return new Result(false, "Bus already empty");
        }

        Driver driver = driverService.getById(bus.getId());
        if(driver == null) {
            return new Result(false, "Driver not found");
        }

        Location location = locationService.getById(eventTO.getLocationId());
        if(location == null) {
            return new Result(false, "Location not exist");
        }

        User currUser = userService.getByNumberAndName(eventTO.getUserIdentification(), eventTO.getUserName());
        if(currUser == null) {
            return new Result(false, "User not exist");
        }

        // check if the customer already get on or get off.


        Event event = new Event();
        // set bus
        event.setBusId(bus.getId());
        event.setBusPlate(bus.getPlate());
        // set driver
        event.setDriverId(driver.getId());
        event.setDriverName(driver.getName());
        // set eventType
        event.setEvent(eventTO.getEventType());
        // set Location
        event.setLocationId(eventTO.getLocationId());
        event.setLocationName(location.getName());
        // set time
        event.setTime(new Date());
        // set user
        event.setUserId(currUser.getId());
        event.setUserName(currUser.getName());
        event.setUserNumber(currUser.getNumber());

        boolean res = eventService.save(event);
        if(res) {
            if(eventTO.getEventType() == EventType.GET_ON) {
                bus.setOccupiedSeatNumber(bus.getOccupiedSeatNumber() + 1);
                busService.update(bus);
            } else {
                bus.setOccupiedSeatNumber(bus.getOccupiedSeatNumber() - 1);
                busService.update(bus);
            }
            return new Result(true, "Save Success");
        }
        return new Result(false, "Save Success");
    }

    @GetMapping("/history")
    public Result getEvent(@CurrentUser User currUser) {
        List<Event> events = eventService.getByUserId(currUser.getId());

        List<HistoryTO> histories = new ArrayList<>();

        for(Event event : events) {
            HistoryTO history = new HistoryTO();
            history.setBusPlate(event.getBusPlate());
            history.setDriverName(event.getDriverName());
            history.setEvent(event.getEvent());
            history.setLocationName(event.getLocationName());
            history.setTime(event.getTime());
            history.setUserName(event.getUserName());
            history.setUserIdentification(event.getUserNumber());
            histories.add(history);
        }

        if(histories.size() == 0)
            return new Result(false, null);
        return new Result(true, histories);
    }



}
