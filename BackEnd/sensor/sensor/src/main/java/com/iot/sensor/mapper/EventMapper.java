package com.iot.sensor.mapper;

import com.iot.sensor.payload.Event;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EventMapper {

    @Insert("insert into event (userId, name, eventType) values (#{userId}, #{name}, #{eventType})")
    int save(Long userId, String name, Integer eventType);

    @Select("select userId, name, eventType from event where userId = #{userId} and name = #{name}")
    List<Event> find(Long userId, String name);


}
