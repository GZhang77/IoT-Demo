package com.iot.sensor.service;

import com.iot.sensor.mapper.LocationMapper;
import com.iot.sensor.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationMapper locationMapper;

    public Location getById(Long id) {
        List<Location> locations = locationMapper.findById(id);
        if(locations.size() == 1) {
            return locations.get(0);
        }
        return null;
    }

    public List<Location> getAll() {
        return locationMapper.findAll();
    }
}
