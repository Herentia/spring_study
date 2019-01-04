package com.pb.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author haohan
 * 12/24/2018 - 10:19 上午
 */
@Order(1)
@Component
@Aspect
public class LoggingAop {

    @Before("execution(public int com.pb.test.Clac.add(..))")
    public void beforeLog(JoinPoint joinPoint) {
        System.out.println("哇哈哈before。。。" + joinPoint.getSignature().getName());
    }

}
