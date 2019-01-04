package com.pb.test;

import org.springframework.stereotype.Component;

/**
 * @author haohan
 * 12/24/2018 - 10:29 上午
 */
@Component
public class Clac {

    public int add(int a, int b) {
        int count;
        count = a + b;
        return count;
    }

}
