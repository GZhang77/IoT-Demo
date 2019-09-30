package com.iot.sensor.service;

import com.iot.sensor.mapper.EventMapper;
import com.iot.sensor.model.Event;
import com.iot.sensor.payload.EventTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventMapper eventMapper;

    public boolean save(Event event) {
        int res = eventMapper.save(event);
        if(res > 0)
            return true;

        return false;
    }

    public List<Event> getByUserId(Long userId) {
        return eventMapper.getByUserId(userId);
    }

}
