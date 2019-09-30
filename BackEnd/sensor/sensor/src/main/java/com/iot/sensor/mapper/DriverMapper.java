package com.iot.sensor.mapper;


import com.iot.sensor.payload.Event;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DriverMapper {
    @Insert("insert into driver (id, driverid, drivername, driverage) values (#{id}, #{driverid}, #{drivername}, #{driverage}")
    int save(Long id, Long driverid, String drivername, Integer driverage);

    @Select("select id, driverid, drivername, driverage from driver where id = #{id} and drivername = #{drivername}")
    List<Event> find(Long id, String drivername);
}
