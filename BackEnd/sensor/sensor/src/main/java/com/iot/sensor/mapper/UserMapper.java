package com.iot.sensor.mapper;


import com.iot.sensor.payload.Event;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("insert into user(id, name, parentphone, uid, gender, classnum)values (#{id}, #{name}, #{parentphone}, #{uid}, #{gender}, #{class}")
    int save(Long id, String name, Long parentphone, Long uid, String gender, Integer classnum);

    @Select("select id, name, parentphone, uid, gender, classnum from user where id = #{id} and name = #{name}")
    List<Event> find(Long userId, String name);
}
