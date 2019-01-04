package com.pb.proxy;

import com.pb.entity.Car;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author haohan
 * 12/21/2018 - 02:00 下午
 * 动态代理，环绕通知就相当于动态代理，ProceedingJoinPoint.proceed();调用被代理类的方法，相当于method.invoke()
 */
public class CarProxy {

    //被代理对象
    private Car traget;

    public CarProxy(Car traget) {
        this.traget = traget;
    }

    public Car getCarProxy() {
        Car carProxy = null;

        //获取被代理对象的类加载器
        ClassLoader classLoader = traget.getClass().getClassLoader();
        //获取被代理对象的接口类型
        Class[] classes = {traget.getClass()};
        //当调用代理对象执行方法时
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;

                try {
                    //前置通知
                    result = method.invoke(traget, args);
                    //返回通知
                } catch (Exception e) {
                    //异常通知
                    e.printStackTrace();
                }
                //后置通知
                return result;
            }
        };

        carProxy = (Car) Proxy.newProxyInstance(classLoader, classes, h);
        return carProxy;
    }



}
