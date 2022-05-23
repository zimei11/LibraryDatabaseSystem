package com.book.dao;

import com.book.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper
{
    @Select("select * from admin where mail = #{mail} and password = #{password}")
    User getUser(@Param("mail")String mail,@Param("password")String password);

}
