package com.pb.factory;

import com.pb.entity.Car;

import java.util.HashMap;
import java.util.Map;

/**
 * @author haohan
 * 12/20/2018 - 04:48 下午
 * 静态工厂的方法
 */
public class CarStaticFactory {
    private static Map<String, Car> cars = new HashMap<>();

    static {
        cars.put("Aodi", new Car("Aodi", 300000.00));
        cars.put("BMW", new Car("BMW", 350000.00));
    }

    private static Car getCar(String carname) {
        Car car = cars.get(carname);
        return car;
    }

}
