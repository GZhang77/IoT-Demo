package com.iot.sensor.service;

import com.iot.sensor.mapper.EventMapper;
import com.iot.sensor.payload.Event;
import com.iot.sensor.payload.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventMapper eventMapper;

    public boolean save(Event event) {
        eventMapper.save(event.getUserId(), event.getName(), event.getEventType());
        return true;
    }

    public Events get(Long userId, String name) {
        List<Event> eventList = eventMapper.find(userId, name);
        Events events = new Events();
        events.setEvents(eventList);
        return events;
    }

}
