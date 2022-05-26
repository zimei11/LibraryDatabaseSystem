package com.book.dao;

import com.book.entity.ViewRank;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ViewMapper
{
    @Select("select * from book_rank_list")
    List<ViewRank> getViewList();
}
