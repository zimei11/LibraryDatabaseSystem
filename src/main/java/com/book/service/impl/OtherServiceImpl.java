package com.book.service.impl;

import com.book.dao.ViewMapper;
import com.book.entity.ViewRank;
import com.book.service.OtherService;
import com.book.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class OtherServiceImpl implements OtherService
{
    @Override
    public List<ViewRank> getViewList()
    {
        try(SqlSession sqlSession= MybatisUtil.getSession())
        {
            ViewMapper mapper=sqlSession.getMapper(ViewMapper.class);
            return mapper.getViewList();
        }
    }
}
