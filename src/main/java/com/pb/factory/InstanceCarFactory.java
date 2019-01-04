package com.pb.factory;

import com.pb.entity.Car;

import java.util.HashMap;
import java.util.Map;

/**
 * @author haohan
 * 12/20/2018 - 05:03 下午
 * 实例工厂的方法
 */
public class InstanceCarFactory {

    private Map<String, Car> carMap = null;

    public InstanceCarFactory() {
        carMap = new HashMap<>();
        carMap.put("Aodi", new Car("Aodi", 300000.00));
        carMap.put("BMW", new Car("BMW", 350000.00));
    }

    public Car getCar(String carname) {
        return carMap.get(carname);
    }
}
