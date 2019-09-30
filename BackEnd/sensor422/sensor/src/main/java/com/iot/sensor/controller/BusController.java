package com.iot.sensor.controller;

import com.iot.sensor.mapper.BusMapper;
import com.iot.sensor.model.Bus;
import com.iot.sensor.payload.Result;
import com.iot.sensor.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/buses/")
public class BusController {

    @Autowired
    private BusService busService;


    @GetMapping("/{busPlate}/seat/free")
    public Result getEmptySeatNumber(@PathVariable("busPlate") String busPlate) {
        Bus bus = busService.getByPlate(busPlate);
        if(bus != null)
            return new Result(true, bus.getSeatNumber() - bus.getOccupiedSeatNumber());

        return new Result(false, null);
    }
}
