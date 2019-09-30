package com.iot.sensor.mapper;


import com.iot.sensor.payload.Event;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UpdateMapper {

    @Insert("insert into update(id, userid, busid, buslocation, time, drivername, getoff)values (#{id}, #{userid}, #{busid}, #{buslocation, #{time}, #{drivername}, #{getoff}")
    int save(Long id, Long userid, Long busid, String buslocation, Long time, String drivername, Boolean getoff);

    @Select("select id, userid, busid, buslocation, time, drivername, getoff from update where id = #{id} and userid = #{userid}, busid=#{busid}, buslocation=#{buslocation}, time=#{time}, drivername=#{drivername}, getoff=#{getoff}")
    List<Event> find(Long id, Long userid, Long busid, String buslocation, Long time, String drivername, Bool getoff);
}
