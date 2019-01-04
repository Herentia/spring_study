package com.pb.entity;

import org.springframework.stereotype.Component;

/**
 * @author haohan
 * 12/20/2018 - 04:36 下午
 */
@Component
public class Car {

    private String carName;
    private Double price;

    public Car() {
    }

    public Car(String carName, Double price) {
        this.carName = carName;
        this.price = price;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                ", price=" + price +
                '}';
    }
}
