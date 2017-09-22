package com.wyj.springbootstudy01.mapper;


import com.wyj.springbootstudy01.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;


@Mapper
public interface UserMapper {
    //@Param 传参方式
    @Select("SELECT * FROM USER WHERE NAME = #{name}")
    User findByName(@Param("name") String name);
    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    //通过Map对象来作为传递参数的容器
    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    //使用对象
    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
    int insertByUser(User user);

    //增删改查
    @Update("UPDATE user SET age=#{age} WHERE name=#{name}")
    void update(User user);
    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(Long id);

    //返回结果的绑定 通过@Results和@Result注解来进行绑定
    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    @Select("SELECT name, age FROM user")
    List<User> findAll();
}
