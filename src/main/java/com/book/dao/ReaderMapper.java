package com.book.dao;

import com.book.entity.Reader;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ReaderMapper
{
    @Select("select * from reader order by open_time desc")
    List<Reader> getReaderList();

    @Delete("delete from reader where mail=#{mail}")
    void deleteReader(String mail);

    @Insert("insert into reader values(#{mail},#{password},#{name},#{sex},now(),null,#{phone},#{state},now())")
    void addReader(@Param("mail") String mail,@Param("password") String password,
    @Param("name") String name,@Param("sex") String sex,@Param("phone") String phone,
                   @Param("state") String state);
}
