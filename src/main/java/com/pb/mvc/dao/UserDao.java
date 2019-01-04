package com.pb.mvc.dao;

import com.pb.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author haohan
 * 12/28/2018 - 10:56 上午
 */
@Component
public class UserDao {

    public Collection<User> getList() {
        List<User> list = new ArrayList<>();
        list.add(new User(1, "jay", 18, "五道口"));
        list.add(new User(2, "jion", 17, "哈哈"));
        list.add(new User(3, "xx", 16, "yaya"));
        return list;
    }

}
