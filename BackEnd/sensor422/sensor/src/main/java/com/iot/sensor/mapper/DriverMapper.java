package com.iot.sensor.mapper;

import com.iot.sensor.model.Driver;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DriverMapper {

    List<Driver> findById(@Param("id") Long id);
}
