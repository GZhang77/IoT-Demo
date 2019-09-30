package com.iot.sensor.model;

public class Bus {
    private Long id;
    private Long driverId;
    private String plate;
    private String year;
    private String brand;
    private Integer seatNumber;
    private Integer occupiedSeatNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Integer getOccupiedSeatNumber() {
        return occupiedSeatNumber;
    }

    public void setOccupiedSeatNumber(Integer occupiedSeatNumber) {
        this.occupiedSeatNumber = occupiedSeatNumber;
    }
}
