package com.iot.sensor.mapper;

import com.iot.sensor.model.Event;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EventMapper {

    int save(Event event);

    List<Event> getByUserId(@Param("userId") Long userId);
}
