package com.twy.springbootjwt.mapper;

import com.twy.springbootjwt.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author gongpeng
 * @date 2020/9/1 16:13
 */
public interface UserMapper {

    @Select("select * from user where userName = #{userName}")
    User findByUserName(@Param("userName") String userName);

    @Select("select * from user where id = #{id}")
    User findUserIdById(@Param("id") Long id);
}
