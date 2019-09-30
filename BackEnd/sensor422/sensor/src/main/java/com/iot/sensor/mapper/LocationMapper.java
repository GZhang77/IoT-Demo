package com.iot.sensor.mapper;

import com.iot.sensor.model.Location;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LocationMapper {

    List<Location> findAll();

    List<Location> findById(Long id);

}
