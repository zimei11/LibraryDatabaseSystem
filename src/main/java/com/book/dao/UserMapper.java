package com.book.dao;

import com.book.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserMapper
{
    @Results(
            {
                    @Result(column = "name", property = "nickname"),
            }
    )
    @Select("select * from(select mail,password,name from reader UNION select mail,password,nickname as name from admin) as a where mail = #{mail} and password = #{password}")
    User getUser(@Param("mail")String mail,@Param("password")String password);

}
