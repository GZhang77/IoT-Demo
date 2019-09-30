package com.iot.sensor.controller;

import com.iot.sensor.model.Location;
import com.iot.sensor.payload.Result;
import com.iot.sensor.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping()
    public Result getAllLocations() {
        List<Location> locations = locationService.getAll();
        if(locations.size() != 0)
            return new Result(true, locations);

        return new Result(false, null);
    }
}
