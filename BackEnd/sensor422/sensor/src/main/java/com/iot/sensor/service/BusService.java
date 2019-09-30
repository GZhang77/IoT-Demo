package com.iot.sensor.service;

import com.iot.sensor.mapper.BusMapper;
import com.iot.sensor.model.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusService {
    @Autowired
    private BusMapper busMapper;


    public Bus getByPlate(String busPlate) {
        List<Bus> buses = busMapper.findByPlate(busPlate);

        if(buses.size() == 1) {
            return buses.get(0);
        }
        return null;
    }

    public boolean update(Bus bus) {
        int res = busMapper.update(bus);
        return res > 0;
    }

}
