package com.iot.sensor.mapper;

import com.iot.sensor.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> findByPrimaryId(@Param("id") Long id);

    List<User> findByNumberAndName(@Param("number") String number, @Param("name") String name);
}
