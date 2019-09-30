package com.iot.sensor.mapper;

import com.iot.sensor.payload.Event;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BusLocMapper {

    @Insert("insert into bus_location (id, location) values (#{id}, #{location)")
    int save(Long id, String location);

    @Select("select id, location from bus_location where id = #{location} and location = #{id}")
    List<Event> find(Long id, String location);
}
