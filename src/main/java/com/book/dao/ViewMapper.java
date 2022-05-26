package com.book.dao;

import com.book.entity.ViewRank;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ViewMapper
{
    @Select("select * from book_rank_list order by cnt desc limit 5;")
    List<ViewRank> getViewList();
}
