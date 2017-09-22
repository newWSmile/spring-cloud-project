package com.wyj.springbootstudy01.mapper;

import com.wyj.springbootstudy01.bean.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    @Rollback
    public void findByName() throws Exception {
//        userMapper.insert("AAA", 20);
//        User u = userMapper.findByName("AAA");
//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "CCC");
//        map.put("age", 40);
//        userMapper.insertByMap(map);
//        Assert.assertEquals(20, u.getAge().intValue());

        // insert一条数据，并select出来验证
        userMapper.insert("AAA", 20);
        User u = userMapper.findByName("AAA");
        Assert.assertEquals(20, u.getAge().intValue());
        // update一条数据，并select出来验证
        u.setAge(30);
        userMapper.update(u);
        u = userMapper.findByName("AAA");
        Assert.assertEquals(30, u.getAge().intValue());
        // 删除这条数据，并select验证
        userMapper.delete(u.getId());
        u = userMapper.findByName("AAA");
        Assert.assertEquals(null, u);
    }


    @Test
    @Rollback
    public void testUserMapper2() throws Exception {
        List<User> userList = userMapper.findAll();
        for(User user : userList) {
//            Assert.assertEquals(null, user.getId());
//            Assert.assertNotEquals(null, user.getName());
            System.out.println("name:"+user.getName()+",age:"+user.getAge());
        }
    }
}