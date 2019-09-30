package com.iot.sensor.mapper;


import com.iot.sensor.payload.Event;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BusMapper {

    @Insert("insert into bus (id, busNumber, busId, busYear, busBrand, seat) values (#{id}, #{busNumber}, #{busId}, #{busYear}, #{busBrand}, #{seat}")
    int save(Long id, Long busNumber, Long busId, Long busYear, String busBrand, Integer seat);

    @Select("select id, busNumber, busId, busYear, busBrand, seat from bus where id = #{id} and seat = #{seat}")
    List<Event> find(Long id, Integer seat);


}
