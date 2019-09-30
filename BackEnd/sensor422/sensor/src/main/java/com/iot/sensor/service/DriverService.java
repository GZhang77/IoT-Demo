package com.iot.sensor.service;

import com.iot.sensor.mapper.BusMapper;
import com.iot.sensor.mapper.DriverMapper;
import com.iot.sensor.model.Bus;
import com.iot.sensor.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    @Autowired
    private DriverMapper driverMapper;


    public Driver getById(Long id) {
        List<Driver> drivers = driverMapper.findById(id);

        if(drivers.size() == 1) {
            return drivers.get(0);
        }
        return null;
    }
}
