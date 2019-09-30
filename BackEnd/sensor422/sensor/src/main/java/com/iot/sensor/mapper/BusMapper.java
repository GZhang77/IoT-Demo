package com.iot.sensor.mapper;

import com.iot.sensor.model.Bus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BusMapper {
    List<Bus> findByPlate(@Param("plate") String plate);

    int update(Bus bus);
}
