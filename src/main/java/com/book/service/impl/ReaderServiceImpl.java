package com.book.service.impl;

import com.book.dao.BookMapper;
import com.book.dao.ReaderMapper;
import com.book.dao.ViewMapper;
import com.book.entity.Reader;
import com.book.service.ReaderService;
import com.book.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ReaderServiceImpl implements ReaderService
{
    @Override
    public List<Reader> getReaderList()
    {
        try(SqlSession sqlSession= MybatisUtil.getSession())
        {
            ReaderMapper mapper=sqlSession.getMapper(ReaderMapper.class);
            return mapper.getReaderList();
        }
    }

    @Override
    public void deleteReader(String mail)
    {
        try(SqlSession sqlSession=MybatisUtil.getSession())
        {
            ReaderMapper mapper=sqlSession.getMapper((ReaderMapper.class));
            mapper.deleteReader(mail);
        }
    }
}
